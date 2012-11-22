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
import com.safetys.zhjg.xjx.model.JxSalesDetailsModel;
import com.safetys.zhjg.xjx.service.IJxSalesDetailsService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxSalesDetailsController")
public class JxSalesDetailsController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxSalesDetails = "/template/xjx/JxSalesDetails_Input.ftl";
	private static final String page_forward_showupdate_jxSalesDetails = "/template/xjx/JxSalesDetails_Input.ftl";
	private static final String page_forward_showdetail_jxSalesDetails = "/template/xjx/JxSalesDetails_Detail.ftl";
	private static final String page_forward_tomanagers_jxSalesDetails = "/template/xjx/JxSalesDetails_Manager.ftl";
	private static final String action_forward_managers_jxSalesDetails = "jxSalesDetails_manager.xhtml";
	@Resource(name = "jxSalesDetailsService")
	private IJxSalesDetailsService jxSalesDetailsService;
	private JxSalesDetailsModel jxSalesDetailsModel;
	private List<JxSalesDetailsModel> jxSalesDetailsModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxSalesDetails);
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
		jxSalesDetailsModel = jxSalesDetailsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxSalesDetails);
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
		jxSalesDetailsModel = jxSalesDetailsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxSalesDetails);
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
		or = jxSalesDetailsService.save(jxSalesDetailsModel);
		this.setJxSalesDetailsModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxSalesDetails);
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
		or = jxSalesDetailsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxSalesDetails);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxSalesDetailsModels = jxSalesDetailsService.getCollection(jxSalesDetailsModel);
		this.setParameters(page_forward_tomanagers_jxSalesDetails);
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
		jxSalesDetailsModels = jxSalesDetailsService.getCollection(jxSalesDetailsModel);
		TableFacade tableFacade = new TableFacade("jxSalesDetailsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jsdSales", "jsdBarcode", "jsdCode", "jsdName", "jsdUnit", "jsdQuantity", "jsdCost", "jsdAmount", "jsdNum", "jsdOverflow", "jsdRate", "jsdPag", "jsdWcost", "jsdWamount",
				"jsdPre", "jsdSamount", "jsdCustitem", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxSalesDetailsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxSalesDetailsModel == null)
		{
			jxSalesDetailsModel = new JxSalesDetailsModel(request, "jxSalesDetailsModel");
		}
	}


	/**
	 * @return the jxSalesDetailsModel
	 */
	public JxSalesDetailsModel getJxSalesDetailsModel()
	{
		return jxSalesDetailsModel;
	}


	/**
	 * @param jxSalesDetailsModel
	 *            the jxSalesDetailsModel to set
	 */
	public void setJxSalesDetailsModel(JxSalesDetailsModel jxSalesDetailsModel)
	{
		this.jxSalesDetailsModel = jxSalesDetailsModel;
	}


	/**
	 * @return the jxSalesDetailsModels
	 */
	public List<JxSalesDetailsModel> getJxSalesDetailsModels()
	{
		return jxSalesDetailsModels;
	}


	/**
	 * @param jxSalesDetailsModels
	 *            the jxSalesDetailsModels to set
	 */
	public void setJxSalesDetailsModels(List<JxSalesDetailsModel> jxSalesDetailsModels)
	{
		this.jxSalesDetailsModels = jxSalesDetailsModels;
	}
}
