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
@Entity(name = "jxUnitModel")
@Table(name = "jx_unit")
@AttributeOverride(name = "id", column = @Column(name = "JU_ID"))
public class JxUnitModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxUnitModel()
	{
		super();
	}


	public JxUnitModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String juCode;
	private java.lang.String juName;
	private java.lang.String juMemo;



	@Column(name = "JU_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJuCode()
	{
		return this.juCode;
	}


	public void setJuCode(java.lang.String juCode)
	{
		this.juCode = juCode;
	}


	@Column(name = "JU_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getJuName()
	{
		return this.juName;
	}


	public void setJuName(java.lang.String juName)
	{
		this.juName = juName;
	}


	@Column(name = "JU_MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJuMemo()
	{
		return this.juMemo;
	}


	public void setJuMemo(java.lang.String juMemo)
	{
		this.juMemo = juMemo;
	}
}
