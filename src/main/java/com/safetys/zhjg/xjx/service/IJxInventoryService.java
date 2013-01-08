/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service;

import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxInventoryModel;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IJxInventoryService extends IBaseService<JxInventoryModel, Long>
{
	/**
	 * 根据仓库和商品代码查询商品库存信息
	 * 
	 * @param warehouse
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public JxInventoryModel findStore(JxWarehouseModel warehouse, JxGoodsModel goods) throws Exception;


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
	public OperateResult inStore(JxWarehouseModel warehouse, JxGoodsModel goods, Float quantitySum, Float wasteSum, Float spareSum) throws Exception;


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
	public OperateResult outStore(JxWarehouseModel warehouse, JxGoodsModel goods, Float quantitySum, Float wasteSum, Float spareSum) throws Exception;
}
