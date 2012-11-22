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

import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.model.CompanyProjectModel;
import com.safetys.zhjg.company.service.ICompanyInfoService;
import com.safetys.zhjg.company.service.ICompanyProjectService;

/**
 * 建设项目（三同时）
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyProjectController")
public class CompanyProjectController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyProject = "/template/company/CompanyProject_Input.ftl";
	private static final String page_forward_showupdate_companyProject = "/template/company/CompanyProject_Input.ftl";
	private static final String page_forward_showdetail_companyProject = "/template/company/CompanyProject_Detail.ftl";
	private static final String page_forward_tomanagers_companyProject = "/template/company/CompanyProject_Manager.ftl";
	private static final String page_forward_managerList_companyProject = "/template/company/CompanyProject_ManagerList.ftl";
	private static final String page_forward_companyList_companyProject = "/template/company/CompanyProject_CompanyList.ftl";
	private static final String action_forward_managers_companyProject = "companyProject_manager.xhtml";
	@Resource(name = "companyProjectService")
	private ICompanyProjectService companyProjectService;
	private CompanyProjectModel companyProjectModel;
	private List<CompanyProjectModel> companyProjectModels;

	@Resource(name = "companyInfoService")
	private ICompanyInfoService companyInfoService;
	private List<CompanyInfoModel> companyInfoModels;
	private CompanyInfoModel companyInfoModel;
	
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		
		this.setParameters(page_forward_showinsert_companyProject);
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
		companyProjectModel = companyProjectService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyProject);
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
		companyProjectModel = companyProjectService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyProject);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		long cId = companyProjectModel.getCompanyInfo().getId();
		or = companyProjectService.save(companyProjectModel);
		this.setCompanyProjectModel(null);
		this.setParameters(or.getMessage(),"companyProject_managerList.xhtml?id=" + cId);
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
		or = companyProjectService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),"companyProject_managerList.xhtml?id=" + this.getId());
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
	/*	companyProjectModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyProjectModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyProjectModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyProjectModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyProjectModel.setFifthArea(this.getCurrentUser().getFifthArea());*/
		companyProjectModels = companyProjectService.getCompanyProjectModels(this.getCurrentUser(),companyProjectModel);
		this.setParameters(page_forward_tomanagers_companyProject);
		return SUCCESS;
	}
	
	public String managerList() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		companyProjectModels =companyProjectService.getProjectByCompanyId(this.getId(),companyProjectModel);
		this.setParameters(page_forward_managerList_companyProject);
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
		this.setParameters(page_forward_companyList_companyProject);
		return SUCCESS;
	}
	
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyProjectModels = companyProjectService.getCollection(companyProjectModel);
		TableFacade tableFacade = new TableFacade("companyProjectModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"projectName","projectAddress","projectInvestment","projectType","facilitiesType","landType","content1","content2","content3","content4",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyProjectModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyProjectModel == null) {
			companyProjectModel = new CompanyProjectModel(request, "companyProjectModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}
	
	/**
	 * @return the companyProjectModel
	 */
	public CompanyProjectModel getCompanyProjectModel() {
		return companyProjectModel;
	}

	/**
	 * @param companyProjectModel the companyProjectModel to set
	 */
	public void setCompanyProjectModel(CompanyProjectModel companyProjectModel) {
		this.companyProjectModel = companyProjectModel;
	}

	/**
	 * @return the companyProjectModels
	 */
	public List<CompanyProjectModel> getCompanyProjectModels() {
		return companyProjectModels;
	}

	/**
	 * @param companyProjectModels the companyProjectModels to set
	 */
	public void setCompanyProjectModels(List<CompanyProjectModel> companyProjectModels) {
		this.companyProjectModels = companyProjectModels;
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
}
