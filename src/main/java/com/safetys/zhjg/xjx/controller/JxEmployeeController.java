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
import com.safetys.zhjg.xjx.model.JxEmployeeModel;
import com.safetys.zhjg.xjx.service.IJxDeptService;
import com.safetys.zhjg.xjx.service.IJxEmployeeService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxEmployeeController")
public class JxEmployeeController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxEmployee = "/template/xjx/JxEmployee_Input.ftl";
	private static final String page_forward_showupdate_jxEmployee = "/template/xjx/JxEmployee_Input.ftl";
	private static final String page_forward_showdetail_jxEmployee = "/template/xjx/JxEmployee_Detail.ftl";
	private static final String page_forward_tomanagers_jxEmployee = "/template/xjx/JxEmployee_Manager.ftl";
	private static final String action_forward_managers_jxEmployee = "jxEmployee_manager.xhtml";
	@Resource(name = "jxEmployeeService")
	private IJxEmployeeService jxEmployeeService;
	@Resource(name = "jxDeptService")
	private IJxDeptService jxDeptService;
	private JxDeptModel jxDeptModel;
	private List<JxDeptModel> jxDeptModels;
	private JxEmployeeModel jxEmployeeModel;
	private List<JxEmployeeModel> jxEmployeeModels;



	public String ajax() throws Exception
	{
		this.response.setContentType("text/html;charset=utf-8");
		this.response.getWriter().print("");
		this.response.getWriter().close();
		return NONE;
	}


	/**
	 * 以JSON方式返回员工列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String jsonList() throws Exception
	{
		jxEmployeeModels = jxEmployeeService.getCollection(jxEmployeeModel);
		if (jxEmployeeModels == null || jxEmployeeModels.isEmpty())
			return null;

		JSONArray jr = new JSONArray();
		JSONObject json = null;
		for (JxEmployeeModel employee : jxEmployeeModels)
		{
			json = new JSONObject();
			json.put("id", employee.getId());
			json.put("code", employee.getJeCode());
			json.put("name", employee.getJeName());
			jr.put(json);
		}

		JSONObject jo = new JSONObject();
		jo.put("total", jxEmployeeModels.size());
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
		jxEmployeeModel.setJeSex(true);
		jxEmployeeModel.setJePlace("宁波");
		jxEmployeeModel.setJeDegree((short) 1);
		jxEmployeeModel.setJeJob((short) 1);
		jxEmployeeModel.setJeIsjob(true);

		if (jxDeptModel == null)
		{
			jxDeptModel = new JxDeptModel();
		}
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

		this.request.setAttribute("deptsNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showinsert_jxEmployee);
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
		jxEmployeeModel = jxEmployeeService.findById(this.getId());

		if (jxDeptModel == null)
		{
			jxDeptModel = new JxDeptModel();
		}
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
		this.request.setAttribute("deptsNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showupdate_jxEmployee);
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
		jxEmployeeModel = jxEmployeeService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxEmployee);
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
		or = jxEmployeeService.save(jxEmployeeModel);
		this.setJxEmployeeModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxEmployee);
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
		or = jxEmployeeService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxEmployee);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{

		jxEmployeeModels = jxEmployeeService.getCollection(jxEmployeeModel);
		this.setParameters(page_forward_tomanagers_jxEmployee);
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
		jxEmployeeModels = jxEmployeeService.getCollection(jxEmployeeModel);
		TableFacade tableFacade = new TableFacade("jxEmployeeModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jeCode", "jePlace", "jeClazz", "jeName", "jeDept", "jeSex", "jeIdcard", "jeDegree", "jeJob", "jeBirthday", "jeAddress", "jePost", "jePhone", "jeIsjob", "jeLevel",
				"jeWorkdate", "jeIndate", "jeResume", "jeRelation", "jeRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxEmployeeModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxEmployeeModel == null)
		{
			jxEmployeeModel = new JxEmployeeModel(request, "jxEmployeeModel");
		}
	}


	/**
	 * @return the jxEmployeeModel
	 */
	public JxEmployeeModel getJxEmployeeModel()
	{
		return jxEmployeeModel;
	}


	/**
	 * @param jxEmployeeModel
	 *            the jxEmployeeModel to set
	 */
	public void setJxEmployeeModel(JxEmployeeModel jxEmployeeModel)
	{
		this.jxEmployeeModel = jxEmployeeModel;
	}


	/**
	 * @return the jxEmployeeModels
	 */
	public List<JxEmployeeModel> getJxEmployeeModels()
	{
		return jxEmployeeModels;
	}


	/**
	 * @param jxEmployeeModels
	 *            the jxEmployeeModels to set
	 */
	public void setJxEmployeeModels(List<JxEmployeeModel> jxEmployeeModels)
	{
		this.jxEmployeeModels = jxEmployeeModels;
	}


	public JxDeptModel getJxDeptModel()
	{
		return jxDeptModel;
	}


	public void setJxDeptModel(JxDeptModel jxDeptModel)
	{
		this.jxDeptModel = jxDeptModel;
	}


	public List<JxDeptModel> getJxDeptModels()
	{
		return jxDeptModels;
	}


	public void setJxDeptModels(List<JxDeptModel> jxDeptModels)
	{
		this.jxDeptModels = jxDeptModels;
	}
}
