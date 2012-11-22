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
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkRoleModel;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkOrganizeService;
import com.safetys.framework.system.service.IFkRoleService;
import com.safetys.framework.system.service.IFkUserService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.MD5;
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
@Controller("fkUserController")
public class FkUserController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_fkUser = "/template/system/FkUser_Input.ftl";
	private static final String forward_contact_fkUser = "/template/system/FkUser_Contact.ftl";
	private static final String page_forward_showupdate_fkUser = "/template/system/FkUser_Input.ftl";
	private static final String page_forward_showdetail_fkUser = "/template/system/FkUser_Detail.ftl";
	private static final String page_forward_tomanagers_fkUser = "/template/system/FkUser_Manager.ftl";
	private static final String action_forward_managers_fkUser = "fkUser_manager.xhtml";
	@Resource(name = "fkUserService")
	private IFkUserService fkUserService;
	@Resource(name = "fkRoleService")
	private IFkRoleService fkRoleService;
	@Resource(name = "fkOrganizeService")
	private IFkOrganizeService fkOrganizeService;
	private FkUserModel fkUserModel;
	private FkOrganizeModel fkOrganizeModel;
	private List<FkOrganizeModel> fkOrganizeModels;
	private List<FkUserModel> fkUserModels;

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		if (fkOrganizeModel == null) {
			fkOrganizeModel = new FkOrganizeModel();
		}
		fkOrganizeModel.setFatherId(0l);
		fkOrganizeModels = fkOrganizeService.getCollection(fkOrganizeModel, false);
		if (fkOrganizeModels != null && fkOrganizeModels.size() > 0) {
			for (FkOrganizeModel element : fkOrganizeModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getOrgName());
				treeModels.add(treeModel);
			}
			fkOrganizeModels.clear();
		}
		this.request.setAttribute("orgsNodes", gson.toJson(treeModels));
		treeModels.clear();
		List<FkRoleModel> datas = fkRoleService.getCollection(new FkRoleModel(), false);
		if (datas != null && datas.size() > 0) {
			for (FkRoleModel element : datas) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setName(element.getRoleName());
				treeModel.setIsParent(false);
				treeModels.add(treeModel);
			}
			datas.clear();
		}
		this.request.setAttribute("roleNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showinsert_fkUser);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkUserModel = fkUserService.findById(this.getId());
		if (fkOrganizeModel == null) {
			fkOrganizeModel = new FkOrganizeModel();
		}
		fkOrganizeModel.setFatherId(0l);
		fkOrganizeModels = fkOrganizeService.getCollection(fkOrganizeModel, false);
		if (fkOrganizeModels != null && fkOrganizeModels.size() > 0) {
			for (FkOrganizeModel element : fkOrganizeModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getOrgName());
				treeModels.add(treeModel);
			}
			fkOrganizeModels.clear();
		}
		this.request.setAttribute("orgsNodes", gson.toJson(treeModels));
		treeModels.clear();
		List<FkRoleModel> datas = fkRoleService.getCollection(new FkRoleModel(), false);
		if (datas != null && datas.size() > 0) {
			for (FkRoleModel element : datas) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setName(element.getRoleName());
				treeModel.setIsParent(false);
				treeModels.add(treeModel);
			}
			datas.clear();
		}
		this.request.setAttribute("roleNodes", gson.toJson(treeModels));
		this.request.setAttribute("orgsName", fkUserModel.getFkOrganize().getOrgName());
		this.setParameters(page_forward_showupdate_fkUser);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkUserModel = fkUserService.findById(this.getId());
		this.request.setAttribute("orgsName", fkUserModel.getFkOrganize().getOrgName());
		this.setParameters(page_forward_showdetail_fkUser);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		if (fkUserModel.getRePassword() != null) {
			fkUserModel.setPassword(MD5.calcMD5(fkUserModel.getRePassword()));
		}
		or = fkUserService.save(fkUserModel);
		this.setParameters(or.getMessage(), action_forward_managers_fkUser);
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
		or = fkUserService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkUser);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String contact()throws Exception{
		fkUserModels = fkUserService.getUsersOrderByOrganId(fkUserModel);
		this.setParameters(forward_contact_fkUser);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		if (fkOrganizeModel == null) {
			fkOrganizeModel = new FkOrganizeModel();
		}
		fkOrganizeModel.setFatherId(0l);
		fkOrganizeModels = fkOrganizeService.getCollection(fkOrganizeModel, false);
		if (fkOrganizeModels != null && fkOrganizeModels.size() > 0) {
			for (FkOrganizeModel element : fkOrganizeModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getOrgName());
				treeModels.add(treeModel);
			}
			fkOrganizeModels.clear();
		}
		this.request.setAttribute("treeNodes", gson.toJson(treeModels));
		fkUserModels = fkUserService.getCollection(fkUserModel);
		request.setAttribute("orgsName", request.getParameter("orgsName"));
		this.setParameters(page_forward_tomanagers_fkUser);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkUserModels = fkUserService.getCollection(fkUserModel);
		TableFacade tableFacade = new TableFacade("fkUserModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "createDate", "isDeleted", "modifyDate", "sortNum", "bornDate", "fiftharea", "firstarea", "fourtharea", "idCard", "orgsId", "password", "resources",
		        "secondarea", "thirdarea", "truename", "userEmail", "userMobile", "userPhone", "username", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkUserModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (fkUserModel == null) {
			fkUserModel = new FkUserModel(request, "fkUserModel");
		}
	}

	/**
	 * @return the fkUserModel
	 */
	public FkUserModel getFkUserModel() {
		return fkUserModel;
	}

	/**
	 * @param fkUserModel
	 *            the fkUserModel to set
	 */
	public void setFkUserModel(FkUserModel fkUserModel) {
		this.fkUserModel = fkUserModel;
	}

	/**
	 * @return the fkUserModels
	 */
	public List<FkUserModel> getFkUserModels() {
		return fkUserModels;
	}

	/**
	 * @param fkUserModels
	 *            the fkUserModels to set
	 */
	public void setFkUserModels(List<FkUserModel> fkUserModels) {
		this.fkUserModels = fkUserModels;
	}

	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}

	public List<FkOrganizeModel> getFkOrganizeModels() {
		return fkOrganizeModels;
	}

	public void setFkOrganizeModels(List<FkOrganizeModel> fkOrganizeModels) {
		this.fkOrganizeModels = fkOrganizeModels;
	}

}
