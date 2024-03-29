/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net Copyright (C) 2004-2010 Frederico Caldeira Knabben == BEGIN LICENSE == Licensed under the terms of any of the following licenses
 * at your choice: - GNU General Public License Version 2 or later (the "GPL") http://www.gnu.org/licenses/gpl.html - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html - Mozilla Public License Version 1.1 or later (the "MPL") http://www.mozilla.org/MPL/MPL-1.1.html == END LICENSE ==
 */
package com.safetys.framework.fckeditor.localization;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.safetys.framework.fckeditor.handlers.PropertiesLoader;
import com.safetys.framework.fckeditor.tool.Utils;

/**
 * Provides access to localized messages (properties).
 * <p>
 * Localized messages are loaded for a particular locale from a HTTP request. The locale is resolved by the current {@link LocaleResolver} instance/singleton. If a locale or a bundle for a locale
 * cannot be found, default messages are used.
 * </p>
 * <p>
 * Note: Loaded messages are cached per locale, any subsequent call of the same locale will be served by the cache instead of another resource bundle retrieval.
 * </p>
 * 
 * @version $Id: LocalizedMessages.java 4785 2009-12-21 20:10:28Z mosipov $
 */
public class LocalizedMessages {

	private static final Map<Locale, LocalizedMessages> prototypes = Collections.synchronizedMap(new HashMap<Locale, LocalizedMessages>());
	private static final String DEFAULT_FILENAME = "default_messages.properties"; //$NON-NLS-1$
	private static final String LOCAL_PROPERTIES = "fckeditor_messages"; //$NON-NLS-1$
	private static final Properties defaultProperties = new Properties();

	private final Properties properties;
	private static LocaleResolver localeResolver;
	private static final Locale NEUTRAL = new Locale(Utils.EMPTY_STRING);
	private static final Logger logger = LoggerFactory.getLogger(LocalizedMessages.class);

