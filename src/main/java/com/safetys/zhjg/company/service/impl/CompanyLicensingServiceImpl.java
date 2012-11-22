/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.utils.AppUtils;
import com.safetys.zhjg.company.dao.ICompanyLicensingDao;
import com.safetys.zhjg.company.model.CompanyLicensingModel;
import com.safetys.zhjg.company.service.ICompanyLicensingService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyLicensingService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyLicensingServiceImpl extends BaseServiceImpl<CompanyLicensingModel, Long> implements ICompanyLicensingService {

	@Resource(name = "companyLicensingDao")
	protected ICompanyLicensingDao companyLicensingDao;

	@Autowired
	public CompanyLicensingServiceImpl(@Qualifier("companyLicensingDao") ICompanyLicensingDao companyLicensingDao) {
		super(companyLicensingDao);
	}

	/**
	 * 获取所有许可证列表 
	 */
	public List<CompanyLicensingModel> getCompanyLicensingModels(FkUserModel user,CompanyLicensingModel companyLicensingModel) throws ServicesException {
		String jpql = "select o from companyLicensingModel o where 1=1 and o.deleted=false ";
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
		
		if (companyLicensingModel.getCompanyInfo() != null && companyLicensingModel.getCompanyInfo().getCompanyName() != "") {
			jpql += "and o.companyInfo.companyName like '%" + companyLicensingModel.getCompanyInfo().getCompanyName() + "%'";
		}
		return this.getCollection(jpql, companyLicensingModel);
	}
	
	/**
	 * 根据企业ID获取某个企业下的许可列表
	 * @param companyId:企业ID
	 */
	public List<CompanyLicensingModel> getLicensinByCompanyId(long companyId,CompanyLicensingModel companyLicensinModel) throws ServicesException {
		String jpql = "select o from companyLicensingModel o where o.deleted=false and o.companyInfo.id="+companyId;
		
		return this.getCollection(jpql, companyLicensinModel);
	}
}