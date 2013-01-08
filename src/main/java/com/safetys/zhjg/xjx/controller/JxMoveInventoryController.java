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
import com.safetys.zhjg.xjx.model.JxMoveInventoryModel;
import com.safetys.zhjg.xjx.service.IJxMoveInventoryService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxMoveInventoryController")
public class JxMoveInventoryController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxMoveInventory = "/template/xjx/JxMoveInventory_Input.ftl";
	private static final String page_forward_showupdate_jxMoveInventory = "/template/xjx/JxMoveInventory_Input.ftl";
	private static final String page_forward_showdetail_jxMoveInventory = "/template/xjx/JxMoveInventory_Detail.ftl";
	private static final String page_forward_tomanagers_jxMoveInventory = "/template/xjx/JxMoveInventory_Manager.ftl";

	@Resource(name = "jxMoveInventoryService")
	private IJxMoveInventoryService jxMoveInventoryService;
	private JxMoveInventoryModel jxMoveInventoryModel;
	private List<JxMoveInventoryModel> jxMoveInventoryModels;

	// 移库明细数据
	private String jsonData;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		jxMoveInventoryModel.setJmDate(getCuurentDate());
		this.setParameters(page_forward_showinsert_jxMoveInventory);
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
		jxMoveInventoryModel = jxMoveInventoryService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxMoveInventory);
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
		jxMoveInventoryModel = jxMoveInventoryService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxMoveInventory);
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
				jxMoveInventoryService.save(jxMoveInventoryModel, array);
				jo.put("msg", "调库成功！");
			}
			catch (Exception e)
			{
				jo.put("error", e.getMessage());
			}
			this.setJxMoveInventoryModel(null);
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
		jxMoveInventoryModels = jxMoveInventoryService.getCollection(jxMoveInventoryModel);
		this.setParameters(page_forward_tomanagers_jxMoveInventory);
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
		jxMoveInventoryModels = jxMoveInventoryService.getCollection(jxMoveInventoryModel);
		TableFacade tableFacade = new TableFacade("jxMoveInventoryModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jmLastCode", "jmOcode", "jmNum", "jmDept", "jmIwarehouse", "jmOwarehouse", "jmUser", "jmDate", "jmRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxMoveInventoryModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxMoveInventoryModel == null)
		{
			jxMoveInventoryModel = new JxMoveInventoryModel(request, "jxMoveInventoryModel");
		}
	}


	/**
	 * @return the jxMoveInventoryModel
	 */
	public JxMoveInventoryModel getJxMoveInventoryModel()
	{
		return jxMoveInventoryModel;
	}


	/**
	 * @param jxMoveInventoryModel
	 *            the jxMoveInventoryModel to set
	 */
	public void setJxMoveInventoryModel(JxMoveInventoryModel jxMoveInventoryModel)
	{
		this.jxMoveInventoryModel = jxMoveInventoryModel;
	}


	/**
	 * @return the jxMoveInventoryModels
	 */
	public List<JxMoveInventoryModel> getJxMoveInventoryModels()
	{
		return jxMoveInventoryModels;
	}


	/**
	 * @param jxMoveInventoryModels
	 *            the jxMoveInventoryModels to set
	 */
	public void setJxMoveInventoryModels(List<JxMoveInventoryModel> jxMoveInventoryModels)
	{
		this.jxMoveInventoryModels = jxMoveInventoryModels;
	}


	public void setJsonData(String jsonData)
	{
		this.jsonData = jsonData;
	}
}
