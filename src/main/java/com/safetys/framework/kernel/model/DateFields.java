package com.safetys.framework.kernel.model;

import java.io.Serializable;
import java.util.List;

/**
 * 封装时间查询对象
 * 
 * @author Stone
 */
public class DateFields implements Serializable {

	private static final long serialVersionUID = -3491673019142478807L;

	private List<QueryField> queryFields;

	public List<QueryField> getQueryFields() {
		return queryFields;
	}

	public void setQueryFields(List<QueryField> queryFields) {
		this.queryFields = queryFields;
	}

}