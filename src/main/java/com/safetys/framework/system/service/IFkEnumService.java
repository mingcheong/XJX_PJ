/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.service;

import java.util.List;

import com.safetys.framework.system.model.FkEnumModel;
import com.safetys.framework.kernel.service.IBaseService;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IFkEnumService extends IBaseService<FkEnumModel, Long>{
	
	//TODO:此平台提供了常规的CRUD等基本功能，开发人员由些添加当前业务模块的服务接口
	
	/**
	 * 根据编号获取所有枚举（包括子类）
	 * @param typeCode
	 * @return
	 */
	public List<FkEnumModel> getAllByTypeCode(String typeCode);
}
