/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.framework.system.dao.IFkUserDao;
import com.safetys.framework.system.model.FkUserModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("fkUserDao")
public class FkUserDaoImpl extends BaseDaoImpl<FkUserModel, Long> implements IFkUserDao {

	public FkUserDaoImpl() {
		super(FkUserModel.class, "fkUserModel");
	}
}

