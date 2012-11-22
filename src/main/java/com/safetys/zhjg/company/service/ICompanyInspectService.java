/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service;

import java.util.List;

import com.safetys.zhjg.company.model.CompanyInspectModel;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.IBaseService;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface ICompanyInspectService extends IBaseService<CompanyInspectModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	
	/**
	 * 查出该企业的行政执法记录
	 * @param companyInspectModel
	 * @return
	 * @throws ServicesException
	 */
	public List<CompanyInspectModel> inspectManager(CompanyInspectModel companyInspectModel)throws ServicesException;
}
