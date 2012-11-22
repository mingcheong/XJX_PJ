/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import java.util.List;
import javax.persistence.*;

import com.safetys.framework.kernel.model.BaseModel;
import javax.servlet.http.HttpServletRequest;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "jxCustomerModel")
@Table(name = "jx_customer")
@AttributeOverride(name = "id", column = @Column(name = "JC_ID"))
public class JxCustomerModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxCustomerModel()
	{
		super();
	}


	public JxCustomerModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}


	private java.lang.String jcCode;
	private java.lang.String jcClazz;
	private java.lang.String jcName;
	private java.lang.String jcAddress;
	private java.lang.String jcPost;
	private java.lang.String jcPhone;
	private java.lang.String jcFullname;
	private java.lang.String jcBank;
	private java.lang.String jcAccount;
	private java.lang.String jcDuty;
	private java.lang.Integer jcUser;
	private java.lang.Boolean jcCanuse;
	private java.lang.String jcRemark;
	private JxEmployeeModel jxEmployee;
	private List<JxSalesModel> jxSaless;


	@Column(name = "JC_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJcCode()
	{
		return this.jcCode;
	}


	public void setJcCode(java.lang.String jcCode)
	{
		this.jcCode = jcCode;
	}


	@Column(name = "JC_CLAZZ", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
	public java.lang.String getJcClazz()
	{
		return this.jcClazz;
	}


	public void setJcClazz(java.lang.String jcClazz)
	{
		this.jcClazz = jcClazz;
	}


	@Column(name = "JC_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getJcName()
	{
		return this.jcName;
	}


	public void setJcName(java.lang.String jcName)
	{
		this.jcName = jcName;
	}


	@Column(name = "JC_ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
	public java.lang.String getJcAddress()
	{
		return this.jcAddress;
	}


	public void setJcAddress(java.lang.String jcAddress)
	{
		this.jcAddress = jcAddress;
	}


	@Column(name = "JC_POST", unique = false, nullable = true, insertable = true, updatable = true, length = 6)
	public java.lang.String getJcPost()
	{
		return this.jcPost;
	}


	public void setJcPost(java.lang.String jcPost)
	{
		this.jcPost = jcPost;
	}


	@Column(name = "JC_PHONE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJcPhone()
	{
		return this.jcPhone;
	}


	public void setJcPhone(java.lang.String jcPhone)
	{
		this.jcPhone = jcPhone;
	}


	@Column(name = "JC_FULLNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJcFullname()
	{
		return this.jcFullname;
	}


	public void setJcFullname(java.lang.String jcFullname)
	{
		this.jcFullname = jcFullname;
	}


	@Column(name = "JC_BANK", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJcBank()
	{
		return this.jcBank;
	}


	public void setJcBank(java.lang.String jcBank)
	{
		this.jcBank = jcBank;
	}


	@Column(name = "JC_ACCOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJcAccount()
	{
		return this.jcAccount;
	}


	public void setJcAccount(java.lang.String jcAccount)
	{
		this.jcAccount = jcAccount;
	}


	@Column(name = "JC_DUTY", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJcDuty()
	{
		return this.jcDuty;
	}


	public void setJcDuty(java.lang.String jcDuty)
	{
		this.jcDuty = jcDuty;
	}


	@Column(name = "JC_USER", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJcUser()
	{
		return this.jcUser;
	}


	public void setJcUser(java.lang.Integer jcUser)
	{
		this.jcUser = jcUser;
	}


	@Column(name = "JC_CANUSE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJcCanuse()
	{
		return this.jcCanuse;
	}


	public void setJcCanuse(java.lang.Boolean jcCanuse)
	{
		this.jcCanuse = jcCanuse;
	}


	@Column(name = "JC_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJcRemark()
	{
		return this.jcRemark;
	}


	public void setJcRemark(java.lang.String jcRemark)
	{
		this.jcRemark = jcRemark;
	}


	public void setJxEmployee(JxEmployeeModel jxEmployee)
	{
		this.jxEmployee = jxEmployee;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JC_USER", nullable = false, insertable = false, updatable = false)
	public JxEmployeeModel getJxEmployee()
	{
		return jxEmployee;
	}


	public void setJxSaless(List<JxSalesModel> jxSaless)
	{
		this.jxSaless = jxSaless;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jsCustomer")
	public List<JxSalesModel> getJxSaless()
	{
		return jxSaless;
	}
}
