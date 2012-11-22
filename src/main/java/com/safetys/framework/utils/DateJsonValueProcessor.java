package com.safetys.framework.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class DateJsonValueProcessor implements JsonValueProcessor {

	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private DateFormat dateFormat;

	public DateJsonValueProcessor(String datePattern) {

		if (null == datePattern) {
			this.dateFormat = new SimpleDateFormat(DateJsonValueProcessor.DEFAULT_DATE_PATTERN);
		} else {
			this.dateFormat = new SimpleDateFormat(datePattern);
		}

	}

	private Object process(Object value) {
		return this.dateFormat.format((Date) value);
	}

	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return this.process(arg0);
	}

	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return this.process(arg1);
	}
}
