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
import com.safetys.framework.system.model.FkOrganizeModel;

/**
 * 重大危险源实体 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyHiddendangerModel")
@Table(name = "C009")
public class CompanyHiddendangerModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyHiddendangerModel() {
		super();
	}

	public CompanyHiddendangerModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//隐患代码
	private java.lang.String code;
	//市级以上重点工程
	private java.lang.Boolean isAbove=false;
	//隐患地址
	private java.lang.String dangerAddress;
	//联系人
	private java.lang.String dangerContact;
	//联系电话
	private java.lang.String dangerPhone;
	//手机
	private java.lang.String dangerMobile;
	//内容
	private java.lang.String dangerContent;
	//隐患类型
	private java.lang.String dangerType;
	//企业信息
	private CompanyInfoModel companyInfoModel;
	//挂牌级别
	private java.lang.String level;
	//督办部门
	private java.lang.String supervise;
	//督办完成时间
	private java.util.Date completionDate;
	//督办单位
	private FkOrganizeModel fkOrganizeModel;

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

	@Column(name = "CC", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getCode() {
		return this.code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	@Column(name = "CIA", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsAbove() {
		return this.isAbove;
	}

	public void setIsAbove(java.lang.Boolean isAbove) {
		this.isAbove = isAbove;
	}

	@Column(name = "CDA", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getDangerAddress() {
		return this.dangerAddress;
	}

	public void setDangerAddress(java.lang.String dangerAddress) {
		this.dangerAddress = dangerAddress;
	}

	@Column(name = "CDC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getDangerContact() {
		return this.dangerContact;
	}

	public void setDangerContact(java.lang.String dangerContact) {
		this.dangerContact = dangerContact;
	}

	@Column(name = "CDP", unique = false, nullable = true, insertable = true, updatable = true, length = 13)
	public java.lang.String getDangerPhone() {
		return this.dangerPhone;
	}

	public void setDangerPhone(java.lang.String dangerPhone) {
		this.dangerPhone = dangerPhone;
	}

	@Column(name = "CDM", unique = false, nullable = true, insertable = true, updatable = true, length = 13)
	public java.lang.String getDangerMobile() {
		return this.dangerMobile;
	}

	public void setDangerMobile(java.lang.String dangerMobile) {
		this.dangerMobile = dangerMobile;
	}

	@Column(name = "DCT", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getDangerContent() {
		return this.dangerContent;
	}

	public void setDangerContent(java.lang.String dangerContent) {
		this.dangerContent = dangerContent;
	}

	@Column(name = "DT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getDangerType() {
		return this.dangerType;
	}

	public void setDangerType(java.lang.String dangerType) {
		this.dangerType = dangerType;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "CI", insertable = true, updatable = true)
	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}

	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}
	@Column(name = "CL", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getLevel() {
		return this.level;
	}

	public void setLevel(java.lang.String level) {
		this.level = level;
	}

	@Column(name = "CS", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getSupervise() {
		return this.supervise;
	}

	public void setSupervise(java.lang.String supervise) {
		this.supervise = supervise;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CDE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getCompletionDate() {
		return this.completionDate;
	}

	public void setCompletionDate(java.util.Date completionDate) {
		this.completionDate = completionDate;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "OI", insertable = true, updatable = true)
	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}
}
