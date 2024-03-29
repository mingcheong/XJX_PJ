/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.xjx.dao.IJxSalesDetailsDao;
import com.safetys.zhjg.xjx.model.JxSalesDetailsModel;
import com.safetys.zhjg.xjx.service.IJxSalesDetailsService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxSalesDetailsService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class, RuntimeException.class })
public class JxSalesDetailsServiceImpl extends BaseServiceImpl<JxSalesDetailsModel, Long> implements IJxSalesDetailsService
{

	@Resource(name = "jxSalesDetailsDao")
	protected IJxSalesDetailsDao jxSalesDetailsDao;



	@Autowired
	public JxSalesDetailsServiceImpl(@Qualifier("jxSalesDetailsDao")
	IJxSalesDetailsDao jxSalesDetailsDao)
	{
		super(jxSalesDetailsDao);
	}

}
