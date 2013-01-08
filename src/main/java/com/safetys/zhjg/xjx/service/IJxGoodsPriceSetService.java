/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service;

import java.util.List;

import com.safetys.zhjg.xjx.model.JxGoodsPriceSetModel;
import com.safetys.framework.kernel.service.IBaseService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IJxGoodsPriceSetService extends IBaseService<JxGoodsPriceSetModel, Long>
{

	/**
	 * 根据客户代码和商品代码查询商品售价设置
	 * 
	 * @param goodsPriceSet
	 * @return
	 * @throws Exception
	 */
	public List<JxGoodsPriceSetModel> findBy(JxGoodsPriceSetModel goodsPriceSet) throws Exception;
}
