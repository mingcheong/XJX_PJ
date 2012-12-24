/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.controller;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.framework.utils.Struts2Utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.safetys.zhjg.xjx.model.JxSettlementTypeModel;
import com.safetys.zhjg.xjx.model.JxUnitModel;
import com.safetys.zhjg.xjx.service.IJxUnitService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxUnitController")
public class JxUnitController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxUnit = "/template/xjx/JxUnit_Input.ftl";
	private static final String page_forward_showupdate_jxUnit = "/template/xjx/JxUnit_Input.ftl";
	private static final String page_forward_showdetail_jxUnit = "/template/xjx/JxUnit_Detail.ftl";
	private static final String page_forward_tomanagers_jxUnit = "/template/xjx/JxUnit_Manager.ftl";
	private static final String action_forward_managers_jxUnit = "jxUnit_manager.xhtml";
	@Resource(name = "jxUnitService")
	private IJxUnitService jxUnitService;
	private JxUnitModel jxUnitModel;
	private List<JxUnitModel> jxUnitModels;



	/**
	 * 以JSON方式返回包装单位列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String jsonList() throws Exception
	{
		jxUnitModels = jxUnitService.getCollection(jxUnitModel);
		if (jxUnitModels == null || jxUnitModels.isEmpty())
			return null;

		JSONArray jr = new JSONArray();
		JSONObject json = null;
		for (JxUnitModel unit : jxUnitModels)
		{
			json = new JSONObject();
			json.put("code", unit.getJuCode());
			json.put("name", unit.getJuName());
			jr.put(json);
		}

		JSONObject jo = new JSONObject();
		jo.put("total", jxUnitModels.size());
		jo.put("rows", jr);
		return Struts2Utils.renderJson(jo.toString());
	}


	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxUnit);
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
		jxUnitModel = jxUnitService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxUnit);
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
		jxUnitModel = jxUnitService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxUnit);
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
		or = jxUnitService.save(jxUnitModel);
		this.setJxUnitModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxUnit);
		return SUCCESS;
	}


	/**
	 * 删除数据
	 * 
	 * @throws ActionException
	 */
	public String remove() throws Exception
	{
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) { throw new ActionException("将要删除的对象编号不可为空！"); }
		or = jxUnitService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxUnit);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxUnitModels = jxUnitService.getCollection(jxUnitModel);
		this.setParameters(page_forward_tomanagers_jxUnit);
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
		jxUnitModels = jxUnitService.getCollection(jxUnitModel);
		TableFacade tableFacade = new TableFacade("jxUnitModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "juCode", "juName", "juMemo", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxUnitModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxUnitModel == null)
		{
			jxUnitModel = new JxUnitModel(request, "jxUnitModel");
		}
	}


	/**
	 * @return the jxUnitModel
	 */
	public JxUnitModel getJxUnitModel()
	{
		return jxUnitModel;
	}


	/**
	 * @param jxUnitModel
	 *            the jxUnitModel to set
	 */
	public void setJxUnitModel(JxUnitModel jxUnitModel)
	{
		this.jxUnitModel = jxUnitModel;
	}


	/**
	 * @return the jxUnitModels
	 */
	public List<JxUnitModel> getJxUnitModels()
	{
		return jxUnitModels;
	}


	/**
	 * @param jxUnitModels
	 *            the jxUnitModels to set
	 */
	public void setJxUnitModels(List<JxUnitModel> jxUnitModels)
	{
		this.jxUnitModels = jxUnitModels;
	}
}
