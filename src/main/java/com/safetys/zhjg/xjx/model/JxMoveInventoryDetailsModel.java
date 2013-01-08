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
@Entity(name = "jxMoveInventoryDetailsModel")
@Table(name = "jx_move_inventory_details")
@AttributeOverride(name = "id", column = @Column(name = "JMD_ID"))
public class JxMoveInventoryDetailsModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxMoveInventoryDetailsModel()
	{
		super();
	}


	public JxMoveInventoryDetailsModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.Float jmdQuantity;
	private java.lang.Float jmdCost;
	private java.lang.Float jmdAmount;
	private java.lang.Float jmdNum;
	private java.lang.String jmdOverflow;
	private java.lang.Float jmdRate;
	private java.lang.Float jmdPack;
	private java.lang.Float jmdWcost;
	private java.lang.Float jmdWamount;
	private JxMoveInventoryModel jmdMoveInventory;
	private JxUnitModel jmdUnit;
	private JxGoodsModel goodsModel;



	@Column(name = "JMD_QUANTITY", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdQuantity()
	{
		return this.jmdQuantity;
	}


	public void setJmdQuantity(java.lang.Float jmdQuantity)
	{
		this.jmdQuantity = jmdQuantity;
	}


	@Column(name = "JMD_COST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdCost()
	{
		return this.jmdCost;
	}


	public void setJmdCost(java.lang.Float jmdCost)
	{
		this.jmdCost = jmdCost;
	}


	@Column(name = "JMD_AMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdAmount()
	{
		return this.jmdAmount;
	}


	public void setJmdAmount(java.lang.Float jmdAmount)
	{
		this.jmdAmount = jmdAmount;
	}


	@Column(name = "JMD_NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdNum()
	{
		return this.jmdNum;
	}


	public void setJmdNum(java.lang.Float jmdNum)
	{
		this.jmdNum = jmdNum;
	}


	@Column(name = "JMD_OVERFLOW", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJmdOverflow()
	{
		return this.jmdOverflow;
	}


	public void setJmdOverflow(java.lang.String jmdOverflow)
	{
		this.jmdOverflow = jmdOverflow;
	}


	@Column(name = "JMD_RATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJmdRate()
	{
		return this.jmdRate;
	}


	public void setJmdRate(java.lang.Float jmdRate)
	{
		this.jmdRate = jmdRate;
	}


	@Column(name = "JMD_PACK", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdPack()
	{
		return this.jmdPack;
	}


	public void setJmdPack(java.lang.Float jmdPack)
	{
		this.jmdPack = jmdPack;
	}


	@Column(name = "JMD_WCOST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdWcost()
	{
		return this.jmdWcost;
	}


	public void setJmdWcost(java.lang.Float jmdWcost)
	{
		this.jmdWcost = jmdWcost;
	}


	@Column(name = "JMD_WAMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJmdWamount()
	{
		return this.jmdWamount;
	}


	public void setJmdWamount(java.lang.Float jmdWamount)
	{
		this.jmdWamount = jmdWamount;
	}


	public void setJmdMoveInventory(JxMoveInventoryModel jmdMoveInventory)
	{
		this.jmdMoveInventory = jmdMoveInventory;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JMD_MOVE_INVENTORY", nullable = false, insertable = true, updatable = true)
	public JxMoveInventoryModel getJmdMoveInventory()
	{
		return jmdMoveInventory;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JMD_UNIT", nullable = false, insertable = true, updatable = true)
	public JxUnitModel getJmdUnit()
	{
		return jmdUnit;
	}


	public void setJmdUnit(JxUnitModel jmdUnit)
	{
		this.jmdUnit = jmdUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JMD_GOODS", nullable = false, insertable = true, updatable = true)
	public JxGoodsModel getGoodsModel()
	{
		return goodsModel;
	}


	public void setGoodsModel(JxGoodsModel goodsModel)
	{
		this.goodsModel = goodsModel;
	}

}
