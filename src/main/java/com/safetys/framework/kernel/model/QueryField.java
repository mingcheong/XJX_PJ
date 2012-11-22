package com.safetys.framework.kernel.model;

import java.util.Date;

/**
 * 日期查询对象
 * @author Stone
 *
 */
public class QueryField {
	/**
	 * 查询字段
	 */
	private String field;
	/**
	 * 启始时间
	 */
	private Date beginDate;
	/**
	 * 结束时间
	 */
	private Date endDate;

	/**
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

}
