/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.dao.IJxMoveInventoryDao;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.model.JxEmployeeModel;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxMoveInventoryDetailsModel;
import com.safetys.zhjg.xjx.model.JxMoveInventoryModel;
import com.safetys.zhjg.xjx.model.JxUnitModel;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxDeptService;
import com.safetys.zhjg.xjx.service.IJxEmployeeService;
import com.safetys.zhjg.xjx.service.IJxInventoryService;
import com.safetys.zhjg.xjx.service.IJxMoveInventoryDetailsService;
import com.safetys.zhjg.xjx.service.IJxMoveInventoryService;
import com.safetys.zhjg.xjx.service.IJxWarehouseService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxMoveInventoryService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class, RuntimeException.class })
public class JxMoveInventoryServiceImpl extends BaseServiceImpl<JxMoveInventoryModel, Long> implements IJxMoveInventoryService
{

	@Resource(name = "jxMoveInventoryDao")
	protected IJxMoveInventoryDao jxMoveInventoryDao;

	@Resource(name = "jxMoveInventoryDetailsService")
	protected IJxMoveInventoryDetailsService jxMoveInventoryDetailsService;

	/**
	 * 部门业务操作类
	 */
	@Resource(name = "jxDeptService")
	protected IJxDeptService jxDeptService;

	/**
	 * 员工信息业务操作类
	 */
	@Resource(name = "jxEmployeeService")
	protected IJxEmployeeService jxEmployeeService;

	/**
	 * 仓库业务操作类
	 */
	@Resource(name = "jxWarehouseService")
	protected IJxWarehouseService jxWarehouseService;

	/**
	 * 库存进出库业务操作类
	 */
	@Resource(name = "jxInventoryService")
	protected IJxInventoryService jxInventoryService;



	@Autowired
	public JxMoveInventoryServiceImpl(@Qualifier("jxMoveInventoryDao")
	IJxMoveInventoryDao jxMoveInventoryDao)
	{
		super(jxMoveInventoryDao);
	}


	/**
	 * 调入调出库保存
	 */
	public OperateResult save(JxMoveInventoryModel entity, JSONArray jsonDetails) throws Exception
	{

		OperateResult or = null;

		JxDeptModel jmDept = null;
		if (StringUtils.isNotEmpty(entity.getJmDept().getJdCode()))
		{
			jmDept = jxDeptService.findUnique("jdCode", entity.getJmDept().getJdCode());
		}

		JxEmployeeModel jmUser = null;
		if (StringUtils.isNotEmpty(entity.getJmUser().getJeCode()))
		{
			jmUser = jxEmployeeService.findUnique("jeCode", entity.getJmUser().getJeCode());
		}

		JxWarehouseModel jmIwarehouse = null;
		if (StringUtils.isNotEmpty(entity.getJmIwarehouse().getJwCode()))
		{
			jmIwarehouse = jxWarehouseService.findUnique("jwCode", entity.getJmIwarehouse().getJwCode());
		}

		JxWarehouseModel jmOwarehouse = null;
		if (StringUtils.isNotEmpty(entity.getJmOwarehouse().getJwCode()))
		{
			jmOwarehouse = jxWarehouseService.findUnique("jwCode", entity.getJmOwarehouse().getJwCode());
		}

		entity.setJmDept(jmDept);
		entity.setJmUser(jmUser);
		entity.setJmIwarehouse(jmIwarehouse);
		entity.setJmOwarehouse(jmOwarehouse);
		or = super.save(entity);

		if (jsonDetails != null && jsonDetails.length() > 0)
		{
			JxMoveInventoryDetailsModel jmd = null;
			JxGoodsModel goodsModel = null;
			JxUnitModel unitModel = null;
			JSONObject jo = null;
			for (int i = 0; i < jsonDetails.length(); i++)
			{
				jmd = new JxMoveInventoryDetailsModel();
				jo = jsonDetails.getJSONObject(i);
				jmd.setJmdMoveInventory(entity);

				goodsModel = new JxGoodsModel();
				goodsModel.setId(jo.getLong("goodsModel.id"));
				goodsModel.setJgCode(jo.getString("goodsModel.jgCode"));
				goodsModel.setJgIncode(jo.getString("goodsModel.jgIncode"));
				goodsModel.setJgName(jo.getString("goodsModel.jgName"));
				jmd.setGoodsModel(goodsModel);

				unitModel = new JxUnitModel();
				unitModel.setId(jo.getLong("jmdUnit.id"));
				unitModel.setJuName(jo.getString("jmdUnit.juName"));
				jmd.setJmdUnit(unitModel);

				jmd.setJmdQuantity((float) jo.optDouble("jmdQuantity"));
				jmd.setJmdCost((float) jo.optDouble("jmdCost"));
				if (StringUtils.isNotEmpty(jo.getString("jmdAmount")))
					jmd.setJmdAmount((float) jo.optDouble("jmdAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jmdWAmount")))
					jmd.setJmdWamount((float) jo.optDouble("jmdWAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jmdNum")))
					jmd.setJmdNum((float) jo.optDouble("jmdNum"));
				jmd.setJmdOverflow(jo.getString("jmdOverflow"));
				if (StringUtils.isNotEmpty(jo.getString("jmdRate")))
					jmd.setJmdRate((float) jo.optDouble("jmdRate"));

				or = jxMoveInventoryDetailsService.save(jmd);

				// 从调出仓调出商品数量
				or = jxInventoryService.outStore(jmOwarehouse, goodsModel, jmd.getJmdQuantity(), 0f, 0f);
				// 将商品调入所选的仓库
				or = jxInventoryService.inStore(jmIwarehouse, goodsModel, jmd.getJmdQuantity(), 0f, 0f);
			}
		}
		return or;
	}
}
