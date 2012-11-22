/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.xjx.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.xjx.dao.IJxInInventoryDao;
import com.safetys.zhjg.xjx.model.JxInInventoryModel;
import com.safetys.zhjg.xjx.service.IJxInInventoryService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxInInventoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxInInventoryServiceImpl extends BaseServiceImpl<JxInInventoryModel, Long> implements IJxInInventoryService {

	@Resource(name = "jxInInventoryDao")
	protected IJxInInventoryDao jxInInventoryDao;
	
	@Autowired
	public JxInInventoryServiceImpl(@Qualifier("jxInInventoryDao") IJxInInventoryDao jxInInventoryDao) {
		super(jxInInventoryDao);
	}
	
}