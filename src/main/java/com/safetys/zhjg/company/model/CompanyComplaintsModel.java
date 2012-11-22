/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.system.model.FkAnnexModel;

/**
 * 举报投诉实体 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyComplaintsModel")
@Table(name = "C007")
public class CompanyComplaintsModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyComplaintsModel() {
		super();
	}

	public CompanyComplaintsModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	
	private java.util.Date callsDate;			//受理日期
	private java.lang.String paperNumber;		//投诉举报编号
	private java.lang.String digest;			//摘要
	private java.lang.String leaderName;		//领导姓名
	private java.lang.String complaintsName;	//举报人姓名
	private java.lang.String supervisory;		//督办情况
	private java.lang.Boolean isAppropriate;	//是否办妥
	private java.lang.String remark;			//投诉举报内容
	private java.lang.String learCheck;			//领导批示
	private java.lang.String callsName;			//受理人(登记人)姓名
	
	private List<FkAnnexModel> fkAnnexModels;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CDE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getCallsDate() {
		return this.callsDate;
	}

	public void setCallsDate(java.util.Date callsDate) {
		this.callsDate = callsDate;
	}

	@Column(name = "PNB", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getPaperNumber() {
		return this.paperNumber;
	}

	public void setPaperNumber(java.lang.String paperNumber) {
		this.paperNumber = paperNumber;
	}

	@Column(name = "CDT", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDigest() {
		return this.digest;
	}

	public void setDigest(java.lang.String digest) {
		this.digest = digest;
	}

	@Column(name = "CLN", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getLeaderName() {
		return this.leaderName;
	}

	public void setLeaderName(java.lang.String leaderName) {
		this.leaderName = leaderName;
	}

	@Column(name = "CCN", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getComplaintsName() {
		return this.complaintsName;
	}

	public void setComplaintsName(java.lang.String complaintsName) {
		this.complaintsName = complaintsName;
	}

	@Column(name = "CSY", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getSupervisory() {
		return this.supervisory;
	}

	public void setSupervisory(java.lang.String supervisory) {
		this.supervisory = supervisory;
	}

	@Column(name = "CIA", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsAppropriate() {
		return this.isAppropriate;
	}

	public void setIsAppropriate(java.lang.Boolean isAppropriate) {
		this.isAppropriate = isAppropriate;
	}

	@Column(name = "CRK", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	@Column(name = "LC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getLearCheck() {
		return learCheck;
	}

	public void setLearCheck(java.lang.String learCheck) {
		this.learCheck = learCheck;
	}
	
	@Column(name = "CN", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCallsName() {
		return callsName;
	}

	public void setCallsName(java.lang.String callsName) {
		this.callsName = callsName;
	}
	
	@Transient
	public List<FkAnnexModel> getFkAnnexModels() {
		return fkAnnexModels;
	}

	public void setFkAnnexModels(List<FkAnnexModel> fkAnnexModels) {
		this.fkAnnexModels = fkAnnexModels;
	}

}
