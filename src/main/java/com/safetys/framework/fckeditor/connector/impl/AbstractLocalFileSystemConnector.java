/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net Copyright (C) 2004-2010 Frederico Caldeira Knabben == BEGIN LICENSE == Licensed under the terms of any of the following licenses
 * at your choice: - GNU General Public License Version 2 or later (the "GPL") http://www.gnu.org/licenses/gpl.html - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 * http://www.gnu.org/licenses/lgpl.html - Mozilla Public License Version 1.1 or later (the "MPL") http://www.mozilla.org/MPL/MPL-1.1.html == END LICENSE ==
 */
package com.safetys.framework.fckeditor.connector.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;

import com.safetys.framework.fckeditor.connector.Connector;
import com.safetys.framework.fckeditor.connector.exception.FolderAlreadyExistsException;
import com.safetys.framework.fckeditor.connector.exception.InvalidCurrentFolderException;
import com.safetys.framework.fckeditor.connector.exception.InvalidNewFolderNameException;
import com.safetys.framework.fckeditor.connector.exception.WriteException;
import com.safetys.framework.fckeditor.handlers.RequestCycleHandler;
import com.safetys.framework.fckeditor.handlers.ResourceType;
import com.safetys.framework.fckeditor.requestcycle.ThreadLocalData;
import com.safetys.framework.fckeditor.requestcycle.UserPathBuilder;
import com.safetys.framework.fckeditor.tool.UtilsFile;

/**
 * Abstract local filesystem backend connector. This class is the default implementation of the <a href="http://docs.fckeditor.net/FCKeditor_2.x/Developers_Guide/Server_Side_Integration"
 * target="_blank">official connector specification</a>.
 * <p>
 * It serves files and folders against a specific local directory which is resolved in a subclass. You cannot use this class directly, instead you have to subclass it and implement the abstract
 * methods and override methods if necessary.
 * 
 * @version $Id: AbstractLocalFileSystemConnector.java 4785 2009-12-21 20:10:28Z mosipov $
 */
public abstract class AbstractLocalFileSystemConnector implements Connector {

	protected ServletContext servletContext;

	public String fileUpload(final ResourceType type, final String currentFolder, final String fileName, final InputStream inputStream) throws InvalidCurrentFolderException, WriteException {
		final String absolutePath = this.getRealUserFilesAbsolutePath(RequestCycleHandler.getUserFilesAbsolutePath(ThreadLocalData.getRequest()));
		final File typeDir = AbstractLocalFileSystemConnector.getOrCreateResourceTypeDir(absolutePath, type);
		final File currentDir = new File(typeDir, currentFolder);
		if (!currentDir.exists() || !currentDir.isDirectory()) { throw new InvalidCurrentFolderException(); }

		final File newFile = new File(currentDir, fileName);
		final File fileToSave = UtilsFile.getUniqueFile(newFile.getAbsoluteFile());

		try {
			IOUtils.copyLarge(inputStream, new FileOutputStream(fileToSave));
		} catch (final IOException e) {
			throw new WriteException();
		}
		return fileToSave.getName();
	}

	public void createFolder(final ResourceType type, final String currentFolder, final String newFolder) throws InvalidCurrentFolderException, InvalidNewFolderNameException,
			FolderAlreadyExistsException {
		final String absolutePath = this.getRealUserFilesAbsolutePath(RequestCycleHandler.getUserFilesAbsolutePath(ThreadLocalData.getRequest()));
		final File typeDir = AbstractLocalFileSystemConnector.getOrCreateResourceTypeDir(absolutePath, type);
		final File currentDir = new File(typeDir, currentFolder);
		if (!currentDir.exists() || !currentDir.isDirectory()) { throw new InvalidCurrentFolderException(); }

		final File newDir = new File(currentDir, newFolder);
		if (newDir.exists()) { throw new FolderAlreadyExistsException(); }
		if (!newDir.mkdir()) { throw new InvalidNewFolderNameException(); }
	}

	public List<Map<String, Object>> getFiles(ResourceType type, String currentFolder) throws InvalidCurrentFolderException {
		final String absolutePath = this.getRealUserFilesAbsolutePath(RequestCycleHandler.getUserFilesAbsolutePath(ThreadLocalData.getRequest()));
		final File typeDir = AbstractLocalFileSystemConnector.getOrCreateResourceTypeDir(absolutePath, type);
		final File currentDir = new File(typeDir, currentFolder);
		if (!currentDir.exists() || !currentDir.isDirectory()) { throw new InvalidCurrentFolderException(); }

		// collect files
		List<Map<String, Object>> files;
		Map<String, Object> fileMap;
		final File[] fileList = currentDir.listFiles((FileFilter) FileFileFilter.FILE);
		files = new ArrayList<Map<String, Object>>(fileList.length);
		for (final File file : fileList) {
			fileMap = new HashMap<String, Object>(2);
			fileMap.put(Connector.KEY_NAME, file.getName());
			fileMap.put(Connector.KEY_SIZE, file.length());
			files.add(fileMap);
		}
		return files;
	}

	public List<String> getFolders(final ResourceType type, final String currentFolder) throws InvalidCurrentFolderException {
		final String absolutePath = this.getRealUserFilesAbsolutePath(RequestCycleHandler.getUserFilesAbsolutePath(ThreadLocalData.getRequest()));
		final File typeDir = AbstractLocalFileSystemConnector.getOrCreateResourceTypeDir(absolutePath, type);
		final File currentDir = new File(typeDir, currentFolder);
		if (!currentDir.exists() || !currentDir.isDirectory()) { throw new InvalidCurrentFolderException(); }

		final String[] fileList = currentDir.list(DirectoryFileFilter.DIRECTORY);
		return Arrays.asList(fileList);
	}

	/**
	 * Resolves a provided userfiles absolute path against a specific backend. The is no restriction how to resolve the path. To keep it simple, you may use
	 * {@link UserPathBuilder#getUserFilesAbsolutePath(javax.servlet.http.HttpServletRequest) UserPathBuilder.getUserFilesAbsolutePath}. The return value has to be consistent within the entire request
	 * cycle.
	 * 
	 * @param userFilesAbsolutePath
	 *            the userfiles absolute path to resolve against a specific backend
	 * @return the resolved userfiles absolute path
	 */
	protected abstract String getRealUserFilesAbsolutePath(String userFilesAbsolutePath);

	/**
	 * Returns a file reference to a created resource type directory. The directory will be created only if it does not exist.
	 * 
	 * @param baseDir
	 *            the current resource type's base directory
	 * @param type
	 *            the current resource type
	 * @return a file reference the resource type directory
	 */
	protected static File getOrCreateResourceTypeDir(final String baseDir, final ResourceType type) {
		final File dir = new File(baseDir, type.getPath());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}
}