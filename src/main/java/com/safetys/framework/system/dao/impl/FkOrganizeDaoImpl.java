/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.dao.impl;

import java.util.List;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import com.safetys.framework.system.dao.IFkOrganizeDao;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.utils.StaticMember;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Repository("fkOrganizeDao")
public class FkOrganizeDaoImpl extends BaseDaoImpl<FkOrganizeModel, Long> implements IFkOrganizeDao {

	private static final String JPQL = "select o from fkOrganizeModel o where o.deleted=false and o.fatherId=:fatherId";

	public FkOrganizeDaoImpl() {
		super(FkOrganizeModel.class, "fkOrganizeModel");
	}
	
	/**
	 * 
	 * @param fatherId
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<FkOrganizeModel> getChildrenResources(long fatherId) throws DaoException {
		return this.getEntityManager().createQuery(JPQL).setParameter("fatherId", fatherId).getResultList();
	}
	
	/**
	 * 
	 * @param fatherId
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List<FkOrganizeModel> getChildrenResourcesInner(long fatherId) throws DaoException {
		String JPQLInner = JPQL + " and o.orgType=:orgType";
		return this.getEntityManager().createQuery(JPQLInner).setParameter("fatherId", fatherId).setParameter("orgType", StaticMember.ORGAN_INNER).getResultList();
	}

}

