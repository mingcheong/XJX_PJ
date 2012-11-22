/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkOrganizeService;
import com.safetys.framework.system.service.IFkUserService;
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
@Controller("fkOrganizeController")
public class FkOrganizeController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_fkOrganize = "/template/system/FkOrganize_Input.ftl";
	private static final String page_forward_showupdate_fkOrganize = "/template/system/FkOrganize_Input.ftl";
	private static final String page_forward_navigation_fkOrganize = "/template/system/FkOrganize_Frame.ftl";
	private static final String page_forward_operatorlist_fkOrganize = "/template/system/FkOrganize_operator.ftl";
	private static final String page_forward_showdetail_fkOrganize = "/template/system/FkOrganize_Detail.ftl";
	private static final String page_forward_tomanagers_fkOrganize = "/template/system/FkOrganize_Manager.ftl";
	private static final String page_forward_chart_fkOrganize = "/template/system/FkOrganize_Chart.ftl";
	private static final String action_forward_managers_fkOrganize = "fkOrganize_manager.xhtml";
	@Resource(name = "fkOrganizeService")
	private IFkOrganizeService fkOrganizeService;
	@Resource(name = "fkUserService")
	private IFkUserService fkUserService;
	private String fkOrganTreeXml = "";// 组织机构树结构xml字符串
	private FkOrganizeModel fkOrganizeModel;
	private List<FkUserModel> fkUserModels;
	private List<FkOrganizeModel> fkOrganizeModels;

	/**
	 * 选择用户导航
	 * 
	 * @throws Exception
	 */
	public String chooseOperator() throws Exception {
		fkOrganizeModel.setFatherId(this.getId());
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
		this.setParameters(page_forward_navigation_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 取用户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String operatorList() throws Exception {
		fkUserModels = new ArrayList<FkUserModel>();
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) {
			fkUserModels = fkOrganizeService.findById(1l).getFkUsers();
		} else {
			fkOrganizeModels = fkOrganizeService.getCollection("select o from fkOrganizeModel o where o.id in(" + this.getSelectedIds() + ")", false);
			if (fkOrganizeModels != null && fkOrganizeModels.size() > 0) {
				for (FkOrganizeModel element : fkOrganizeModels) {
					List<FkUserModel> tmpDatas = element.getFkUsers();
					if (tmpDatas != null && tmpDatas.size() > 0) fkUserModels.addAll(tmpDatas);
				}
			}
		}
		this.setParameters(page_forward_operatorlist_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 通过AJAX取下级机构
	 * 
	 * @throws ActionException
	 * @throws IOException
	 */
	public String ajax() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			this.setId(0l);
		}
		fkOrganizeModel.setFatherId(this.getId());
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
		this.response.getWriter().print(gson.toJson(treeModels));
		this.response.getWriter().close();
		return NONE;
	}

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
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
		this.setParameters(page_forward_showinsert_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
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
		fkOrganizeModel = fkOrganizeService.findById(this.getId());
		this.request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showupdate_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkOrganizeModel = fkOrganizeService.findById(this.getId());
		this.setParameters(page_forward_showdetail_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = fkOrganizeService.save(fkOrganizeModel);
		this.setFkOrganizeModel(null);
		this.setParameters(or.getMessage(), action_forward_managers_fkOrganize);
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
		or = fkOrganizeService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		fkOrganizeModels = fkOrganizeService.getCollection(fkOrganizeModel);
		this.setParameters(page_forward_tomanagers_fkOrganize);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkOrganizeModels = fkOrganizeService.getCollection(fkOrganizeModel);
		TableFacade tableFacade = new TableFacade("fkOrganizeModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "createDate", "isDeleted", "modifyDate", "sortNum", "fatherId", "fiftharea", "firstarea", "fourtharea", "orgCode", "orgDesc", "orgGrade", "orgName",
		        "resources", "secondarea", "thirdarea", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkOrganizeModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	/**
	 * 组织机构架构图
	 * 
	 * @throws ActionException
	 */
	public String chart() throws Exception {
		long orgId = this.getCurrentUser().getFkOrganize().getId();
		List<FkOrganizeModel> fkOrganizeModels = fkOrganizeService.getChildrenResources(orgId,true);
		request.setAttribute("organXml", fkOrganizeService.getXml(fkOrganizeModels));
		this.setParameters(page_forward_chart_fkOrganize);
		return SUCCESS;
	}

	public void prepare() throws Exception {
		if (fkOrganizeModel == null) {
			fkOrganizeModel = new FkOrganizeModel(request, "fkOrganizeModel");
		}
	}

	/**
	 * @return the fkOrganizeModel
	 */
	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	/**
	 * @param fkOrganizeModel
	 *            the fkOrganizeModel to set
	 */
	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}

	/**
	 * @return the fkOrganizeModels
	 */
	public List<FkOrganizeModel> getFkOrganizeModels() {
		return fkOrganizeModels;
	}

	/**
	 * @param fkOrganizeModels
	 *            the fkOrganizeModels to set
	 */
	public void setFkOrganizeModels(List<FkOrganizeModel> fkOrganizeModels) {
		this.fkOrganizeModels = fkOrganizeModels;
	}

	public String getFkOrganTreeXml() {
		return fkOrganTreeXml;
	}

	public void setFkOrganTreeXml(String fkOrganTreeXml) {
		this.fkOrganTreeXml = fkOrganTreeXml;
	}

	public List<FkUserModel> getFkUserModels() {
		return fkUserModels;
	}

	public void setFkUserModels(List<FkUserModel> fkUserModels) {
		this.fkUserModels = fkUserModels;
	}

}
