/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net Copyright (C) 2004-2010 Frederico Caldeira Knabben == BEGIN LICENSE == Licensed under the terms of any of the following licenses
 * at your choice: - GNU General Public License Version 2 or later (the "GPL") http://www.gnu.org/licenses/gpl.html - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html - Mozilla Public License Version 1.1 or later (the "MPL") http://www.mozilla.org/MPL/MPL-1.1.html == END LICENSE ==
 */
package com.safetys.framework.fckeditor.requestcycle.impl;

import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.fckeditor.requestcycle.UserAction;

/**
 * UserAction implementation which always returns {@code true}.
 * 
 * @version $Id: EnabledUserAction.java 4785 2009-12-21 20:10:28Z mosipov $
 */
public class EnabledUserAction implements UserAction {

	public boolean isEnabledForFileBrowsing(final HttpServletRequest request) {
		return true;
	}

	public boolean isEnabledForFileUpload(final HttpServletRequest request) {
		return true;
	}

	public boolean isCreateFolderEnabled(final HttpServletRequest request) {
		return true;
	}
}