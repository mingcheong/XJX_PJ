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
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 培训管理
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyTrainModel")
@Table(name = "C008")
public class CompanyTrainModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyTrainModel() {
		super();
	}

	public CompanyTrainModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	private java.lang.String personName;		//培训人员姓名
	private java.lang.String personIdcard;		//培训人员身份证
	private java.lang.String personPhone;		//电话
	private java.lang.String certificateCode;	//身份证
	private java.lang.Float score;				//得分
	private java.lang.Integer state;			//培训状态
	private java.lang.String trainType;  		//培训类型

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

	@Column(name = "PN", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getPersonName() {
		return this.personName;
	}

	public void setPersonName(java.lang.String personName) {
		this.personName = personName;
	}

	@Column(name = "PID", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getPersonIdcard() {
		return this.personIdcard;
	}

	public void setPersonIdcard(java.lang.String personIdcard) {
		this.personIdcard = personIdcard;
	}

	@Column(name = "PP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getPersonPhone() {
		return this.personPhone;
	}

	public void setPersonPhone(java.lang.String personPhone) {
		this.personPhone = personPhone;
	}

	@Column(name = "CC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCertificateCode() {
		return this.certificateCode;
	}

	public void setCertificateCode(java.lang.String certificateCode) {
		this.certificateCode = certificateCode;
	}

	@Column(name = "PSC", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Float getScore() {
		return this.score;
	}

	public void setScore(java.lang.Float score) {
		this.score = score;
	}

	@Column(name = "PST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getState() {
		return this.state;
	}

	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	public void setCompanyInfo(CompanyInfoModel companyInfo) {
		this.companyInfo = companyInfo;
	}
	
	@Column(name = "TT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getTrainType() {
		return trainType;
	}

	public void setTrainType(java.lang.String trainType) {
		this.trainType = trainType;
	}
	

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "CI", insertable = true, updatable = true)
	public CompanyInfoModel getCompanyInfo() {
		return companyInfo;
	}
}
