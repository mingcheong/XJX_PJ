/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.controller;

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
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.model.CompanyLicensingModel;
import com.safetys.zhjg.company.service.ICompanyInfoService;
import com.safetys.zhjg.company.service.ICompanyLicensingService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyLicensingController")
public class CompanyLicensingController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyLicensing = "/template/company/CompanyLicensing_Input.ftl";
	private static final String page_forward_showupdate_companyLicensing = "/template/company/CompanyLicensing_Input.ftl";
	private static final String page_forward_showdetail_companyLicensing = "/template/company/CompanyLicensing_Detail.ftl";
	private static final String page_forward_tomanagers_companyLicensing = "/template/company/CompanyLicensing_Manager.ftl";
	private static final String page_forward_managerList_companyLicensing = "/template/company/CompanyLicensing_ManagerList.ftl";
	private static final String page_forward_companyList_companyLicensing = "/template/company/CompanyLicensing_CompanyList.ftl";
	private static final String action_forward_managers_companyLicensing = "companyLicensing_manager.xhtml";
	@Resource(name = "companyLicensingService")
	private ICompanyLicensingService companyLicensingService;
	@Resource(name = "companyInfoService")
	private ICompanyInfoService companyInfoService;

	private CompanyLicensingModel companyLicensingModel;
	private List<CompanyLicensingModel> companyLicensingModels;
	private List<CompanyInfoModel> companyInfoModels;
	private CompanyInfoModel companyInfoModel;

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		this.setParameters(page_forward_showinsert_companyLicensing);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		companyLicensingModel = companyLicensingService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyLicensing);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要查看的对象编号不可为空！"); }
		companyLicensingModel = companyLicensingService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyLicensing);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		long cId = companyLicensingModel.getCompanyInfo().getId();
		or = companyLicensingService.save(companyLicensingModel);
		this.setCompanyLicensingModel(null);
		this.setParameters(or.getMessage(), "companyLicensing_managerList.xhtml?id=" + cId);
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * s
	 * @throws ActionException
	 */
	public String remove() throws Exception {
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) { throw new ActionException("将要删除的对象编号不可为空！"); }
		or = companyLicensingService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), "companyLicensing_managerList.xhtml?id=" + this.getId());
		return SUCCESS;
	}

	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String managerList() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		companyLicensingModels = companyLicensingService.getLicensinByCompanyId(this.getId(), companyLicensingModel);
		this.setParameters(page_forward_managerList_companyLicensing);
		return SUCCESS;
	}

	public String manager() throws Exception {
		companyLicensingModels = companyLicensingService.getCompanyLicensingModels(this.getCurrentUser(), companyLicensingModel);
		this.setParameters(page_forward_tomanagers_companyLicensing);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyLicensingModels = companyLicensingService.getCollection(companyLicensingModel);
		TableFacade tableFacade = new TableFacade("companyLicensingModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "companyId", "companyChief", "economicType", "companyLeavel", "certificateNumber", "standardType", "validityBegin", "validityEnd", "issueDate",
		        "issueUnit", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyLicensingModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	/**
	 * 企业列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String companyList() throws Exception {
		companyInfoModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInfoModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInfoModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInfoModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInfoModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		this.setParameters(page_forward_companyList_companyLicensing);
		return SUCCESS;
	}

	public void prepare() throws Exception {
		if (companyLicensingModel == null) {
			companyLicensingModel = new CompanyLicensingModel(request, "companyLicensingModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}

	/**
	 * @return the companyLicensingModel
	 */
	public CompanyLicensingModel getCompanyLicensingModel() {
		return companyLicensingModel;
	}

	/**
	 * @param companyLicensingModel
	 *            the companyLicensingModel to set
	 */
	public void setCompanyLicensingModel(CompanyLicensingModel companyLicensingModel) {
		this.companyLicensingModel = companyLicensingModel;
	}

	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}

	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}

	/**
	 * @return the companyLicensingModels
	 */
	public List<CompanyLicensingModel> getCompanyLicensingModels() {
		return companyLicensingModels;
	}

	/**
	 * @param companyLicensingModels
	 *            the companyLicensingModels to set
	 */
	public void setCompanyLicensingModels(List<CompanyLicensingModel> companyLicensingModels) {
		this.companyLicensingModels = companyLicensingModels;
	}

	public List<CompanyInfoModel> getCompanyInfoModels() {
		return companyInfoModels;
	}

	public void setCompanyInfoModels(List<CompanyInfoModel> companyInfoModels) {
		this.companyInfoModels = companyInfoModels;
	}

}
