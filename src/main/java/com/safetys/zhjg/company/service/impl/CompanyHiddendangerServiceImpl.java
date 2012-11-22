/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.company.dao.ICompanyHiddendangerDao;
import com.safetys.zhjg.company.model.CompanyHiddendangerModel;
import com.safetys.zhjg.company.service.ICompanyHiddendangerService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyHiddendangerService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyHiddendangerServiceImpl extends BaseServiceImpl<CompanyHiddendangerModel, Long> implements ICompanyHiddendangerService {

	@Resource(name = "companyHiddendangerDao")
	protected ICompanyHiddendangerDao companyHiddendangerDao;

	@Autowired
	public CompanyHiddendangerServiceImpl(@Qualifier("companyHiddendangerDao") ICompanyHiddendangerDao companyHiddendangerDao) {
		super(companyHiddendangerDao);
	}

	public String buildCode(CompanyHiddendangerModel companyHiddendangerModel) {
		String code = "";
		if (companyHiddendangerModel != null && companyHiddendangerModel.getCompanyInfoModel() != null) {
			code += Calendar.DAY_OF_YEAR;
		}
		return code;
	}

	public List<CompanyHiddendangerModel> getCompanyHiddendangerModels(CompanyHiddendangerModel companyHiddendangerModel) throws ServicesException {
		String jpql = "select o from companyHiddendangerModel o where 1=1 ";
		if (companyHiddendangerModel.getCompanyInfoModel() != null) {
			if (companyHiddendangerModel.getCompanyInfoModel().getCompanyName() != null && !companyHiddendangerModel.getCompanyInfoModel().getCompanyName().equals("")) {
				jpql += " and o.companyInfoModel.companyName like '%" + companyHiddendangerModel.getCompanyInfoModel().getCompanyName() + "%' ";
			}
			if (companyHiddendangerModel.getCompanyInfoModel().getFirstArea() != null && !companyHiddendangerModel.getCompanyInfoModel().getFirstArea().equals("")
			        && !companyHiddendangerModel.getCompanyInfoModel().getFirstArea().equals("0")) {
				jpql += " and o.companyInfoModel.firstArea = '" + companyHiddendangerModel.getCompanyInfoModel().getFirstArea() + "' ";
			}
			if (companyHiddendangerModel.getCompanyInfoModel().getSecondArea() != null && !companyHiddendangerModel.getCompanyInfoModel().getSecondArea().equals("")
			        && !companyHiddendangerModel.getCompanyInfoModel().getSecondArea().equals("0")) {
				jpql += " and o.companyInfoModel.secondArea = '" + companyHiddendangerModel.getCompanyInfoModel().getSecondArea() + "'";
			}
			if (companyHiddendangerModel.getCompanyInfoModel().getThirdArea() != null && !companyHiddendangerModel.getCompanyInfoModel().getThirdArea().equals("")
			        && !companyHiddendangerModel.getCompanyInfoModel().getThirdArea().equals("0")) {
				jpql += " and  o.companyInfoModel.thirdArea = '" + companyHiddendangerModel.getCompanyInfoModel().getThirdArea() + "'";
			}
		}
		jpql +=" and o.deleted=false ";
		try {
			return companyHiddendangerDao.getCollection(jpql, companyHiddendangerModel);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}

	}

	public List<CompanyHiddendangerModel> companyHidden(
			CompanyHiddendangerModel companyHiddendangerModel)
			throws ServicesException {
		String jpql = "select o from companyHiddendangerModel o where 1=1 ";
		if(companyHiddendangerModel.getCompanyInfoModel()!=null){
			if(companyHiddendangerModel.getCompanyInfoModel().getId()!=null&&companyHiddendangerModel.getCompanyInfoModel().getId()>0){
				jpql+=" and o.companyInfoModel.id = "+companyHiddendangerModel.getCompanyInfoModel().getId()+" ";
			}
		}
		jpql +=" and o.deleted=false ";
		try {
			return companyHiddendangerDao.getCollection(jpql, companyHiddendangerModel);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
	}

	public List<CompanyHiddendangerModel> getCompanyHiddendangerListingModels(
			CompanyHiddendangerModel companyHiddendangerModel)
			throws ServicesException {
		String jpql = "select o from companyHiddendangerModel o where 1=1 ";
		if(companyHiddendangerModel==null||AppUtils.isNullOrEmptyString(companyHiddendangerModel.getLevel())){
			jpql += "and (o.level is not null or o.level != '') ";
		}
		if (companyHiddendangerModel.getCompanyInfoModel() != null) {
			if (companyHiddendangerModel.getCompanyInfoModel().getCompanyName() != null && !companyHiddendangerModel.getCompanyInfoModel().getCompanyName().equals("")) {
				jpql += " and o.companyInfoModel.companyName like '%" + companyHiddendangerModel.getCompanyInfoModel().getCompanyName() + "%' ";
			}
			if (companyHiddendangerModel.getCompanyInfoModel().getFirstArea() != null && !companyHiddendangerModel.getCompanyInfoModel().getFirstArea().equals("")
			        && !companyHiddendangerModel.getCompanyInfoModel().getFirstArea().equals("0")) {
				jpql += " and o.companyInfoModel.firstArea = '" + companyHiddendangerModel.getCompanyInfoModel().getFirstArea() + "' ";
			}
			if (companyHiddendangerModel.getCompanyInfoModel().getSecondArea() != null && !companyHiddendangerModel.getCompanyInfoModel().getSecondArea().equals("")
			        && !companyHiddendangerModel.getCompanyInfoModel().getSecondArea().equals("0")) {
				jpql += " and o.companyInfoModel.secondArea = '" + companyHiddendangerModel.getCompanyInfoModel().getSecondArea() + "'";
			}
			if (companyHiddendangerModel.getCompanyInfoModel().getThirdArea() != null && !companyHiddendangerModel.getCompanyInfoModel().getThirdArea().equals("")
			        && !companyHiddendangerModel.getCompanyInfoModel().getThirdArea().equals("0")) {
				jpql += " and  o.companyInfoModel.thirdArea = '" + companyHiddendangerModel.getCompanyInfoModel().getThirdArea() + "'";
			}
		}
		jpql +=" and o.deleted=false ";
		try {
			return companyHiddendangerDao.getCollection(jpql, companyHiddendangerModel);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}

	}


}