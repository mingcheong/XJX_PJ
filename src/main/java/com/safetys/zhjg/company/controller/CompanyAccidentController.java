/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.controller;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.kernel.model.TreeModel;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkOrganizeService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.safetys.zhjg.company.model.CompanyAccidentModel;
import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.service.ICompanyAccidentService;
import com.safetys.zhjg.company.service.ICompanyInfoService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyAccidentController")
public class CompanyAccidentController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyAccident = "/template/company/CompanyAccident_Input.ftl";
	private static final String page_forward_showupdate_companyAccident = "/template/company/CompanyAccident_Input.ftl";
	private static final String page_forward_showdetail_companyAccident = "/template/company/CompanyAccident_Detail.ftl";
	private static final String page_forward_tomanagers_companyAccident = "/template/company/CompanyAccident_Manager.ftl";
	private static final String page_forward_managerList_companyAccident = "/template/company/CompanyAccident_ManagerList.ftl";
	private static final String page_forward_companyList_companyAccident = "/template/company/CompanyAccident_CompanyList.ftl";
	private static final String action_forward_managers_companyAccident = "companyAccident_manager.xhtml";
	@Resource(name = "companyAccidentService")
	private ICompanyAccidentService companyAccidentService;
	private CompanyAccidentModel companyAccidentModel;
	private List<CompanyAccidentModel> companyAccidentModels;

	@Resource(name = "companyInfoService")
	private ICompanyInfoService companyInfoService;
	private List<CompanyInfoModel> companyInfoModels;
	private CompanyInfoModel companyInfoModel;
	
	@Resource(name = "fkOrganizeService")
	private IFkOrganizeService fkOrganizeService;
	private FkOrganizeModel fkOrganizeModel;
	private List<FkOrganizeModel> fkOrganizeModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
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
		this.setParameters(page_forward_showinsert_companyAccident);
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
		companyAccidentModel = companyAccidentService.findById(this.getId());
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
		this.setParameters(page_forward_showupdate_companyAccident);
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
		companyAccidentModel = companyAccidentService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyAccident);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		long cId = companyAccidentModel.getAccidentUnit().getId();
		or = companyAccidentService.save(companyAccidentModel);
		this.setCompanyAccidentModel(null);
		this.setParameters(or.getMessage(),"companyAccident_managerList.xhtml?id=" + cId);
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
		or = companyAccidentService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),"companyAccident_managerList.xhtml?id=" + this.getId());//企业ID
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		/*companyAccidentModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyAccidentModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyAccidentModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyAccidentModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyAccidentModel.setFifthArea(this.getCurrentUser().getFifthArea());*/
		companyAccidentModels = companyAccidentService.getCompanyAccidentModels(this.getCurrentUser(),companyAccidentModel);
		this.setParameters(page_forward_tomanagers_companyAccident);
		return SUCCESS;
	}
	
	public String managerList() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		companyAccidentModels = companyAccidentService.getAccidentsByCompanyId(this.getId(),companyAccidentModel);
		this.setParameters(page_forward_managerList_companyAccident);
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
		this.setParameters(page_forward_companyList_companyAccident);
		return SUCCESS;
	}
	
	/**
	 * 通过AJAX取部门机构
	 * 
	 * @throws ActionException
	 * @throws IOException
	 */
	public String ajaxOrgan() throws Exception {
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
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyAccidentModels = companyAccidentService.getCollection(companyAccidentModel);
		TableFacade tableFacade = new TableFacade("companyAccidentModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"bigtype","accidentReportUnit","accidentContact","accidentUnit","accidentPhone","accidentType","accidentDuty","accidentLoss","accidentDate","accidentReportDate","totalNumber","deathNumber","missedNumber","seriovsWoundNumber","minorWoundNumber","casualtiesIds","casualtiesNames","accidentContent","isReport",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyAccidentModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyAccidentModel == null) {
			companyAccidentModel = new CompanyAccidentModel(request, "companyAccidentModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
		
		if (fkOrganizeModel == null) {
			fkOrganizeModel = new FkOrganizeModel(request, "fkOrganizeModel");
		}
	}
	
	/**
	 * @return the companyAccidentModel
	 */
	public CompanyAccidentModel getCompanyAccidentModel() {
		return companyAccidentModel;
	}

	/**
	 * @param companyAccidentModel the companyAccidentModel to set
	 */
	public void setCompanyAccidentModel(CompanyAccidentModel companyAccidentModel) {
		this.companyAccidentModel = companyAccidentModel;
	}

	/**
	 * @return the companyAccidentModels
	 */
	public List<CompanyAccidentModel> getCompanyAccidentModels() {
		return companyAccidentModels;
	}

	/**
	 * @param companyAccidentModels the companyAccidentModels to set
	 */
	public void setCompanyAccidentModels(List<CompanyAccidentModel> companyAccidentModels) {
		this.companyAccidentModels = companyAccidentModels;
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
	
	
	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}

	public List<FkOrganizeModel> getFkOrganizeModels() {
		return fkOrganizeModels;
	}

	public void setFkOrganizeModels(List<FkOrganizeModel> fkOrganizeModels) {
		this.fkOrganizeModels = fkOrganizeModels;
	}


}
