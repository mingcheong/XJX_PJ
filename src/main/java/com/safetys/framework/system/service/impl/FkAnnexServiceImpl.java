/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.system.dao.IFkAnnexDao;
import com.safetys.framework.system.model.FkAnnexModel;
import com.safetys.framework.system.service.IFkAnnexService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkAnnexService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkAnnexServiceImpl extends BaseServiceImpl<FkAnnexModel, Long> implements IFkAnnexService {

	@Resource(name = "fkAnnexDao")
	protected IFkAnnexDao fkAnnexDao;
	
	@Autowired
	public FkAnnexServiceImpl(@Qualifier("fkAnnexDao") IFkAnnexDao fkAnnexDao) {
		super(fkAnnexDao);
	}
	
}