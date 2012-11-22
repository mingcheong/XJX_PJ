/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
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

import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.model.CompanyStandardModel;
import com.safetys.zhjg.company.service.ICompanyInfoService;
import com.safetys.zhjg.company.service.ICompanyStandardService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyStandardController")
public class CompanyStandardController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyStandard = "/template/company/CompanyStandard_Input.ftl";
	private static final String page_forward_showupdate_companyStandard = "/template/company/CompanyStandard_Input.ftl";
	private static final String page_forward_showdetail_companyStandard = "/template/company/CompanyStandard_Detail.ftl";
	private static final String page_forward_tomanagers_companyStandard = "/template/company/CompanyStandard_Manager.ftl";
	private static final String page_forward_managerList_companyStandard = "/template/company/CompanyStandard_ManagerList.ftl";
	private static final String page_forward_companyList_ccompanyStandard = "/template/company/CompanyStandard_CompanyList.ftl";
	private static final String action_forward_managers_companyStandard = "companyStandard_manager.xhtml";
	@Resource(name = "companyStandardService")
	private ICompanyStandardService companyStandardService;
	private CompanyStandardModel companyStandardModel;
	private List<CompanyStandardModel> companyStandardModels;

	@Resource(name = "companyInfoService")
	private ICompanyInfoService companyInfoService;
	private List<CompanyInfoModel> companyInfoModels;
	private CompanyInfoModel companyInfoModel;

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		this.setParameters(page_forward_showinsert_companyStandard);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		companyStandardModel = companyStandardService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyStandard);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要查看的对象编号不可为空！"); }
		companyStandardModel = companyStandardService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyStandard);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		long cId = companyStandardModel.getCompanyInfo().getId();
		companyStandardModel.setCompanyChief("");
		or = companyStandardService.save(companyStandardModel);
		this.setCompanyStandardModel(null);
		this.setParameters(or.getMessage(), "companyStandard_managerList.xhtml?id=" + cId);
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
		or = companyStandardService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), "companyStandard_managerList.xhtml?id=" + this.getId());
		return SUCCESS;
	}

	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		
		companyStandardModels = companyStandardService.getCompanyStandardModels(this.getCurrentUser(), companyStandardModel);
		this.setParameters(page_forward_tomanagers_companyStandard);
		return SUCCESS;
	}

	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String managerList() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		companyStandardModels = companyStandardService.getStandardByCompanyId(this.getId(), companyStandardModel);
		this.setParameters(page_forward_managerList_companyStandard);
		return SUCCESS;
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
		this.setParameters(page_forward_companyList_ccompanyStandard);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyStandardModels = companyStandardService.getCollection(companyStandardModel);
		TableFacade tableFacade = new TableFacade("companyStandardModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "companyId", "companyChief", "economicType", "companyLeavel", "certificateNumber", "standardType", "validityBegin", "validityEnd", "issueDate",
		        "issueUnit", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyStandardModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (companyStandardModel == null) {
			companyStandardModel = new CompanyStandardModel(request, "companyStandardModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}

	public List<CompanyInfoModel> getCompanyInfoModels() {
		return companyInfoModels;
	}

	public void setCompanyInfoModels(List<CompanyInfoModel> companyInfoModels) {
		this.companyInfoModels = companyInfoModels;
	}

	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}

	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}

	/**
	 * @return the companyStandardModel
	 */
	public CompanyStandardModel getCompanyStandardModel() {
		return companyStandardModel;
	}

	/**
	 * @param companyStandardModel
	 *            the companyStandardModel to set
	 */
	public void setCompanyStandardModel(CompanyStandardModel companyStandardModel) {
		this.companyStandardModel = companyStandardModel;
	}

	/**
	 * @return the companyStandardModels
	 */
	public List<CompanyStandardModel> getCompanyStandardModels() {
		return companyStandardModels;
	}

	/**
	 * @param companyStandardModels
	 *            the companyStandardModels to set
	 */
	public void setCompanyStandardModels(List<CompanyStandardModel> companyStandardModels) {
		this.companyStandardModels = companyStandardModels;
	}
}
