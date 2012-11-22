/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.framework.system.dao.IFkAnnexDao;
import com.safetys.framework.system.model.FkAnnexModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("fkAnnexDao")
public class FkAnnexDaoImpl extends BaseDaoImpl<FkAnnexModel, Long> implements IFkAnnexDao {

	public FkAnnexDaoImpl() {
		super(FkAnnexModel.class, "fkAnnexModel");
	}
}

