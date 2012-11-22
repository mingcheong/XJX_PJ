/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import javax.persistence.AttributeOverride;
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
@Entity(name = "jxBackInventoryDetailsModel")
@Table(name = "jx_back_inventory_details")
@AttributeOverride(name = "id", column = @Column(name = "JBD_ID"))
public class JxBackInventoryDetailsModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxBackInventoryDetailsModel()
	{
		super();
	}


	public JxBackInventoryDetailsModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jbdBarcode;
	private java.lang.String jbdCode;
	private java.lang.String jbdName;
	private java.lang.Integer jbdUnit;
	private java.lang.Float jbdQuantity;
	private java.lang.Float jbdCost;
	private java.lang.Float jbdAmount;
	private java.lang.Float jbdNum;
	private java.lang.String jbdOverflow;
	private java.lang.Float jbdRate;
	private JxBackInventoryModel jbdBackInventory;



	@Column(name = "JBD_BARCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJbdBarcode()
	{
		return this.jbdBarcode;
	}


	public void setJbdBarcode(java.lang.String jbdBarcode)
	{
		this.jbdBarcode = jbdBarcode;
	}


	@Column(name = "JBD_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJbdCode()
	{
		return this.jbdCode;
	}


	public void setJbdCode(java.lang.String jbdCode)
	{
		this.jbdCode = jbdCode;
	}


	@Column(name = "JBD_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getJbdName()
	{
		return this.jbdName;
	}


	public void setJbdName(java.lang.String jbdName)
	{
		this.jbdName = jbdName;
	}


	@Column(name = "JBD_UNIT", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJbdUnit()
	{
		return this.jbdUnit;
	}


	public void setJbdUnit(java.lang.Integer jbdUnit)
	{
		this.jbdUnit = jbdUnit;
	}


	@Column(name = "JBD_QUANTITY", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJbdQuantity()
	{
		return this.jbdQuantity;
	}


	public void setJbdQuantity(java.lang.Float jbdQuantity)
	{
		this.jbdQuantity = jbdQuantity;
	}


	@Column(name = "JBD_COST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJbdCost()
	{
		return this.jbdCost;
	}


	public void setJbdCost(java.lang.Float jbdCost)
	{
		this.jbdCost = jbdCost;
	}


	@Column(name = "JBD_AMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJbdAmount()
	{
		return this.jbdAmount;
	}


	public void setJbdAmount(java.lang.Float jbdAmount)
	{
		this.jbdAmount = jbdAmount;
	}


	@Column(name = "JBD_NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJbdNum()
	{
		return this.jbdNum;
	}


	public void setJbdNum(java.lang.Float jbdNum)
	{
		this.jbdNum = jbdNum;
	}


	@Column(name = "JBD_OVERFLOW", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJbdOverflow()
	{
		return this.jbdOverflow;
	}


	public void setJbdOverflow(java.lang.String jbdOverflow)
	{
		this.jbdOverflow = jbdOverflow;
	}


	@Column(name = "JBD_RATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJbdRate()
	{
		return this.jbdRate;
	}


	public void setJbdRate(java.lang.Float jbdRate)
	{
		this.jbdRate = jbdRate;
	}


	public void setJbdBackInventory(JxBackInventoryModel jbdBackInventory)
	{
		this.jbdBackInventory = jbdBackInventory;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JBD_BACK_INVENTORY", nullable = false, insertable = false, updatable = false)
	public JxBackInventoryModel getJbdBackInventory()
	{
		return jbdBackInventory;
	}
}
