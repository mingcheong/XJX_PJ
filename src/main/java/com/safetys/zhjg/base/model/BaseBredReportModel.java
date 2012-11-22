/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "baseBredReportModel")
@Table(name = "B008")
public class BaseBredReportModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseBredReportModel() {
		super();
	}

	public BaseBredReportModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	private java.lang.String name;
	private java.lang.Long orgsId;
	private java.lang.Boolean isReport;
	private java.util.Date reportDate;

	@Column(name = "A1", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFirstArea() {
		return firstArea;
	}
	
	public void setFirstArea(java.lang.String firstArea) {
		this.firstArea = firstArea;
	}
	
	@Column(name = "A2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSecondArea() {
		return secondArea;
	}
	
	public void setSecondArea(java.lang.String secondArea) {
		this.secondArea = secondArea;
	}
	
	@Column(name = "A3", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getThirdArea() {
		return thirdArea;
	}
	
	public void setThirdArea(java.lang.String thirdArea) {
		this.thirdArea = thirdArea;
	}
	
	@Column(name = "A4", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFourthArea() {
		return fourthArea;
	}
	
	public void setFourthArea(java.lang.String fourthArea) {
		this.fourthArea = fourthArea;
	}
	
	@Column(name = "A5", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFifthArea() {
		return fifthArea;
	}
	
	public void setFifthArea(java.lang.String fifthArea) {
		this.fifthArea = fifthArea;
	}

	@Column(name = "RN", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@Column(name = "OI", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Long getOrgsId() {
		return this.orgsId;
	}

	public void setOrgsId(java.lang.Long orgsId) {
		this.orgsId = orgsId;
	}

	@Column(name = "IR", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsReport() {
		return this.isReport;
	}

	public void setIsReport(java.lang.Boolean isReport) {
		this.isReport = isReport;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RDE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(java.util.Date reportDate) {
		this.reportDate = reportDate;
	}

}
