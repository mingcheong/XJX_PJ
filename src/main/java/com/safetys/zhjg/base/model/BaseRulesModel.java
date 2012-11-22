/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 法律法规
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "baseRulesModel")
@Table(name = "B003")
public class BaseRulesModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseRulesModel() {
		super();
	}

	public BaseRulesModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//标题
	private java.lang.String title;
	//制定单位
	private java.lang.String formUnit;
	//实施单位
	private java.lang.String implUnit;
	//类型
	private java.lang.String rulesType;
	//发布时间
	private java.util.Date releaseDate;
	//内容
	private java.lang.String content;
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
	
	@Column(name = "RT", unique = false, nullable = false, insertable = true, updatable = true, length = 250)
	public java.lang.String getTitle() {
		return this.title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	@Column(name = "FU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getFormUnit() {
		return this.formUnit;
	}

	public void setFormUnit(java.lang.String formUnit) {
		this.formUnit = formUnit;
	}

	@Column(name = "IU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getImplUnit() {
		return this.implUnit;
	}

	public void setImplUnit(java.lang.String implUnit) {
		this.implUnit = implUnit;
	}

	@Column(name = "RTP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getRulesType() {
		return this.rulesType;
	}

	public void setRulesType(java.lang.String rulesType) {
		this.rulesType = rulesType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RDE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Column(name = "RC", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getContent() {
		return this.content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

}
