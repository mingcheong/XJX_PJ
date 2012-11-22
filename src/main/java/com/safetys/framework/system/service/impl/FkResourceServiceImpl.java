/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.dao.IFkResourceDao;
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.system.service.IFkResourceService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkResourceService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkResourceServiceImpl extends BaseServiceImpl<FkResourceModel, Long> implements IFkResourceService {

	@Resource(name = "fkResourceDao")
	protected IFkResourceDao fkResourceDao;

	@Autowired
	public FkResourceServiceImpl(@Qualifier("fkResourceDao") IFkResourceDao fkResourceDao) {
		super(fkResourceDao);
	}

	public List<FkResourceModel> getChildrenResources(long fatherId) throws ServicesException {
		List<FkResourceModel> models = null;
		try {
			models = this.fkResourceDao.getChildrenResources(fatherId);
			if ((models != null) && (models.size() > 0)) {
				for (final FkResourceModel model : models) {
					if (model.getHasChildren()) {
						final List<FkResourceModel> datas = this.getChildrenResources(model.getId());
						if ((datas != null) && (datas.size() > 0)) {
							model.setChildren(datas);
						}
					}
				}
			}
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return models;
	}

	public List<FkResourceModel> getChildrenResources(String resourceIds, long fatherId) throws ServicesException {
		List<FkResourceModel> models = null;
		try {
			models = this.fkResourceDao.getChildrenResources(resourceIds, fatherId);
			if ((models != null) && (models.size() > 0)) {
				for (final FkResourceModel model : models) {
					if (model.getHasChildren()) {
						final List<FkResourceModel> datas = this.getChildrenResources(resourceIds, model.getId());
						if ((datas != null) && (datas.size() > 0)) {
							model.setChildren(datas);
						}
					}
				}
			}
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return models;
	}

	public List<TreeModel> getJson(List<FkResourceModel> fkResourceModels, List<TreeModel> treeModels) throws ServicesException {
		for (FkResourceModel element : fkResourceModels) {
			TreeModel treeModel = new TreeModel();
			treeModel.setId(element.getId());
			treeModel.setpId(element.getFatherId());
			treeModel.setName(element.getResourceName());
			if(!element.getIsMenu()){treeModel.setFont("{color:red}");}
			if (element.getChildren() != null && element.getChildren().size() > 0) {
				treeModel.setIsParent(true);
				treeModel.setOpen(true);
				treeModels.add(treeModel);
				getJson(element.getChildren(), treeModels);
			} else {
				treeModel.setIsParent(false);
				treeModel.setOpen(false);
				treeModels.add(treeModel);
			}

		}
		return treeModels;
	}

	public List<String> getActions(String resourceIds) throws ServicesException {
		try {
			return fkResourceDao.getActions(resourceIds);
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
	}

}