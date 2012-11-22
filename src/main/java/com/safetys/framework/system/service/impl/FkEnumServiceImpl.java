/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.framework.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.system.dao.IFkEnumDao;
import com.safetys.framework.system.model.FkEnumModel;
import com.safetys.framework.system.service.IFkEnumService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkEnumService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkEnumServiceImpl extends BaseServiceImpl<FkEnumModel, Long> implements IFkEnumService {

	@Resource(name = "fkEnumDao")
	protected IFkEnumDao fkEnumDao;
	
	@Autowired
	public FkEnumServiceImpl(@Qualifier("fkEnumDao") IFkEnumDao fkEnumDao) {
		super(fkEnumDao);
	}

	public List<FkEnumModel> getAllByTypeCode(String typeCode) {
		List<FkEnumModel> enums = new ArrayList<FkEnumModel>();
		try {
			enums = fkEnumDao.getCollection("select o from fkEnumModel o where o.fatherId in (select e.id from fkEnumModel e where e.enumCode = '"+typeCode+"' and e.deleted = false) and o.deleted = false order by o.sortNum",false);
			if(enums!=null&&enums.size()>0){
				for(int i = 0;i<enums.size();i++){
					if(enums.get(i)!=null&&!enums.get(i).getEnumCode().equals("")&&enums.get(i).getHasChildren()){
						enums.get(i).setChildern(getAllByTypeCode(enums.get(i).getEnumCode()));
					}
				}
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return enums;
	}
	
}