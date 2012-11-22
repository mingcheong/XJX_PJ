/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 组织机构
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkOrganizeModel")
@Table(name = "A002")
public class FkOrganizeModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkOrganizeModel() {
		super();
	}

	public FkOrganizeModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	//父编号
	private java.lang.Long fatherId;
	//机构代码
	private java.lang.String orgCode;
	//机构描述
	private java.lang.String orgDesc;
	//
	private java.lang.Integer orgGrade;
	//机构名称
	private java.lang.String orgName;
	//
	private java.lang.String resources;
	//机构类型:public 内部机构,inner 外部机构
	private java.lang.String orgType;
	
	private List<FkUserModel> fkUsers;
	private List<FkOrganizeModel> children;

	@Column(name = "F", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.lang.Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(java.lang.Long fatherId) {
		this.fatherId = fatherId;
	}

	@Column(name = "C", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(java.lang.String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "D", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOrgDesc() {
		return this.orgDesc;
	}

	public void setOrgDesc(java.lang.String orgDesc) {
		this.orgDesc = orgDesc;
	}

	@Column(name = "G", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getOrgGrade() {
		return this.orgGrade;
	}

	public void setOrgGrade(java.lang.Integer orgGrade) {
		this.orgGrade = orgGrade;
	}

	@Column(name = "N", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public java.lang.String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}
	
	@Column(name = "TY", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getOrgType() {
		return orgType;
	}

	public void setOrgType(java.lang.String orgType) {
		this.orgType = orgType;
	}

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "R", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public java.lang.String getResources() {
		return this.resources;
	}

	public void setResources(java.lang.String resources) {
		this.resources = resources;
	}

	public void setFkUsers(List<FkUserModel> fkUsers) {
		this.fkUsers = fkUsers;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "fkOrganize")
	public List<FkUserModel> getFkUsers() {
		return fkUsers;
	}
	

	@Transient
	public List<FkOrganizeModel> getChildren() {
		return children;
	}


	public void setChildren(List<FkOrganizeModel> children) {
		this.children = children;
	}
	
	

}
