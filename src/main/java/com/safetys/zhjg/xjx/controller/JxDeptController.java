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
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.framework.utils.Struts2Utils;
import com.safetys.zhjg.xjx.model.JxDeptModel;
import com.safetys.zhjg.xjx.model.JxSettlementTypeModel;
import com.safetys.zhjg.xjx.service.IJxDeptService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxDeptController")
public class JxDeptController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxDept = "/template/xjx/JxDept_Input.ftl";
	private static final String page_forward_showupdate_jxDept = "/template/xjx/JxDept_Input.ftl";
	private static final String page_forward_showdetail_jxDept = "/template/xjx/JxDept_Detail.ftl";
	private static final String page_forward_tomanagers_jxDept = "/template/xjx/JxDept_Manager.ftl";
	private static final String action_forward_managers_jxDept = "jxDept_manager.xhtml";
	@Resource(name = "jxDeptService")
	private IJxDeptService jxDeptService;
	private JxDeptModel jxDeptModel;
	private List<JxDeptModel> jxDeptModels;



	/**
	 * 通过AJAX取下级菜单
	 * 
	 * @throws ActionException
	 */
	public String ajax() throws Exception
	{
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("对象编号不可为空或小于零！"); }
		jxDeptModel.setJdParent(this.getId().intValue());
		jxDeptModels = jxDeptService.getCollection(jxDeptModel, false);
		if (jxDeptModels != null && jxDeptModels.size() > 0)
		{
			for (JxDeptModel element : jxDeptModels)
			{
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getJdParent().longValue());
				treeModel.setName(element.getJdName());
				treeModels.add(treeModel);
			}
			jxDeptModels.clear();
		}
		this.response.getWriter().print(gson.toJson(treeModels));
		this.response.getWriter().close();
		return NONE;
	}


	/**
	 * 以JSON方式返回部门列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String jsonList() throws Exception
	{
		jxDeptModels = jxDeptService.getCollection(jxDeptModel);
		if (jxDeptModels == null || jxDeptModels.isEmpty())
			return null;

		JSONArray jr = new JSONArray();
		JSONObject json = null;
		for (JxDeptModel dept : jxDeptModels)
		{
			json = new JSONObject();
			json.put("code", dept.getJdCode());
			json.put("name", dept.getJdName());
			jr.put(json);
		}

		JSONObject jo = new JSONObject();
		jo.put("total", jxDeptModels.size());
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
		jxDeptModel.setJdParent(0);
		jxDeptModel.setJdCanuse(true);
		jxDeptModels = jxDeptService.getCollection(jxDeptModel, false);
		if (jxDeptModels != null && jxDeptModels.size() > 0)
		{
			for (JxDeptModel element : jxDeptModels)
			{
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getJdParent().longValue());
				treeModel.setName(element.getJdName());
				treeModels.add(treeModel);
			}
			jxDeptModels.clear();
		}
		request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showinsert_jxDept);
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

		jxDeptModel.setJdParent(0);
		jxDeptModel.setJdCanuse(true);
		jxDeptModels = jxDeptService.getCollection(jxDeptModel, false);
		if (jxDeptModels != null && jxDeptModels.size() > 0)
		{
			for (JxDeptModel element : jxDeptModels)
			{
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getJdParent().longValue());
				treeModel.setName(element.getJdName());
				treeModels.add(treeModel);
			}
			jxDeptModels.clear();
		}
		jxDeptModel = jxDeptService.findById(this.getId());
		if (jxDeptModel.getJdParent() > 0)
		{
			request.setAttribute("fatherName", jxDeptService.findById(jxDeptModel.getJdParent().longValue()).getJdName());
		}
		request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showupdate_jxDept);
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
		jxDeptModel = jxDeptService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxDept);
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
		or = jxDeptService.save(jxDeptModel);
		this.setJxDeptModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxDept);
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
		or = jxDeptService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxDept);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxDeptModels = jxDeptService.getCollection(jxDeptModel);
		this.setParameters(page_forward_tomanagers_jxDept);
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
		jxDeptModels = jxDeptService.getCollection(jxDeptModel);
		TableFacade tableFacade = new TableFacade("jxDeptModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jdCode", "jdName", "jdParent", "jdCanuse", "jdRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxDeptModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxDeptModel == null)
		{
			jxDeptModel = new JxDeptModel(request, "jxDeptModel");
		}
	}


	/**
	 * @return the jxDeptModel
	 */
	public JxDeptModel getJxDeptModel()
	{
		return jxDeptModel;
	}


	/**
	 * @param jxDeptModel
	 *            the jxDeptModel to set
	 */
	public void setJxDeptModel(JxDeptModel jxDeptModel)
	{
		this.jxDeptModel = jxDeptModel;
	}


	/**
	 * @return the jxDeptModels
	 */
	public List<JxDeptModel> getJxDeptModels()
	{
		return jxDeptModels;
	}


	/**
	 * @param jxDeptModels
	 *            the jxDeptModels to set
	 */
	public void setJxDeptModels(List<JxDeptModel> jxDeptModels)
	{
		this.jxDeptModels = jxDeptModels;
	}
}
