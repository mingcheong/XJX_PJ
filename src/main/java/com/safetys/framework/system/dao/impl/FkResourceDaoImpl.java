/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import com.safetys.framework.system.dao.IFkResourceDao;
import com.safetys.framework.system.model.FkResourceModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("fkResourceDao")
public class FkResourceDaoImpl extends BaseDaoImpl<FkResourceModel, Long> implements IFkResourceDao {

	private static final String JPQL = "select o from fkResourceModel o where o.fatherId=:fatherId and o.deleted=false order by o.id asc, o.sortNum asc";

	public FkResourceDaoImpl() {
		super(FkResourceModel.class, "fkResourceModel");
	}

	@SuppressWarnings("unchecked")
	public List<FkResourceModel> getChildrenResources(long fatherId) throws DaoException {
		return this.getEntityManager().createQuery(JPQL).setParameter("fatherId", fatherId).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<FkResourceModel> getChildrenResources(String resourceIds, long fatherId) throws DaoException {
		return this.getEntityManager().createQuery("select o from fkResourceModel o where o.id in(" + resourceIds + ") and fatherId=" + fatherId+" and o.deleted=false and o.isMenu = true order by o.id asc,o.sortNum asc").getResultList();
	}

	@SuppressWarnings("unchecked")
    public List<String> getActions(String resourceIds) throws DaoException {
	    return this.getEntityManager().createQuery("select o.resourceUrl from fkResourceModel o where o.id in(" + resourceIds + ") and o.deleted=false order by o.id asc,o.sortNum asc").getResultList();
    }
}
