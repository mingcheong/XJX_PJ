/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.dao.IFkRoleDao;
import com.safetys.framework.system.model.FkRoleModel;
import com.safetys.framework.system.service.IFkRoleService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkRoleService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkRoleServiceImpl extends BaseServiceImpl<FkRoleModel, Long> implements IFkRoleService {

	@Resource(name = "fkRoleDao")
	protected IFkRoleDao fkRoleDao;

	@Autowired
	public FkRoleServiceImpl(@Qualifier("fkRoleDao") IFkRoleDao fkRoleDao) {
		super(fkRoleDao);
	}

	@SuppressWarnings("rawtypes")
    public String datasToXml(List<FkRoleModel> datas) throws ServicesException {
		if (datas == null || datas.size() <= 0) { return ""; }
		FkRoleModel model = null;
		final Document document = DocumentHelper.createDocument();
		final Element nodesElement = document.addElement(NODES);
		final Iterator iterator = datas.iterator();
		while (iterator.hasNext()) {
			model = (FkRoleModel) iterator.next();
			final Element nodeElement = nodesElement.addElement(NODE);
			nodeElement.addAttribute(ID, String.valueOf(model.getId()));
			nodeElement.addAttribute(NAME, model.getRoleName());
		}
		return document.asXML();
	}

}