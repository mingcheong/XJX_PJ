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
 * 通知反馈对象 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "baseNoticeFeedbackModel")
@Table(name = "B010")
public class BaseNoticeFeedbackModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public BaseNoticeFeedbackModel() {
		super();
	}

	public BaseNoticeFeedbackModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	// 通知对象
	private BaseNoticeModel baseNoticeModel;

	// 反馈内容
	private java.lang.String content;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "NI", insertable = true, updatable = true)
	public BaseNoticeModel getBaseNoticeModel() {
		return baseNoticeModel;
	}

	public void setBaseNoticeModel(BaseNoticeModel baseNoticeModel) {
		this.baseNoticeModel = baseNoticeModel;
	}

	@Column(name = "content", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getContent() {
		return this.content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

}
