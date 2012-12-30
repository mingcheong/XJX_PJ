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
@Entity(name = "jxInInventoryDetailsModel")
@Table(name = "jx_in_inventory_details")
@AttributeOverride(name = "id", column = @Column(name = "JID_ID"))
public class JxInInventoryDetailsModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxInInventoryDetailsModel()
	{
		super();
	}


	public JxInInventoryDetailsModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.Float jidQuantity;
	private java.lang.Float jidCost;
	private java.lang.Float jidAmount;
	private java.lang.Float jidNum;
	private java.lang.String jidOverflow;
	private java.lang.Float jidRate;
	private JxInInventoryModel jidInInventory;
	private JxUnitModel jidUnit;
	private JxUnitModel jidBUnit;
	private JxGoodsModel goodsModel;



	@Column(name = "JID_QUANTITY", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJidQuantity()
	{
		return this.jidQuantity;
	}


	public void setJidQuantity(java.lang.Float jidQuantity)
	{
		this.jidQuantity = jidQuantity;
	}


	@Column(name = "JID_COST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJidCost()
	{
		return this.jidCost;
	}


	public void setJidCost(java.lang.Float jidCost)
	{
		this.jidCost = jidCost;
	}


	@Column(name = "JID_AMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJidAmount()
	{
		return this.jidAmount;
	}


	public void setJidAmount(java.lang.Float jidAmount)
	{
		this.jidAmount = jidAmount;
	}


	@Column(name = "JID_NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJidNum()
	{
		return this.jidNum;
	}


	public void setJidNum(java.lang.Float jidNum)
	{
		this.jidNum = jidNum;
	}


	@Column(name = "JID_OVERFLOW", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJidOverflow()
	{
		return this.jidOverflow;
	}


	public void setJidOverflow(java.lang.String jidOverflow)
	{
		this.jidOverflow = jidOverflow;
	}


	@Column(name = "JID_RATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJidRate()
	{
		return this.jidRate;
	}


	public void setJidRate(java.lang.Float jidRate)
	{
		this.jidRate = jidRate;
	}


	public void setJidInInventory(JxInInventoryModel jidInInventory)
	{
		this.jidInInventory = jidInInventory;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JID_IN_INVENTORY", nullable = false, insertable = true, updatable = true)
	public JxInInventoryModel getJidInInventory()
	{
		return jidInInventory;
	}


	public void setJidUnit(JxUnitModel jidUnit)
	{
		this.jidUnit = jidUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JID_UNIT", nullable = false, insertable = true, updatable = true)
	public JxUnitModel getJidUnit()
	{
		return jidUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JID_BUNIT", nullable = false, insertable = true, updatable = true)
	public JxUnitModel getJidBUnit()
	{
		return jidBUnit;
	}


	public void setJidBUnit(JxUnitModel jidBUnit)
	{
		this.jidBUnit = jidBUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JID_GOODS", nullable = false, insertable = true, updatable = true)
	public JxGoodsModel getGoodsModel()
	{
		return goodsModel;
	}


	public void setGoodsModel(JxGoodsModel goodsModel)
	{
		this.goodsModel = goodsModel;
	}

}
