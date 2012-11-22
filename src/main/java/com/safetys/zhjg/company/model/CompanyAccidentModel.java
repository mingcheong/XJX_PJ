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
 * 事故上报实体
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyAccidentModel")
@Table(name = "C006")
public class CompanyAccidentModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyAccidentModel() {
		super();
	}

	public CompanyAccidentModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;				//*事故所在区域
	private java.lang.String bigtype;				//*事故大类
	private java.lang.String accidentReportUnit;	//*事故报告单位名称	组织机构
	
	private java.lang.String accidentContact;		//事故单位联系人
	
	private java.lang.String accidentPhone;			//事故单位电话
	private java.lang.String accidentType;			//事故类型
	private java.lang.String accidentDuty;			//事故责任单位
	private java.lang.Float accidentLoss;			//直接经济损失
	private java.util.Date accidentDate;			//*事故时间
	private java.util.Date accidentReportDate;		//事故接报时间
	private java.lang.Integer totalNumber;			//伤亡情况->现场共有人数
	private java.lang.Integer deathNumber;			//伤亡情况->其中死亡人数
	private java.lang.Integer missedNumber;			//伤亡情况->其中失踪人数
	private java.lang.Integer seriovsWoundNumber;	//伤亡情况->其中重伤人数
	private java.lang.Integer minorWoundNumber;		//伤亡情况->其中轻伤人数
	private java.lang.String casualtiesIds;			//伤亡人员ID数组以,号分割
	private java.lang.String casualtiesNames;		//伤亡人员姓名数组以,号分割
	private java.lang.String accidentContent;		//*事故简要情况
	private java.lang.Boolean isReport;				//*是否已上报
	
	//private java.lang.Long accidentUnit;			//*事故单位名称		发生事故的企业
	private CompanyInfoModel accidentUnit;			//*事故单位名称		发生事故的企业
	private FkOrganizeModel  accidentReportOrgan;	//*事故报告单位  
	

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

	@Column(name = "CBT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getBigtype() {
		return this.bigtype;
	}

	public void setBigtype(java.lang.String bigtype) {
		this.bigtype = bigtype;
	}

	@Column(name = "ARU", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getAccidentReportUnit() {
		return this.accidentReportUnit;
	}

	public void setAccidentReportUnit(java.lang.String accidentReportUnit) {
		this.accidentReportUnit = accidentReportUnit;
	}

	@Column(name = "ACT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getAccidentContact() {
		return this.accidentContact;
	}

	public void setAccidentContact(java.lang.String accidentContact) {
		this.accidentContact = accidentContact;
	}



	@Column(name = "CAP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getAccidentPhone() {
		return this.accidentPhone;
	}

	public void setAccidentPhone(java.lang.String accidentPhone) {
		this.accidentPhone = accidentPhone;
	}

	@Column(name = "CAD", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getAccidentDuty() {
		return this.accidentDuty;
	}

	public void setAccidentDuty(java.lang.String accidentDuty) {
		this.accidentDuty = accidentDuty;
	}

	@Column(name = "CAL", unique = false, nullable = true, insertable = true, updatable = true, length = 22)
	public java.lang.Float getAccidentLoss() {
		return this.accidentLoss;
	}

	public void setAccidentLoss(java.lang.Float accidentLoss) {
		this.accidentLoss = accidentLoss;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getAccidentDate() {
		return this.accidentDate;
	}

	public void setAccidentDate(java.util.Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ARD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getAccidentReportDate() {
		return this.accidentReportDate;
	}

	public void setAccidentReportDate(java.util.Date accidentReportDate) {
		this.accidentReportDate = accidentReportDate;
	}
	
	@Column(name = "CAT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getAccidentType() {
		return this.accidentType;
	}

	public void setAccidentType(java.lang.String accidentType) {
		this.accidentType = accidentType;
	}
	
	@Column(name = "TN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getTotalNumber() {
		return this.totalNumber;
	}

	public void setTotalNumber(java.lang.Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	@Column(name = "DN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getDeathNumber() {
		return this.deathNumber;
	}

	public void setDeathNumber(java.lang.Integer deathNumber) {
		this.deathNumber = deathNumber;
	}

	@Column(name = "MN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMissedNumber() {
		return this.missedNumber;
	}

	public void setMissedNumber(java.lang.Integer missedNumber) {
		this.missedNumber = missedNumber;
	}

	@Column(name = "SWN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getSeriovsWoundNumber() {
		return this.seriovsWoundNumber;
	}

	public void setSeriovsWoundNumber(java.lang.Integer seriovsWoundNumber) {
		this.seriovsWoundNumber = seriovsWoundNumber;
	}

	@Column(name = "MWN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMinorWoundNumber() {
		return this.minorWoundNumber;
	}

	public void setMinorWoundNumber(java.lang.Integer minorWoundNumber) {
		this.minorWoundNumber = minorWoundNumber;
	}

	@Column(name = "CID", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getCasualtiesIds() {
		return this.casualtiesIds;
	}

	public void setCasualtiesIds(java.lang.String casualtiesIds) {
		this.casualtiesIds = casualtiesIds;
	}

	@Column(name = "CNS", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getCasualtiesNames() {
		return this.casualtiesNames;
	}

	public void setCasualtiesNames(java.lang.String casualtiesNames) {
		this.casualtiesNames = casualtiesNames;
	}

	@Column(name = "CAC", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getAccidentContent() {
		return this.accidentContent;
	}

	public void setAccidentContent(java.lang.String accidentContent) {
		this.accidentContent = accidentContent;
	}

	@Column(name = "CIR", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsReport() {
		return this.isReport;
	}

	public void setIsReport(java.lang.Boolean isReport) {
		this.isReport = isReport;
	}
	
	/*@Column(name = "CAU", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Long getAccidentUnit() {
		return this.accidentUnit;
	}

	public void setAccidentUnit(java.lang.Long accidentUnit) {
		this.accidentUnit = accidentUnit;
	}*/

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "CAU", insertable = true, updatable = true)
	public CompanyInfoModel getAccidentUnit() {
		return accidentUnit;
	}

	public void setAccidentUnit(CompanyInfoModel accidentUnit) {
		this.accidentUnit = accidentUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ARO", insertable = true, updatable = true)
	public FkOrganizeModel getAccidentReportOrgan() {
		return this.accidentReportOrgan;
	}

	public void setAccidentReportOrgan(FkOrganizeModel accidentReportOrgan) {
		this.accidentReportOrgan = accidentReportOrgan;
	}

}
