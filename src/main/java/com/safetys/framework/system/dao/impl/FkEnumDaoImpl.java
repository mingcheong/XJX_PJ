/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.framework.system.dao.IFkEnumDao;
import com.safetys.framework.system.model.FkEnumModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("fkEnumDao")
public class FkEnumDaoImpl extends BaseDaoImpl<FkEnumModel, Long> implements IFkEnumDao {

	public FkEnumDaoImpl() {
		super(FkEnumModel.class, "fkEnumModel");
	}
}

