/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 标准化
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyStandardModel")
@Table(name = "C004")
public class CompanyStandardModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyStandardModel() {
		super();
	}

	public CompanyStandardModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//
	private java.lang.String companyChief;
	//
	private java.lang.String economicType;
	//标准化达标级别
	private java.lang.String companyLeavel;
	//证书编号
	private java.lang.String certificateNumber;
	//标准化类型
	private java.lang.String standardType;
	//有效日期    起
	private java.util.Date validityBegin;
	//有效日期   止
	private java.util.Date validityEnd;
	//发证日期
	private java.util.Date issueDate;
	//发证机关
	private java.lang.String issueUnit;
	private CompanyInfoModel companyInfo;

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


	@Column(name = "CC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCompanyChief() {
		return this.companyChief;
	}

	public void setCompanyChief(java.lang.String companyChief) {
		this.companyChief = companyChief;
	}

	@Column(name = "ET", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getEconomicType() {
		return this.economicType;
	}

	public void setEconomicType(java.lang.String economicType) {
		this.economicType = economicType;
	}

	@Column(name = "CL", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCompanyLeavel() {
		return this.companyLeavel;
	}

	public void setCompanyLeavel(java.lang.String companyLeavel) {
		this.companyLeavel = companyLeavel;
	}

	@Column(name = "CN", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCertificateNumber() {
		return this.certificateNumber;
	}

	public void setCertificateNumber(java.lang.String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	@Column(name = "ST", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getStandardType() {
		return this.standardType;
	}

	public void setStandardType(java.lang.String standardType) {
		this.standardType = standardType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VB", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getValidityBegin() {
		return this.validityBegin;
	}

	public void setValidityBegin(java.util.Date validityBegin) {
		this.validityBegin = validityBegin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getValidityEnd() {
		return this.validityEnd;
	}

	public void setValidityEnd(java.util.Date validityEnd) {
		this.validityEnd = validityEnd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ISD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(java.util.Date issueDate) {
		this.issueDate = issueDate;
	}

	@Column(name = "IU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getIssueUnit() {
		return this.issueUnit;
	}

	public void setIssueUnit(java.lang.String issueUnit) {
		this.issueUnit = issueUnit;
	}

	public void setCompanyInfo(CompanyInfoModel companyInfo) {
		this.companyInfo = companyInfo;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "CI", insertable = true, updatable = true)
	public CompanyInfoModel getCompanyInfo() {
		return companyInfo;
	}
}
