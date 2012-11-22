package com.safetys.framework.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {

	private static final DateFormat[] ACCEPT_DATE_FORMATS = { 
			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"), 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
	        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss") };

	@Override
	@SuppressWarnings("rawtypes")
	public Object convertValue(Map context, Object value, Class toType) {
		Date date = null;
		if (toType == Date.class) {
			String dateString = null;
			String[] params = (String[]) value;
			dateString = params[0];
			for (DateFormat format : ACCEPT_DATE_FORMATS) {
				try {
					return format.parse(dateString);
				} catch (Exception e) {
					continue;
				}
			}
		} else if (toType == String.class) {
			date = (Date) value;
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		}
		return null;
	}
}
