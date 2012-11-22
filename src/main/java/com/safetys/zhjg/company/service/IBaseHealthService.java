/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service;

import java.util.List;

import com.safetys.zhjg.company.model.BaseHealthModel;
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
public interface IBaseHealthService extends IBaseService<BaseHealthModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	/**
	 * 获取所有的防治信息
	 */
	public List<BaseHealthModel> getCompanyBaseHealthModels(FkUserModel user,BaseHealthModel baseHealthModel) throws ServicesException ;
	
	/**
	 * 根据企业ID获取某个企业下的防治信息列表
	 */
	public List<BaseHealthModel> getBaseHealthByCompanyId(long companyId,BaseHealthModel baseHealthModel) throws ServicesException ;

}
