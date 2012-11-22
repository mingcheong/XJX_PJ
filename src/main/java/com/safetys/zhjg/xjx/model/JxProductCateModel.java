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
@Entity(name = "jxProductCateModel")
@Table(name = "jx_product_cate")
@AttributeOverride(name = "id", column = @Column(name = "JPC_ID"))
public class JxProductCateModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxProductCateModel()
	{
		super();
	}


	public JxProductCateModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jpcCode;
	private java.lang.String jpcName;
	private java.lang.Boolean jpcUse;
	private java.lang.String jpcMemo;



	@Column(name = "JPC_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJpcCode()
	{
		return this.jpcCode;
	}


	public void setJpcCode(java.lang.String jpcCode)
	{
		this.jpcCode = jpcCode;
	}


	@Column(name = "JPC_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public java.lang.String getJpcName()
	{
		return this.jpcName;
	}


	public void setJpcName(java.lang.String jpcName)
	{
		this.jpcName = jpcName;
	}


	@Column(name = "JPC_USE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJpcUse()
	{
		return this.jpcUse;
	}


	public void setJpcUse(java.lang.Boolean jpcUse)
	{
		this.jpcUse = jpcUse;
	}


	@Column(name = "JPC_MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJpcMemo()
	{
		return this.jpcMemo;
	}


	public void setJpcMemo(java.lang.String jpcMemo)
	{
		this.jpcMemo = jpcMemo;
	}

}
