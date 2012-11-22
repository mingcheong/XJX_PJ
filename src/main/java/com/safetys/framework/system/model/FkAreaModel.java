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
 * 区域
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkAreaModel")
@Table(name = "A005")
public class FkAreaModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkAreaModel() {
		super();
	}

	public FkAreaModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	//区域代码
	private java.lang.String areaCode;
	//区域名称
	private java.lang.String areaName;
	//是否有子类
	private java.lang.Boolean hasChildren = false;
	//父类编号
	private java.lang.Long fatherId;
	
	private List<FkAreaModel> children;

	@Column(name = "C", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(java.lang.String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "N", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(java.lang.String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "F", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.lang.Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(java.lang.Long fatherId) {
		this.fatherId = fatherId;
	}

	@Column(name = "H", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(java.lang.Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	@Transient
	public List<FkAreaModel> getChildren() {
		return children;
	}

	public void setChildren(List<FkAreaModel> children) {
		this.children = children;
	}

}
