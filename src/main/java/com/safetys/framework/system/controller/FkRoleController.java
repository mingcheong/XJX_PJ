/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.system.model.FkRoleModel;
import com.safetys.framework.system.service.IFkRoleService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("fkRoleController")
public class FkRoleController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_fkRole = "/template/system/FkRole_Input.ftl";
	private static final String page_forward_showupdate_fkRole = "/template/system/FkRole_Input.ftl";
	private static final String page_forward_showdetail_fkRole = "/template/system/FkRole_Detail.ftl";
	private static final String page_forward_tomanagers_fkRole = "/template/system/FkRole_Manager.ftl";
	private static final String action_forward_managers_fkRole = "fkRole_manager.xhtml";
	@Resource(name = "fkRoleService")
	private IFkRoleService fkRoleService;
	private FkRoleModel fkRoleModel;
	private List<FkRoleModel> fkRoleModels;

	public String ajax() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		this.response.getWriter().print("");
		this.response.getWriter().close();
		return NONE;
	}

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_fkRole);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkRoleModel = fkRoleService.findById(this.getId());
		this.setParameters(page_forward_showupdate_fkRole);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkRoleModel = fkRoleService.findById(this.getId());
		this.setParameters(page_forward_showdetail_fkRole);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = fkRoleService.save(fkRoleModel);
		this.setFkRoleModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_fkRole);
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * 
	 * @throws ActionException
	 */
	public String remove() throws Exception {
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) { throw new ActionException("将要删除的对象编号不可为空！"); }
		or = fkRoleService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkRole);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		fkRoleModels = fkRoleService.getCollection(fkRoleModel);
		this.setParameters(page_forward_tomanagers_fkRole);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkRoleModels = fkRoleService.getCollection(fkRoleModel);
		TableFacade tableFacade = new TableFacade("fkRoleModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "id", "createDate", "isDeleted", "modifyDate", "sortNum", "fiftharea", "firstarea", "fourtharea", "resources", "roleCode", "roleName", "secondarea",
		        "thirdarea", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkRoleModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (fkRoleModel == null) {
			fkRoleModel = new FkRoleModel(request, "fkRoleModel");
		}
	}

	/**
	 * @return the fkRoleModel
	 */
	public FkRoleModel getFkRoleModel() {
		return fkRoleModel;
	}

	/**
	 * @param fkRoleModel
	 *            the fkRoleModel to set
	 */
	public void setFkRoleModel(FkRoleModel fkRoleModel) {
		this.fkRoleModel = fkRoleModel;
	}

	/**
	 * @return the fkRoleModels
	 */
	public List<FkRoleModel> getFkRoleModels() {
		return fkRoleModels;
	}

	/**
	 * @param fkRoleModels
	 *            the fkRoleModels to set
	 */
	public void setFkRoleModels(List<FkRoleModel> fkRoleModels) {
		this.fkRoleModels = fkRoleModels;
	}
}
