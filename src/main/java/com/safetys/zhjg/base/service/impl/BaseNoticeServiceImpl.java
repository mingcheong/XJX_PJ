/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.base.dao.IBaseNoticeDao;
import com.safetys.zhjg.base.model.BaseNoticeModel;
import com.safetys.zhjg.base.service.IBaseNoticeService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("baseNoticeService")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseNoticeServiceImpl extends BaseServiceImpl<BaseNoticeModel, Long> implements IBaseNoticeService {

	@Resource(name = "baseNoticeDao")
	protected IBaseNoticeDao baseNoticeDao;
	
	@Autowired
	public BaseNoticeServiceImpl(@Qualifier("baseNoticeDao") IBaseNoticeDao baseNoticeDao) {
		super(baseNoticeDao);
	}
	
}