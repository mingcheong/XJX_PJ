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
@Entity(name = "jxInventoryModel")
@Table(name = "jx_inventory")
@AttributeOverride(name = "id", column = @Column(name = "JI_ID"))
public class JxInventoryModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxInventoryModel()
	{
		super();
	}


	public JxInventoryModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.Float jiCursum;
	private java.lang.Float jiTotalsum;
	private java.lang.Float jiWastesum;
	private java.lang.Float jiSparesum;
	private JxGoodsModel jiGoods;
	private JxWarehouseModel jiWarehouse;



	@Column(name = "JI_CURSUM", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Float getJiCursum()
	{
		return this.jiCursum;
	}


	public void setJiCursum(java.lang.Float jiCursum)
	{
		this.jiCursum = jiCursum;
	}


	@Column(name = "JI_TOTALSUM", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Float getJiTotalsum()
	{
		return this.jiTotalsum;
	}


	public void setJiTotalsum(java.lang.Float jiTotalsum)
	{
		this.jiTotalsum = jiTotalsum;
	}


	@Column(name = "JI_WASTESUM", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Float getJiWastesum()
	{
		return this.jiWastesum;
	}


	public void setJiWastesum(java.lang.Float jiWastesum)
	{
		this.jiWastesum = jiWastesum;
	}


	@Column(name = "JI_SPARESUM", unique = false, nullable = false, insertable = true, updatable = true, length = 12)
	public java.lang.Float getJiSparesum()
	{
		return this.jiSparesum;
	}


	public void setJiSparesum(java.lang.Float jiSparesum)
	{
		this.jiSparesum = jiSparesum;
	}


	public void setJiGoods(JxGoodsModel jiGoods)
	{
		this.jiGoods = jiGoods;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_GOODS", nullable = false, insertable = true, updatable = true)
	public JxGoodsModel getJiGoods()
	{
		return jiGoods;
	}


	public void setJiWarehouse(JxWarehouseModel jiWarehouse)
	{
		this.jiWarehouse = jiWarehouse;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_WAREHOUSE", nullable = false, insertable = true, updatable = true)
	public JxWarehouseModel getJiWarehouse()
	{
		return jiWarehouse;
	}
}
