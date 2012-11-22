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

import com.safetys.zhjg.company.model.CompanyHiddendangerModel;
import com.safetys.zhjg.company.model.CompanyHiddenlistingModel;
import com.safetys.zhjg.company.service.ICompanyHiddendangerService;
import com.safetys.zhjg.company.service.ICompanyHiddenlistingService;

/**
 * 隐患挂牌控制器
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyHiddenlistingController")
public class CompanyHiddenlistingController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyHiddenlisting = "/template/company/CompanyHiddenlisting_Input.ftl";
	private static final String page_forward_showupdate_companyHiddenlisting = "/template/company/CompanyHiddenlisting_Input.ftl";
	private static final String page_forward_showdetail_companyHiddenlisting = "/template/company/CompanyHiddenlisting_Detail.ftl";
	private static final String page_forward_tomanagers_companyHiddenlisting = "/template/company/CompanyHiddenlisting_Manager.ftl";
	private static final String action_forward_managers_companyHiddenlisting = "companyHiddenlisting_hiddendangerSearch.xhtml";
	private static final String page_forward_tohiddenlistingmanagers_companyHiddenlisting = "/template/company/CompanyHiddendanger_Hiddenlisting_Manager.ftl";
	@Resource(name = "companyHiddenlistingService")
	private ICompanyHiddenlistingService companyHiddenlistingService;
	@Resource(name = "companyHiddendangerService")
	private ICompanyHiddendangerService companyHiddendangerService;
	private CompanyHiddenlistingModel companyHiddenlistingModel;
	private CompanyHiddendangerModel companyHiddendangerModel;
	private List<CompanyHiddenlistingModel> companyHiddenlistingModels;
	private List<CompanyHiddendangerModel> companyHiddendangerModels;

	/**
	 * 隐患挂牌
	 * @return
	 * @throws Exception
	 */
	public String hiddendangerSearch()throws Exception{
		companyHiddendangerModels = companyHiddendangerService.getCollection(companyHiddendangerModel);
		this.setParameters(page_forward_tohiddenlistingmanagers_companyHiddenlisting);
		return SUCCESS;
	}
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_companyHiddenlisting);
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
		companyHiddenlistingModel = companyHiddenlistingService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyHiddenlisting);
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
		companyHiddenlistingModel = companyHiddenlistingService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyHiddenlisting);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = companyHiddenlistingService.save(companyHiddenlistingModel);
		this.setCompanyHiddenlistingModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_companyHiddenlisting);
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
		or = companyHiddenlistingService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_companyHiddenlisting);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyHiddenlistingModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyHiddenlistingModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyHiddenlistingModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyHiddenlistingModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyHiddenlistingModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyHiddenlistingModels = companyHiddenlistingService.getCollection(companyHiddenlistingModel);
		this.setParameters(page_forward_tomanagers_companyHiddenlisting);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyHiddenlistingModels = companyHiddenlistingService.getCollection(companyHiddenlistingModel);
		TableFacade tableFacade = new TableFacade("companyHiddenlistingModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"level","orgsId","supervise","completionDate",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyHiddenlistingModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyHiddenlistingModel == null) {
			companyHiddenlistingModel = new CompanyHiddenlistingModel(request, "companyHiddenlistingModel");
		}
		if (companyHiddendangerModel == null) {
			companyHiddendangerModel = new CompanyHiddendangerModel(request, "companyHiddendangerModel");
		}
	}
	
	/**
	 * @return the companyHiddenlistingModel
	 */
	public CompanyHiddenlistingModel getCompanyHiddenlistingModel() {
		return companyHiddenlistingModel;
	}

	/**
	 * @param companyHiddenlistingModel the companyHiddenlistingModel to set
	 */
	public void setCompanyHiddenlistingModel(CompanyHiddenlistingModel companyHiddenlistingModel) {
		this.companyHiddenlistingModel = companyHiddenlistingModel;
	}

	/**
	 * @return the companyHiddenlistingModels
	 */
	public List<CompanyHiddenlistingModel> getCompanyHiddenlistingModels() {
		return companyHiddenlistingModels;
	}

	/**
	 * @param companyHiddenlistingModels the companyHiddenlistingModels to set
	 */
	public void setCompanyHiddenlistingModels(List<CompanyHiddenlistingModel> companyHiddenlistingModels) {
		this.companyHiddenlistingModels = companyHiddenlistingModels;
	}

	public CompanyHiddendangerModel getCompanyHiddendangerModel() {
		return companyHiddendangerModel;
	}

	public void setCompanyHiddendangerModel(
			CompanyHiddendangerModel companyHiddendangerModel) {
		this.companyHiddendangerModel = companyHiddendangerModel;
	}

	public List<CompanyHiddendangerModel> getCompanyHiddendangerModels() {
		return companyHiddendangerModels;
	}

	public void setCompanyHiddendangerModels(
			List<CompanyHiddendangerModel> companyHiddendangerModels) {
		this.companyHiddendangerModels = companyHiddendangerModels;
	}
}
