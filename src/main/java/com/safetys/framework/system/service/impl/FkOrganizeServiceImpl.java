/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.service.impl;

import java.util.ArrayList;
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

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.dao.IFkOrganizeDao;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.system.service.IFkOrganizeService;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkOrganizeService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkOrganizeServiceImpl extends BaseServiceImpl<FkOrganizeModel, Long> implements IFkOrganizeService {

	@Resource(name = "fkOrganizeDao")
	protected IFkOrganizeDao fkOrganizeDao;
	
	@Autowired
	public FkOrganizeServiceImpl(@Qualifier("fkOrganizeDao") IFkOrganizeDao fkOrganizeDao) {
		super(fkOrganizeDao);
	}

	@SuppressWarnings("rawtypes")
    public String datasToXml(List<FkOrganizeModel> datas) throws ServicesException {
		if (datas == null || datas.size() <= 0) { return ""; }
		FkOrganizeModel model = null;
		final Document document = DocumentHelper.createDocument();
		final Element nodesElement = document.addElement(NODES);
		final Iterator iterator = datas.iterator();
		while (iterator.hasNext()) {
			model = (FkOrganizeModel) iterator.next();
			final Element nodeElement = nodesElement.addElement(NODE);
			nodeElement.addAttribute(ID, String.valueOf(model.getId()));
			nodeElement.addAttribute(NAME, model.getOrgName());
		}
		return document.asXML();
    }
	
	
	public List<FkOrganizeModel> getChildrenResources(long fatherId,boolean isFather) throws ServicesException {
		List<FkOrganizeModel> models = null;
		try {
			if(isFather)
			{
				models = new ArrayList<FkOrganizeModel>();
				FkOrganizeModel fatherOrgan = this.fkOrganizeDao.findById(fatherId); //查找出顶级父结点
				models.add(fatherOrgan);
			}else{
				models = this.fkOrganizeDao.getChildrenResourcesInner(fatherId);
			}
			if ((models != null) && (models.size() > 0)) {
				for (final FkOrganizeModel model : models) {
					final List<FkOrganizeModel> datas = this.getChildrenResources(model.getId(),false);
					if ((datas != null) && (datas.size() > 0)) {
						model.setChildren(datas);
					}
				}
			}
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return models;
	}
	
	
	public String getXml(List<FkOrganizeModel> fkOrganizeModels) throws ServicesException {
		StringBuffer sf = new StringBuffer("<?xml version='1.0' encoding='utf-8' ?> ");
		sf.append("<root>");
		this.buildTreeXml(sf,fkOrganizeModels);
		sf.append("</root>");
		
		return sf.toString();
	}
	
	/**
	 * 根结一个Tree数据结构生成XML文件
	 * @param tempXml
	 * @param tree
	 */
	private void buildTreeXml(StringBuffer tempXml,List<FkOrganizeModel> list) {
		
		if(list !=null)
		{
			for(int i =0;i<list.size();i++)
			{
				FkOrganizeModel model = list.get(i);
				String s = "<tree id='" + model.getId()+"' name='"+model.getOrgName()+"' scription='"+model.getOrgDesc()+"' size='";
				if(model.getChildren() != null && model.getChildren().size()>0)
				{
					tempXml.append(s + model.getChildren().size() + "' >");
					buildTreeXml(tempXml,model.getChildren());
					tempXml.append("</tree>");
				}else{
					tempXml.append(s+"0' />");
				}
			}
		}
	}

	
	
}