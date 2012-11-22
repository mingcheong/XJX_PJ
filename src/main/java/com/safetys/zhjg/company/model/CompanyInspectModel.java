/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.model;

import javax.persistence.*;

import com.safetys.framework.kernel.model.BaseModel;
import javax.servlet.http.HttpServletRequest;


/**
 * 此文件通过快速开发平台自动生成
 * 
 * 行政执法
 * 
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyInspectModel")
@Table(name = "C012")
public class CompanyInspectModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public CompanyInspectModel(){ 
		super();
	}
	
	public CompanyInspectModel(HttpServletRequest request, String tableId){
		super(request, tableId);
	}
	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	private java.lang.String inspecttype;
	private java.util.Date startdate;
	private java.util.Date enddate;
	private java.lang.String place;
	private java.lang.String inspectors;
	private java.lang.String recordors;
	private java.lang.String enforceunit;
	private java.lang.String remark;
	private CompanyInfoModel companyInfoModel;
	
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
	
	@Column(name = "IT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getInspecttype() {
		return this.inspecttype;
	}
	
	public void setInspecttype(java.lang.String inspecttype) {
		this.inspecttype = inspecttype;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getStartdate() {
		return this.startdate;
	}
	
	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ED", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getEnddate() {
		return this.enddate;
	}
	
	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}
	
	@Column(name = "PL", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getPlace() {
		return this.place;
	}
	
	public void setPlace(java.lang.String place) {
		this.place = place;
	}
	
	@Column(name = "IO", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getInspectors() {
		return this.inspectors;
	}
	
	public void setInspectors(java.lang.String inspectors) {
		this.inspectors = inspectors;
	}
	
	@Column(name = "RO", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getRecordors() {
		return this.recordors;
	}
	
	public void setRecordors(java.lang.String recordors) {
		this.recordors = recordors;
	}
	
	@Column(name = "EU", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getEnforceunit() {
		return this.enforceunit;
	}
	
	public void setEnforceunit(java.lang.String enforceunit) {
		this.enforceunit = enforceunit;
	}
	
	@Column(name = "RM", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "CI", insertable = true, updatable = true)
	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}

	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}
	
}

