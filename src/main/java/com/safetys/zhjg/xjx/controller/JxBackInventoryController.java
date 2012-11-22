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
import com.safetys.zhjg.xjx.model.JxBackInventoryModel;
import com.safetys.zhjg.xjx.service.IJxBackInventoryService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxBackInventoryController")
public class JxBackInventoryController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxBackInventory = "/template/xjx/JxBackInventory_Input.ftl";
	private static final String page_forward_showupdate_jxBackInventory = "/template/xjx/JxBackInventory_Input.ftl";
	private static final String page_forward_showdetail_jxBackInventory = "/template/xjx/JxBackInventory_Detail.ftl";
	private static final String page_forward_tomanagers_jxBackInventory = "/template/xjx/JxBackInventory_Manager.ftl";
	private static final String action_forward_managers_jxBackInventory = "jxBackInventory_manager.xhtml";
	@Resource(name = "jxBackInventoryService")
	private IJxBackInventoryService jxBackInventoryService;
	private JxBackInventoryModel jxBackInventoryModel;
	private List<JxBackInventoryModel> jxBackInventoryModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxBackInventory);
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
		jxBackInventoryModel = jxBackInventoryService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxBackInventory);
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
		jxBackInventoryModel = jxBackInventoryService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxBackInventory);
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
		or = jxBackInventoryService.save(jxBackInventoryModel);
		this.setJxBackInventoryModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxBackInventory);
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
		or = jxBackInventoryService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxBackInventory);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxBackInventoryModels = jxBackInventoryService.getCollection(jxBackInventoryModel);
		this.setParameters(page_forward_tomanagers_jxBackInventory);
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
		jxBackInventoryModels = jxBackInventoryService.getCollection(jxBackInventoryModel);
		TableFacade tableFacade = new TableFacade("jxBackInventoryModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jbCode", "jbLastCode", "jbOcode", "jbCodemark", "jbDept", "jbSupplier", "jbUser", "jbDate", "jbCheckuser", "jbWarehouse", "jbRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxBackInventoryModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxBackInventoryModel == null)
		{
			jxBackInventoryModel = new JxBackInventoryModel(request, "jxBackInventoryModel");
		}
	}


	/**
	 * @return the jxBackInventoryModel
	 */
	public JxBackInventoryModel getJxBackInventoryModel()
	{
		return jxBackInventoryModel;
	}


	/**
	 * @param jxBackInventoryModel
	 *            the jxBackInventoryModel to set
	 */
	public void setJxBackInventoryModel(JxBackInventoryModel jxBackInventoryModel)
	{
		this.jxBackInventoryModel = jxBackInventoryModel;
	}


	/**
	 * @return the jxBackInventoryModels
	 */
	public List<JxBackInventoryModel> getJxBackInventoryModels()
	{
		return jxBackInventoryModels;
	}


	/**
	 * @param jxBackInventoryModels
	 *            the jxBackInventoryModels to set
	 */
	public void setJxBackInventoryModels(List<JxBackInventoryModel> jxBackInventoryModels)
	{
		this.jxBackInventoryModels = jxBackInventoryModels;
	}
}
