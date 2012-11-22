/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service;

import java.util.List;

import com.safetys.zhjg.company.model.CompanyLicensingModel;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.system.model.FkUserModel;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface ICompanyLicensingService extends IBaseService<CompanyLicensingModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	/**
	 * @param user 当前登录的用户信息
	 */
	public List<CompanyLicensingModel> getCompanyLicensingModels(FkUserModel user,CompanyLicensingModel companyLicensingModel)throws ServicesException;
	
	/**
	 * 获取某个企业下的所有许可证列表
	 * @param companyId 企业ID
	 * @param companyLicensinModel
	 * @return
	 * @throws ServicesException
	 */
	public List<CompanyLicensingModel> getLicensinByCompanyId(long companyId,CompanyLicensingModel companyLicensinModel) throws ServicesException;
}
