/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity(name = "jxPuchaseTypeModel")
@Table(name = "jx_puchase_type")
@AttributeOverride(name = "id", column = @Column(name = "JP_ID"))
public class JxPuchaseTypeModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxPuchaseTypeModel()
	{
		super();
	}


	public JxPuchaseTypeModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jpCode;
	private java.lang.String jpName;
	private java.lang.Boolean jpCanuse;
	private java.lang.String jpRemark;



	@Column(name = "JP_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJpCode()
	{
		return this.jpCode;
	}


	public void setJpCode(java.lang.String jpCode)
	{
		this.jpCode = jpCode;
	}


	@Column(name = "JP_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getJpName()
	{
		return this.jpName;
	}


	public void setJpName(java.lang.String jpName)
	{
		this.jpName = jpName;
	}


	@Column(name = "JP_CANUSE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJpCanuse()
	{
		return this.jpCanuse;
	}


	public void setJpCanuse(java.lang.Boolean jpCanuse)
	{
		this.jpCanuse = jpCanuse;
	}


	@Column(name = "JP_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJpRemark()
	{
		return this.jpRemark;
	}


	public void setJpRemark(java.lang.String jpRemark)
	{
		this.jpRemark = jpRemark;
	}
}
