/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 枚举
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkEnumModel")
@Table(name = "A006")
public class FkEnumModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkEnumModel() {
		super();
	}

	public FkEnumModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	//枚举代码
	private java.lang.String enumCode;
	//枚举描述
	private java.lang.String enumDesc;
	//枚举名称
	private java.lang.String enumName;
	//是否有子类
	private java.lang.Boolean hasChildren = false;
	//子类编号
	private java.lang.Long fatherId;
	
	private List<FkEnumModel> childern;

	@Column(name = "C", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	public java.lang.String getEnumCode() {
		return this.enumCode;
	}

	public void setEnumCode(java.lang.String enumCode) {
		this.enumCode = enumCode;
	}

	@Column(name = "D", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getEnumDesc() {
		return this.enumDesc;
	}

	public void setEnumDesc(java.lang.String enumDesc) {
		this.enumDesc = enumDesc;
	}

	@Column(name = "N", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public java.lang.String getEnumName() {
		return this.enumName;
	}

	public void setEnumName(java.lang.String enumName) {
		this.enumName = enumName;
	}

	@Column(name = "H", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(java.lang.Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	@Column(name = "F", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.lang.Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(java.lang.Long fatherId) {
		this.fatherId = fatherId;
	}

	@Transient
	public List<FkEnumModel> getChildern() {
		return childern;
	}

	public void setChildern(List<FkEnumModel> childern) {
		this.childern = childern;
	}

}
