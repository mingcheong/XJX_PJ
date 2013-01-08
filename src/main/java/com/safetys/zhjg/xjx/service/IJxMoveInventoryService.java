/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service;

import org.json.JSONArray;

import com.safetys.zhjg.xjx.model.JxMoveInventoryModel;
import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.utils.OperateResult;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
public interface IJxMoveInventoryService extends IBaseService<JxMoveInventoryModel, Long>
{

	/**
	 * 调入调出库保存
	 */
	public OperateResult save(JxMoveInventoryModel entity, JSONArray jsonDetails) throws Exception;
}
