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
import com.safetys.zhjg.xjx.model.JxInventoryModel;
import com.safetys.zhjg.xjx.service.IJxInventoryService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxInventoryController")
public class JxInventoryController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxInventory = "/template/xjx/JxInventory_Input.ftl";
	private static final String page_forward_showupdate_jxInventory = "/template/xjx/JxInventory_Input.ftl";
	private static final String page_forward_showdetail_jxInventory = "/template/xjx/JxInventory_Detail.ftl";
	private static final String page_forward_tomanagers_jxInventory = "/template/xjx/JxInventory_Manager.ftl";
	private static final String action_forward_managers_jxInventory = "jxInventory_manager.xhtml";
	@Resource(name = "jxInventoryService")
	private IJxInventoryService jxInventoryService;
	private JxInventoryModel jxInventoryModel;
	private List<JxInventoryModel> jxInventoryModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxInventory);
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
		jxInventoryModel = jxInventoryService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxInventory);
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
		jxInventoryModel = jxInventoryService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxInventory);
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
		or = jxInventoryService.save(jxInventoryModel);
		this.setJxInventoryModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxInventory);
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
		or = jxInventoryService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxInventory);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxInventoryModels = jxInventoryService.getCollection(jxInventoryModel);
		this.setParameters(page_forward_tomanagers_jxInventory);
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
		jxInventoryModels = jxInventoryService.getCollection(jxInventoryModel);
		TableFacade tableFacade = new TableFacade("jxInventoryModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jiWarehouse", "jiGoods", "jiCursum", "jiTotalsum", "jiWastesum", "jiSparesum", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxInventoryModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxInventoryModel == null)
		{
			jxInventoryModel = new JxInventoryModel(request, "jxInventoryModel");
		}
	}


	/**
	 * @return the jxInventoryModel
	 */
	public JxInventoryModel getJxInventoryModel()
	{
		return jxInventoryModel;
	}


	/**
	 * @param jxInventoryModel
	 *            the jxInventoryModel to set
	 */
	public void setJxInventoryModel(JxInventoryModel jxInventoryModel)
	{
		this.jxInventoryModel = jxInventoryModel;
	}


	/**
	 * @return the jxInventoryModels
	 */
	public List<JxInventoryModel> getJxInventoryModels()
	{
		return jxInventoryModels;
	}


	/**
	 * @param jxInventoryModels
	 *            the jxInventoryModels to set
	 */
	public void setJxInventoryModels(List<JxInventoryModel> jxInventoryModels)
	{
		this.jxInventoryModels = jxInventoryModels;
	}
}
