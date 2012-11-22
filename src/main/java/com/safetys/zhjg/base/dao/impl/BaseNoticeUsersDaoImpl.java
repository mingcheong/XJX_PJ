package com.safetys.zhjg.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.safetys.framework.kernel.dao.impl.BaseDaoImpl;
import com.safetys.zhjg.base.dao.IBaseNoticeUsersDao;
import com.safetys.zhjg.base.model.BaseNoticeUsersModel;

@Repository("baseNoticeUsersDao")
public class BaseNoticeUsersDaoImpl extends BaseDaoImpl<BaseNoticeUsersModel, Long> implements IBaseNoticeUsersDao {

	public BaseNoticeUsersDaoImpl() {
		super(BaseNoticeUsersModel.class, "baseNoticeUsersModel");
	}

}
