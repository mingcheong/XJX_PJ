/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.zhjg.xjx.dao.IJxGoodsPriceSetDao;
import com.safetys.zhjg.xjx.model.JxGoodsPriceSetModel;
import com.safetys.zhjg.xjx.service.IJxGoodsPriceSetService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxGoodsPriceSetService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxGoodsPriceSetServiceImpl extends BaseServiceImpl<JxGoodsPriceSetModel, Long> implements IJxGoodsPriceSetService
{

	@Resource(name = "jxGoodsPriceSetDao")
	protected IJxGoodsPriceSetDao jxGoodsPriceSetDao;



	@Autowired
	public JxGoodsPriceSetServiceImpl(@Qualifier("jxGoodsPriceSetDao")
	IJxGoodsPriceSetDao jxGoodsPriceSetDao)
	{
		super(jxGoodsPriceSetDao);
	}


	/**
	 * 根据客户代码和商品代码查询商品售价设置
	 * 
	 * @param goodsPriceSet
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<JxGoodsPriceSetModel> findBy(JxGoodsPriceSetModel goodsPriceSet) throws Exception
	{
		Map<String, Object> attrMap = new HashMap<String, Object>();
		StringBuffer jpql = new StringBuffer("from jxGoodsPriceSetModel a where 1 = 1");
		if (goodsPriceSet.getJpCustomer() != null)
		{
			if (StringUtils.isNotEmpty(goodsPriceSet.getJpCustomer().getJcCode()))
			{
				jpql.append(" and a.jpCustomer.jcCode = :jcCode");
				attrMap.put("jcCode", goodsPriceSet.getJpCustomer().getJcCode());
			}
			if (StringUtils.isNotEmpty(goodsPriceSet.getJpCustomer().getJcName()))
			{
				jpql.append(" and a.jpCustomer.jcName = :jcName");
				attrMap.put("jcName", goodsPriceSet.getJpCustomer().getJcName());
			}
		}

		if (goodsPriceSet.getJpGoods() != null)
		{
			if (StringUtils.isNotEmpty(goodsPriceSet.getJpGoods().getJgCode()))
			{
				jpql.append(" and a.jpGoods.jgCode = :jgCode");
				attrMap.put("jgCode", goodsPriceSet.getJpGoods().getJgCode());
			}
			if (StringUtils.isNotEmpty(goodsPriceSet.getJpGoods().getJgName()))
			{
				jpql.append(" and a.jpGoods.jgName = :jgName");
				attrMap.put("jgName", goodsPriceSet.getJpGoods().getJgName());
			}
		}
		List<?> list = jxGoodsPriceSetDao.find(jpql.toString(), attrMap);
		if (list != null)
			return (List<JxGoodsPriceSetModel>) list;
		return null;
	}

}
