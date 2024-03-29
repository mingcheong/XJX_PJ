/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net Copyright (C) 2004-2010 Frederico Caldeira Knabben == BEGIN LICENSE == Licensed under the terms of any of the following licenses
 * at your choice: - GNU General Public License Version 2 or later (the "GPL") http://www.gnu.org/licenses/gpl.html - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html - Mozilla Public License Version 1.1 or later (the "MPL") http://www.mozilla.org/MPL/MPL-1.1.html == END LICENSE ==
 */
package com.safetys.framework.fckeditor.handlers;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages FCKeditor.Java properties files.
 * <p>
 * It manages/loads the properties files in the following order:
 * <ol>
 * <li>the default properties as defined <a href="http://java.fckeditor.net/properties.html">here</a>,
 * <li>the user-defined properties (<code>fckeditor.properties</code>) if present.
 * </ol>
 * This means that user-defined properties <em>override</em> default ones. In the backend it utilizes the regular {@link Properties} class.
 * </p>
 * <p>
 * Moreover, you can set properties programmatically too but make sure to override them <em>before</em> the first call of that specific property.
 * 
 * @version $Id: PropertiesLoader.java 4785 2009-12-21 20:10:28Z mosipov $
 */
public class PropertiesLoader {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
	private static final String DEFAULT_FILENAME = "default.properties";
	private static final String LOCAL_PROPERTIES = "/fckeditor.properties";
	private static Properties properties = new Properties();

	static {

		// 1. load library defaults
		InputStream in = PropertiesLoader.class.getResourceAsStream(PropertiesLoader.DEFAULT_FILENAME);

		if (in == null) {
			PropertiesLoader.logger.error("{} not found", PropertiesLoader.DEFAULT_FILENAME);
			throw new RuntimeException(PropertiesLoader.DEFAULT_FILENAME + " not found");
		} else {
			if (!(in instanceof BufferedInputStream)) {
				in = new BufferedInputStream(in);
			}

			try {
				PropertiesLoader.properties.load(in);
				in.close();
				PropertiesLoader.logger.debug("{} loaded", PropertiesLoader.DEFAULT_FILENAME);
			} catch (final Exception e) {
				PropertiesLoader.logger.error("Error while processing {}", PropertiesLoader.DEFAULT_FILENAME);
				throw new RuntimeException("Error while processing " + PropertiesLoader.DEFAULT_FILENAME, e);
			}
		}

		// 2. load user defaults if present
		InputStream in2 = PropertiesLoader.class.getResourceAsStream(PropertiesLoader.LOCAL_PROPERTIES);

		if (in2 == null) {
			PropertiesLoader.logger.info("{} not found", PropertiesLoader.LOCAL_PROPERTIES);
		} else {

			if (!(in2 instanceof BufferedInputStream)) {
				in2 = new BufferedInputStream(in2);
			}

			try {
				PropertiesLoader.properties.load(in2);
				in2.close();
				PropertiesLoader.logger.debug("{} loaded", PropertiesLoader.LOCAL_PROPERTIES);
			} catch (final Exception e) {
				PropertiesLoader.logger.error("Error while processing {}", PropertiesLoader.LOCAL_PROPERTIES);
				throw new RuntimeException("Error while processing " + PropertiesLoader.LOCAL_PROPERTIES, e);
			}

		}
	}

	/**
	 * Searches for the property with the specified key in this property list.
	 * 
	 * @see Properties#getProperty(String)
	 */
	public static String getProperty(final String key) {
		return PropertiesLoader.properties.getProperty(key);
	}

	/**
	 * Sets the property with the specified key in this property list.
	 * 
	 * @see Properties#setProperty(String, String)
	 */
	public static void setProperty(final String key, final String value) {
		PropertiesLoader.properties.setProperty(key, value);
	}

	/**
	 * Returns <code>fckeditor.toolbarSet</code> property
	 */
	public static String getEditorToolbarSet() {
		return PropertiesLoader.properties.getProperty("fckeditor.toolbarSet");
	}

	/**
	 * Returns <code>fckeditor.width</code> property
	 */
	public static String getEditorWidth() {
		return PropertiesLoader.properties.getProperty("fckeditor.width");
	}

