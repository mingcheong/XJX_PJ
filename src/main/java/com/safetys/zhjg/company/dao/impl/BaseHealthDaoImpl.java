/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.zhjg.company.dao.IBaseHealthDao;
import com.safetys.zhjg.company.model.BaseHealthModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("baseHealthDao")
public class BaseHealthDaoImpl extends BaseDaoImpl<BaseHealthModel, Long> implements IBaseHealthDao {

	public BaseHealthDaoImpl() {
		super(BaseHealthModel.class, "baseHealthModel");
	}
}

