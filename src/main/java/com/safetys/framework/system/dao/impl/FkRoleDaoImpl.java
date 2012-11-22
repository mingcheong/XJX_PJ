/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.framework.system.dao.IFkRoleDao;
import com.safetys.framework.system.model.FkRoleModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("fkRoleDao")
public class FkRoleDaoImpl extends BaseDaoImpl<FkRoleModel, Long> implements IFkRoleDao {

	public FkRoleDaoImpl() {
		super(FkRoleModel.class, "fkRoleModel");
	}
}

