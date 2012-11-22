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
import com.safetys.zhjg.xjx.model.JxCustomerModel;
import com.safetys.zhjg.xjx.service.IJxCustomerService;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("jxCustomerController")
public class JxCustomerController extends BaseController implements Preparable
{

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_jxCustomer = "/template/xjx/JxCustomer_Input.ftl";
	private static final String page_forward_showupdate_jxCustomer = "/template/xjx/JxCustomer_Input.ftl";
	private static final String page_forward_showdetail_jxCustomer = "/template/xjx/JxCustomer_Detail.ftl";
	private static final String page_forward_tomanagers_jxCustomer = "/template/xjx/JxCustomer_Manager.ftl";
	private static final String action_forward_managers_jxCustomer = "jxCustomer_manager.xhtml";
	@Resource(name = "jxCustomerService")
	private IJxCustomerService jxCustomerService;
	private JxCustomerModel jxCustomerModel;
	private List<JxCustomerModel> jxCustomerModels;



	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception
	{
		this.setParameters(page_forward_showinsert_jxCustomer);
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
		jxCustomerModel = jxCustomerService.findById(this.getId());
		this.setParameters(page_forward_showupdate_jxCustomer);
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
		jxCustomerModel = jxCustomerService.findById(this.getId());
		this.setParameters(page_forward_showdetail_jxCustomer);
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
		or = jxCustomerService.save(jxCustomerModel);
		this.setJxCustomerModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_jxCustomer);
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
		or = jxCustomerService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_jxCustomer);
		return SUCCESS;
	}


	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception
	{
		jxCustomerModels = jxCustomerService.getCollection(jxCustomerModel);
		this.setParameters(page_forward_tomanagers_jxCustomer);
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
		jxCustomerModels = jxCustomerService.getCollection(jxCustomerModel);
		TableFacade tableFacade = new TableFacade("jxCustomerModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "jcCode", "jcClazz", "jcName", "jcAddress", "jcPost", "jcPhone", "jcFullname", "jcBank", "jcAccount", "jcDuty", "jcUser", "jcCanuse", "jcRemark", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(jxCustomerModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported())
		{
			tableFacade.render();
		}
		return NONE;
	}


	public void prepare() throws Exception
	{
		if (jxCustomerModel == null)
		{
			jxCustomerModel = new JxCustomerModel(request, "jxCustomerModel");
		}
	}


	/**
	 * @return the jxCustomerModel
	 */
	public JxCustomerModel getJxCustomerModel()
	{
		return jxCustomerModel;
	}


	/**
	 * @param jxCustomerModel
	 *            the jxCustomerModel to set
	 */
	public void setJxCustomerModel(JxCustomerModel jxCustomerModel)
	{
		this.jxCustomerModel = jxCustomerModel;
	}


	/**
	 * @return the jxCustomerModels
	 */
	public List<JxCustomerModel> getJxCustomerModels()
	{
		return jxCustomerModels;
	}


	/**
	 * @param jxCustomerModels
	 *            the jxCustomerModels to set
	 */
	public void setJxCustomerModels(List<JxCustomerModel> jxCustomerModels)
	{
		this.jxCustomerModels = jxCustomerModels;
	}
}
