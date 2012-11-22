/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service;

import java.util.List;

import com.safetys.zhjg.company.model.CompanyHiddendangerModel;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.IBaseService;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface ICompanyHiddendangerService extends IBaseService<CompanyHiddendangerModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	
	/**
	 * 生成隐患编号
	 * @param companyHiddendangerModel
	 * @return
	 */
	public String buildCode(CompanyHiddendangerModel companyHiddendangerModel);
	
	/**
	 * 隐患挂牌
	 * 查询已有隐患
	 * @param companyHiddendangerModel
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<CompanyHiddendangerModel> getCompanyHiddendangerModels(CompanyHiddendangerModel companyHiddendangerModel)throws ServicesException;
	
	
	/**
	 * 企业 隐患
	 * @param companyId
	 * @return
	 * @throws ServicesException
	 */
	public List<CompanyHiddendangerModel> companyHidden(CompanyHiddendangerModel companyHiddendangerModel) throws ServicesException;
	
	/**
	 * 挂牌查询
	 * @param companyHiddendangerModel
	 * @return
	 * @throws ServicesException
	 */
	public List<CompanyHiddendangerModel> getCompanyHiddendangerListingModels(CompanyHiddendangerModel companyHiddendangerModel) throws ServicesException;
}
