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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.safetys.zhjg.xjx.model.JxPuchaseTypeModel;
import com.safetys.zhjg.xjx.service.IJxPuchaseTypeService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxPuchaseTypeController")
public class JxPuchaseTypeController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxPuchaseType = "/template/xjx/JxPuchaseType_Input.ftl";
	private static final String page_forward_showupdate_jxPuchaseType = "/template/xjx/JxPuchaseType_Input.ftl";
	private static final String page_forward_showdetail_jxPuchaseType = "/template/xjx/JxPuchaseType_Detail.ftl";
	private static final String page_forward_tomanagers_jxPuchaseType = "/template/xjx/JxPuchaseType_Manager.ftl";
	private static final String action_forward_managers_jxPuchaseType = "jxPuchaseType_manager.xhtml";
	@Resource(name = "jxPuchaseTypeService")
	private IJxPuchaseTypeService jxPuchaseTypeService;
	private JxPuchaseTypeModel jxPuchaseTypeModel;
	private List<JxPuchaseTypeModel> jxPuchaseTypeModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		jxPuchaseTypeModel.setJpCanuse(true);
		this.setParameters(page_forward_showinsert_jxPuchaseType);
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
		jxPuchaseTypeModel = jxPuchaseTypeService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxPuchaseType);
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
		jxPuchaseTypeModel = jxPuchaseTypeService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxPuchaseType);
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
		or = jxPuchaseTypeService.save(jxPuchaseTypeModel);
		this.setJxPuchaseTypeModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxPuchaseType);
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
		or = jxPuchaseTypeService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxPuchaseType);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxPuchaseTypeModels = jxPuchaseTypeService.getCollection(jxPuchaseTypeModel);
		this.setParameters(page_forward_tomanagers_jxPuchaseType);
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
		jxPuchaseTypeModels = jxPuchaseTypeService.getCollection(jxPuchaseTypeModel);
		TableFacade tableFacade = new TableFacade("jxPuchaseTypeModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jpCode", "jpName", "jpRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxPuchaseTypeModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxPuchaseTypeModel == null)
		{
			jxPuchaseTypeModel = new JxPuchaseTypeModel(request, "jxPuchaseTypeModel");
		}
	}


	/**
	 * @return the jxPuchaseTypeModel
	 */
	public JxPuchaseTypeModel getJxPuchaseTypeModel()
	{
		return jxPuchaseTypeModel;
	}


	/**
	 * @param jxPuchaseTypeModel
	 *            the jxPuchaseTypeModel to set
	 */
	public void setJxPuchaseTypeModel(JxPuchaseTypeModel jxPuchaseTypeModel)
	{
		this.jxPuchaseTypeModel = jxPuchaseTypeModel;
	}


	/**
	 * @return the jxPuchaseTypeModels
	 */
	public List<JxPuchaseTypeModel> getJxPuchaseTypeModels()
	{
		return jxPuchaseTypeModels;
	}


	/**
	 * @param jxPuchaseTypeModels
	 *            the jxPuchaseTypeModels to set
	 */
	public void setJxPuchaseTypeModels(List<JxPuchaseTypeModel> jxPuchaseTypeModels)
	{
		this.jxPuchaseTypeModels = jxPuchaseTypeModels;
	}
}
