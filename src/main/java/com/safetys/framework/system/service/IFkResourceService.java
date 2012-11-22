/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.service;

import java.util.List;

import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.kernel.service.IBaseService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IFkResourceService extends IBaseService<FkResourceModel, Long> {

	/**
	 * 取子菜单
	 * 
	 * @param fatherId
	 * @throws ServicesException
	 */
	public List<FkResourceModel> getChildrenResources(long fatherId) throws ServicesException;

	/**
	 * 取子菜单
	 * @param resourceIds
	 * @param fatherId
	 * @throws ServicesException
	 */
	public List<FkResourceModel> getChildrenResources(String resourceIds, long fatherId) throws ServicesException;
	
	/**
	 * 取URL
	 * @param resourceIds
	 * @return
	 * @throws ServicesException
	 */
	public List<String> getActions(String resourceIds)throws ServicesException;

	public List<TreeModel> getJson(List<FkResourceModel> datas, List<TreeModel> treeModels) throws ServicesException;
}
