/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "baseCompactDataModel")
@Table(name = "B007")
public class BaseCompactDataModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseCompactDataModel() {
		super();
	}

	public BaseCompactDataModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.Integer holdNumber;
	private java.lang.Integer clampNumber;
	private java.lang.Integer holdingNumber;
	private BaseCompactModel baseCompact;

	@Column(name = "HN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getHoldNumber() {
		return this.holdNumber;
	}

	public void setHoldNumber(java.lang.Integer holdNumber) {
		this.holdNumber = holdNumber;
	}

	@Column(name = "CN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getClampNumber() {
		return this.clampNumber;
	}

	public void setClampNumber(java.lang.Integer clampNumber) {
		this.clampNumber = clampNumber;
	}

	@Column(name = "HIN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getHoldingNumber() {
		return this.holdingNumber;
	}

	public void setHoldingNumber(java.lang.Integer holdingNumber) {
		this.holdingNumber = holdingNumber;
	}

	public void setBaseCompact(BaseCompactModel baseCompact) {
		this.baseCompact = baseCompact;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "CI",insertable = true, updatable = true)
	public BaseCompactModel getBaseCompact() {
		return baseCompact;
	}
}
