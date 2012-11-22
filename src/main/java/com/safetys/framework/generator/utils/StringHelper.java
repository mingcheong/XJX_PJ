package com.safetys.framework.generator.utils;

/**
 * 字符串辅助类
 * @author Stone
 *
 */
public class StringHelper {

	/**
	 * 将所有分割好的字符串的第一个字母转成大写
	 * @param sqlName
	 * @return {@link String}
	 */
	public static String makeAllWordFirstLetterUpperCase(String sqlName) {
		String[] strs = sqlName.toLowerCase().split("_");
		String result = "";
		String preStr = "";
		for (int i = 0; i < strs.length; i++) {
			if (preStr.length() == 1) {
				result += strs[i];
			} else {
				result += capitalize(strs[i]);
			}
			preStr = strs[i];
		}
		return result;
	}

	/**
	 * 替换字符
	 * @param inString
	 * @param oldPattern
	 * @param newPattern
	 * @return {@link String}
	 */
	public static String replace(String inString, String oldPattern, String newPattern) {
		if (inString == null) { return null; }
		if (oldPattern == null || newPattern == null) { return inString; }
		StringBuffer sbuf = new StringBuffer();
		int pos = 0;
		int index = inString.indexOf(oldPattern);
		int patLen = oldPattern.length();
		while (index >= 0) {
			sbuf.append(inString.substring(pos, index));
			sbuf.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sbuf.append(inString.substring(pos));
		return sbuf.toString();
	}

	public static String capitalize(String str) {
		return changeFirstCharacterCase(str, true);
	}

	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(str, false);
	}

	/**
	 * 转换首字母大小写
	 * @param str
	 * @param capitalize
	 * @return {@link String}
	 */
	private static String changeFirstCharacterCase(String str, boolean capitalize) {
		if (str == null || str.length() == 0) { return str; }
		StringBuffer buf = new StringBuffer(str.length());
		if (capitalize) {
			buf.append(Character.toUpperCase(str.charAt(0)));
		} else {
			buf.append(Character.toLowerCase(str.charAt(0)));
		}
		buf.append(str.substring(1));
		return buf.toString();
	}
}
