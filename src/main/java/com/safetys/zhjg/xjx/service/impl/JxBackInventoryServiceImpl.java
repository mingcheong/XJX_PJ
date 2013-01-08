/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.service.impl;

import javax.annotation.Resource;

import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.utils.OperateResult;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.xjx.dao.IJxBackInventoryDao;
import com.safetys.zhjg.xjx.model.JxBackInventoryDetailsModel;
import com.safetys.zhjg.xjx.model.JxBackInventoryModel;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.model.JxEmployeeModel;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxSupplierModel;
import com.safetys.zhjg.xjx.model.JxUnitModel;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxBackInventoryDetailsService;
import com.safetys.zhjg.xjx.service.IJxBackInventoryService;
import com.safetys.zhjg.xjx.service.IJxDeptService;
import com.safetys.zhjg.xjx.service.IJxEmployeeService;
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
@Service("jxBackInventoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class JxBackInventoryServiceImpl extends BaseServiceImpl<JxBackInventoryModel, Long> implements IJxBackInventoryService
{

	@Resource(name = "jxBackInventoryDao")
	protected IJxBackInventoryDao jxBackInventoryDao;



	@Autowired
	public JxBackInventoryServiceImpl(@Qualifier("jxBackInventoryDao")
	IJxBackInventoryDao jxBackInventoryDao)
	{
		super(jxBackInventoryDao);
	}



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

	@Resource(name = "jxBackInventoryDetailsService")
	protected IJxBackInventoryDetailsService jxBackInventoryDetailsService;



	/**
	 * 退货入库保存
	 */
	public OperateResult save(JxBackInventoryModel entity, JSONArray jsonDetails) throws Exception
	{

		OperateResult or = null;

		JxDeptModel jbDept = null;
		if (StringUtils.isNotEmpty(entity.getJbDept().getJdCode()))
		{
			jbDept = jxDeptService.findUnique("jdCode", entity.getJbDept().getJdCode());
		}

		JxEmployeeModel jbCheckuser = null;
		if (StringUtils.isNotEmpty(entity.getJbCheckuser().getJeCode()))
		{
			jbCheckuser = jxEmployeeService.findUnique("jeCode", entity.getJbCheckuser().getJeCode());
		}

		JxEmployeeModel jbUser = null;
		if (StringUtils.isNotEmpty(entity.getJbUser().getJeCode()))
		{
			jbUser = jxEmployeeService.findUnique("jeCode", entity.getJbUser().getJeCode());
		}

		JxSupplierModel jbSupplier = null;
		if (StringUtils.isNotEmpty(entity.getJbSupplier().getJsCode()))
		{
			jbSupplier = jxSupplierService.findUnique("jsCode", entity.getJbSupplier().getJsCode());
		}

		JxWarehouseModel jbWarehouse = null;
		if (StringUtils.isNotEmpty(entity.getJbWarehouse().getJwCode()))
		{
			jbWarehouse = jxWarehouseService.findUnique("jwCode", entity.getJbWarehouse().getJwCode());
		}

		entity.setJbDept(jbDept);
		entity.setJbCheckuser(jbCheckuser);
		entity.setJbUser(jbUser);
		entity.setJbSupplier(jbSupplier);
		entity.setJbWarehouse(jbWarehouse);
		or = super.save(entity);

		if (jsonDetails != null && jsonDetails.length() > 0)
		{
			JxBackInventoryDetailsModel jbdm = null;
			JxGoodsModel goodsModel = null;
			JxUnitModel unitModel = null;
			JSONObject jo = null;
			for (int i = 0; i < jsonDetails.length(); i++)
			{
				jbdm = new JxBackInventoryDetailsModel();
				jo = jsonDetails.getJSONObject(i);
				jbdm.setJbdBackInventory(entity);

				goodsModel = new JxGoodsModel();
				goodsModel.setId(jo.getLong("goodsModel.id"));
				goodsModel.setJgCode(jo.getString("goodsModel.jgCode"));
				goodsModel.setJgIncode(jo.getString("goodsModel.jgIncode"));
				goodsModel.setJgName(jo.getString("goodsModel.jgName"));
				jbdm.setGoodsModel(goodsModel);

				unitModel = new JxUnitModel();
				unitModel.setId(jo.getLong("jbdUnit.id"));
				unitModel.setJuName(jo.getString("jbdUnit.juName"));
				jbdm.setJbdUnit(unitModel);

				jbdm.setJbdQuantity((float) jo.optDouble("jbdQuantity"));
				jbdm.setJbdCost((float) jo.optDouble("jbdCost"));
				if (StringUtils.isNotEmpty(jo.getString("jbdAmount")))
					jbdm.setJbdAmount((float) jo.optDouble("jbdAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jbdWAmount")))
					jbdm.setJbdWAmount((float) jo.optDouble("jbdWAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jbdNum")))
					jbdm.setJbdNum((float) jo.optDouble("jbdNum"));
				jbdm.setJbdOverflow(jo.getString("jbdOverflow"));
				if (StringUtils.isNotEmpty(jo.getString("jbdRate")))
					jbdm.setJbdRate((float) jo.optDouble("jbdRate"));

				or = jxBackInventoryDetailsService.save(jbdm);
				if (StringUtils.isNotEmpty(entity.getJbCodemark()))
				{
					or = jxInventoryService.inStore(jbWarehouse, goodsModel, 0f, 0f, jbdm.getJbdQuantity());
				}
				else
				{
					or = jxInventoryService.inStore(jbWarehouse, goodsModel, jbdm.getJbdQuantity(), 0f, 0f);
				}
			}
		}
		return or;
	}
}
