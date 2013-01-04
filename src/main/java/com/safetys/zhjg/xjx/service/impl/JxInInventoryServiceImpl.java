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
import com.safetys.zhjg.xjx.dao.IJxInInventoryDao;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.model.JxEmployeeModel;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxInInventoryDetailsModel;
import com.safetys.zhjg.xjx.model.JxInInventoryModel;
import com.safetys.zhjg.xjx.model.JxSupplierModel;
import com.safetys.zhjg.xjx.model.JxUnitModel;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxDeptService;
import com.safetys.zhjg.xjx.service.IJxEmployeeService;
import com.safetys.zhjg.xjx.service.IJxInInventoryDetailsService;
import com.safetys.zhjg.xjx.service.IJxInInventoryService;
import com.safetys.zhjg.xjx.service.IJxInventoryService;
import com.safetys.zhjg.xjx.service.IJxSupplierService;
import com.safetys.zhjg.xjx.service.IJxWarehouseService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxInInventoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxInInventoryServiceImpl extends BaseServiceImpl<JxInInventoryModel, Long> implements IJxInInventoryService
{

	@Resource(name = "jxInInventoryDao")
	protected IJxInInventoryDao jxInInventoryDao;

	@Resource(name = "jxInInventoryDetailsService")
	protected IJxInInventoryDetailsService jxInInventoryDetailsService;

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
	 * 供应商业务操作类
	 */
	@Resource(name = "jxSupplierService")
	protected IJxSupplierService jxSupplierService;

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
	public JxInInventoryServiceImpl(@Qualifier("jxInInventoryDao")
	IJxInInventoryDao jxInInventoryDao)
	{
		super(jxInInventoryDao);
	}


	/**
	 * 进货入库保存
	 */
	public OperateResult save(JxInInventoryModel entity, JSONArray jsonDetails) throws Exception
	{

		OperateResult or = null;

		JxDeptModel jiDept = null;
		if (StringUtils.isNotEmpty(entity.getJiDept().getJdCode()))
		{
			jiDept = jxDeptService.findUnique("jdCode", entity.getJiDept().getJdCode());
		}

		JxEmployeeModel jiCheckuser = null;
		if (StringUtils.isNotEmpty(entity.getJiCheckuser().getJeCode()))
		{
			jiCheckuser = jxEmployeeService.findUnique("jeCode", entity.getJiCheckuser().getJeCode());
		}

		JxEmployeeModel jiUser = null;
		if (StringUtils.isNotEmpty(entity.getJiUser().getJeCode()))
		{
			jiUser = jxEmployeeService.findUnique("jeCode", entity.getJiUser().getJeCode());
		}

		JxSupplierModel jiSupplier = null;
		if (StringUtils.isNotEmpty(entity.getJiSupplier().getJsCode()))
		{
			jiSupplier = jxSupplierService.findUnique("jsCode", entity.getJiSupplier().getJsCode());
		}

		JxWarehouseModel jiWarehouse = null;
		if (StringUtils.isNotEmpty(entity.getJiWarehouse().getJwCode()))
		{
			jiWarehouse = jxWarehouseService.findUnique("jwCode", entity.getJiWarehouse().getJwCode());
		}

		entity.setJiDept(jiDept);
		entity.setJiCheckuser(jiCheckuser);
		entity.setJiUser(jiUser);
		entity.setJiSupplier(jiSupplier);
		entity.setJiWarehouse(jiWarehouse);
		or = super.save(entity);

		if (jsonDetails != null && jsonDetails.length() > 0)
		{
			JxInInventoryDetailsModel jdm = null;
			JxGoodsModel goodsModel = null;
			JxUnitModel unitModel = null;
			JSONObject jo = null;
			for (int i = 0; i < jsonDetails.length(); i++)
			{
				jdm = new JxInInventoryDetailsModel();
				jo = jsonDetails.getJSONObject(i);
				jdm.setJidInInventory(entity);

				goodsModel = new JxGoodsModel();
				goodsModel.setId(jo.getLong("goodsModel.id"));
				goodsModel.setJgCode(jo.getString("goodsModel.jgCode"));
				goodsModel.setJgIncode(jo.getString("goodsModel.jgIncode"));
				goodsModel.setJgName(jo.getString("goodsModel.jgName"));
				jdm.setGoodsModel(goodsModel);

				unitModel = new JxUnitModel();
				unitModel.setId(jo.getLong("jidUnit.id"));
				unitModel.setJuName(jo.getString("jidUnit.juName"));
				jdm.setJidUnit(unitModel);

				jdm.setJidQuantity((float) jo.optDouble("jidQuantity"));
				jdm.setJidCost((float) jo.optDouble("jidCost"));
				if (StringUtils.isNotEmpty(jo.getString("jidAmount")))
					jdm.setJidAmount((float) jo.optDouble("jidAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jidWAmount")))
					jdm.setJidWAmount((float) jo.optDouble("jidWAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jidNum")))
					jdm.setJidNum((float) jo.optDouble("jidNum"));
				jdm.setJidOverflow(jo.getString("jidOverflow"));
				if (StringUtils.isNotEmpty(jo.getString("jidRate")))
					jdm.setJidRate((float) jo.optDouble("jidRate"));

				or = jxInInventoryDetailsService.save(jdm);
				if (StringUtils.isNotEmpty(entity.getJiCodemark()))
				{
					or = jxInventoryService.save(jiWarehouse, goodsModel, 0f, 0f, jdm.getJidQuantity());
				}
				else
				{
					or = jxInventoryService.save(jiWarehouse, goodsModel, jdm.getJidQuantity(), 0f, 0f);
				}
			}
		}
		return or;
	}
}
