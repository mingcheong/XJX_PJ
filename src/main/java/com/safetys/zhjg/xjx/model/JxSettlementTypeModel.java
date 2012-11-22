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
@Entity(name = "jxSettlementTypeModel")
@Table(name = "jx_settlement_type")
@AttributeOverride(name = "id", column = @Column(name = "JS_ID"))
public class JxSettlementTypeModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxSettlementTypeModel()
	{
		super();
	}


	public JxSettlementTypeModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jsCode;
	private java.lang.String jsName;
	private java.lang.String jsRemark;



	@Column(name = "JS_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsCode()
	{
		return this.jsCode;
	}


	public void setJsCode(java.lang.String jsCode)
	{
		this.jsCode = jsCode;
	}


	@Column(name = "JS_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsName()
	{
		return this.jsName;
	}


	public void setJsName(java.lang.String jsName)
	{
		this.jsName = jsName;
	}


	@Column(name = "JS_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJsRemark()
	{
		return this.jsRemark;
	}


	public void setJsRemark(java.lang.String jsRemark)
	{
		this.jsRemark = jsRemark;
	}
}
