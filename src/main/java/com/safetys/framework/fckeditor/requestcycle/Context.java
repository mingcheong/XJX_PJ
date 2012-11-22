/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net Copyright (C) 2004-2010 Frederico Caldeira Knabben == BEGIN LICENSE == Licensed under the terms of any of the following licenses
 * at your choice: - GNU General Public License Version 2 or later (the "GPL") http://www.gnu.org/licenses/gpl.html - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html - Mozilla Public License Version 1.1 or later (the "MPL") http://www.mozilla.org/MPL/MPL-1.1.html == END LICENSE ==
 */
package com.safetys.framework.fckeditor.requestcycle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.safetys.framework.fckeditor.connector.Dispatcher;
import com.safetys.framework.fckeditor.handlers.Command;
import com.safetys.framework.fckeditor.handlers.ResourceType;
import com.safetys.framework.fckeditor.tool.Utils;

/**
 * Maintains base/common request parameters from the File Browser. The gain of this class is to provide abstracted and pre-processed access to common request parameters.
 * <p>
 * In the regular case, you will use an already created instance of this class.
 * </p>
 * 
 * @version $Id: Context.java 4785 2009-12-21 20:10:28Z mosipov $
 */
public class Context {
	// This is just a helper class which has no relevance for the logger
	private static final Logger logger = LoggerFactory.getLogger(Dispatcher.class);

	private String typeStr;
	private String commandStr;
	private String currentFolderStr;

	/**
	 * Sole class constructor. Takes in a request instance, processes parameters and populates private fields which can be accessed through getters.<br />
	 * This class will only be instantiated in {@link ThreadLocalData}.
	 * 
	 * @param request
	 *            current user request instance
	 */
	protected Context(final HttpServletRequest request) {
		this.commandStr = request.getParameter("Command");
		this.typeStr = request.getParameter("Type");
		this.currentFolderStr = request.getParameter("CurrentFolder");

		// if this is a QuickUpload request, 'commandStr', 'currentFolderStr'
		// are empty and 'typeStr' maybe empty too
		if (Utils.isEmpty(this.commandStr) && Utils.isEmpty(this.currentFolderStr)) {
			this.commandStr = "QuickUpload";
			this.currentFolderStr = "/";
			if (Utils.isEmpty(this.typeStr)) {
				this.typeStr = "File";
			}
		}

		// checks to meet specs in http://docs.fckeditor.net/FCKeditor_2.x/Developers_Guide/Server_Side_Integration#File_Browser_Requests
		if ((this.currentFolderStr != null) && !this.currentFolderStr.startsWith("/")) {
			this.currentFolderStr = "/".concat(this.currentFolderStr);
		}
	}

	/**
	 * Returns the type parameter of this context.
	 * 
	 * @return the type parameter of this context
	 */
	public String getTypeStr() {
		return this.typeStr;
	}

	/**
	 * Returns a default resource type instance for the type parameter.
	 * 
	 * @see ResourceType#getDefaultResourceType(String)
	 * @return default resource type instance
	 */
	public ResourceType getDefaultResourceType() {
		return ResourceType.getDefaultResourceType(this.typeStr);
	}

	/**
	 * Returns a resource type instance for the type parameter.
	 * 
	 * @see ResourceType#getResourceType(String)
	 * @return resource type instance
	 */
	public ResourceType getResourceType() {
		return ResourceType.getResourceType(this.typeStr);
	}

	/**
	 * Returns the command parameter of this context.
	 * 
	 * @return the command parameter of this context
	 */
	public String getCommandStr() {
		return this.commandStr;
	}

	/**
	 * Returns a command instance for the command parameter.
	 * 
	 * @see Command#getCommand(String)
	 * @return command instance
	 */
	public Command getCommand() {
		return Command.getCommand(this.commandStr);
	}

	/**
	 * Returns the current folder parameter of this context.
	 * 
	 * @return the current folder parameter of this context
	 */
	public String getCurrentFolderStr() {
		return this.currentFolderStr;
	}

	/** Logs base/common request parameters. */
	public void logBaseParameters() {
		Context.logger.debug("Parameter Command: {}", this.commandStr);
		Context.logger.debug("Parameter Type: {}", this.typeStr);
		Context.logger.debug("Parameter CurrentFolder: {}", this.currentFolderStr);
	}

}
