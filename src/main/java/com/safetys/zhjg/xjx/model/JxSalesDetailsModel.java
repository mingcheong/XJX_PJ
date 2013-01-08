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
@Entity(name = "jxSalesDetailsModel")
@Table(name = "jx_sales_details")
@AttributeOverride(name = "id", column = @Column(name = "JSD_ID"))
public class JxSalesDetailsModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxSalesDetailsModel()
	{
		super();
	}


	public JxSalesDetailsModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.Float jsdQuantity;
	private java.lang.Float jsdCost;
	private java.lang.Float jsdAmount;
	private java.lang.Float jsdNum;
	private java.lang.String jsdOverflow;
	private java.lang.Float jsdRate;
	private java.lang.String jsdPag;
	private java.lang.Float jsdWcost;
	private java.lang.Float jsdWamount;
	private java.lang.Float jsdPre;
	private java.lang.Float jsdSamount;
	private java.lang.String jsdCustitem;
	private JxSalesModel jsdSales;
	private JxUnitModel jsdUnit;
	private JxGoodsModel goodsModel;



	@Column(name = "JSD_QUANTITY", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdQuantity()
	{
		return this.jsdQuantity;
	}


	public void setJsdQuantity(java.lang.Float jsdQuantity)
	{
		this.jsdQuantity = jsdQuantity;
	}


	@Column(name = "JSD_COST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdCost()
	{
		return this.jsdCost;
	}


	public void setJsdCost(java.lang.Float jsdCost)
	{
		this.jsdCost = jsdCost;
	}


	@Column(name = "JSD_AMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdAmount()
	{
		return this.jsdAmount;
	}


	public void setJsdAmount(java.lang.Float jsdAmount)
	{
		this.jsdAmount = jsdAmount;
	}


	@Column(name = "JSD_NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdNum()
	{
		return this.jsdNum;
	}


	public void setJsdNum(java.lang.Float jsdNum)
	{
		this.jsdNum = jsdNum;
	}


	@Column(name = "JSD_OVERFLOW", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJsdOverflow()
	{
		return this.jsdOverflow;
	}


	public void setJsdOverflow(java.lang.String jsdOverflow)
	{
		this.jsdOverflow = jsdOverflow;
	}


	@Column(name = "JSD_RATE", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJsdRate()
	{
		return this.jsdRate;
	}


	public void setJsdRate(java.lang.Float jsdRate)
	{
		this.jsdRate = jsdRate;
	}


	@Column(name = "JSD_PAG", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsdPag()
	{
		return this.jsdPag;
	}


	public void setJsdPag(java.lang.String jsdPag)
	{
		this.jsdPag = jsdPag;
	}


	@Column(name = "JSD_WCOST", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdWcost()
	{
		return this.jsdWcost;
	}


	public void setJsdWcost(java.lang.Float jsdWcost)
	{
		this.jsdWcost = jsdWcost;
	}


	@Column(name = "JSD_WAMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdWamount()
	{
		return this.jsdWamount;
	}


	public void setJsdWamount(java.lang.Float jsdWamount)
	{
		this.jsdWamount = jsdWamount;
	}


	@Column(name = "JSD_PRE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdPre()
	{
		return this.jsdPre;
	}


	public void setJsdPre(java.lang.Float jsdPre)
	{
		this.jsdPre = jsdPre;
	}


	@Column(name = "JSD_SAMOUNT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Float getJsdSamount()
	{
		return this.jsdSamount;
	}


	public void setJsdSamount(java.lang.Float jsdSamount)
	{
		this.jsdSamount = jsdSamount;
	}


	@Column(name = "JSD_CUSTITEM", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJsdCustitem()
	{
		return this.jsdCustitem;
	}


	public void setJsdCustitem(java.lang.String jsdCustitem)
	{
		this.jsdCustitem = jsdCustitem;
	}


	public void setJsdSales(JxSalesModel jsdSales)
	{
		this.jsdSales = jsdSales;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JSD_SALES", nullable = false, insertable = true, updatable = true)
	public JxSalesModel getJsdSales()
	{
		return jsdSales;
	}


	public void setJsdUnit(JxUnitModel jsdUnit)
	{
		this.jsdUnit = jsdUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JSD_UNIT", nullable = false, insertable = true, updatable = true)
	public JxUnitModel getJsdUnit()
	{
		return jsdUnit;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JSD_GOODS", nullable = false, insertable = true, updatable = true)
	public JxGoodsModel getGoodsModel()
	{
		return goodsModel;
	}


	public void setGoodsModel(JxGoodsModel goodsModel)
	{
		this.goodsModel = goodsModel;
	}
}
