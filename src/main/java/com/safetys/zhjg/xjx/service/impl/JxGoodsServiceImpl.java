/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.zhjg.xjx.dao.IJxGoodsDao;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.service.IJxGoodsService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxGoodsService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxGoodsServiceImpl extends BaseServiceImpl<JxGoodsModel, Long> implements IJxGoodsService
{

	@Resource(name = "jxGoodsDao")
	protected IJxGoodsDao jxGoodsDao;



	@Autowired
	public JxGoodsServiceImpl(@Qualifier("jxGoodsDao")
	IJxGoodsDao jxGoodsDao)
	{
		super(jxGoodsDao);
	}


	/**
	 * 根据商品编号查询商品
	 * 
	 * @param code
	 * @return
	 * @throws ServicesException
	 */
	public JxGoodsModel findByCode(String code) throws ServicesException
	{
		JxGoodsModel goods = null;
		if (!StringUtils.isEmpty(code))
		{
			try
			{
				List<JxGoodsModel> goodsList = jxGoodsDao.find("from jxGoodsModel a where a.jgIncode = ? or a.jgCode = ?", new Object[] { code, code });
				if (goodsList != null && !goodsList.isEmpty())
					goods = goodsList.get(0);
			}
			catch (DaoException e)
			{
				throw new ServicesException("查询商品编号失败：", e);
			}
		}
		return goods;
	}
}
