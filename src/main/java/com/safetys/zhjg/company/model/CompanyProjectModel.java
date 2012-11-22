/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 建设项目（三同时） 
 * 此文件通过快速开发平台自动生成
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyProjectModel")
@Table(name = "C011")
public class CompanyProjectModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyProjectModel() {
		super();
	}

	public CompanyProjectModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	// 项目名称
	private java.lang.String projectName;
	// 项目地址
	private java.lang.String projectAddress;
	// 投资金额
	private java.lang.Float projectInvestment;
	// 项目类型
	private java.lang.String projectType;
	// 设施类型
	private java.lang.String facilitiesType;
	// 土地性质
	private java.lang.String landType;
	// 规划许可情况
	private java.lang.String content1;
	// 投资主管部门对建设项目是否进行审批（核准、备案）？若无，无需对项目审批（核准、备案）原因的说明。
	private java.lang.String content2;
	// 建设项目主要内容，工艺及技术来源
	private java.lang.String content3;
	// 项目实施后，危险化学产品（包括副产、中间产品）品种、能力的前后变化。
	private java.lang.String content4;
	// 企业信息
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

	@Column(name = "PN", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(java.lang.String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "PA", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getProjectAddress() {
		return this.projectAddress;
	}

	public void setProjectAddress(java.lang.String projectAddress) {
		this.projectAddress = projectAddress;
	}

	@Column(name = "PI", unique = false, nullable = true, insertable = true, updatable = true, length = 12)
	public java.lang.Float getProjectInvestment() {
		return this.projectInvestment;
	}

	public void setProjectInvestment(java.lang.Float projectInvestment) {
		this.projectInvestment = projectInvestment;
	}

	@Column(name = "PT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(java.lang.String projectType) {
		this.projectType = projectType;
	}

	@Column(name = "FT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFacilitiesType() {
		return this.facilitiesType;
	}

	public void setFacilitiesType(java.lang.String facilitiesType) {
		this.facilitiesType = facilitiesType;
	}

	@Column(name = "LT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getLandType() {
		return this.landType;
	}

	public void setLandType(java.lang.String landType) {
		this.landType = landType;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CT1", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getContent1() {
		return this.content1;
	}

	public void setContent1(java.lang.String content1) {
		this.content1 = content1;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CT2", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getContent2() {
		return this.content2;
	}

	public void setContent2(java.lang.String content2) {
		this.content2 = content2;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CT3", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getContent3() {
		return this.content3;
	}

	public void setContent3(java.lang.String content3) {
		this.content3 = content3;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CT4", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getContent4() {
		return this.content4;
	}

	public void setContent4(java.lang.String content4) {
		this.content4 = content4;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "CI", insertable = true, updatable = true)
	public CompanyInfoModel getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfoModel companyInfo) {
		this.companyInfo = companyInfo;
	}
}
