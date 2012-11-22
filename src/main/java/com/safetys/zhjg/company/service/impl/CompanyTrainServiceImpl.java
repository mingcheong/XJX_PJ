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
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.company.dao.ICompanyTrainDao;
import com.safetys.zhjg.company.model.CompanyLicensingModel;
import com.safetys.zhjg.company.model.CompanyTrainModel;
import com.safetys.zhjg.company.service.ICompanyTrainService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyTrainService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyTrainServiceImpl extends BaseServiceImpl<CompanyTrainModel, Long> implements ICompanyTrainService {

	@Resource(name = "companyTrainDao")
	protected ICompanyTrainDao companyTrainDao;
	
	@Autowired
	public CompanyTrainServiceImpl(@Qualifier("companyTrainDao") ICompanyTrainDao companyTrainDao) {
		super(companyTrainDao);
	}
	
	/**
	 * 获取所有的培训信息
	 */
	public List<CompanyTrainModel> getCompanyTrainModels(FkUserModel user,CompanyTrainModel companyTrainModel) throws ServicesException {
		String jpql = "select o from companyTrainModel o where 1=1 and o.deleted=false ";
		
		if(!AppUtils.isNullOrEmptyString(user.getFirstArea()) && !"0".equals(user.getFirstArea()))
			jpql += " and o.companyInfo.firstArea like " + user.getFirstArea();
		if(!AppUtils.isNullOrEmptyString(user.getSecondArea()) && !"0".equals(user.getSecondArea()))
			jpql += " and o.companyInfo.secondArea like " + user.getSecondArea();
		if(!AppUtils.isNullOrEmptyString(user.getThirdArea()) && !"0".equals(user.getThirdArea()))
			jpql += " and o.companyInfo.thirdArea like " + user.getThirdArea();
		if(!AppUtils.isNullOrEmptyString(user.getFourthArea()) && !"0".equals(user.getFourthArea()))
			jpql += " and o.companyInfo.fourthArea like " + user.getFourthArea();
		if(!AppUtils.isNullOrEmptyString(user.getFifthArea()) && !"0".equals(user.getFifthArea()))
			jpql += " and o.companyInfo.fifthArea like " + user.getFifthArea();
		
		if (companyTrainModel.getCompanyInfo() != null && companyTrainModel.getCompanyInfo().getCompanyName() != "") {
			jpql += "and o.companyInfo.companyName like '%" + companyTrainModel.getCompanyInfo().getCompanyName() + "%'";
		}
		return this.getCollection(jpql, companyTrainModel);
	}

	/**
	 * 获取某个企业下的培训信息
	 */
	public List<CompanyTrainModel> getTrainByCompanyId(long companyId, CompanyTrainModel companyTrainModel) throws ServicesException {
		String jpql = "select o from companyTrainModel o where o.deleted=false and o.companyInfo.id="+companyId;
		
		return this.getCollection(jpql, companyTrainModel);
	}
	
}