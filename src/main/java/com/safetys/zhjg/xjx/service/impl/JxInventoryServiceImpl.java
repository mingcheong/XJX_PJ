/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.dao.IJxInventoryDao;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxInventoryModel;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxInventoryService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxInventoryService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class, RuntimeException.class })
public class JxInventoryServiceImpl extends BaseServiceImpl<JxInventoryModel, Long> implements IJxInventoryService
{

	@Resource(name = "jxInventoryDao")
	protected IJxInventoryDao jxInventoryDao;



	@Autowired
	public JxInventoryServiceImpl(@Qualifier("jxInventoryDao")
	IJxInventoryDao jxInventoryDao)
	{
		super(jxInventoryDao);
	}


	/**
	 * 根据仓库和商品代码查询商品库存信息
	 * 
	 * @param warehouse
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public JxInventoryModel findStore(JxWarehouseModel warehouse, JxGoodsModel goods) throws Exception
	{
		List<?> inventoryList = jxInventoryDao.find("from jxInventoryModel a where a.jiGoods.id = ? and a.jiWarehouse.jwCode = ?", new Object[] { goods.getId(), warehouse.getJwCode() });
		JxInventoryModel inventory = null;
		if (inventoryList != null && !inventoryList.isEmpty())
		{
			inventory = (JxInventoryModel) inventoryList.get(0);
		}
		return inventory;
	}


	/**
	 * 进货入库操作
	 * 
	 * @param warehouse
	 *            所属仓库
	 * @param goods
	 *            商品代码
	 * @param quantitySum
	 *            可用数
	 * @param wasteSum
	 *            废品数
	 * @param spareSum
	 *            备用数
	 * @return
	 * @throws Exception
	 */
	public OperateResult inStore(JxWarehouseModel warehouse, JxGoodsModel goods, Float quantitySum, Float wasteSum, Float spareSum) throws Exception
	{
		if (warehouse == null || goods == null || quantitySum == null || wasteSum == null || spareSum == null)
			return null;

		// 如果为空则初始化数量为0
		quantitySum = quantitySum != null ? quantitySum : 0f;
		wasteSum = wasteSum != null ? wasteSum : 0f;
		spareSum = spareSum != null ? spareSum : 0f;

		List<?> inventoryList = jxInventoryDao.find("from jxInventoryModel a where a.jiGoods.id = ? and a.jiWarehouse.id = ?", new Object[] { goods.getId(), warehouse.getId() });
		JxInventoryModel inventory = null;
		if (inventoryList != null && !inventoryList.isEmpty())
		{
			inventory = (JxInventoryModel) inventoryList.get(0);

			// 可用数
			if (inventory.getJiCursum() != null)
			{
				quantitySum += inventory.getJiCursum().floatValue();
			}

			// 废品数
			if (inventory.getJiWastesum() != null)
			{
				wasteSum += inventory.getJiWastesum().floatValue();
			}

			// 备用数
			if (inventory.getJiSparesum() != null)
			{
				spareSum += inventory.getJiSparesum().floatValue();
			}
		}
		else
		{
			inventory = new JxInventoryModel();
			inventory.setJiWarehouse(warehouse);
			inventory.setJiGoods(goods);
		}

		inventory.setJiCursum(quantitySum);
		inventory.setJiWastesum(wasteSum);
		inventory.setJiSparesum(spareSum);
		inventory.setJiTotalsum(quantitySum + wasteSum + spareSum);
		return super.save(inventory);
	}


	/**
	 * 调减出库操作
	 * 
	 * @param warehouse
	 *            所属仓库
	 * @param goods
	 *            商品代码
	 * @param quantitySum
	 *            可用数
	 * @param wasteSum
	 *            废品数
	 * @param spareSum
	 *            备用数
	 * @return
	 * @throws Exception
	 */
	public OperateResult outStore(JxWarehouseModel warehouse, JxGoodsModel goods, Float quantitySum, Float wasteSum, Float spareSum) throws Exception
	{
		if (warehouse == null || goods == null || quantitySum == null || wasteSum == null || spareSum == null)
			return null;

		// 如果为空则初始化数量为0
		quantitySum = quantitySum != null ? quantitySum : 0f;
		wasteSum = wasteSum != null ? wasteSum : 0f;
		spareSum = spareSum != null ? spareSum : 0f;

		List<?> inventoryList = jxInventoryDao.find("from jxInventoryModel a where a.jiGoods.id = ? and a.jiWarehouse.id = ?", new Object[] { goods.getId(), warehouse.getId() });
		JxInventoryModel inventory = null;
		if (inventoryList != null && !inventoryList.isEmpty())
		{
			inventory = (JxInventoryModel) inventoryList.get(0);

			// 可用数
			if (inventory.getJiCursum() != null)
			{
				quantitySum = inventory.getJiCursum().floatValue() - quantitySum;
				if (quantitySum < 0)
					throw new ServicesException("" + warehouse.getJwName() + "的[" + goods.getJgName() + "]可用数不够！");
			}

			// 废品数
			if (inventory.getJiWastesum() != null)
			{
				wasteSum = inventory.getJiWastesum().floatValue() - wasteSum;
				if (wasteSum < 0)
					throw new ServicesException("" + warehouse.getJwName() + "的[" + goods.getJgName() + "]废品数不够！");
			}

			// 备用数
			if (inventory.getJiSparesum() != null)
			{
				spareSum = inventory.getJiSparesum().floatValue() - spareSum;
				if (spareSum < 0)
					throw new ServicesException("" + warehouse.getJwName() + "的[" + goods.getJgName() + "]备用数不够！");
			}

			inventory.setJiCursum(quantitySum);
			inventory.setJiWastesum(wasteSum);
			inventory.setJiSparesum(spareSum);
			inventory.setJiTotalsum(quantitySum + wasteSum + spareSum);
			return super.save(inventory);
		}
		else
		{
			throw new ServicesException("" + warehouse.getJwName() + "仓库的[" + goods.getJgName() + "]不存在！");
		}
	}
}
