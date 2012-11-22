/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.system.model.FkEnumModel;
import com.safetys.framework.system.service.IFkEnumService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.ConfigUtil;
import com.safetys.framework.utils.FileUtils;
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
@Controller("fkEnumController")
public class FkEnumController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_fkEnum = "/template/system/FkEnum_Input.ftl";
	private static final String page_forward_showupdate_fkEnum = "/template/system/FkEnum_Input.ftl";
	private static final String page_forward_navigation_fkEnum = "/template/system/FkEnum_Frame.ftl";
	private static final String page_forward_showdetail_fkEnum = "/template/system/FkEnum_Detail.ftl";
	private static final String page_forward_tomanagers_fkEnum = "/template/system/FkEnum_Manager.ftl";
	private static final String action_forward_managers_fkEnum = "fkEnum_manager.xhtml";
	@Resource(name = "fkEnumService")
	private IFkEnumService fkEnumService;
	private FkEnumModel fkEnumModel;
	private List<FkEnumModel> fkEnumModels;

	/**
	 * 生成XML(暂提供四级)
	 * 
	 * @throws Exception
	 */
	public String builderXml() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		fkEnumModel.setFatherId(0l);
		fkEnumModels = fkEnumService.getCollection(fkEnumModel, new String[] { "id" }, false);
		if (fkEnumModels != null && fkEnumModels.size() > 0) {
			Document document = DocumentHelper.createDocument();
			Element element = document.addElement("fk-enum");
			for (FkEnumModel firstEnum : fkEnumModels) {
				Element first = element.addElement(firstEnum.getEnumCode());
				first.addAttribute("name", firstEnum.getEnumName());
				if (firstEnum.getHasChildren()) {
					fkEnumModel.setFatherId(firstEnum.getId());
					List<FkEnumModel> secondDatas = fkEnumService.getCollection(fkEnumModel, new String[] { "id" }, false);
					if (secondDatas != null && secondDatas.size() > 0) {
						for (FkEnumModel secondEnum : secondDatas) {
							Element second = first.addElement(secondEnum.getEnumCode());
							second.addAttribute("name", secondEnum.getEnumName());
							if (secondEnum.getHasChildren()) {
								fkEnumModel.setFatherId(secondEnum.getId());
								List<FkEnumModel> thirdDatas = fkEnumService.getCollection(fkEnumModel, new String[] { "id" }, false);
								if (thirdDatas != null && thirdDatas.size() > 0) {
									for (FkEnumModel thirdEnum : thirdDatas) {
										Element third = second.addElement(thirdEnum.getEnumCode());
										third.addAttribute("name", thirdEnum.getEnumName());
									}
								}
							}
						}
					}
				}
			}
			FileUtils.writerBufferToLocalFile(document.asXML(), ConfigUtil.getGlobalPropertyValue("file.release.dir") + File.separator + "enum.xml");
			this.response.getWriter().print("生成成功！");
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
			fkEnumModel.setFatherId(0l);
		} else {
			fkEnumModel.setFatherId(this.getId());
		}
		fkEnumModels = fkEnumService.getCollection(fkEnumModel, false);
		if (fkEnumModels != null && fkEnumModels.size() > 0) {
			for (FkEnumModel element : fkEnumModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getEnumName());
				treeModels.add(treeModel);
			}
			fkEnumModels.clear();
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
		fkEnumModel.setFatherId(0l);
		fkEnumModels = fkEnumService.getCollection(fkEnumModel, false);
		if (fkEnumModels != null && fkEnumModels.size() > 0) {
			for (FkEnumModel element : fkEnumModels) {
				treeModel = new TreeModel();
				treeModel.setId(element.getId());
				treeModel.setpId(element.getFatherId());
				treeModel.setName(element.getEnumName());
				treeModels.add(treeModel);
			}
			fkEnumModels.clear();
		}
		this.request.setAttribute("treeNodes", gson.toJson(treeModels));
		this.setParameters(page_forward_navigation_fkEnum);
		return SUCCESS;
	}

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		if (!AppUtils.isNullOrEmptyString(this.getId()) && this.getId() > 0) {
			FkEnumModel model = fkEnumService.findById(this.getId());
			fkEnumModel.setFatherId(this.getId());
			this.request.setAttribute("enumName", model.getEnumName());
		}
		this.setParameters(page_forward_showinsert_fkEnum);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkEnumModel = fkEnumService.findById(this.getId());
		this.request.setAttribute("enumName", fkEnumModel.getEnumName());
		this.setParameters(page_forward_showupdate_fkEnum);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		fkEnumModel = fkEnumService.findById(this.getId());
		this.setParameters(page_forward_showdetail_fkEnum);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = fkEnumService.save(fkEnumModel);
		FkEnumModel model = fkEnumService.findById(fkEnumModel.getFatherId());
		if (model != null && !model.getHasChildren()) {
			model.setHasChildren(true);
			fkEnumService.save(model);
		}
		this.setParameters(or.getMessage(), action_forward_managers_fkEnum + "?fkEnumModel.fatherId=" + fkEnumModel.getFatherId());
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
		or = fkEnumService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkEnum);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		if (AppUtils.isNullOrEmptyString(fkEnumModel.getFatherId())) {
			fkEnumModel.setFatherId(0l);
		}
		fkEnumModels = fkEnumService.getCollection(fkEnumModel);
		this.setParameters(page_forward_tomanagers_fkEnum);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkEnumModels = fkEnumService.getCollection(fkEnumModel);
		TableFacade tableFacade = new TableFacade("fkEnumModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "createDate", "isDeleted", "modifyDate", "sortNum", "enumCode", "enumDesc", "enumName", "fatherId", "fiftharea", "firstarea", "fourtharea",
		        "secondarea", "thirdarea", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkEnumModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (fkEnumModel == null) {
			fkEnumModel = new FkEnumModel(request, "fkEnumModel");
		}
	}

	/**
	 * @return the fkEnumModel
	 */
	public FkEnumModel getFkEnumModel() {
		return fkEnumModel;
	}

	/**
	 * @param fkEnumModel
	 *            the fkEnumModel to set
	 */
	public void setFkEnumModel(FkEnumModel fkEnumModel) {
		this.fkEnumModel = fkEnumModel;
	}

	/**
	 * @return the fkEnumModels
	 */
	public List<FkEnumModel> getFkEnumModels() {
		return fkEnumModels;
	}

	/**
	 * @param fkEnumModels
	 *            the fkEnumModels to set
	 */
	public void setFkEnumModels(List<FkEnumModel> fkEnumModels) {
		this.fkEnumModels = fkEnumModels;
	}
}
