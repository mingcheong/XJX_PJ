package com.safetys.framework.utils;

import java.util.ResourceBundle;

public class PropertieUtils {

	/**
	 * 读取主要资源文件
	 * 
	 * @param key
	 * @return String
	 */
	public static String getApplicationResources(String key) {
		String result = null;
		final ResourceBundle rb = ResourceBundle.getBundle("ApplicationResources");
		result = rb.getString(key);
		return result;
	}

	/**
	 * 读取附件属性资源文件
	 * 
	 * @param key
	 * @return String
	 */
	public static String getAnnexResources(String key) {
		String result = null;
		final ResourceBundle rb = ResourceBundle.getBundle("Annex");
		result = rb.getString(key);
		return result;
	}

}
