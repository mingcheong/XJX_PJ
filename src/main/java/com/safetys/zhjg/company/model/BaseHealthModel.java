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
 * 职业健康防治 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "baseHealthModel")
@Table(name = "B012")
public class BaseHealthModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseHealthModel() {
		super();
	}

	public BaseHealthModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	// 职工人数
	private java.lang.Integer staffNum;
	// 工作场所
	private java.lang.String workPlace;
	// 工种
	private java.lang.String workType;
	// 健康情况
	private java.lang.String scription;
	// 企业信息
	private CompanyInfoModel companyInfo;

	@Column(name = "NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStaffNum() {
		return this.staffNum;
	}

	public void setStaffNum(java.lang.Integer staffNum) {
		this.staffNum = staffNum;
	}

	@Column(name = "WP", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getWorkPlace() {
		return this.workPlace;
	}

	public void setWorkPlace(java.lang.String workPlace) {
		this.workPlace = workPlace;
	}

	@Column(name = "WT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getWorkType() {
		return this.workType;
	}

	public void setWorkType(java.lang.String workType) {
		this.workType = workType;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "SC", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getScription() {
		return this.scription;
	}

	public void setScription(java.lang.String scription) {
		this.scription = scription;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "CI", insertable = true, updatable = true)
	public CompanyInfoModel getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfoModel companyInfo) {
		this.companyInfo = companyInfo;
	}

}
