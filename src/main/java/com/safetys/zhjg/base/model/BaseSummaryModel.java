/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.base.model;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkUserModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 工作总结
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "baseSummaryModel")
@Table(name = "B002")
public class BaseSummaryModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseSummaryModel() {
		super();
	}

	public BaseSummaryModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//标题
	private java.lang.String name;
	//制定单位
	private java.lang.String ruleUnit;
	//实施单位
	private java.lang.String implUnit;
	//类型
	private java.lang.String summaryType;
	//发布时间
	private java.util.Date releaseDate;
	//内容
	private java.lang.String content;
	//备注
	private java.lang.String remark;
	//总结类型
	private java.lang.String modelType;
	private FkUserModel fkUserModel;
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

	@Column(name = "SNA", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@Column(name = "RU", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getRuleUnit() {
		return this.ruleUnit;
	}

	public void setRuleUnit(java.lang.String ruleUnit) {
		this.ruleUnit = ruleUnit;
	}

	@Column(name = "IU", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getImplUnit() {
		return this.implUnit;
	}

	public void setImplUnit(java.lang.String implUnit) {
		this.implUnit = implUnit;
	}

	@Column(name = "ST", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSummaryType() {
		return this.summaryType;
	}

	public void setSummaryType(java.lang.String summaryType) {
		this.summaryType = summaryType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RDE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Lob()
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "RC", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getContent() {
		return this.content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	@Lob()
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "RR", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "UI")
	public FkUserModel getFkUserModel() {
		return fkUserModel;
	}

	public void setFkUserModel(FkUserModel fkUserModel) {
		this.fkUserModel = fkUserModel;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH, optional = true)
	@JoinColumn(name = "OI")
	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}

	@Column(name = "TT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getModelType() {
		return modelType;
	}

	public void setModelType(java.lang.String modelType) {
		this.modelType = modelType;
	}
	
}
