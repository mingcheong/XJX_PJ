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
import com.safetys.zhjg.xjx.model.JxBackInventoryDetailsModel;
import com.safetys.zhjg.xjx.service.IJxBackInventoryDetailsService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxBackInventoryDetailsController")
public class JxBackInventoryDetailsController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxBackInventoryDetails = "/template/xjx/JxBackInventoryDetails_Input.ftl";
	private static final String page_forward_showupdate_jxBackInventoryDetails = "/template/xjx/JxBackInventoryDetails_Input.ftl";
	private static final String page_forward_showdetail_jxBackInventoryDetails = "/template/xjx/JxBackInventoryDetails_Detail.ftl";
	private static final String page_forward_tomanagers_jxBackInventoryDetails = "/template/xjx/JxBackInventoryDetails_Manager.ftl";
	private static final String action_forward_managers_jxBackInventoryDetails = "jxBackInventoryDetails_manager.xhtml";
	@Resource(name = "jxBackInventoryDetailsService")
	private IJxBackInventoryDetailsService jxBackInventoryDetailsService;
	private JxBackInventoryDetailsModel jxBackInventoryDetailsModel;
	private List<JxBackInventoryDetailsModel> jxBackInventoryDetailsModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxBackInventoryDetails);
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
		jxBackInventoryDetailsModel = jxBackInventoryDetailsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxBackInventoryDetails);
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
		jxBackInventoryDetailsModel = jxBackInventoryDetailsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxBackInventoryDetails);
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
		or = jxBackInventoryDetailsService.save(jxBackInventoryDetailsModel);
		this.setJxBackInventoryDetailsModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxBackInventoryDetails);
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
		or = jxBackInventoryDetailsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxBackInventoryDetails);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxBackInventoryDetailsModels = jxBackInventoryDetailsService.getCollection(jxBackInventoryDetailsModel);
		this.setParameters(page_forward_tomanagers_jxBackInventoryDetails);
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
		jxBackInventoryDetailsModels = jxBackInventoryDetailsService.getCollection(jxBackInventoryDetailsModel);
		TableFacade tableFacade = new TableFacade("jxBackInventoryDetailsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jbdBackInventory", "jbdBarcode", "jbdCode", "jbdName", "jbdUnit", "jbdQuantity", "jbdCost", "jbdAmount", "jbdNum", "jbdOverflow", "jbdRate", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxBackInventoryDetailsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxBackInventoryDetailsModel == null)
		{
			jxBackInventoryDetailsModel = new JxBackInventoryDetailsModel(request, "jxBackInventoryDetailsModel");
		}
	}


	/**
	 * @return the jxBackInventoryDetailsModel
	 */
	public JxBackInventoryDetailsModel getJxBackInventoryDetailsModel()
	{
		return jxBackInventoryDetailsModel;
	}


	/**
	 * @param jxBackInventoryDetailsModel
	 *            the jxBackInventoryDetailsModel to set
	 */
	public void setJxBackInventoryDetailsModel(JxBackInventoryDetailsModel jxBackInventoryDetailsModel)
	{
		this.jxBackInventoryDetailsModel = jxBackInventoryDetailsModel;
	}


	/**
	 * @return the jxBackInventoryDetailsModels
	 */
	public List<JxBackInventoryDetailsModel> getJxBackInventoryDetailsModels()
	{
		return jxBackInventoryDetailsModels;
	}


	/**
	 * @param jxBackInventoryDetailsModels
	 *            the jxBackInventoryDetailsModels to set
	 */
	public void setJxBackInventoryDetailsModels(List<JxBackInventoryDetailsModel> jxBackInventoryDetailsModels)
	{
		this.jxBackInventoryDetailsModels = jxBackInventoryDetailsModels;
	}
}
