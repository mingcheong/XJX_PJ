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

import com.safetys.zhjg.xjx.dao.IJxWarehouseDao;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxWarehouseService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxWarehouseService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxWarehouseServiceImpl extends BaseServiceImpl<JxWarehouseModel, Long> implements IJxWarehouseService {

	@Resource(name = "jxWarehouseDao")
	protected IJxWarehouseDao jxWarehouseDao;
	
	@Autowired
	public JxWarehouseServiceImpl(@Qualifier("jxWarehouseDao") IJxWarehouseDao jxWarehouseDao) {
		super(jxWarehouseDao);
	}
	
}