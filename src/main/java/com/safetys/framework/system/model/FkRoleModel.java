/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 角色
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkRoleModel")
@Table(name = "A004")
public class FkRoleModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkRoleModel() {
		super();
	}

	public FkRoleModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	//资源
	private java.lang.String resources;
	//角色编码
	private java.lang.String roleCode;
	//角色名称
	private java.lang.String roleName;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "R", unique = false, nullable = true, insertable = true, updatable = true, length = 2147483647)
	public java.lang.String getResources() {
		return this.resources;
	}

	public void setResources(java.lang.String resources) {
		this.resources = resources;
	}

	@Column(name = "C", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(java.lang.String roleCode) {
		this.roleCode = roleCode;
	}

	@Column(name = "N", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}

}