	static {

		InputStream in = LocalizedMessages.class.getResourceAsStream(LocalizedMessages.DEFAULT_FILENAME);

		if (in == null) {
			LocalizedMessages.logger.error("{} not found", LocalizedMessages.DEFAULT_FILENAME); //$NON-NLS-1$
			throw new RuntimeException(LocalizedMessages.DEFAULT_FILENAME + " not found"); //$NON-NLS-1$
		} else {
			if (!(in instanceof BufferedInputStream)) {
				in = new BufferedInputStream(in);
			}

			try {
				LocalizedMessages.defaultProperties.load(in);
				in.close();
				LocalizedMessages.logger.debug("{} loaded", LocalizedMessages.DEFAULT_FILENAME); //$NON-NLS-1$
			} catch (final Exception e) {
				LocalizedMessages.logger.error("Error while loading {}", LocalizedMessages.DEFAULT_FILENAME); //$NON-NLS-1$
				throw new RuntimeException("Error while loading " + LocalizedMessages.DEFAULT_FILENAME, e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Returns an instance of <code>LocalizedMessages</code> for a given request. This method automatically determines the locale of this request and loads the appropriate bundle. If locale is null or
	 * not available, the default locale will be used.
	 * 
	 * @param request
	 *            the current request instance
	 * @return instance with localized messages
	 */
	public static LocalizedMessages getInstance(HttpServletRequest request) {

		if (request == null) { throw new NullPointerException("the request cannot be null"); }

		Locale locale = LocalizedMessages.getLocaleResolverInstance().resolveLocale(request);

		if (locale == null) {
			locale = LocalizedMessages.NEUTRAL;
		}

		synchronized (LocalizedMessages.class) {
			if (!LocalizedMessages.prototypes.containsKey(locale)) {
				LocalizedMessages.prototypes.put(locale, new LocalizedMessages(locale));
			}
		}

		// for now we don't need any cloning since the values are accessed
		// read-only
		return LocalizedMessages.prototypes.get(locale);

	}

	/**
	 * Returns the locale resolver instance. The implementation class name is provided by {@link PropertiesLoader#getLocaleResolverImpl()}.
	 * 
	 * @return the locale resolver instance
	 */
	private synchronized static LocaleResolver getLocaleResolverInstance() {

		if (LocalizedMessages.localeResolver == null) {
			final String className = PropertiesLoader.getLocaleResolverImpl();

			if (Utils.isEmpty(className)) {
				LocalizedMessages.logger.error("Empty LocaleResolver implementation class name provided"); //$NON-NLS-1$
			} else {
				try {
					final Class<?> clazz = Class.forName(className);
					LocalizedMessages.localeResolver = (LocaleResolver) clazz.newInstance();
					LocalizedMessages.logger.info("LocaleResolver initialized to {}", className); //$NON-NLS-1$
				} catch (final Throwable e) {
					LocalizedMessages.logger.error("LocaleResolver implementation {} could not be instantiated", className); //$NON-NLS-1$
					throw new RuntimeException("LocaleResolver implementation " + className + " could not be instantiated", e); //$NON-NLS-1$
				}
			}
		}

		return LocalizedMessages.localeResolver;
	}

	/**
	 * Loads the localized messages for the given locale. This constructor loads the resource bundle for this locale and only for this, in other words it short-circuits the default resource bundle
	 * load mechanism in order to prevent the loading of the system default locale which may result in a completely different resource bundle.
	 * 
	 * @param locale
	 *            the locale of the new localized messages
	 */
	private LocalizedMessages(Locale locale) {

		this.properties = new Properties(LocalizedMessages.defaultProperties);

		ResourceBundle localized = null;
		try {
			localized = ResourceBundle.getBundle(LocalizedMessages.LOCAL_PROPERTIES, locale, Thread.currentThread().getContextClassLoader());
		} catch (final Exception e) {
			; // do nothing
		}

		if ((localized != null) && localized.getLocale().getLanguage().equals(locale.getLanguage())) {
			final Enumeration<String> keys = localized.getKeys();

			while (keys.hasMoreElements()) {
				final String key = keys.nextElement();
				this.properties.setProperty(key, localized.getString(key));
			}

			LocalizedMessages.logger.debug("Resource bundle for locale '{}' loaded", locale); //$NON-NLS-1$
		} else {
			LocalizedMessages.logger.debug("No resource bundle for locale '{}' found, loading default bundle", locale); //$NON-NLS-1$

			ResourceBundle base = null;
			try {
				base = ResourceBundle.getBundle(LocalizedMessages.LOCAL_PROPERTIES, LocalizedMessages.NEUTRAL, Thread.currentThread().getContextClassLoader());
			} catch (final Exception e) {
				; // do nothing
			}

			if ((base != null) && base.getLocale().equals(LocalizedMessages.NEUTRAL)) {
				final Enumeration<String> keys = base.getKeys();

				while (keys.hasMoreElements()) {
					final String key = keys.nextElement();
					this.properties.setProperty(key, base.getString(key));
				}
			}

		}

	}

	/**
	 * Searches for the message with the specified key in this message list.
	 * 
	 * @see Properties#getProperty(String)
	 */
	private String getMessage(String key) {
		return this.properties.getProperty(key);
	}

	/** Returns localized <code>editor.compatibleBrowser.yes</code> property. */
	public String getCompatibleBrowserYes() {
		return this.getMessage("editor.compatibleBrowser.yes"); //$NON-NLS-1$
	}

	/** Returns localized <code>editor.compatibleBrowser.no</code> property. */
	public String getCompatibleBrowserNo() {
		return this.getMessage("editor.compatibleBrowser.no"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.fileUpload.enabled</code> property. */
	public String getFileUploadEnabled() {
		return this.getMessage("connector.fileUpload.enabled"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.fileUpload.disabled</code> property. */
	public String getFileUploadDisabled() {
		return this.getMessage("connector.fileUpload.disabled"); //$NON-NLS-1$
	}

	/**
	 * Returns localized <code>connector.file_renamed_warning</code> property.
	 * 
	 * @param newFileName
	 *            the new filename of the warning
	 * @return localized message with new filename
	 */
	public String getFileRenamedWarning(String newFileName) {
		return MessageFormat.format(this.getMessage("connector.fileUpload.file_renamed_warning"), newFileName); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.fileUpload.invalid_file_type_specified</code> property. */
	public String getInvalidFileTypeSpecified() {
		return this.getMessage("connector.fileUpload.invalid_file_type_specified"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.fileUpload.write_error</code> property. */
	public String getFileUploadWriteError() {
		return this.getMessage("connector.fileUpload.write_error"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.getResources.enabled</code> property. */
	public String getGetResourcesEnabled() {
		return this.getMessage("connector.getResources.enabled"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.getResources.disabled</code> property. */
	public String getGetResourcesDisabled() {
		return this.getMessage("connector.getResources.disabled"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.getResources.read_error</code> property. */
	public String getGetResourcesReadError() {
		return this.getMessage("connector.getResources.read_error"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.createFolder.enabled</code> property. */
	public String getCreateFolderEnabled() {
		return this.getMessage("connector.createFolder.enabled"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.createFolder.disabled</code> property. */
	public String getCreateFolderDisabled() {
		return this.getMessage("connector.createFolder.disabled"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.invalid_command_specified</code> property. */
	public String getInvalidCommandSpecified() {
		return this.getMessage("connector.invalid_command_specified"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.createFolder.folder_already_exists_error</code> property. */
	public String getFolderAlreadyExistsError() {
		return this.getMessage("connector.createFolder.folder_already_exists_error"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.createFolder.invalid_new_folder_name_specified</code> property. */
	public String getInvalidNewFolderNameSpecified() {
		return this.getMessage("connector.createFolder.invalid_new_folder_name_specified"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.createFolder.write_error</code> property. */
	public String getCreateFolderWriteError() {
		return this.getMessage("connector.createFolder.write_error"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.invalid_resource_type_specified</code> property. */
	public String getInvalidResouceTypeSpecified() {
		return this.getMessage("connector.invalid_resource_type_specified"); //$NON-NLS-1$
	}

	/** Returns localized <code>connector.invalid_current_folder_specified</code> property. */
	public String getInvalidCurrentFolderSpecified() {
		return this.getMessage("connector.invalid_current_folder_specified"); //$NON-NLS-1$
	}

}