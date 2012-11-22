/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service;

import java.util.List;

import com.safetys.zhjg.company.model.CompanyLicensingModel;
import com.safetys.zhjg.company.model.CompanyTrainModel;
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
public interface ICompanyTrainService extends IBaseService<CompanyTrainModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	/**
	 * 获取所有的培训信息
	 */
	public List<CompanyTrainModel> getCompanyTrainModels(FkUserModel user,CompanyTrainModel companyTrainModel) throws ServicesException;
	/**
	 * 获取某个企业下的所有培训信息
	 * @param companyId
	 * @param companyTrainModel
	 * @return
	 * @throws ServicesException
	 */
	List<CompanyTrainModel> getTrainByCompanyId(long companyId,CompanyTrainModel companyTrainModel) throws ServicesException ;
}
