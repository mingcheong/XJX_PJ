/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.dao;

import java.util.List;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.dao.IBaseDao;
import com.safetys.framework.system.model.FkResourceModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IFkResourceDao extends IBaseDao<FkResourceModel, Long> {
	
	public List<String> getActions(String resourceIds) throws DaoException;

	public List<FkResourceModel> getChildrenResources(long fatherId) throws DaoException;
	
	public List<FkResourceModel> getChildrenResources(String resourceIds,long fatherId) throws DaoException;
}
