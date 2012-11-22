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

import com.safetys.zhjg.base.dao.IBaseCompactDao;
import com.safetys.zhjg.base.model.BaseCompactModel;
import com.safetys.zhjg.base.service.IBaseCompactService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("baseCompactService")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseCompactServiceImpl extends BaseServiceImpl<BaseCompactModel, Long> implements IBaseCompactService {

	@Resource(name = "baseCompactDao")
	protected IBaseCompactDao baseCompactDao;
	
	@Autowired
	public BaseCompactServiceImpl(@Qualifier("baseCompactDao") IBaseCompactDao baseCompactDao) {
		super(baseCompactDao);
	}
	
}