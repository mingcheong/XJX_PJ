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
import com.safetys.zhjg.xjx.model.JxWarehouseModel;
import com.safetys.zhjg.xjx.service.IJxWarehouseService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxWarehouseController")
public class JxWarehouseController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxWarehouse = "/template/xjx/JxWarehouse_Input.ftl";
	private static final String page_forward_showupdate_jxWarehouse = "/template/xjx/JxWarehouse_Input.ftl";
	private static final String page_forward_showdetail_jxWarehouse = "/template/xjx/JxWarehouse_Detail.ftl";
	private static final String page_forward_tomanagers_jxWarehouse = "/template/xjx/JxWarehouse_Manager.ftl";
	private static final String action_forward_managers_jxWarehouse = "jxWarehouse_manager.xhtml";
	@Resource(name = "jxWarehouseService")
	private IJxWarehouseService jxWarehouseService;
	private JxWarehouseModel jxWarehouseModel;
	private List<JxWarehouseModel> jxWarehouseModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxWarehouse);
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
		jxWarehouseModel = jxWarehouseService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxWarehouse);
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
		jxWarehouseModel = jxWarehouseService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxWarehouse);
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
		or = jxWarehouseService.save(jxWarehouseModel);
		this.setJxWarehouseModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxWarehouse);
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
		or = jxWarehouseService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxWarehouse);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxWarehouseModels = jxWarehouseService.getCollection(jxWarehouseModel);
		this.setParameters(page_forward_tomanagers_jxWarehouse);
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
		jxWarehouseModels = jxWarehouseService.getCollection(jxWarehouseModel);
		TableFacade tableFacade = new TableFacade("jxWarehouseModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jwCode", "jwName", "jwUser", "jwMemo", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxWarehouseModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxWarehouseModel == null)
		{
			jxWarehouseModel = new JxWarehouseModel(request, "jxWarehouseModel");
		}
	}


	/**
	 * @return the jxWarehouseModel
	 */
	public JxWarehouseModel getJxWarehouseModel()
	{
		return jxWarehouseModel;
	}


	/**
	 * @param jxWarehouseModel
	 *            the jxWarehouseModel to set
	 */
	public void setJxWarehouseModel(JxWarehouseModel jxWarehouseModel)
	{
		this.jxWarehouseModel = jxWarehouseModel;
	}


	/**
	 * @return the jxWarehouseModels
	 */
	public List<JxWarehouseModel> getJxWarehouseModels()
	{
		return jxWarehouseModels;
	}


	/**
	 * @param jxWarehouseModels
	 *            the jxWarehouseModels to set
	 */
	public void setJxWarehouseModels(List<JxWarehouseModel> jxWarehouseModels)
	{
		this.jxWarehouseModels = jxWarehouseModels;
	}
}
