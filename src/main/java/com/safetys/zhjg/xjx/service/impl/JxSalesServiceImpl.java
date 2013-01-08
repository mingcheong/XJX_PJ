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

import com.safetys.zhjg.xjx.dao.IJxSalesDao;
import com.safetys.zhjg.xjx.model.JxCustomerModel;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.model.JxEmployeeModel;
import com.safetys.zhjg.xjx.model.JxGoodsModel;
import com.safetys.zhjg.xjx.model.JxSalesDetailsModel;
import com.safetys.zhjg.xjx.model.JxSalesModel;
import com.safetys.zhjg.xjx.model.JxSettlementTypeModel;
import com.safetys.zhjg.xjx.model.JxUnitModel;
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxCustomerService;
import com.safetys.zhjg.xjx.service.IJxDeptService;
import com.safetys.zhjg.xjx.service.IJxEmployeeService;
import com.safetys.zhjg.xjx.service.IJxInventoryService;
import com.safetys.zhjg.xjx.service.IJxSalesDetailsService;
import com.safetys.zhjg.xjx.service.IJxSalesService;
import com.safetys.zhjg.xjx.service.IJxSettlementTypeService;
import com.safetys.zhjg.xjx.service.IJxWarehouseService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("jxSalesService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class, RuntimeException.class })
public class JxSalesServiceImpl extends BaseServiceImpl<JxSalesModel, Long> implements IJxSalesService
{

	@Resource(name = "jxSalesDao")
	protected IJxSalesDao jxSalesDao;

	/**
	 * 客户代码业务操作类
	 */
	@Resource(name = "jxCustomerService")
	protected IJxCustomerService jxCustomerService;

	/**
	 * 付款类型业务操作类
	 */
	@Resource(name = "jxSettlementTypeService")
	protected IJxSettlementTypeService jxSettlementTypeService;

	/**
	 * 员工信息业务操作类
	 */
	@Resource(name = "jxEmployeeService")
	protected IJxEmployeeService jxEmployeeService;

	/**
	 * 部门业务操作类
	 */
	@Resource(name = "jxDeptService")
	protected IJxDeptService jxDeptService;

	@Resource(name = "jxWarehouseService")
	private IJxWarehouseService jxWarehouseService;

	@Resource(name = "jxSalesDetailsService")
	protected IJxSalesDetailsService jxSalesDetailsService;

	/**
	 * 库存进出库业务操作类
	 */
	@Resource(name = "jxInventoryService")
	protected IJxInventoryService jxInventoryService;



	@Autowired
	public JxSalesServiceImpl(@Qualifier("jxSalesDao")
	IJxSalesDao jxSalesDao)
	{
		super(jxSalesDao);
	}


	/**
	 * 批发销售保存
	 */
	public OperateResult save(JxSalesModel entity, JSONArray jsonDetails) throws Exception
	{

		OperateResult or = null;

		JxDeptModel jsDept = null;
		if (StringUtils.isNotEmpty(entity.getJsDept().getJdCode()))
		{
			jsDept = jxDeptService.findUnique("jdCode", entity.getJsDept().getJdCode());
		}

		JxSettlementTypeModel settlementType = null;
		if (StringUtils.isNotEmpty(entity.getJsSettlement().getJsCode()))
		{
			settlementType = jxSettlementTypeService.findUnique("jsCode", entity.getJsSettlement().getJsCode());
		}

		JxCustomerModel customer = null;
		if (StringUtils.isNotEmpty(entity.getJsCustomer().getJcCode()))
		{
			customer = jxCustomerService.findUnique("jcCode", entity.getJsCustomer().getJcCode());
		}

		JxEmployeeModel employee = null;
		if (StringUtils.isNotEmpty(entity.getJsUser().getJeCode()))
		{
			employee = jxEmployeeService.findUnique("jeCode", entity.getJsUser().getJeCode());
		}

		JxWarehouseModel warehouseModel = null;
		if (StringUtils.isNotEmpty(entity.getJsWarehouse().getJwCode()))
		{
			warehouseModel = jxWarehouseService.findUnique("jwCode", entity.getJsWarehouse().getJwCode());
		}

		entity.setJsDept(jsDept);
		entity.setJsSettlement(settlementType);
		entity.setJsCustomer(customer);
		entity.setJsUser(employee);
		entity.setJsWarehouse(warehouseModel);
		or = super.save(entity);

		if (jsonDetails != null && jsonDetails.length() > 0)
		{
			JxSalesDetailsModel jsd = null;
			JxGoodsModel goodsModel = null;
			JxUnitModel unitModel = null;
			JSONObject jo = null;
			for (int i = 0; i < jsonDetails.length(); i++)
			{
				jsd = new JxSalesDetailsModel();
				jo = jsonDetails.getJSONObject(i);
				jsd.setJsdSales(entity);

				goodsModel = new JxGoodsModel();
				goodsModel.setId(jo.getLong("goodsModel.id"));
				goodsModel.setJgCode(jo.getString("goodsModel.jgCode"));
				goodsModel.setJgIncode(jo.getString("goodsModel.jgIncode"));
				goodsModel.setJgName(jo.getString("goodsModel.jgName"));
				jsd.setGoodsModel(goodsModel);

				unitModel = new JxUnitModel();
				unitModel.setId(jo.getLong("jsdUnit.id"));
				unitModel.setJuName(jo.getString("jsdUnit.juName"));
				jsd.setJsdUnit(unitModel);

				jsd.setJsdQuantity((float) jo.optDouble("jsdQuantity"));
				jsd.setJsdCost((float) jo.optDouble("jsdCost"));
				if (StringUtils.isNotEmpty(jo.getString("jsdAmount")))
					jsd.setJsdAmount((float) jo.optDouble("jsdAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jsdWAmount")))
					jsd.setJsdWamount((float) jo.optDouble("jsdWAmount"));
				if (StringUtils.isNotEmpty(jo.getString("jsdNum")))
					jsd.setJsdNum((float) jo.optDouble("jsdNum"));
				jsd.setJsdOverflow(jo.getString("jsdOverflow"));
				if (StringUtils.isNotEmpty(jo.getString("jsdRate")))
					jsd.setJsdRate((float) jo.optDouble("jsdRate"));

				or = jxSalesDetailsService.save(jsd);

				// 从批发销售库存数量
				or = jxInventoryService.outStore(warehouseModel, goodsModel, jsd.getJsdQuantity(), 0f, 0f);
			}
		}
		return or;
	}
}
