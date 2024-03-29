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
@Entity(name = "jxWarehouseModel")
@Table(name = "jx_warehouse")
@AttributeOverride(name = "id", column = @Column(name = "JW_ID"))
public class JxWarehouseModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxWarehouseModel()
	{
		super();
	}


	public JxWarehouseModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jwCode;
	private java.lang.String jwName;
	private java.lang.String jwMemo;

	// 仓库员枚举
	private java.lang.String users;
	// 仓库员名字
	private java.lang.String usersName;



	@Column(name = "JW_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJwCode()
	{
		return this.jwCode;
	}


	public void setJwCode(java.lang.String jwCode)
	{
		this.jwCode = jwCode;
	}


	@Column(name = "JW_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getJwName()
	{
		return this.jwName;
	}


	public void setJwName(java.lang.String jwName)
	{
		this.jwName = jwName;
	}


	@Column(name = "JW_MEMO", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJwMemo()
	{
		return this.jwMemo;
	}


	public void setJwMemo(java.lang.String jwMemo)
	{
		this.jwMemo = jwMemo;
	}


	@Column(name = "JW_USERS", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getUsers()
	{
		return users;
	}


	public void setUsers(java.lang.String users)
	{
		this.users = users;
	}


	@Column(name = "JW_USERSNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getUsersName()
	{
		return usersName;
	}


	public void setUsersName(java.lang.String usersName)
	{
		this.usersName = usersName;
	}
}
