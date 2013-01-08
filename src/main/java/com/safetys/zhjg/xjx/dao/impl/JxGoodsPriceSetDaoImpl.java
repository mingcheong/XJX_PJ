/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.xjx.dao.impl;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.zhjg.xjx.dao.IJxGoodsPriceSetDao;
import com.safetys.zhjg.xjx.model.JxGoodsPriceSetModel;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("jxGoodsPriceSetDao")
public class JxGoodsPriceSetDaoImpl extends BaseDaoImpl<JxGoodsPriceSetModel, Long> implements IJxGoodsPriceSetDao {

	public JxGoodsPriceSetDaoImpl() {
		super(JxGoodsPriceSetModel.class, "jxGoodsPriceSetModel");
	}
}

