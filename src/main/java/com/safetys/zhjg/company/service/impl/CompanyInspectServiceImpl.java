/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.company.dao.ICompanyInspectDao;
import com.safetys.zhjg.company.model.CompanyInspectModel;
import com.safetys.zhjg.company.service.ICompanyInspectService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyInspectService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyInspectServiceImpl extends BaseServiceImpl<CompanyInspectModel, Long> implements ICompanyInspectService {

	@Resource(name = "companyInspectDao")
	protected ICompanyInspectDao companyInspectDao;
	
	@Autowired
	public CompanyInspectServiceImpl(@Qualifier("companyInspectDao") ICompanyInspectDao companyInspectDao) {
		super(companyInspectDao);
	}

	public List<CompanyInspectModel> inspectManager(
			CompanyInspectModel companyInspectModel) throws ServicesException {
		String SQL = "select o from companyInspectModel o where 1=1 ";
		if(companyInspectModel.getCompanyInfoModel()!=null&&companyInspectModel.getCompanyInfoModel().getId()!=null&&companyInspectModel.getCompanyInfoModel().getId()>0){
			SQL += " and o.companyInfoModel.id = "+companyInspectModel.getCompanyInfoModel().getId();
		}
		SQL += " AND o.deleted = false ";
		try {
			return companyInspectDao.getCollection(SQL, companyInspectModel);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
	}
	
}