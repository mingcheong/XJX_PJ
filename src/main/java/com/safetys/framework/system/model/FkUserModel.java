/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 用户
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkUserModel")
@Table(name = "A003")
public class FkUserModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkUserModel() {
		super();
	}

	public FkUserModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//出生年月
	private java.util.Date bornDate;
	//身份证号码
	private java.lang.String idCard;
	//登陆密码
	private java.lang.String password;
	//用户菜单资源
	private java.lang.String resources;
	//真实姓名
	private java.lang.String truename;
	//岗位名称
	private java.lang.String position;
	//角色  枚举
	private java.lang.String roles;
	//角色名字
	private java.lang.String rolesName;
	//性别
	private java.lang.String sex;
	//电子邮件
	private java.lang.String userEmail;
	//手机号码
	private java.lang.String userMobile;
	//固定电话
	private java.lang.String userPhone;
	//帐号名称
	private java.lang.String username;
	//
	private FkOrganizeModel fkOrganize;
	//密码
	private java.lang.String rePassword;

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
	@Column(name = "B", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(java.util.Date bornDate) {
		this.bornDate = bornDate;
	}

	@Column(name = "IC", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(java.lang.String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "P", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getPosition() {
		return position;
	}

	public void setPosition(java.lang.String position) {
		this.position = position;
	}

	@Column(name = "PW", unique = false, nullable = false, insertable = true, updatable = true, length = 35)
	public java.lang.String getPassword() {
		return this.password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "R", unique = false, nullable = true, insertable = true, updatable = true, length = 2147483647)
	public java.lang.String getResources() {
		return this.resources;
	}

	public void setResources(java.lang.String resources) {
		this.resources = resources;
	}

	@Column(name = "RS", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getRoles() {
		return roles;
	}

	public void setRoles(java.lang.String roles) {
		this.roles = roles;
	}

	@Column(name = "RN", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getRolesName() {
		return rolesName;
	}

	public void setRolesName(java.lang.String rolesName) {
		this.rolesName = rolesName;
	}

	@Column(name = "TN", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getTruename() {
		return this.truename;
	}

	public void setTruename(java.lang.String truename) {
		this.truename = truename;
	}

	@Column(name = "X", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	public java.lang.String getSex() {
		return sex;
	}

	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}

	@Column(name = "E", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "M", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(java.lang.String userMobile) {
		this.userMobile = userMobile;
	}

	@Column(name = "TP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(java.lang.String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "N", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getUsername() {
		return this.username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public void setFkOrganize(FkOrganizeModel fkOrganize) {
		this.fkOrganize = fkOrganize;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "O", insertable = true, updatable = true)
	public FkOrganizeModel getFkOrganize() {
		return fkOrganize;
	}

	@Transient
	public java.lang.String getRePassword() {
		return rePassword;
	}

	public void setRePassword(java.lang.String rePassword) {
		this.rePassword = rePassword;
	}

}