	/**
	 * Returns <code>fckeditor.height</code> property
	 */
	public static String getEditorHeight() {
		return PropertiesLoader.properties.getProperty("fckeditor.height");
	}

	/**
	 * Returns <code>fckeditor.basePath</code> property
	 */
	public static String getEditorBasePath() {
		return PropertiesLoader.properties.getProperty("fckeditor.basePath");
	}

	/**
	 * Returns <code>connector.resourceType.file.path</code> property
	 */
	public static String getFileResourceTypePath() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.file.path");
	}

	/**
	 * Returns <code>connector.resourceType.flash.path</code> property
	 */
	public static String getFlashResourceTypePath() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.flash.path");
	}

	/**
	 * Returns <code>connector.resourceType.image.path</code> property
	 */
	public static String getImageResourceTypePath() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.image.path");
	}

	/**
	 * Returns <code>connector.resourceType.media.path</code> property
	 */
	public static String getMediaResourceTypePath() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.media.path");
	}

	/**
	 * Returns <code>connector.resourceType.file.extensions.allowed</code> property
	 */
	public static String getFileResourceTypeAllowedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.file.extensions.allowed");
	}

	/**
	 * Returns <code>connector.resourceType.file.extensions.denied</code> property
	 */
	public static String getFileResourceTypeDeniedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.file.extensions.denied");
	}

	/**
	 * Returns <code>connector.resourceType.flash.extensions.allowed</code> property
	 */
	public static String getFlashResourceTypeAllowedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.flash.extensions.allowed");
	}

	/**
	 * Returns <code>connector.resourceType.flash.extensions.denied</code> property
	 */
	public static String getFlashResourceTypeDeniedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.flash.extensions.denied");
	}

	/**
	 * Returns <code>connector.resourceType.image.extensions.allowed</code> property
	 */
	public static String getImageResourceTypeAllowedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.image.extensions.allowed");
	}

	/**
	 * Returns <code>connector.resourceType.image.extensions.denied</code> property
	 */
	public static String getImageResourceTypeDeniedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.image.extensions.denied");
	}

	/**
	 * Returns <code>connector.resourceType.media.extensions.allowed</code> property
	 */
	public static String getMediaResourceTypeAllowedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.media.extensions.allowed");
	}

	/**
	 * Returns <code>connector.resourceType.media.extensions.denied</code> property
	 */
	public static String getMediaResourceTypeDeniedExtensions() {
		return PropertiesLoader.properties.getProperty("connector.resourceType.media.extensions.denied");
	}

	/**
	 * Returns <code>connector.userFilesPath</code> property
	 */
	public static String getUserFilesPath() {
		return PropertiesLoader.properties.getProperty("connector.userFilesPath");
	}

	/**
	 * Returns <code>connector.userFilesAbsolutePath</code> property
	 */
	public static String getUserFilesAbsolutePath() {
		return PropertiesLoader.properties.getProperty("connector.userFilesAbsolutePath");
	}

	/**
	 * Returns <code>connector.forceSingleExtension</code> property
	 */
	public static boolean isForceSingleExtension() {
		return Boolean.valueOf(PropertiesLoader.properties.getProperty("connector.forceSingleExtension"));
	}

	/**
	 * Returns <code>connector.secureImageUploads</code> property
	 */
	public static boolean isSecureImageUploads() {
		return Boolean.valueOf(PropertiesLoader.properties.getProperty("connector.secureImageUploads"));
	}

	/**
	 * Returns <code>connector.impl</code> property
	 */
	public static String getConnectorImpl() {
		return PropertiesLoader.properties.getProperty("connector.impl");
	}

	/**
	 * Returns <code>connector.userActionImpl</code> property
	 */
	public static String getUserActionImpl() {
		return PropertiesLoader.properties.getProperty("connector.userActionImpl");
	}

	/**
	 * Returns <code>connector.userPathBuilderImpl</code> property
	 */
	public static String getUserPathBuilderImpl() {
		return PropertiesLoader.properties.getProperty("connector.userPathBuilderImpl");
	}

	/**
	 * Returns <code>connector.localeResolverImpl</code> property
	 */
	public static String getLocaleResolverImpl() {
		return PropertiesLoader.properties.getProperty("localization.localeResolverImpl");
	}
}
