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
import com.safetys.framework.system.model.FkResourceModel;
import com.safetys.framework.system.service.IFkResourceService;
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
@Controller("fkResourceController")
public class FkResourceController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_fkResource = "/template/system/FkResource_Input.ftl";
	private static final String page_forward_showupdate_fkResource = "/template/system/FkResource_Input.ftl";
	private static final String page_forward_showdetail_fkResource = "/template/system/FkResource_Detail.ftl";
	private static final String page_forward_tomanagers_fkResource = "/template/system/FkResource_Manager.ftl";
	private static final String action_forward_managers_fkResource = "fkResource_manager.xhtml";
	@Resource(name = "fkResourceService")
	private IFkResourceService fkResourceService;
	private FkResourceModel fkResourceModel;
	private List<FkResourceModel> fkResourceModels;

	/**
	 * 通过AJAX取下级菜单
	 * 
	 * @throws ActionException
	 */
	public String ajax() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("对象编号不可为空或小于零！"); }
		fkResourceModel.setFatherId(this.getId());
		fkResourceModels = fkResourceService.getCollection(fkResourceModel, false);
		if (fkResourceModels != null && fkResourceModels.size() > 0) {
			for (FkResourceModel element : fkResourceModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getResourceName());
				treeModels.add(treeModel);
			}
			fkResourceModels.clear();
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
		fkResourceModel.setFatherId(0l);
		fkResourceModels = fkResourceService.getCollection(fkResourceModel, false);
		if (fkResourceModels != null && fkResourceModels.size() > 0) {
			for (FkResourceModel element : fkResourceModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getResourceName());
				treeModels.add(treeModel);
			}
			fkResourceModels.clear();
		}
		request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showinsert_fkResource);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkResourceModel.setFatherId(0l);
		fkResourceModels = fkResourceService.getCollection(fkResourceModel, false);
		if (fkResourceModels != null && fkResourceModels.size() > 0) {
			for (FkResourceModel element : fkResourceModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getResourceName());
				treeModels.add(treeModel);
			}
			fkResourceModels.clear();
		}
		fkResourceModel = fkResourceService.findById(this.getId());
		if(fkResourceModel.getFatherId() > 0){
			request.setAttribute("fatherName", fkResourceService.findById(fkResourceModel.getFatherId()).getResourceName());
		}
		request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_showupdate_fkResource);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkResourceModel = fkResourceService.findById(this.getId());
		this.setParameters(page_forward_showdetail_fkResource);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = fkResourceService.save(fkResourceModel);
		FkResourceModel model = fkResourceService.findById(fkResourceModel.getFatherId());
		if (model != null && !model.getHasChildren()) {
			model.setHasChildren(true);
			fkResourceService.save(model);
		}
		this.setParameters(or.getMessage(), action_forward_managers_fkResource);
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
		or = fkResourceService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkResource);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		fkResourceModels = fkResourceService.getCollection(fkResourceModel);
		this.setParameters(page_forward_tomanagers_fkResource);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkResourceModels = fkResourceService.getCollection(fkResourceModel);
		TableFacade tableFacade = new TableFacade("fkResourceModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "createDate", "isDeleted", "modifyDate", "sortNum", "fatherId", "fiftharea", "firstarea", "fourtharea", "isMenu", "resourceImg", "resourceName",
		        "resourceUrl", "secondarea", "thirdarea", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkResourceModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (fkResourceModel == null) {
			fkResourceModel = new FkResourceModel(request, "fkResourceModel");
		}
	}

	/**
	 * @return the fkResourceModel
	 */
	public FkResourceModel getFkResourceModel() {
		return fkResourceModel;
	}

	/**
	 * @param fkResourceModel
	 *            the fkResourceModel to set
	 */
	public void setFkResourceModel(FkResourceModel fkResourceModel) {
		this.fkResourceModel = fkResourceModel;
	}

	/**
	 * @return the fkResourceModels
	 */
	public List<FkResourceModel> getFkResourceModels() {
		return fkResourceModels;
	}

	/**
	 * @param fkResourceModels
	 *            the fkResourceModels to set
	 */
	public void setFkResourceModels(List<FkResourceModel> fkResourceModels) {
		this.fkResourceModels = fkResourceModels;
	}
}
