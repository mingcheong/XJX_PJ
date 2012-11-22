/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.dao;

import java.util.List;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.dao.IBaseDao;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkResourceModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IFkOrganizeDao extends IBaseDao<FkOrganizeModel, Long> {
	/**
	 * 根据父ID获取该部门下的子部门
	 * @param fatherId  父ID
	 * @return   organizeModel 集合
	 * @throws DaoException
	 */
	public List<FkOrganizeModel> getChildrenResources(long fatherId) throws DaoException;
	public List<FkOrganizeModel> getChildrenResourcesInner(long fatherId) throws DaoException;
	
}
