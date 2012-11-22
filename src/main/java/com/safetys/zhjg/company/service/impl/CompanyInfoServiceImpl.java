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

import com.safetys.zhjg.company.dao.ICompanyInfoDao;
import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.service.ICompanyInfoService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyInfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyInfoServiceImpl extends BaseServiceImpl<CompanyInfoModel, Long> implements ICompanyInfoService {

	@Resource(name = "companyInfoDao")
	protected ICompanyInfoDao companyInfoDao;
	
	@Autowired
	public CompanyInfoServiceImpl(@Qualifier("companyInfoDao") ICompanyInfoDao companyInfoDao) {
		super(companyInfoDao);
	}
	
}