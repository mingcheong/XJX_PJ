package com.safetys.zhjg.base.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.zhjg.base.dao.IBaseNoticeUsersDao;
import com.safetys.zhjg.base.model.BaseNoticeUsersModel;
import com.safetys.zhjg.base.service.IBaseNoticeUsersService;

@Service("baseNoticeUsersService")
public class BaseNoticeUsersServiceImpl extends BaseServiceImpl<BaseNoticeUsersModel, Long> implements IBaseNoticeUsersService {

	@Resource(name = "baseNoticeUsersDao")
	protected IBaseNoticeUsersDao baseNoticeUsersDao;

	@Autowired
	public BaseNoticeUsersServiceImpl(@Qualifier("baseNoticeUsersDao") IBaseNoticeUsersDao baseNoticeUsersDao) {
		super(baseNoticeUsersDao);
	}

}
