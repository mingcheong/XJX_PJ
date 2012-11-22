/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.base.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Entity(name = "baseCompactModel")
@Table(name = "B006")
public class BaseCompactModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseCompactModel() {
		super();
	}

	public BaseCompactModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	private java.lang.String compactType;
	private java.lang.String industryTypes;
	private java.lang.String unitChief;
	private java.lang.String preparer;
	private java.lang.String phone;
	private List<BaseCompactDataModel> baseCompactDatas;

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

	@Column(name = "CT", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getCompactType() {
		return this.compactType;
	}

	public void setCompactType(java.lang.String compactType) {
		this.compactType = compactType;
	}

	@Column(name = "IT", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getIndustryTypes() {
		return this.industryTypes;
	}

	public void setIndustryTypes(java.lang.String industryTypes) {
		this.industryTypes = industryTypes;
	}

	@Column(name = "UC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getUnitChief() {
		return this.unitChief;
	}

	public void setUnitChief(java.lang.String unitChief) {
		this.unitChief = unitChief;
	}

	@Column(name = "CPP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getPreparer() {
		return this.preparer;
	}

	public void setPreparer(java.lang.String preparer) {
		this.preparer = preparer;
	}

	@Column(name = "CP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getPhone() {
		return this.phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public void setBaseCompactDatas(List<BaseCompactDataModel> baseCompactDatas) {
		this.baseCompactDatas = baseCompactDatas;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "baseCompact")
	public List<BaseCompactDataModel> getBaseCompactDatas() {
		return baseCompactDatas;
	}
}
