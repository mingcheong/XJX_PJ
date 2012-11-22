package com.safetys.framework.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.safetys.framework.kernel.model.DateFields;
import com.safetys.framework.system.model.FkUserModel;

/**
 * 常规方法集合类
 * 
 * @author Stone
 */
public class AppUtils {

	static final String[] AREAS = new String[] { "firstArea", "secondArea", "thirdArea", "fourthArea", "fifthArea" };

	/**
	 * 判断对象是否为空
	 * 
	 * @param object
	 * @return boolean
	 */
	public static boolean isNullOrEmptyString(Object object) {
		if (object == null) { return true; }
		if (object instanceof String) {
			final String str = (String) object;
			if (str.length() == 0) { return true; }
		}
		if (object instanceof Long) {
			Long obj = (Long) object;
			if (obj <= 0) { return true; }
		}
		return false;
	}

	/**
	 * 将客户端传递过来的id字符串处理成为List
	 * 
	 * @param code
	 * @return {@link List}
	 */
	public static List<Long> idsStringToList(String code) {
		final List<Long> ids = new ArrayList<Long>();
		final String[] idsArray = code.split(",");
		for (final String element : idsArray) {
			ids.add(Long.parseLong(element.trim()));
		}
		return ids;
	}

	/**
	 * 返回用户最后一级区域，一般用于根据用户区域查找时，辅助使用
	 * 
	 * @param user
	 * @return {@link Option}
	 */
	public static Option getUserLastArea(Object obj) {
		String areaCode = null;
		String areaName = "";
		for (int i = AREAS.length - 1; i >= 0; i--) {
			areaCode = (String) getProperty(obj, AREAS[i]);
			if (areaCode != null && areaCode.length() > 5) {
				areaName = AREAS[i];
				break;
			}
		}
		if (areaCode == null) { return null; }
		return new Option(areaName, areaCode);
	}

	/**
	 * 将JAVA对旬中的区域名称转到数据库的区域名称
	 * (暂定)
	 * @param pojoName
	 * @return {@link String}
	 */
	public static String getNativeColumnName(String pojoName) {
		if ("firstArea".equals(pojoName)) {
			return "A2";
		} else if ("secondArea".equals(pojoName)) {
			return "A3";
		} else if ("thirdArea".equals(pojoName)) {
			return "A4";
		} else if ("fourthArea".equals(pojoName)) {
			return "A5";
		} else {
			return "A5";
		}
	}
	
	/**
	 * 将JAVA对旬中的区域名称转到数据库的区域名称
	 * 
	 * @param pojoName
	 * @return {@link String}
	 */
	public static String getNativeTrueColumnName(String pojoName) {
		if ("firstArea".equals(pojoName)) {
			return "A1";
		} else if ("secondArea".equals(pojoName)) {
			return "A2";
		} else if ("thirdArea".equals(pojoName)) {
			return "A3";
		} else if ("fourthArea".equals(pojoName)) {
			return "A4";
		} else {
			return "A5";
		}
	}

	/**
	 * 反射，根据当前传入对象实例，方法名，返回执行后的值
	 * 
	 * @param obj
	 * @param methodName
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static Object getProperty(Object obj, String methodName) {
		try {
			if (obj == null || methodName == null) { return null; }
			String m = methodName.substring(0, 1).toUpperCase();
			m = "get" + m + methodName.substring(1, methodName.length());
			return obj.getClass().getMethod(m, null).invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将以数字衔接在一起的字符串转换成数字类型
	 * 
	 * @param tmpStr
	 * @return {@link Integer}
	 */
	public static Integer str2Integer(String tmpStr) {
		Integer integer = 0;
		try {
			integer = Integer.parseInt(tmpStr);
		} catch (final NumberFormatException e) {
			return 0;
		}
		return integer;
	}

	/**
	 * 判断某个对象是否为日期类型
	 * 
	 * @param object
	 * @return {@link Boolean}
	 */
	public static boolean isDate(Object object) {
		if (object instanceof Date) { return true; }
		return false;
	}

	/**
	 * 判断某个对象是数字类型
	 * 
	 * @param object
	 * @return {@link Boolean}
	 */
	public static boolean isNumber(Object object) {
		if ((object instanceof Short) || (object instanceof Integer) || (object instanceof Long) || (object instanceof Double) || (object instanceof Float)) { return true; }
		return false;
	}

	/**
	 * 判断某个对象是字符串类型
	 * 
	 * @param object
	 * @return {@link Boolean}
	 */
	public static boolean isString(Object object) {
		if ((object instanceof String) || (object instanceof Byte)) { return true; }
		return false;
	}

