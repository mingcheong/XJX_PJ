/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.zhjg.company.dao.ICompanyStandardDao;
import com.safetys.zhjg.company.model.CompanyStandardModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("companyStandardDao")
public class CompanyStandardDaoImpl extends BaseDaoImpl<CompanyStandardModel, Long> implements ICompanyStandardDao {

	public CompanyStandardDaoImpl() {
		super(CompanyStandardModel.class, "companyStandardModel");
	}
}

