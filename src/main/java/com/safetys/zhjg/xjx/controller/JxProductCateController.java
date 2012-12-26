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
import com.safetys.zhjg.xjx.model.JxProductCateModel;
import com.safetys.zhjg.xjx.service.IJxProductCateService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxProductCateController")
public class JxProductCateController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxProductCate = "/template/xjx/JxProductCate_Input.ftl";
	private static final String page_forward_showupdate_jxProductCate = "/template/xjx/JxProductCate_Input.ftl";
	private static final String page_forward_showdetail_jxProductCate = "/template/xjx/JxProductCate_Detail.ftl";
	private static final String page_forward_tomanagers_jxProductCate = "/template/xjx/JxProductCate_Manager.ftl";
	private static final String action_forward_managers_jxProductCate = "jxProductCate_manager.xhtml";
	@Resource(name = "jxProductCateService")
	private IJxProductCateService jxProductCateService;
	private JxProductCateModel jxProductCateModel;
	private List<JxProductCateModel> jxProductCateModels;



	/**
	 * 以JSON方式返回产品分类列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String jsonList() throws Exception
	{
		jxProductCateModels = jxProductCateService.getCollection(jxProductCateModel);
		if (jxProductCateModels == null || jxProductCateModels.isEmpty())
			return null;

		JSONArray jr = new JSONArray();
		JSONObject json = null;
		for (JxProductCateModel productCate : jxProductCateModels)
		{
			json = new JSONObject();
			json.put("id", productCate.getId());
			json.put("code", productCate.getJpcCode());
			json.put("name", productCate.getJpcName());
			json.put("canUse", productCate.getJpcUse() ? "是" : "否");
			jr.put(json);
		}

		JSONObject jo = new JSONObject();
		jo.put("total", jxProductCateModels.size());
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
		jxProductCateModel.setJpcUse(true);
		this.setParameters(page_forward_showinsert_jxProductCate);
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
		jxProductCateModel = jxProductCateService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxProductCate);
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
		jxProductCateModel = jxProductCateService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxProductCate);
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
		or = jxProductCateService.save(jxProductCateModel);
		this.setJxProductCateModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxProductCate);
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
		or = jxProductCateService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxProductCate);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxProductCateModels = jxProductCateService.getCollection(jxProductCateModel);
		this.setParameters(page_forward_tomanagers_jxProductCate);
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
		jxProductCateModels = jxProductCateService.getCollection(jxProductCateModel);
		TableFacade tableFacade = new TableFacade("jxProductCateModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jpcCode", "jpcName", "jpcUse", "jpcMemo", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxProductCateModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxProductCateModel == null)
		{
			jxProductCateModel = new JxProductCateModel(request, "jxProductCateModel");
		}
	}


	/**
	 * @return the jxProductCateModel
	 */
	public JxProductCateModel getJxProductCateModel()
	{
		return jxProductCateModel;
	}


	/**
	 * @param jxProductCateModel
	 *            the jxProductCateModel to set
	 */
	public void setJxProductCateModel(JxProductCateModel jxProductCateModel)
	{
		this.jxProductCateModel = jxProductCateModel;
	}


	/**
	 * @return the jxProductCateModels
	 */
	public List<JxProductCateModel> getJxProductCateModels()
	{
		return jxProductCateModels;
	}


	/**
	 * @param jxProductCateModels
	 *            the jxProductCateModels to set
	 */
	public void setJxProductCateModels(List<JxProductCateModel> jxProductCateModels)
	{
		this.jxProductCateModels = jxProductCateModels;
	}
}
