package com.safetys.framework.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * JPA辅助类
 * 
 * @author Stone
 */
public class JPAHelper {

	/**
	 * 根据基础JPQL查询语句和查询对象构建Map
	 * 
	 * @param jpql
	 * @param object
	 * @return {@link Map}
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map buildReflectJpql(String jpql, Object object) {
		final Map jpqlMap = new HashMap();
		if (null == jpql) { return null; }
		final StringBuilder sb = new StringBuilder();
		if (jpql.indexOf("where") > 0) {
			sb.append(" ");
		} else {
			sb.append(" where 1=1 and o.deleted=false ");
		}
		if (null == object) {
			jpqlMap.put((jpql + sb.toString() + " order by o.sortNum asc, o.id desc").trim(), null);
			return jpqlMap;
		}
		final List params = new ArrayList();
		final Method[] methods = object.getClass().getDeclaredMethods();
		for (final Method element : methods) {
			if (element.getName().indexOf("get") == 0) {
				final String field = element.getName().substring(3, 4).toLowerCase() + element.getName().substring(4);
				Object obj = new Object();
				try {
					obj = element.invoke(object);
					if (AppUtils.isNumber(obj)) {
						if (!"-1".equals(obj + "".trim()) && !"0.0".equals(obj + "".trim())) {
							sb.append(" and o." + field + "= ? ");
							params.add(obj);
						}
					}
					if (AppUtils.isDateFields(obj)) {
						sb.append(dateFieldsToSql(sb, obj));
					}
					if(AppUtils.isDate(obj)){
						sb.append(" and o." + field + " = ? ");
						params.add(obj);
					}
					if (AppUtils.isString(obj)) {
						if ((null != obj) && !"".equals(obj + "".trim())) {
							sb.append(" and o." + field + " like ? ");
							params.add("%" + obj + "%");
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		jpql += sb.toString();
		jpql += " order by o.sortNum asc, o.id desc";
		jpql.trim();
		jpqlMap.put(jpql, params);
		return jpqlMap;
	}

	/**
	 * 将时期字段加入到JPQL语句中
	 * @param jpql
	 * @param object 
	 * @return {@link String}
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	private static String dateFieldsToSql(StringBuilder jpql, Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method[] methods = object.getClass().getDeclaredMethods();
		for (final Method element : methods) {
			if (element.getName().indexOf("get") == 0) {
				List<Object> objects = (List<Object>) element.invoke(object);
				for (Object obj : objects) {
					methods = obj.getClass().getDeclaredMethods();
					String field = "";
					Object beginDate = null;
					Object endDate = null;
					for (final Method method : methods) {
						if (element.getName().indexOf("get") == 0) {
							Object o = method.invoke(obj);
							String tmpStr = element.getName().substring(3, 4).toLowerCase() + element.getName().substring(4);
							if ("beginDate".equals(tmpStr)) {
								beginDate = o;
							} else if ("endDate".equals(tmpStr)) {
								endDate = 0;
							} else {
								field = tmpStr;
							}
						}
					}
					if (field != null && field.length() > 0 && beginDate != null && endDate != null) {
						jpql.append(" and o." + field + " >= " + beginDate + " ");
						jpql.append(" and o." + field + " <= " + endDate + " ");
					}
				}
			}
		}
		return jpql.toString();
	}

	/**
	 * 取得jpql语句
	 * 
	 * @param map
	 * @return jpql
	 */
	@SuppressWarnings("rawtypes")
	public static String getJpql(Map map) {
		if (null == map) { return null; }
		String jpql = "";
		for (final Iterator it = map.keySet().iterator(); it.hasNext();) {
			jpql = it.next().toString();
		}
		return jpql;
	}

	/**
	 * 取得jpql语句中需要的参数值
	 * 
	 * @param map
	 * @return Object[]
	 */
	@SuppressWarnings("rawtypes")
	public static Object[] getParams(Map map) {
		if (null == map) { return null; }
		List list = new ArrayList();
		for (final Iterator it = map.keySet().iterator(); it.hasNext();) {
			final Object key = it.next();
			if (null == map.get(key)) { return null; }
			list = (ArrayList) map.get(key);
		}
		return list.toArray();
	}

	/**
	 * 检验jqpl语句的合法性(默认返回TRUE)
	 * 
	 * @param jpql
	 * @return {@link Boolean}
	 */
	public static boolean validJpql(String jpql) {
		if (jpql.toLowerCase().indexOf("select") < 0) { return false; }
		if (jpql.toLowerCase().indexOf("from") < 0) { return false; }
		return true;
	}
}
