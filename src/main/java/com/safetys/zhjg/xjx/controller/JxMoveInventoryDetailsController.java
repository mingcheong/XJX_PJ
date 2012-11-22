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
import com.safetys.zhjg.xjx.model.JxMoveInventoryDetailsModel;
import com.safetys.zhjg.xjx.service.IJxMoveInventoryDetailsService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxMoveInventoryDetailsController")
public class JxMoveInventoryDetailsController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxMoveInventoryDetails = "/template/xjx/JxMoveInventoryDetails_Input.ftl";
	private static final String page_forward_showupdate_jxMoveInventoryDetails = "/template/xjx/JxMoveInventoryDetails_Input.ftl";
	private static final String page_forward_showdetail_jxMoveInventoryDetails = "/template/xjx/JxMoveInventoryDetails_Detail.ftl";
	private static final String page_forward_tomanagers_jxMoveInventoryDetails = "/template/xjx/JxMoveInventoryDetails_Manager.ftl";
	private static final String action_forward_managers_jxMoveInventoryDetails = "jxMoveInventoryDetails_manager.xhtml";
	@Resource(name = "jxMoveInventoryDetailsService")
	private IJxMoveInventoryDetailsService jxMoveInventoryDetailsService;
	private JxMoveInventoryDetailsModel jxMoveInventoryDetailsModel;
	private List<JxMoveInventoryDetailsModel> jxMoveInventoryDetailsModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxMoveInventoryDetails);
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
		jxMoveInventoryDetailsModel = jxMoveInventoryDetailsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxMoveInventoryDetails);
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
		jxMoveInventoryDetailsModel = jxMoveInventoryDetailsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxMoveInventoryDetails);
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
		or = jxMoveInventoryDetailsService.save(jxMoveInventoryDetailsModel);
		this.setJxMoveInventoryDetailsModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxMoveInventoryDetails);
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
		or = jxMoveInventoryDetailsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxMoveInventoryDetails);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxMoveInventoryDetailsModels = jxMoveInventoryDetailsService.getCollection(jxMoveInventoryDetailsModel);
		this.setParameters(page_forward_tomanagers_jxMoveInventoryDetails);
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
		jxMoveInventoryDetailsModels = jxMoveInventoryDetailsService.getCollection(jxMoveInventoryDetailsModel);
		TableFacade tableFacade = new TableFacade("jxMoveInventoryDetailsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jmdMoveInventory", "jmdBarcode", "jmdCode", "jmdName", "jmdUnit", "jmdQuantity", "jmdCost", "jmdAmount", "jmdNum", "jmdOverflow", "jmdRate", "jmdPack", "jmdWcost",
				"jmdWamount", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxMoveInventoryDetailsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxMoveInventoryDetailsModel == null)
		{
			jxMoveInventoryDetailsModel = new JxMoveInventoryDetailsModel(request, "jxMoveInventoryDetailsModel");
		}
	}


	/**
	 * @return the jxMoveInventoryDetailsModel
	 */
	public JxMoveInventoryDetailsModel getJxMoveInventoryDetailsModel()
	{
		return jxMoveInventoryDetailsModel;
	}


	/**
	 * @param jxMoveInventoryDetailsModel
	 *            the jxMoveInventoryDetailsModel to set
	 */
	public void setJxMoveInventoryDetailsModel(JxMoveInventoryDetailsModel jxMoveInventoryDetailsModel)
	{
		this.jxMoveInventoryDetailsModel = jxMoveInventoryDetailsModel;
	}


	/**
	 * @return the jxMoveInventoryDetailsModels
	 */
	public List<JxMoveInventoryDetailsModel> getJxMoveInventoryDetailsModels()
	{
		return jxMoveInventoryDetailsModels;
	}


	/**
	 * @param jxMoveInventoryDetailsModels
	 *            the jxMoveInventoryDetailsModels to set
	 */
	public void setJxMoveInventoryDetailsModels(List<JxMoveInventoryDetailsModel> jxMoveInventoryDetailsModels)
	{
		this.jxMoveInventoryDetailsModels = jxMoveInventoryDetailsModels;
	}
}
