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

import com.safetys.zhjg.base.dao.IBaseCompactDataDao;
import com.safetys.zhjg.base.model.BaseCompactDataModel;
import com.safetys.zhjg.base.service.IBaseCompactDataService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("baseCompactDataService")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseCompactDataServiceImpl extends BaseServiceImpl<BaseCompactDataModel, Long> implements IBaseCompactDataService {

	@Resource(name = "baseCompactDataDao")
	protected IBaseCompactDataDao baseCompactDataDao;
	
	@Autowired
	public BaseCompactDataServiceImpl(@Qualifier("baseCompactDataDao") IBaseCompactDataDao baseCompactDataDao) {
		super(baseCompactDataDao);
	}
	
}