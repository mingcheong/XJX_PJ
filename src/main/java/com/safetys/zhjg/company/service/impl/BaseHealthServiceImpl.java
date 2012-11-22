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

import com.safetys.zhjg.company.dao.IBaseHealthDao;
import com.safetys.zhjg.company.model.BaseHealthModel;
import com.safetys.zhjg.company.model.CompanyAccidentModel;
import com.safetys.zhjg.company.service.IBaseHealthService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("baseHealthService")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseHealthServiceImpl extends BaseServiceImpl<BaseHealthModel, Long> implements IBaseHealthService {

	@Resource(name = "baseHealthDao")
	protected IBaseHealthDao baseHealthDao;
	
	@Autowired
	public BaseHealthServiceImpl(@Qualifier("baseHealthDao") IBaseHealthDao baseHealthDao) {
		super(baseHealthDao);
	}
	
	/**
	 * 获取所有的防治信息
	 */
	public List<BaseHealthModel> getCompanyBaseHealthModels(FkUserModel user,BaseHealthModel baseHealthModel) throws ServicesException {
		String jpql = "select o from baseHealthModel o where 1=1 and o.deleted=false ";
		
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
		
		if ( baseHealthModel.getCompanyInfo() != null && baseHealthModel.getCompanyInfo().getCompanyName() != "") 
		{
			jpql += " and o.companyInfo.companyName like '%" + baseHealthModel.getCompanyInfo().getCompanyName() + "%'";
		}
		
		return this.getCollection(jpql, baseHealthModel);
	}
	
	/**
	 * 根据企业ID获取某个企业下的防治信息列表
	 */
	public List<BaseHealthModel> getBaseHealthByCompanyId(long companyId,BaseHealthModel baseHealthModel) throws ServicesException {
		String jpql = "select o from baseHealthModel o where o.deleted=false and o.companyInfo.id="+companyId;

		return this.getCollection(jpql, baseHealthModel);
	}
	
}