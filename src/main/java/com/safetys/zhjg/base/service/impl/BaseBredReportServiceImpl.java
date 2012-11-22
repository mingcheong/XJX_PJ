/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.base.dao.IBaseBredReportDao;
import com.safetys.zhjg.base.model.BaseBredReportModel;
import com.safetys.zhjg.base.service.IBaseBredReportService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("baseBredReportService")
@Transactional(propagation = Propagation.REQUIRED)
public class BaseBredReportServiceImpl extends BaseServiceImpl<BaseBredReportModel, Long> implements IBaseBredReportService {

	@Resource(name = "baseBredReportDao")
	protected IBaseBredReportDao baseBredReportDao;
	
	@Autowired
	public BaseBredReportServiceImpl(@Qualifier("baseBredReportDao") IBaseBredReportDao baseBredReportDao) {
		super(baseBredReportDao);
	}
	
}