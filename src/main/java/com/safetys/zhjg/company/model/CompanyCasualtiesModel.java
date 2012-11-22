/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 人员伤亡情况实体
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyCasualtiesModel")
@Table(name = "C005")
public class CompanyCasualtiesModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyCasualtiesModel() {
		super();
	}

	public CompanyCasualtiesModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//姓名
	private java.lang.String name;
	//性别
	private java.lang.String sex;
	//年龄
	private java.lang.Integer age;
	//身份证
	private java.lang.String idcard;
	//地址	
	private java.lang.String address;

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

	@Column(name = "CN", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@Column(name = "CS", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.String getSex() {
		return this.sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	@Column(name = "CA", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getAge() {
		return this.age;
	}

	public void setAge(java.lang.Integer age) {
		this.age = age;
	}

	@Column(name = "CI", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(java.lang.String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "ADS", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getAddress() {
		return this.address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

}
