/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Entity(name = "jxSupplierModel")
@Table(name = "jx_supplier")
@AttributeOverride(name = "id", column = @Column(name = "JS_ID"))
public class JxSupplierModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxSupplierModel()
	{
		super();
	}


	public JxSupplierModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jsCode;
	private java.lang.String jsName;
	private java.lang.String jsAddr;
	private java.lang.String jsPost;
	private java.lang.String jsTele;
	private java.lang.String jsFullname;
	private java.lang.String jsBank;
	private java.lang.String jsAccount;
	private java.lang.String jsDutyno;
	private java.lang.String jsContact;
	private java.lang.String jsPerson;
	private java.lang.String jsRemark;
	private java.lang.Boolean jsCanuse;
	private java.lang.String jsCate;
	private java.lang.Float jsLimit;
	private java.lang.Float jsBalance;
	private java.util.Date jsCreatetime;



	@Column(name = "JS_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsCode()
	{
		return this.jsCode;
	}


	public void setJsCode(java.lang.String jsCode)
	{
		this.jsCode = jsCode;
	}


	@Column(name = "JS_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public java.lang.String getJsName()
	{
		return this.jsName;
	}


	public void setJsName(java.lang.String jsName)
	{
		this.jsName = jsName;
	}


	@Column(name = "JS_ADDR", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJsAddr()
	{
		return this.jsAddr;
	}


	public void setJsAddr(java.lang.String jsAddr)
	{
		this.jsAddr = jsAddr;
	}


	@Column(name = "JS_POST", unique = false, nullable = true, insertable = true, updatable = true, length = 6)
	public java.lang.String getJsPost()
	{
		return this.jsPost;
	}


	public void setJsPost(java.lang.String jsPost)
	{
		this.jsPost = jsPost;
	}


	@Column(name = "JS_TELE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsTele()
	{
		return this.jsTele;
	}


	public void setJsTele(java.lang.String jsTele)
	{
		this.jsTele = jsTele;
	}


	@Column(name = "JS_FULLNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJsFullname()
	{
		return this.jsFullname;
	}


	public void setJsFullname(java.lang.String jsFullname)
	{
		this.jsFullname = jsFullname;
	}


	@Column(name = "JS_BANK", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsBank()
	{
		return this.jsBank;
	}


	public void setJsBank(java.lang.String jsBank)
	{
		this.jsBank = jsBank;
	}


	@Column(name = "JS_ACCOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsAccount()
	{
		return this.jsAccount;
	}


	public void setJsAccount(java.lang.String jsAccount)
	{
		this.jsAccount = jsAccount;
	}


	@Column(name = "JS_DUTYNO", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsDutyno()
	{
		return this.jsDutyno;
	}


	public void setJsDutyno(java.lang.String jsDutyno)
	{
		this.jsDutyno = jsDutyno;
	}


	@Column(name = "JS_CONTACT", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsContact()
	{
		return this.jsContact;
	}


	public void setJsContact(java.lang.String jsContact)
	{
		this.jsContact = jsContact;
	}


	@Column(name = "JS_PERSON", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsPerson()
	{
		return this.jsPerson;
	}


	public void setJsPerson(java.lang.String jsPerson)
	{
		this.jsPerson = jsPerson;
	}


	@Column(name = "JS_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJsRemark()
	{
		return this.jsRemark;
	}


	public void setJsRemark(java.lang.String jsRemark)
	{
		this.jsRemark = jsRemark;
	}


	@Column(name = "JS_CANUSE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJsCanuse()
	{
		return this.jsCanuse;
	}


	public void setJsCanuse(java.lang.Boolean jsCanuse)
	{
		this.jsCanuse = jsCanuse;
	}


	@Column(name = "JS_CATE", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.String getJsCate()
	{
		return this.jsCate;
	}


	public void setJsCate(java.lang.String jsCate)
	{
		this.jsCate = jsCate;
	}


	@Column(name = "JS_LIMIT", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.Float getJsLimit()
	{
		return this.jsLimit;
	}


	public void setJsLimit(java.lang.Float jsLimit)
	{
		this.jsLimit = jsLimit;
	}


	@Column(name = "JS_BALANCE", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public java.lang.Float getJsBalance()
	{
		return this.jsBalance;
	}


	public void setJsBalance(java.lang.Float jsBalance)
	{
		this.jsBalance = jsBalance;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JS_CREATETIME", unique = false, nullable = true, insertable = true, updatable = false, length = 19)
	public java.util.Date getJsCreatetime()
	{
		return this.jsCreatetime;
	}


	public void setJsCreatetime(java.util.Date jsCreatetime)
	{
		this.jsCreatetime = jsCreatetime;
	}

}
