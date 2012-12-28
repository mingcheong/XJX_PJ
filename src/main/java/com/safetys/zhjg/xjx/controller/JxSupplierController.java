/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.controller;

import java.util.List;

import javax.annotation.Resource;

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
import com.safetys.framework.utils.OperateResult;
import com.safetys.framework.utils.Struts2Utils;
import com.safetys.zhjg.xjx.model.JxSupplierModel;
import com.safetys.zhjg.xjx.service.IJxSupplierService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxSupplierController")
public class JxSupplierController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxSupplier = "/template/xjx/JxSupplier_Input.ftl";
	private static final String page_forward_showupdate_jxSupplier = "/template/xjx/JxSupplier_Input.ftl";
	private static final String page_forward_showdetail_jxSupplier = "/template/xjx/JxSupplier_Detail.ftl";
	private static final String page_forward_tomanagers_jxSupplier = "/template/xjx/JxSupplier_Manager.ftl";
	private static final String action_forward_managers_jxSupplier = "jxSupplier_manager.xhtml";
	@Resource(name = "jxSupplierService")
	private IJxSupplierService jxSupplierService;
	private JxSupplierModel jxSupplierModel;
	private List<JxSupplierModel> jxSupplierModels;



	/**
	 * 以JSON方式返回供应商列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String jsonList() throws Exception
	{
		jxSupplierModels = jxSupplierService.getCollection(jxSupplierModel);
		if (jxSupplierModels == null || jxSupplierModels.isEmpty())
			return null;

		JSONArray jr = new JSONArray();
		JSONObject json = null;
		for (JxSupplierModel supplier : jxSupplierModels)
		{
			json = new JSONObject();
			json.put("id", supplier.getId());
			json.put("code", supplier.getJsCode());
			json.put("name", supplier.getJsName());
			jr.put(json);
		}

		JSONObject jo = new JSONObject();
		jo.put("total", jxSupplierModels.size());
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
		this.setParameters(page_forward_showinsert_jxSupplier);
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
		jxSupplierModel = jxSupplierService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxSupplier);
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
		jxSupplierModel = jxSupplierService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxSupplier);
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
		or = jxSupplierService.save(jxSupplierModel);
		this.setJxSupplierModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxSupplier);
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
		or = jxSupplierService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxSupplier);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxSupplierModels = jxSupplierService.getCollection(jxSupplierModel);
		this.setParameters(page_forward_tomanagers_jxSupplier);
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
		jxSupplierModels = jxSupplierService.getCollection(jxSupplierModel);
		TableFacade tableFacade = new TableFacade("jxSupplierModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jsCode", "jsName", "jsAddr", "jsPost", "jsTele", "jsFullname", "jsBank", "jsAccount", "jsDutyno", "jsContact", "jsPerson", "jsRemark", "jsCanuse", "jsCate", "jsLimit",
				"jsBalance", "jsCreatetime", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxSupplierModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxSupplierModel == null)
		{
			jxSupplierModel = new JxSupplierModel(request, "jxSupplierModel");
		}
	}


	/**
	 * @return the jxSupplierModel
	 */
	public JxSupplierModel getJxSupplierModel()
	{
		return jxSupplierModel;
	}


	/**
	 * @param jxSupplierModel
	 *            the jxSupplierModel to set
	 */
	public void setJxSupplierModel(JxSupplierModel jxSupplierModel)
	{
		this.jxSupplierModel = jxSupplierModel;
	}


	/**
	 * @return the jxSupplierModels
	 */
	public List<JxSupplierModel> getJxSupplierModels()
	{
		return jxSupplierModels;
	}


	/**
	 * @param jxSupplierModels
	 *            the jxSupplierModels to set
	 */
	public void setJxSupplierModels(List<JxSupplierModel> jxSupplierModels)
	{
		this.jxSupplierModels = jxSupplierModels;
	}
}
