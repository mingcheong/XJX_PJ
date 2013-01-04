/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service;

import org.json.JSONArray;

import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.model.JxInInventoryModel;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IJxInInventoryService extends IBaseService<JxInInventoryModel, Long>
{

	public OperateResult save(JxInInventoryModel entity, JSONArray jsonDetails) throws Exception;
}
