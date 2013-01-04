/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.model.JxInInventoryModel;
import com.safetys.zhjg.xjx.service.IJxInInventoryService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxInInventoryController")
public class JxInInventoryController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxInInventory = "/template/xjx/JxInInventory_Input.ftl";
	private static final String page_forward_showupdate_jxInInventory = "/template/xjx/JxInInventory_Input.ftl";
	private static final String page_forward_showdetail_jxInInventory = "/template/xjx/JxInInventory_Detail.ftl";
	private static final String page_forward_tomanagers_jxInInventory = "/template/xjx/JxInInventory_Manager.ftl";
	private static final String action_forward_insert_jxInInventory = "jxInInventory_insert.xhtml";
	@Resource(name = "jxInInventoryService")
	private IJxInInventoryService jxInInventoryService;
	private JxInInventoryModel jxInInventoryModel;
	private List<JxInInventoryModel> jxInInventoryModels;

	// 进货明细数据
	private String jsonData;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		jxInInventoryModel.setJiDate(this.getCuurentDate());
		this.setParameters(page_forward_showinsert_jxInInventory);
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
		jxInInventoryModel = jxInInventoryService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxInInventory);
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
		jxInInventoryModel = jxInInventoryService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxInInventory);
		return SUCCESS;
	}


	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception
	{
		OperateResult or = null;
		if (StringUtils.isNotEmpty(jsonData))
		{
			JSONArray array = new JSONArray(jsonData);
			or = jxInInventoryService.save(jxInInventoryModel, array);
			this.setJxInInventoryModel(null);
			this.setParameters(or.getMessage(), action_forward_insert_jxInInventory);
		}
		return SUCCESS;
	}



	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxInInventoryModels = jxInInventoryService.getCollection(jxInInventoryModel);
		this.setParameters(page_forward_tomanagers_jxInInventory);
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
		jxInInventoryModels = jxInInventoryService.getCollection(jxInInventoryModel);
		TableFacade tableFacade = new TableFacade("jxInInventoryModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jiCode", "jiLastCode", "jiOcode", "jiCodemark", "jiDept", "jiSupplier", "jiUser", "jiDate", "jiCheckuser", "jiWarehouse", "jiRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxInInventoryModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxInInventoryModel == null)
		{
			jxInInventoryModel = new JxInInventoryModel(request, "jxInInventoryModel");
		}
	}


	/**
	 * @return the jxInInventoryModel
	 */
	public JxInInventoryModel getJxInInventoryModel()
	{
		return jxInInventoryModel;
	}


	/**
	 * @param jxInInventoryModel
	 *            the jxInInventoryModel to set
	 */
	public void setJxInInventoryModel(JxInInventoryModel jxInInventoryModel)
	{
		this.jxInInventoryModel = jxInInventoryModel;
	}


	/**
	 * @return the jxInInventoryModels
	 */
	public List<JxInInventoryModel> getJxInInventoryModels()
	{
		return jxInInventoryModels;
	}


	/**
	 * @param jxInInventoryModels
	 *            the jxInInventoryModels to set
	 */
	public void setJxInInventoryModels(List<JxInInventoryModel> jxInInventoryModels)
	{
		this.jxInInventoryModels = jxInInventoryModels;
	}


	public void setJsonData(String jsonData)
	{
		this.jsonData = jsonData;
	}
}
