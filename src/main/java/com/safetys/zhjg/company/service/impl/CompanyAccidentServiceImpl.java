/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.company.dao.ICompanyAccidentDao;
import com.safetys.zhjg.company.model.CompanyAccidentModel;
import com.safetys.zhjg.company.model.CompanyTrainModel;
import com.safetys.zhjg.company.service.ICompanyAccidentService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyAccidentService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyAccidentServiceImpl extends BaseServiceImpl<CompanyAccidentModel, Long> implements ICompanyAccidentService {

	@Resource(name = "companyAccidentDao")
	protected ICompanyAccidentDao companyAccidentDao;
	
	@Autowired
	public CompanyAccidentServiceImpl(@Qualifier("companyAccidentDao") ICompanyAccidentDao companyAccidentDao) {
		super(companyAccidentDao);
	}

	/**
	 * 获取所有的事故信息
	 */
	public List<CompanyAccidentModel> getCompanyAccidentModels(FkUserModel user,CompanyAccidentModel companyAccidentModel) throws ServicesException {
		String jpql = "select o from companyAccidentModel o where 1=1 and o.deleted=false ";
		if(companyAccidentModel.getIsReport() != null)
			jpql += " and o.isReport="+companyAccidentModel.getIsReport();
		
		if(!AppUtils.isNullOrEmptyString(user.getFirstArea()) && !"0".equals(user.getFirstArea()))
			jpql += " and o.firstArea like " + user.getFirstArea();
		if(!AppUtils.isNullOrEmptyString(user.getSecondArea()) && !"0".equals(user.getSecondArea()))
			jpql += " and o.secondArea like " + user.getSecondArea();
		if(!AppUtils.isNullOrEmptyString(user.getThirdArea()) && !"0".equals(user.getThirdArea()))
			jpql += " and o.thirdArea like " + user.getThirdArea();
		if(!AppUtils.isNullOrEmptyString(user.getFourthArea()) && !"0".equals(user.getFourthArea()))
			jpql += " and o.fourthArea like " + user.getFourthArea();
		if(!AppUtils.isNullOrEmptyString(user.getFifthArea()) && !"0".equals(user.getFifthArea()))
			jpql += " and o.fifthArea like " + user.getFifthArea();
		
		if (companyAccidentModel.getAccidentUnit() != null && companyAccidentModel.getAccidentUnit().getCompanyName() != "") 
		{
			jpql += " and o.accidentUnit.companyName like '%" + companyAccidentModel.getAccidentUnit().getCompanyName() + "%'";
		}
		if (companyAccidentModel.getAccidentReportOrgan() != null && companyAccidentModel.getAccidentReportOrgan().getOrgName() != "") 
		{
			jpql += " and o.accidentReportOrgan.orgName like '%" + companyAccidentModel.getAccidentReportOrgan().getOrgName() + "%'";
		}
		
		return this.getCollection(jpql, companyAccidentModel);

	}
	
	/**
	 * 根据企业ID获取某个企业下的事故列表
	 */
	public List<CompanyAccidentModel> getAccidentsByCompanyId(long companyId,CompanyAccidentModel companyAccidentModel) throws ServicesException {
		String jpql = "select o from companyAccidentModel o where o.deleted=false and o.accidentUnit.id="+companyId;
		if(companyAccidentModel.getIsReport() != null)
			jpql += " and o.isReport="+companyAccidentModel.getIsReport();
		if (companyAccidentModel.getAccidentReportOrgan() != null && companyAccidentModel.getAccidentReportOrgan().getOrgName() != "") 
		{
			jpql += " and o.accidentReportOrgan.orgName like '%" + companyAccidentModel.getAccidentReportOrgan().getOrgName() + "%'";
		}
		
		return this.getCollection(jpql, companyAccidentModel);

	}
}