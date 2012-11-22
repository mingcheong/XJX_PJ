package com.safetys.framework.utils;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期辅助类
 * 
 * @author Stone
 */
public class DateUtils {

	/**
	 * 取系统当前时间
	 * 
	 * @return {@link String}
	 */
	public static String getFullDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(new Date());
	}

	/**
	 * 取系统当前时间
	 * 
	 * @return {@link String}
	 */
	public static String getDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		return date.format(new Date());
	}

	/**
	 * 根据字符串格式的时间，返回Date
	 * 
	 * @param date 日期对象
	 * @param pattern  日期格式
	 * @return {@link Date}
	 */
	public static Date convertStringToDate(String date, String pattern) {
		DateFormat sdf = null;
		if (pattern == null) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat(pattern);
		}
		try {
			ParsePosition pos = new ParsePosition(0);
			return sdf.parse(date, pos);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据Date，返回字符型日期格式
	 * 
	 * @param date 日期对象
	 * @param pattern 日期格式
	 * @return {@link String}
	 */
	public static String date2Str(Date date, String pattern) {
		if (date == null) { return null; }
		SimpleDateFormat sdf = new SimpleDateFormat();
		if (!AppUtils.isEmpty(pattern)) {
			sdf.applyPattern(pattern);
		} else {
			sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		}
		return sdf.format(date);
	}
}