	/**
	 * 验证是否是自定义的查询对象
	 * 
	 * @param object
	 * @return {@link Boolean}
	 */
	public static boolean isDateFields(Object object) {
		if (object instanceof DateFields) { return true; }
		return false;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return {@link Boolean}
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.trim().length() > 0) { return true; }
		return false;
	}

	/**
	 * 判断list是否为空
	 * 
	 * @param list
	 * @return {@link Boolean}
	 */
	@SuppressWarnings({ "null", "rawtypes" })
	public static boolean isEmpty(List list) {
		if (list != null || list.size() > 0) { return true; }
		return false;
	}

	/**
	 * 生成0-9组合成的随机数
	 * 
	 * @param length
	 * @return {@link String}
	 */
	public static String getRandInteger(int length) {
		final StringBuffer buffer = new StringBuffer("0123456789");
		final StringBuffer SB = new StringBuffer();
		final Random rd = new Random();
		final int rand = buffer.length();
		for (int i = 0; i < length; i++) {
			SB.append(buffer.charAt(rd.nextInt(rand)));
		}
		return SB.toString();
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length
	 * @return {@link String}
	 */
	public static String randString(int length) {
		StringBuilder temple = new StringBuilder("abcdefghijklmnopqrstuvwxyz1234567890");
		StringBuilder tpStr = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			tpStr.append(temple.charAt(random.nextInt(temple.length())));
		}
		return tpStr.toString();
	}

	/**
	 * 取得完整的系统日期和时间
	 * 
	 * @return
	 */
	public static String getFullDate() {
		final SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
		return date.format(new Date());
	}
	
	/**
	 * 根据用户拼接语句
	 * 准确到每个字段是否有值，空为“0”或“null”
	 * @param fkUserModel
	 * @param obj
	 * @return
	 */
	public static String buildSqlByUser(FkUserModel fkUserModel, String obj) {
		StringBuilder SQL = new StringBuilder();
		if (fkUserModel.getFirstArea() != null) {
			if (!AppUtils.isNullOrEmptyString(fkUserModel.getFirstArea())
					&& !fkUserModel.getFirstArea().equals("0")) {
				SQL.append(" and " + obj + ".firstArea = '"
						+ fkUserModel.getFirstArea() + "'");
			} else {
				SQL.append(" and " + obj + ".firstArea = '0'");
			}
		} else {
			SQL.append(" and " + obj + ".firstArea is NULL ");
		}
		if (fkUserModel.getSecondArea() != null) {
			if (!AppUtils.isNullOrEmptyString(fkUserModel.getSecondArea())
					&& !fkUserModel.getSecondArea().equals("0")) {
				SQL.append(" and " + obj + ".secondArea = '"
						+ fkUserModel.getSecondArea() + "'");
			} else {
				SQL.append(" and " + obj + ".secondArea = '0'");
			}
		} else {
			SQL.append(" and " + obj + ".secondArea is NULL ");
		}
		if (fkUserModel.getThirdArea() != null) {
			if (!AppUtils.isNullOrEmptyString(fkUserModel.getThirdArea())
					&& !fkUserModel.getThirdArea().equals("0")) {
				SQL.append(" and " + obj + ".thirdArea = '" + fkUserModel.getThirdArea()
						+ "'");
			} else {
				SQL.append(" and " + obj + ".thirdArea = '0'");
			}
		} else {
			SQL.append(" and " + obj + ".thirdArea is NULL ");
		}
		if (fkUserModel.getFourthArea() != null) {
			if (!AppUtils.isNullOrEmptyString(fkUserModel.getFourthArea())
					&& !fkUserModel.getFourthArea().equals("0")) {
				SQL.append(" and " + obj + ".fourthArea = '"
						+ fkUserModel.getFourthArea() + "'");
			} else {
				SQL.append(" and " + obj + ".fourthArea = '0'");
			}
		} else {
			SQL.append(" and " + obj + ".fourthArea is NULL ");
		}
		if (fkUserModel.getFifthArea() != null) {
			if (!AppUtils.isNullOrEmptyString(fkUserModel.getFifthArea())
					&& !fkUserModel.getFifthArea().equals("0")) {
				SQL.append(" and " + obj + ".fifthArea = '" + fkUserModel.getFifthArea()
						+ "'");
			} else {
				SQL.append(" and " + obj + ".fifthArea = '0'");
			}
		} else {
			SQL.append(" and " + obj + ".fifthArea is NULL ");
		}
		return SQL.toString();
	}
}
