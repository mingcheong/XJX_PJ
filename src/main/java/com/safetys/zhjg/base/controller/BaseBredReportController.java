/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.controller;

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
import com.safetys.zhjg.base.model.BaseBredReportModel;
import com.safetys.zhjg.base.service.IBaseBredReportService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseBredReportController")
public class BaseBredReportController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseBredReport = "/template/base/BaseBredReport_Input.ftl";
	private static final String page_forward_showupdate_baseBredReport = "/template/base/BaseBredReport_Input.ftl";
	private static final String page_forward_showdetail_baseBredReport = "/template/base/BaseBredReport_Detail.ftl";
	private static final String page_forward_tomanagers_baseBredReport = "/template/base/BaseBredReport_Manager.ftl";
	private static final String action_forward_managers_baseBredReport = "baseBredReport_manager.xhtml";
	@Resource(name = "baseBredReportService")
	private IBaseBredReportService baseBredReportService;
	private BaseBredReportModel baseBredReportModel;
	private List<BaseBredReportModel> baseBredReportModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_baseBredReport);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要修改的对象编号不可为空！");
        }
		baseBredReportModel = baseBredReportService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseBredReport);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要查看的对象编号不可为空！");
        }
		baseBredReportModel = baseBredReportService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseBredReport);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseBredReportModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseBredReportModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseBredReportModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseBredReportModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseBredReportModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseBredReportService.save(baseBredReportModel);
		this.setBaseBredReportModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseBredReport);
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * @throws ActionException
	 */
	public String remove() throws Exception {
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) { 
			throw new ActionException("将要删除的对象编号不可为空！");
		}
		or = baseBredReportService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseBredReport);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseBredReportModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseBredReportModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseBredReportModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseBredReportModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseBredReportModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseBredReportModels = baseBredReportService.getCollection(baseBredReportModel);
		this.setParameters(page_forward_tomanagers_baseBredReport);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseBredReportModels = baseBredReportService.getCollection(baseBredReportModel);
		TableFacade tableFacade = new TableFacade("baseBredReportModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"name","orgsId","isReport","reportDate",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseBredReportModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseBredReportModel == null) {
			baseBredReportModel = new BaseBredReportModel(request, "baseBredReportModel");
		}
	}
	
	/**
	 * @return the baseBredReportModel
	 */
	public BaseBredReportModel getBaseBredReportModel() {
		return baseBredReportModel;
	}

	/**
	 * @param baseBredReportModel the baseBredReportModel to set
	 */
	public void setBaseBredReportModel(BaseBredReportModel baseBredReportModel) {
		this.baseBredReportModel = baseBredReportModel;
	}

	/**
	 * @return the baseBredReportModels
	 */
	public List<BaseBredReportModel> getBaseBredReportModels() {
		return baseBredReportModels;
	}

	/**
	 * @param baseBredReportModels the baseBredReportModels to set
	 */
	public void setBaseBredReportModels(List<BaseBredReportModel> baseBredReportModels) {
		this.baseBredReportModels = baseBredReportModels;
	}
}
