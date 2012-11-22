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
import com.safetys.framework.system.model.FkAreaModel;
import com.safetys.framework.system.service.IFkAreaService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.statistic.util.ImpAreaXml;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("fkAreaController")
public class FkAreaController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_fkArea = "/template/system/FkArea_Input.ftl";
	private static final String page_forward_showupdate_fkArea = "/template/system/FkArea_Input.ftl";
	private static final String page_forward_navigation_fkArea = "/template/system/FkArea_Frame.ftl";
	private static final String page_forward_showdetail_fkArea = "/template/system/FkArea_Detail.ftl";
	private static final String page_forward_tomanagers_fkArea = "/template/system/FkArea_Manager.ftl";
	private static final String action_forward_managers_fkArea = "fkArea_manager.xhtml";
	@Resource(name = "fkAreaService")
	private IFkAreaService fkAreaService;
	private FkAreaModel fkAreaModel;
	private String areaCode;
	private List<FkAreaModel> fkAreaModels;
	
//	public String loadXml()throws Exception{
//		ImpAreaXml imp = new ImpAreaXml();
//		fkAreaModels = imp.readXML("D://项目包//滁州//city.xml");
//		fkAreaModel = new FkAreaModel();
//		fkAreaModel.setAreaCode("000000");
//		fkAreaModel.setAreaName("中华人民共和国");
//		fkAreaModel.setHasChildren(true);
//		fkAreaModel.setFatherId(0L);
//		fkAreaService.save(fkAreaModel);
//		fkAreaService.saveByXml(fkAreaModels,fkAreaModel);
//		return NONE;
//	}

	/**
	 * 生成XML
	 * 
	 * @throws Exception
	 */
	public String builderXml() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (!AppUtils.isNullOrEmptyString(areaCode)) {
			fkAreaModel = fkAreaService.getCollection("select o from fkAreaModel o where o.areaCode='" + areaCode + "'", false).get(0);
			fkAreaModels = fkAreaService.getCollection("select o from fkAreaModel o where o.fatherId=" + fkAreaModel.getId(), new String[] { "id" }, false);
			if (fkAreaService.datasToXml(fkAreaModel, fkAreaModels)) {
				this.response.getWriter().print("生成成功！");
				this.response.getWriter().close();
			}
		} else {
			this.response.getWriter().print("生成失败！");
			this.response.getWriter().close();
		}
		return NONE;
	}

	/**
	 * 异步加载下级资源
	 * 
	 * @throws Exception
	 */
	public String ajax() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			fkAreaModel.setFatherId(0l);
		} else {
			fkAreaModel.setFatherId(this.getId());
		}
		fkAreaModels = fkAreaService.getCollection(fkAreaModel,new String[]{"id"}, false);
		if (fkAreaModels != null && fkAreaModels.size() > 0) {
			for (FkAreaModel element : fkAreaModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getAreaName());
				treeModels.add(treeModel);
			}
			fkAreaModels.clear();
		}
		this.response.getWriter().print(gson.toJson(treeModels));
		this.response.getWriter().close();
		return NONE;
	}

	/**
	 * 管理导航
	 * 
	 * @throws Exception
	 */
	public String navigation() throws Exception {
		fkAreaModel.setFatherId(0l);
		fkAreaModels = fkAreaService.getCollection(fkAreaModel, false);
		if (fkAreaModels != null && fkAreaModels.size() > 0) {
			for (FkAreaModel element : fkAreaModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getAreaName());
				treeModels.add(treeModel);
			}
			fkAreaModels.clear();
		}
		this.request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_navigation_fkArea);
		return SUCCESS;
	}

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		if (!AppUtils.isNullOrEmptyString(this.getId()) && this.getId() > -1) {
			FkAreaModel model = fkAreaService.findById(this.getId());
			fkAreaModel.setFatherId(this.getId());
			this.request.setAttribute("areaName", model.getAreaName());
		}
		this.setParameters(page_forward_showinsert_fkArea);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkAreaModel = fkAreaService.findById(this.getId());
		this.request.setAttribute("areaName", fkAreaModel.getAreaName());
		this.setParameters(page_forward_showupdate_fkArea);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkAreaModel = fkAreaService.findById(this.getId());
		this.setParameters(page_forward_showdetail_fkArea);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = fkAreaService.save(fkAreaModel);
		FkAreaModel model = fkAreaService.findById(fkAreaModel.getFatherId());
		if (model != null && !model.getHasChildren()) {
			model.setHasChildren(true);
			fkAreaService.save(model);
		}
		this.setParameters(or.getMessage(), action_forward_managers_fkArea + "?fkAreaModel.fatherId=" + fkAreaModel.getFatherId());
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
		or = fkAreaService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkArea);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		fkAreaModels = fkAreaService.getCollection(fkAreaModel);
		this.setParameters(page_forward_tomanagers_fkArea);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkAreaModels = fkAreaService.getCollection(fkAreaModel);
		TableFacade tableFacade = new TableFacade("fkAreaModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "createDate", "isDeleted", "modifyDate", "sortNum", "areaCode", "areaName", "fatherId", "fiftharea", "firstarea", "fourtharea", "secondarea",
		        "thirdarea", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkAreaModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (fkAreaModel == null) {
			fkAreaModel = new FkAreaModel(request, "fkAreaModel");
		}
	}

	/**
	 * @return the fkAreaModel
	 */
	public FkAreaModel getFkAreaModel() {
		return fkAreaModel;
	}

	/**
	 * @param fkAreaModel
	 *            the fkAreaModel to set
	 */
	public void setFkAreaModel(FkAreaModel fkAreaModel) {
		this.fkAreaModel = fkAreaModel;
	}

	/**
	 * @return the fkAreaModels
	 */
	public List<FkAreaModel> getFkAreaModels() {
		return fkAreaModels;
	}

	/**
	 * @param fkAreaModels
	 *            the fkAreaModels to set
	 */
	public void setFkAreaModels(List<FkAreaModel> fkAreaModels) {
		this.fkAreaModels = fkAreaModels;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode
	 *            the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

}
