/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service;

import org.json.JSONArray;

import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.model.JxBackInventoryModel;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IJxBackInventoryService extends IBaseService<JxBackInventoryModel, Long>
{

	public OperateResult save(JxBackInventoryModel entity, JSONArray jsonDetails) throws Exception;
}
