package com.safetys.framework.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 文件输入输出辅助类
 * 
 * @author Stone
 */
public class FileUtils {

	public static final int BUFFER_SIZE = 2 * 1024;

	/**
	 * 将字符串写到文件中
	 * 
	 * @param content
	 * @param dst
	 * @throws IOException
	 */
	public static void writerBufferToLocalFile(String content, String dst) throws IOException {
		File file = new File(dst);
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		BufferedWriter writer = new BufferedWriter(write);
		writer.write(content);
		writer.close();
	}

	/**
	 * 将上传的文件写入到本地文件中
	 * 
	 * @param src
	 *            读取的文件
	 * @param dst
	 *            将要写入的文件
	 */
	public static void writeToLocalFile(String src, String dst) {
		InputStream in = null;
		OutputStream out = null;
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			try {
				in = new BufferedInputStream(new FileInputStream(src));
				out = new BufferedOutputStream(new FileOutputStream(dst));
				int length = -1;
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
			} finally {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出到浏览器
	 * 
	 * @param writer
	 * @param src
	 */
	public static void writeToResponse(OutputStream writer, File src) {
		InputStream in = null;
		byte[] buffer = new byte[BUFFER_SIZE];
		try {
			in = new BufferedInputStream(new FileInputStream(src));
			int length = -1;
			while ((length = in.read(buffer)) > 0) {
				writer.write(buffer, 0, length);
			}
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
				writer.close();
				writer = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 取得文件扩展名
	 * 
	 * @param fileName
	 *            文件名
	 * @return String
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	/**
	 * 移出文件或文件夹
	 * 
	 * @param directory
	 */
	public static void remove(File directory) {
		if (directory.exists()) {
			if (!directory.delete()) {
				final File[] files = directory.listFiles();
				for (final File element : files) {
					if (element.isDirectory()) {
						remove(element);
					} else {
						element.delete();
					}
				}
			}
			directory.delete();
		}
	}

	/**
	 * 创建文件夹
	 * 
	 * @param path
	 */
	public static void createDirectory(String path) {
		final File theFile = new File(path);
		if (!theFile.exists()) {
			theFile.mkdir();
		}
	}

	/**
	 * 检查文件是否在在,如果存在则加(n)
	 * 
	 * @param fileName
	 * @param dir
	 * @return String
	 */
	public static String checkFileName(String fileName, String dir) {
		boolean isDirectory = new File(dir + fileName).isDirectory();
		if (isFileExist(fileName, dir)) {
			int index = fileName.lastIndexOf(".");
			StringBuffer newFileName = new StringBuffer();
			String name = isDirectory ? fileName : fileName.substring(0, index);
			String extendName = isDirectory ? "" : fileName.substring(index);
			int nameNum = 1;
			while (true) {
				newFileName.append(name).append("(").append(nameNum).append(")");
				if (!isDirectory) {
					newFileName.append(extendName);
				}
				if (isFileExist(newFileName.toString(), dir)) {
					nameNum++;
					newFileName = new StringBuffer();
					continue;
				}
				return newFileName.toString();
			}
		}
		return fileName;
	}

	/**
	 * 判断文件是否存在
	 * 
	 * @param fileName
	 * @param dir
	 * @return boolean
	 */
	public static boolean isFileExist(String fileName, String dir) {
		File files = new File(dir + fileName);
		return (files.exists()) ? true : false;
	}

	/**
	 * 多文件加压
	 * 
	 * @param zosm
	 * @param file
	 * @param basePath
	 * @return boolean
	 */
	public static boolean compressionFiles(java.util.zip.ZipOutputStream zosm, File file, String basePath) {
		boolean flag = true;
		try {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				zosm.putNextEntry(new ZipEntry(basePath + "/"));
				basePath = basePath + (basePath.length() == 0 ? "" : "/") + file.getName();
				for (File f : files) {
					compressionFiles(zosm, f, basePath);
				}
				FileInputStream fism = null;
				BufferedInputStream bism = null;
				byte[] bytes = new byte[1024];
				fism = new FileInputStream(file);
				bism = new BufferedInputStream(fism, 1024);
				basePath = basePath + (basePath.length() == 0 ? "" : "/") + file.getName();
				zosm.putNextEntry(new ZipEntry(basePath));
				int count;
				while ((count = bism.read(bytes, 0, 1024)) != -1) {
					zosm.write(bytes, 0, count);
				}
				if (bism != null) {
					bism.close();
				}
				if (fism != null) {
					fism.close();
				}
			}
		} catch (Exception exception) {
			flag = true;
			exception.printStackTrace();
		}
		return flag;
	}

	/**
	 * 取地址
	 * 
	 * @param directory
	 * @param subDirectory
	 */
	public static void getDir(String directory, String subDirectory) {
		String dir[];
		File fileDir = new File(directory);
		try {
			if ((subDirectory == "") && (fileDir.exists() != true)) {
				fileDir.mkdir();
			} else if (subDirectory != "") {
				dir = subDirectory.replace('\\', '/').split("/");
				for (String element : dir) {
					File subFile = new File(directory + File.separator + element);
					if (subFile.exists() == false) {
						subFile.mkdir();
					}
					directory += File.separator + element;
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 解压ZIP文件
	 * 
	 * @param zipFileName
	 * @param outputDirectory
	 */
	@SuppressWarnings("rawtypes")
	public static boolean decompressionZipFiles(String zipFileName, String outputDirectory) {
		boolean flag = true;
		try {
			ZipFile zipFile = new ZipFile(zipFileName);
			Enumeration e = zipFile.entries();
			ZipEntry zipEntry = null;
			getDir(outputDirectory, "");
			while (e.hasMoreElements()) {
				zipEntry = (ZipEntry) e.nextElement();
				if (zipEntry.isDirectory()) { // 如果得到的是个目录，
					String name = zipEntry.getName(); // 就创建在指定的文件夹下创建目录
					name = name.substring(0, name.length() - 1);
					File f = new File(outputDirectory + File.separator + name);
					f.mkdir();
				} else {
					String fileName = zipEntry.getName();
					fileName = fileName.replace('\\', '/');
					if (fileName.indexOf("/") != -1) {
						getDir(outputDirectory, fileName.substring(0, fileName.lastIndexOf("/")));
						fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
					}
					File f = new File(outputDirectory + File.separator + zipEntry.getName());
					f.createNewFile();
					InputStream in = zipFile.getInputStream(zipEntry);
					FileOutputStream out = new FileOutputStream(f);
					byte[] by = new byte[1024];
					int c;
					while ((c = in.read(by)) != -1) {
						out.write(by, 0, c);
					}
					out.close();
					in.close();
				}
			}
		} catch (Exception exception) {
			flag = false;// 正常情况是决不会失败的,出非加密过了
		}
		return flag;
	}

}
