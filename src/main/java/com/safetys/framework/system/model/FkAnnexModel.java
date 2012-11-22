/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 附件
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "fkAnnexModel")
@Table(name = "A007")
public class FkAnnexModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public FkAnnexModel() {
		super();
	}

	public FkAnnexModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}
	
	/**
	 * 附件的objectType和annexPath参考@com.safetys.framework.utils.StaticMember
	 */

	//对象编号
	private java.lang.Long objectId;
	//对象类别
	private java.lang.Long objectType;
	//附件原名称
	private java.lang.String annexName;
	//附件路劲
	private java.lang.String annexPath;
	//附件类别
	private java.lang.String annexType;
	//附件大小
	private java.lang.Float annexSize;
	//附件描述
	private java.lang.String annexDesc;

	@Column(name = "O", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Long getObjectId() {
		return this.objectId;
	}

	public void setObjectId(java.lang.Long objectId) {
		this.objectId = objectId;
	}

	@Column(name = "OT", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Long getObjectType() {
		return this.objectType;
	}

	public void setObjectType(java.lang.Long objectType) {
		this.objectType = objectType;
	}

	@Column(name = "N", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getAnnexName() {
		return this.annexName;
	}

	public void setAnnexName(java.lang.String annexName) {
		this.annexName = annexName;
	}

	@Column(name = "P", unique = false, nullable = false, insertable = true, updatable = true, length = 500)
	public java.lang.String getAnnexPath() {
		return this.annexPath;
	}

	public void setAnnexPath(java.lang.String annexPath) {
		this.annexPath = annexPath;
	}

	@Column(name = "AT", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getAnnexType() {
		return this.annexType;
	}

	public void setAnnexType(java.lang.String annexType) {
		this.annexType = annexType;
	}

	@Column(name = "S", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Float getAnnexSize() {
		return this.annexSize;
	}

	public void setAnnexSize(java.lang.Float annexSize) {
		this.annexSize = annexSize;
	}

	@Column(name = "D", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public java.lang.String getAnnexDesc() {
		return this.annexDesc;
	}

	public void setAnnexDesc(java.lang.String annexDesc) {
		this.annexDesc = annexDesc;
	}

}
