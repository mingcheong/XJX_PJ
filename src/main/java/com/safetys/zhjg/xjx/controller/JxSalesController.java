/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.Struts2Utils;
import com.safetys.zhjg.xjx.model.JxSalesModel;
import com.safetys.zhjg.xjx.service.IJxGoodsService;
import com.safetys.zhjg.xjx.service.IJxSalesService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxSalesController")
public class JxSalesController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxSales = "/template/xjx/JxSales_Input.ftl";
	private static final String page_forward_showupdate_jxSales = "/template/xjx/JxSales_Input.ftl";
	private static final String page_forward_showdetail_jxSales = "/template/xjx/JxSales_Detail.ftl";
	private static final String page_forward_tomanagers_jxSales = "/template/xjx/JxSales_Manager.ftl";
	@Resource(name = "jxSalesService")
	private IJxSalesService jxSalesService;
	private JxSalesModel jxSalesModel;
	private List<JxSalesModel> jxSalesModels;
	// 移库明细数据
	private String jsonData;
	/**
	 * 商品代码业务操作类
	 */
	@Resource(name = "jxGoodsService")
	private IJxGoodsService jxGoodsService;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		jxSalesModel.setJsDate(getCuurentDate());
		this.setParameters(page_forward_showinsert_jxSales);
		return SUCCESS;
	}


	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception
	{
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		jxSalesModel = jxSalesService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxSales);
		return SUCCESS;
	}


	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception
	{
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要查看的对象编号不可为空！"); }
		jxSalesModel = jxSalesService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxSales);
		return SUCCESS;
	}


	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception
	{
		JSONObject jo = new JSONObject();
		if (StringUtils.isNotEmpty(jsonData))
		{
			JSONArray array = new JSONArray(jsonData);
			try
			{
				jxSalesService.save(jxSalesModel, array);
				jo.put("msg", "出库成功！");
			}
			catch (Exception e)
			{
				jo.put("error", e.getMessage());
			}
			this.setJxSalesModel(null);
		}
		return Struts2Utils.renderJson(jo.toString());
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxSalesModels = jxSalesService.getCollection(jxSalesModel);
		this.setParameters(page_forward_tomanagers_jxSales);
		return SUCCESS;
	}


	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception
	{
		jxSalesModels = jxSalesService.getCollection(jxSalesModel);
		TableFacade tableFacade = new TableFacade("jxSalesModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jsDept", "jsOcode", "jsNum", "jsLastCode", "jsWarehouse", "jsCustomer", "jsSettlement", "jsUser", "jsDate", "jsRate", "jsDelivery", "jsRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxSalesModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxSalesModel == null)
		{
			jxSalesModel = new JxSalesModel(request, "jxSalesModel");
		}
	}


	/**
	 * @return the jxSalesModel
	 */
	public JxSalesModel getJxSalesModel()
	{
		return jxSalesModel;
	}


	/**
	 * @param jxSalesModel
	 *            the jxSalesModel to set
	 */
	public void setJxSalesModel(JxSalesModel jxSalesModel)
	{
		this.jxSalesModel = jxSalesModel;
	}


	/**
	 * @return the jxSalesModels
	 */
	public List<JxSalesModel> getJxSalesModels()
	{
		return jxSalesModels;
	}


	/**
	 * @param jxSalesModels
	 *            the jxSalesModels to set
	 */
	public void setJxSalesModels(List<JxSalesModel> jxSalesModels)
	{
		this.jxSalesModels = jxSalesModels;
	}


	public void setJsonData(String jsonData)
	{
		this.jsonData = jsonData;
	}
}
