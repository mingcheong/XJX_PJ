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
 * 菜单资源
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkResourceModel")
@Table(name = "A008")
public class FkResourceModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkResourceModel() {
		super();
	}

	public FkResourceModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private List<FkResourceModel> children;
	//父类编号
	private java.lang.Long fatherId;
	//是否是菜单
	private java.lang.Boolean isMenu = true;
	//是否有子类
	private java.lang.Boolean hasChildren = false;
	//图片地址
	private java.lang.String resourceImg;
	//资源名字
	private java.lang.String resourceName;
	//资源链接
	private java.lang.String resourceUrl;

	@Column(name = "F", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.lang.Long getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(java.lang.Long fatherId) {
		this.fatherId = fatherId;
	}

	@Column(name = "M", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsMenu() {
		return this.isMenu;
	}

	public void setIsMenu(java.lang.Boolean isMenu) {
		this.isMenu = isMenu;
	}

	@Column(name = "H", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(java.lang.Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	@Column(name = "I", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getResourceImg() {
		return this.resourceImg;
	}

	public void setResourceImg(java.lang.String resourceImg) {
		this.resourceImg = resourceImg;
	}

	@Column(name = "R", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(java.lang.String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @return the children
	 */
	@Transient
	public List<FkResourceModel> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<FkResourceModel> children) {
		this.children = children;
	}

	@Column(name = "U", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getResourceUrl() {
		return this.resourceUrl;
	}

	public void setResourceUrl(java.lang.String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

}
