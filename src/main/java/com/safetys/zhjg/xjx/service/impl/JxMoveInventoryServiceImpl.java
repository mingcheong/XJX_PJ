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

import com.safetys.zhjg.xjx.dao.IJxMoveInventoryDao;
import com.safetys.zhjg.xjx.model.JxMoveInventoryModel;
import com.safetys.zhjg.xjx.service.IJxMoveInventoryService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxMoveInventoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxMoveInventoryServiceImpl extends BaseServiceImpl<JxMoveInventoryModel, Long> implements IJxMoveInventoryService {

	@Resource(name = "jxMoveInventoryDao")
	protected IJxMoveInventoryDao jxMoveInventoryDao;
	
	@Autowired
	public JxMoveInventoryServiceImpl(@Qualifier("jxMoveInventoryDao") IJxMoveInventoryDao jxMoveInventoryDao) {
		super(jxMoveInventoryDao);
	}
	
}