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
import com.safetys.zhjg.xjx.model.JxSettlementTypeModel;
import com.safetys.zhjg.xjx.service.IJxSettlementTypeService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxSettlementTypeController")
public class JxSettlementTypeController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxSettlementType = "/template/xjx/JxSettlementType_Input.ftl";
	private static final String page_forward_showupdate_jxSettlementType = "/template/xjx/JxSettlementType_Input.ftl";
	private static final String page_forward_showdetail_jxSettlementType = "/template/xjx/JxSettlementType_Detail.ftl";
	private static final String page_forward_tomanagers_jxSettlementType = "/template/xjx/JxSettlementType_Manager.ftl";
	private static final String action_forward_managers_jxSettlementType = "jxSettlementType_manager.xhtml";
	@Resource(name = "jxSettlementTypeService")
	private IJxSettlementTypeService jxSettlementTypeService;
	private JxSettlementTypeModel jxSettlementTypeModel;
	private List<JxSettlementTypeModel> jxSettlementTypeModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxSettlementType);
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
		jxSettlementTypeModel = jxSettlementTypeService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxSettlementType);
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
		jxSettlementTypeModel = jxSettlementTypeService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxSettlementType);
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
		or = jxSettlementTypeService.save(jxSettlementTypeModel);
		this.setJxSettlementTypeModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxSettlementType);
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
		or = jxSettlementTypeService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxSettlementType);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxSettlementTypeModels = jxSettlementTypeService.getCollection(jxSettlementTypeModel);
		this.setParameters(page_forward_tomanagers_jxSettlementType);
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
		jxSettlementTypeModels = jxSettlementTypeService.getCollection(jxSettlementTypeModel);
		TableFacade tableFacade = new TableFacade("jxSettlementTypeModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jsCode", "jsName", "jsRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxSettlementTypeModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxSettlementTypeModel == null)
		{
			jxSettlementTypeModel = new JxSettlementTypeModel(request, "jxSettlementTypeModel");
		}
	}


	/**
	 * @return the jxSettlementTypeModel
	 */
	public JxSettlementTypeModel getJxSettlementTypeModel()
	{
		return jxSettlementTypeModel;
	}


	/**
	 * @param jxSettlementTypeModel
	 *            the jxSettlementTypeModel to set
	 */
	public void setJxSettlementTypeModel(JxSettlementTypeModel jxSettlementTypeModel)
	{
		this.jxSettlementTypeModel = jxSettlementTypeModel;
	}


	/**
	 * @return the jxSettlementTypeModels
	 */
	public List<JxSettlementTypeModel> getJxSettlementTypeModels()
	{
		return jxSettlementTypeModels;
	}


	/**
	 * @param jxSettlementTypeModels
	 *            the jxSettlementTypeModels to set
	 */
	public void setJxSettlementTypeModels(List<JxSettlementTypeModel> jxSettlementTypeModels)
	{
		this.jxSettlementTypeModels = jxSettlementTypeModels;
	}
}
