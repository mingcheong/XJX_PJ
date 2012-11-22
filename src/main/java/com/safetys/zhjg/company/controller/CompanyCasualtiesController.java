/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.controller;

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
import com.safetys.zhjg.company.model.CompanyCasualtiesModel;
import com.safetys.zhjg.company.service.ICompanyCasualtiesService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyCasualtiesController")
public class CompanyCasualtiesController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyCasualties = "/template/company/CompanyCasualties_Input.ftl";
	private static final String page_forward_showupdate_companyCasualties = "/template/company/CompanyCasualties_Input.ftl";
	private static final String page_forward_showdetail_companyCasualties = "/template/company/CompanyCasualties_Detail.ftl";
	private static final String page_forward_tomanagers_companyCasualties = "/template/company/CompanyCasualties_Manager.ftl";
	private static final String action_forward_managers_companyCasualties = "companyCasualties_manager.xhtml";
	@Resource(name = "companyCasualtiesService")
	private ICompanyCasualtiesService companyCasualtiesService;
	private CompanyCasualtiesModel companyCasualtiesModel;
	private List<CompanyCasualtiesModel> companyCasualtiesModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_companyCasualties);
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
		companyCasualtiesModel = companyCasualtiesService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyCasualties);
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
		companyCasualtiesModel = companyCasualtiesService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyCasualties);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = companyCasualtiesService.save(companyCasualtiesModel);
		this.setCompanyCasualtiesModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_companyCasualties);
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
		or = companyCasualtiesService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_companyCasualties);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyCasualtiesModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyCasualtiesModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyCasualtiesModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyCasualtiesModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyCasualtiesModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyCasualtiesModels = companyCasualtiesService.getCollection(companyCasualtiesModel);
		this.setParameters(page_forward_tomanagers_companyCasualties);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyCasualtiesModels = companyCasualtiesService.getCollection(companyCasualtiesModel);
		TableFacade tableFacade = new TableFacade("companyCasualtiesModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"id","name","sex","age","idcard","address",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyCasualtiesModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyCasualtiesModel == null) {
			companyCasualtiesModel = new CompanyCasualtiesModel(request, "companyCasualtiesModel");
		}
	}
	
	/**
	 * @return the companyCasualtiesModel
	 */
	public CompanyCasualtiesModel getCompanyCasualtiesModel() {
		return companyCasualtiesModel;
	}

	/**
	 * @param companyCasualtiesModel the companyCasualtiesModel to set
	 */
	public void setCompanyCasualtiesModel(CompanyCasualtiesModel companyCasualtiesModel) {
		this.companyCasualtiesModel = companyCasualtiesModel;
	}

	/**
	 * @return the companyCasualtiesModels
	 */
	public List<CompanyCasualtiesModel> getCompanyCasualtiesModels() {
		return companyCasualtiesModels;
	}

	/**
	 * @param companyCasualtiesModels the companyCasualtiesModels to set
	 */
	public void setCompanyCasualtiesModels(List<CompanyCasualtiesModel> companyCasualtiesModels) {
		this.companyCasualtiesModels = companyCasualtiesModels;
	}
}
