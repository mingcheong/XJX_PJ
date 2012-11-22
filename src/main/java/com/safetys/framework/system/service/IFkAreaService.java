/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.service;

import java.util.List;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.system.model.FkAreaModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IFkAreaService extends IBaseService<FkAreaModel, Long> {

	public boolean datasToXml(FkAreaModel model, List<FkAreaModel> datas);
	
	public boolean saveByXml(List<FkAreaModel> fkAreaModels,FkAreaModel fkAreaModel)throws ServicesException;
}
