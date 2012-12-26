/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.zhjg.xjx.dao.IJxDeptDao;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.service.IJxDeptService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxDeptService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxDeptServiceImpl extends BaseServiceImpl<JxDeptModel, Long> implements IJxDeptService
{

	@Resource(name = "jxDeptDao")
	protected IJxDeptDao jxDeptDao;



	@Autowired
	public JxDeptServiceImpl(@Qualifier("jxDeptDao")
	IJxDeptDao jxDeptDao)
	{
		super(jxDeptDao);
	}

}
