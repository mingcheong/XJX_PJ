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
@Entity(name = "jxSalesModel")
@Table(name = "jx_sales")
@AttributeOverride(name = "id", column = @Column(name = "JS_ID"))
public class JxSalesModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxSalesModel()
	{
		super();
	}


	public JxSalesModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.Integer jsDept;
	private java.lang.String jsOcode;
	private java.lang.String jsNum;
	private java.lang.String jsLastCode;
	private java.lang.Integer jsWarehouse;
	private java.lang.Integer jsUser;
	private java.util.Date jsDate;
	private java.lang.Float jsRate;
	private java.lang.String jsDelivery;
	private java.lang.String jsRemark;
	private JxDeptModel jxDept;
	private JxSettlementTypeModel jsSettlement;
	private JxCustomerModel jsCustomer;
	private JxWarehouseModel jxWarehouse;
	private JxEmployeeModel jxEmployee;
	private List<JxSalesDetailsModel> jxSalesDetailss;



	@Column(name = "JS_DEPT", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJsDept()
	{
		return this.jsDept;
	}


	public void setJsDept(java.lang.Integer jsDept)
	{
		this.jsDept = jsDept;
	}


	@Column(name = "JS_OCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsOcode()
	{
		return this.jsOcode;
	}


	public void setJsOcode(java.lang.String jsOcode)
	{
		this.jsOcode = jsOcode;
	}


	@Column(name = "JS_NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsNum()
	{
		return this.jsNum;
	}


	public void setJsNum(java.lang.String jsNum)
	{
		this.jsNum = jsNum;
	}


	@Column(name = "JS_LAST_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsLastCode()
	{
		return this.jsLastCode;
	}


	public void setJsLastCode(java.lang.String jsLastCode)
	{
		this.jsLastCode = jsLastCode;
	}


	@Column(name = "JS_WAREHOUSE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJsWarehouse()
	{
		return this.jsWarehouse;
	}


	public void setJsWarehouse(java.lang.Integer jsWarehouse)
	{
		this.jsWarehouse = jsWarehouse;
	}


	@Column(name = "JS_USER", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJsUser()
	{
		return this.jsUser;
	}


	public void setJsUser(java.lang.Integer jsUser)
	{
		this.jsUser = jsUser;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JS_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.util.Date getJsDate()
	{
		return this.jsDate;
	}


	public void setJsDate(java.util.Date jsDate)
	{
		this.jsDate = jsDate;
	}


	@Column(name = "JS_RATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJsRate()
	{
		return this.jsRate;
	}


	public void setJsRate(java.lang.Float jsRate)
	{
		this.jsRate = jsRate;
	}


	@Column(name = "JS_DELIVERY", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsDelivery()
	{
		return this.jsDelivery;
	}


	public void setJsDelivery(java.lang.String jsDelivery)
	{
		this.jsDelivery = jsDelivery;
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


	public void setJxDept(JxDeptModel jxDept)
	{
		this.jxDept = jxDept;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JS_DEPT", nullable = false, insertable = false, updatable = false)
	public JxDeptModel getJxDept()
	{
		return jxDept;
	}


	public void setJsSettlement(JxSettlementTypeModel jsSettlement)
	{
		this.jsSettlement = jsSettlement;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JS_SETTLEMENT", nullable = false, insertable = false, updatable = false)
	public JxSettlementTypeModel getJsSettlement()
	{
		return jsSettlement;
	}


	public void setJsCustomer(JxCustomerModel jsCustomer)
	{
		this.jsCustomer = jsCustomer;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JS_CUSTOMER", nullable = false, insertable = false, updatable = false)
	public JxCustomerModel getJsCustomer()
	{
		return jsCustomer;
	}


	public void setJxWarehouse(JxWarehouseModel jxWarehouse)
	{
		this.jxWarehouse = jxWarehouse;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JS_WAREHOUSE", nullable = false, insertable = false, updatable = false)
	public JxWarehouseModel getJxWarehouse()
	{
		return jxWarehouse;
	}


	public void setJxEmployee(JxEmployeeModel jxEmployee)
	{
		this.jxEmployee = jxEmployee;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JS_USER", nullable = false, insertable = false, updatable = false)
	public JxEmployeeModel getJxEmployee()
	{
		return jxEmployee;
	}


	public void setJxSalesDetailss(List<JxSalesDetailsModel> jxSalesDetailss)
	{
		this.jxSalesDetailss = jxSalesDetailss;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jsdSales")
	public List<JxSalesDetailsModel> getJxSalesDetailss()
	{
		return jxSalesDetailss;
	}
}
