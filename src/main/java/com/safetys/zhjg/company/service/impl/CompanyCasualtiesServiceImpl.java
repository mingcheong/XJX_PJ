/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.company.dao.ICompanyCasualtiesDao;
import com.safetys.zhjg.company.model.CompanyCasualtiesModel;
import com.safetys.zhjg.company.service.ICompanyCasualtiesService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyCasualtiesService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyCasualtiesServiceImpl extends BaseServiceImpl<CompanyCasualtiesModel, Long> implements ICompanyCasualtiesService {

	@Resource(name = "companyCasualtiesDao")
	protected ICompanyCasualtiesDao companyCasualtiesDao;
	
	@Autowired
	public CompanyCasualtiesServiceImpl(@Qualifier("companyCasualtiesDao") ICompanyCasualtiesDao companyCasualtiesDao) {
		super(companyCasualtiesDao);
	}
	
}