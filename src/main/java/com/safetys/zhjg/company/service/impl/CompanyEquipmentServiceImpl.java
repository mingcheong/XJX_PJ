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

import com.safetys.zhjg.company.dao.ICompanyEquipmentDao;
import com.safetys.zhjg.company.model.CompanyEquipmentModel;
import com.safetys.zhjg.company.service.ICompanyEquipmentService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyEquipmentService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyEquipmentServiceImpl extends BaseServiceImpl<CompanyEquipmentModel, Long> implements ICompanyEquipmentService {

	@Resource(name = "companyEquipmentDao")
	protected ICompanyEquipmentDao companyEquipmentDao;
	
	@Autowired
	public CompanyEquipmentServiceImpl(@Qualifier("companyEquipmentDao") ICompanyEquipmentDao companyEquipmentDao) {
		super(companyEquipmentDao);
	}
	
}