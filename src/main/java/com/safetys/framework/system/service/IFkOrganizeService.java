/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.service;

import java.util.List;

import com.safetys.framework.system.model.FkOrganizeModel;
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
public interface IFkOrganizeService extends IBaseService<FkOrganizeModel, Long> {

	/**
	 * 将集合转换成XML
	 * @param datas
	 * @return {@link String}
	 * @throws ServicesException
	 */
	public String datasToXml(List<FkOrganizeModel> datas) throws ServicesException;
	/**
	 * 根据父ID  获取子部门"父子"结构集合
	 * @param fatherId :是否是当用户所在部门的ID
	 * @param isFather:是否是当用户所在部门
	 * @return 部门集合
	 * @throws ServicesException
	 */
	public List<FkOrganizeModel> getChildrenResources(long fatherId,boolean isFather) throws ServicesException;
	/**
	 * 获取  部门树结构的xml格式字符串
	 * @param fkOrganizeModels 含有子部门的部门集合
	 * @return  xml格式的字符串
	 * @throws ServicesException
	 */
	public String getXml(List<FkOrganizeModel> fkOrganizeModels) throws ServicesException ;
}
