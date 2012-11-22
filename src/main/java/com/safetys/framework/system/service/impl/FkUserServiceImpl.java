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
import com.safetys.framework.system.dao.IFkUserDao;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkUserService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.zhjg.company.model.CompanyTrainModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkUserService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkUserServiceImpl extends BaseServiceImpl<FkUserModel, Long> implements IFkUserService {

	@Resource(name = "fkUserDao")
	protected IFkUserDao fkUserDao;

	@Autowired
	public FkUserServiceImpl(@Qualifier("fkUserDao") IFkUserDao fkUserDao) {
		super(fkUserDao);
	}

	@SuppressWarnings("rawtypes")
	public String datasToXml(List<FkUserModel> datas) throws ServicesException {
		if (datas == null || datas.size() <= 0) { return ""; }
		FkUserModel model = null;
		final Document document = DocumentHelper.createDocument();
		final Element nodesElement = document.addElement(NODES);
		final Iterator iterator = datas.iterator();
		while (iterator.hasNext()) {
			model = (FkUserModel) iterator.next();
			final Element nodeElement = nodesElement.addElement(NODE);
			nodeElement.addAttribute(ID, String.valueOf(model.getId()));
			nodeElement.addAttribute(NAME, model.getTruename());
		}
		return document.asXML();
	}
	public List<FkUserModel> getUsersOrderByOrganId(FkUserModel fkUserModel) throws ServicesException {
		String jpql = "select o from fkUserModel o where 1=1 and o.deleted=false order by o.fkOrganize.id desc";
		
		
		return this.getCollection(jpql, fkUserModel);
	}
}