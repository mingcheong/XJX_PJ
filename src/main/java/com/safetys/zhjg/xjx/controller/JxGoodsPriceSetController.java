/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.xjx.model.JxCustomerModel;
import com.safetys.zhjg.xjx.model.JxGoodsPriceSetModel;
import com.safetys.zhjg.xjx.service.IJxCustomerService;
import com.safetys.zhjg.xjx.service.IJxGoodsPriceSetService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxGoodsPriceSetController")
public class JxGoodsPriceSetController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxGoodsPriceSet = "/template/xjx/JxGoodsPriceSet_Input.ftl";
	private static final String page_forward_showupdate_jxGoodsPriceSet = "/template/xjx/JxGoodsPriceSet_Input.ftl";
	private static final String page_forward_showdetail_jxGoodsPriceSet = "/template/xjx/JxGoodsPriceSet_Detail.ftl";
	private static final String page_forward_tomanagers_jxGoodsPriceSet = "/template/xjx/JxGoodsPriceSet_Manager.ftl";
	private static final String action_forward_managers_jxGoodsPriceSet = "jxGoodsPriceSet_manager.xhtml";
	@Resource(name = "jxGoodsPriceSetService")
	private IJxGoodsPriceSetService jxGoodsPriceSetService;
	private JxGoodsPriceSetModel jxGoodsPriceSetModel;
	private List<JxGoodsPriceSetModel> jxGoodsPriceSetModels;

	@Resource(name = "jxCustomerService")
	private IJxCustomerService jxCustomerService;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		jxGoodsPriceSetModel.setJpDate(getCuurentDate());
		this.setParameters(page_forward_showinsert_jxGoodsPriceSet);
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
		jxGoodsPriceSetModel = jxGoodsPriceSetService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxGoodsPriceSet);
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
		jxGoodsPriceSetModel = jxGoodsPriceSetService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxGoodsPriceSet);
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

		JxCustomerModel customerModel = null;
		if (StringUtils.isNotEmpty(jxGoodsPriceSetModel.getJpCustomer().getJcCode()))
		{
			customerModel = jxCustomerService.findUnique("jcCode", jxGoodsPriceSetModel.getJpCustomer().getJcCode());
		}
		jxGoodsPriceSetModel.setJpCustomer(customerModel);
		or = jxGoodsPriceSetService.save(jxGoodsPriceSetModel);
		this.setJxGoodsPriceSetModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxGoodsPriceSet);
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
		or = jxGoodsPriceSetService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxGoodsPriceSet);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
//		jxGoodsPriceSetModels = jxGoodsPriceSetService.findBy(jxGoodsPriceSetModel);
		jxGoodsPriceSetModels = jxGoodsPriceSetService.getCollection(jxGoodsPriceSetModel);
		this.setParameters(page_forward_tomanagers_jxGoodsPriceSet);
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
		jxGoodsPriceSetModels = jxGoodsPriceSetService.getCollection(jxGoodsPriceSetModel);
		TableFacade tableFacade = new TableFacade("jxGoodsPriceSetModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jpGoods", "jpCustomer", "jpPrice", "jpPricelast", "jpCost", "jpDate", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxGoodsPriceSetModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxGoodsPriceSetModel == null)
		{
			jxGoodsPriceSetModel = new JxGoodsPriceSetModel(request, "jxGoodsPriceSetModel");
		}
	}


	/**
	 * @return the jxGoodsPriceSetModel
	 */
	public JxGoodsPriceSetModel getJxGoodsPriceSetModel()
	{
		return jxGoodsPriceSetModel;
	}


	/**
	 * @param jxGoodsPriceSetModel
	 *            the jxGoodsPriceSetModel to set
	 */
	public void setJxGoodsPriceSetModel(JxGoodsPriceSetModel jxGoodsPriceSetModel)
	{
		this.jxGoodsPriceSetModel = jxGoodsPriceSetModel;
	}


	/**
	 * @return the jxGoodsPriceSetModels
	 */
	public List<JxGoodsPriceSetModel> getJxGoodsPriceSetModels()
	{
		return jxGoodsPriceSetModels;
	}


	/**
	 * @param jxGoodsPriceSetModels
	 *            the jxGoodsPriceSetModels to set
	 */
	public void setJxGoodsPriceSetModels(List<JxGoodsPriceSetModel> jxGoodsPriceSetModels)
	{
		this.jxGoodsPriceSetModels = jxGoodsPriceSetModels;
	}
}
