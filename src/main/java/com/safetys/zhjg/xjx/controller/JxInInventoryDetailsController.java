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
import com.safetys.zhjg.xjx.model.JxInInventoryDetailsModel;
import com.safetys.zhjg.xjx.service.IJxInInventoryDetailsService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxInInventoryDetailsController")
public class JxInInventoryDetailsController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxInInventoryDetails = "/template/xjx/JxInInventoryDetails_Input.ftl";
	private static final String page_forward_showupdate_jxInInventoryDetails = "/template/xjx/JxInInventoryDetails_Input.ftl";
	private static final String page_forward_showdetail_jxInInventoryDetails = "/template/xjx/JxInInventoryDetails_Detail.ftl";
	private static final String page_forward_tomanagers_jxInInventoryDetails = "/template/xjx/JxInInventoryDetails_Manager.ftl";
	private static final String action_forward_managers_jxInInventoryDetails = "jxInInventoryDetails_manager.xhtml";
	@Resource(name = "jxInInventoryDetailsService")
	private IJxInInventoryDetailsService jxInInventoryDetailsService;
	private JxInInventoryDetailsModel jxInInventoryDetailsModel;
	private List<JxInInventoryDetailsModel> jxInInventoryDetailsModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxInInventoryDetails);
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
		jxInInventoryDetailsModel = jxInInventoryDetailsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxInInventoryDetails);
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
		jxInInventoryDetailsModel = jxInInventoryDetailsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxInInventoryDetails);
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
		or = jxInInventoryDetailsService.save(jxInInventoryDetailsModel);
		this.setJxInInventoryDetailsModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxInInventoryDetails);
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
		or = jxInInventoryDetailsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxInInventoryDetails);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxInInventoryDetailsModels = jxInInventoryDetailsService.getCollection(jxInInventoryDetailsModel);
		this.setParameters(page_forward_tomanagers_jxInInventoryDetails);
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
		jxInInventoryDetailsModels = jxInInventoryDetailsService.getCollection(jxInInventoryDetailsModel);
		TableFacade tableFacade = new TableFacade("jxInInventoryDetailsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jidInInventory", "jidBarcode", "jidCode", "jidName", "jidUnit", "jidQuantity", "jidCost", "jidAmount", "jidNum", "jidOverflow", "jidRate", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxInInventoryDetailsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxInInventoryDetailsModel == null)
		{
			jxInInventoryDetailsModel = new JxInInventoryDetailsModel(request, "jxInInventoryDetailsModel");
		}
	}


	/**
	 * @return the jxInInventoryDetailsModel
	 */
	public JxInInventoryDetailsModel getJxInInventoryDetailsModel()
	{
		return jxInInventoryDetailsModel;
	}


	/**
	 * @param jxInInventoryDetailsModel
	 *            the jxInInventoryDetailsModel to set
	 */
	public void setJxInInventoryDetailsModel(JxInInventoryDetailsModel jxInInventoryDetailsModel)
	{
		this.jxInInventoryDetailsModel = jxInInventoryDetailsModel;
	}


	/**
	 * @return the jxInInventoryDetailsModels
	 */
	public List<JxInInventoryDetailsModel> getJxInInventoryDetailsModels()
	{
		return jxInInventoryDetailsModels;
	}


	/**
	 * @param jxInInventoryDetailsModels
	 *            the jxInInventoryDetailsModels to set
	 */
	public void setJxInInventoryDetailsModels(List<JxInInventoryDetailsModel> jxInInventoryDetailsModels)
	{
		this.jxInInventoryDetailsModels = jxInInventoryDetailsModels;
	}
}
