/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service;

import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.IBaseService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IJxGoodsService extends IBaseService<JxGoodsModel, Long>
{

	/**
	 * 根据商品编号查询商品
	 * 
	 * @param code
	 * @return
	 * @throws ServicesException
	 */
	public JxGoodsModel findByCode(String code) throws ServicesException;
}
