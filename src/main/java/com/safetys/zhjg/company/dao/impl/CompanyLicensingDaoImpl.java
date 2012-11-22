/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import com.safetys.zhjg.company.dao.ICompanyLicensingDao;
import com.safetys.zhjg.company.model.CompanyLicensingModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("companyLicensingDao")
public class CompanyLicensingDaoImpl extends BaseDaoImpl<CompanyLicensingModel, Long> implements ICompanyLicensingDao {

	public CompanyLicensingDaoImpl() {
		super(CompanyLicensingModel.class, "companyLicensingModel");
	}
	
	public List<CompanyLicensingModel>findByCompanyId(long companyId) throws ServicesException {
//		// TODO Auto-generated method stub
//		String JPQL = "select o from companyLicensingModel o where o.companyInfo.id=:companyId";
//		CompanyInfoModel model = new CompanyInfoModel();
//		model.setId(companyId);
//		//List<CompanyLicensingModel> models =  this.getEntityManager().createQuery(JPQL).setParameter("companyId", companyId).getResultList();
		

		return null;
	}
}

