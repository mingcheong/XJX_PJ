/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "jxGoodsPriceSetModel")
@Table(name = "jx_goods_price_set")
public class JxGoodsPriceSetModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxGoodsPriceSetModel()
	{
		super();
	}


	public JxGoodsPriceSetModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.Float jpPrice;
	private java.lang.Float jpPricelast;
	private java.lang.Float jpCost;
	private java.util.Date jpDate;
	private JxGoodsModel jpGoods;
	private JxCustomerModel jpCustomer;



	@Column(name = "JP_PRICE", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJpPrice()
	{
		return this.jpPrice;
	}


	public void setJpPrice(java.lang.Float jpPrice)
	{
		this.jpPrice = jpPrice;
	}


	@Column(name = "JP_PRICELAST", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJpPricelast()
	{
		return this.jpPricelast;
	}


	public void setJpPricelast(java.lang.Float jpPricelast)
	{
		this.jpPricelast = jpPricelast;
	}


	@Column(name = "JP_COST", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJpCost()
	{
		return this.jpCost;
	}


	public void setJpCost(java.lang.Float jpCost)
	{
		this.jpCost = jpCost;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JP_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.util.Date getJpDate()
	{
		return this.jpDate;
	}


	public void setJpDate(java.util.Date jpDate)
	{
		this.jpDate = jpDate;
	}


	public void setJpGoods(JxGoodsModel jpGoods)
	{
		this.jpGoods = jpGoods;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JP_GOODS", nullable = false, insertable = true, updatable = true)
	public JxGoodsModel getJpGoods()
	{
		return jpGoods;
	}


	public void setJpCustomer(JxCustomerModel jpCustomer)
	{
		this.jpCustomer = jpCustomer;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JP_CUSTOMER", nullable = false, insertable = true, updatable = true)
	public JxCustomerModel getJpCustomer()
	{
		return jpCustomer;
	}
}
