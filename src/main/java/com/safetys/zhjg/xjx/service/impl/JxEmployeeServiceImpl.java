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

import com.safetys.zhjg.xjx.dao.IJxEmployeeDao;
import com.safetys.zhjg.xjx.model.JxEmployeeModel;
import com.safetys.zhjg.xjx.service.IJxEmployeeService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxEmployeeService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxEmployeeServiceImpl extends BaseServiceImpl<JxEmployeeModel, Long> implements IJxEmployeeService {

	@Resource(name = "jxEmployeeDao")
	protected IJxEmployeeDao jxEmployeeDao;
	
	@Autowired
	public JxEmployeeServiceImpl(@Qualifier("jxEmployeeDao") IJxEmployeeDao jxEmployeeDao) {
		super(jxEmployeeDao);
	}
	
}