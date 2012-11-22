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

import com.safetys.zhjg.company.dao.ICompanyHiddenlistingDao;
import com.safetys.zhjg.company.model.CompanyHiddenlistingModel;
import com.safetys.zhjg.company.service.ICompanyHiddenlistingService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyHiddenlistingService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyHiddenlistingServiceImpl extends BaseServiceImpl<CompanyHiddenlistingModel, Long> implements ICompanyHiddenlistingService {

	@Resource(name = "companyHiddenlistingDao")
	protected ICompanyHiddenlistingDao companyHiddenlistingDao;
	
	@Autowired
	public CompanyHiddenlistingServiceImpl(@Qualifier("companyHiddenlistingDao") ICompanyHiddenlistingDao companyHiddenlistingDao) {
		super(companyHiddenlistingDao);
	}
	
}