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
	 * 保存库存信息
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
	public OperateResult save(JxWarehouseModel warehouse, JxGoodsModel goods, Float quantitySum, Float wasteSum, Float spareSum) throws Exception;
}
