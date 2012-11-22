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

import com.safetys.zhjg.company.dao.ICompanyComplaintsDao;
import com.safetys.zhjg.company.model.CompanyComplaintsModel;
import com.safetys.zhjg.company.service.ICompanyComplaintsService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyComplaintsService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyComplaintsServiceImpl extends BaseServiceImpl<CompanyComplaintsModel, Long> implements ICompanyComplaintsService {

	@Resource(name = "companyComplaintsDao")
	protected ICompanyComplaintsDao companyComplaintsDao;
	
	@Autowired
	public CompanyComplaintsServiceImpl(@Qualifier("companyComplaintsDao") ICompanyComplaintsDao companyComplaintsDao) {
		super(companyComplaintsDao);
	}
	
}