/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
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
import com.safetys.framework.system.model.FkOrganizeModel;
import com.safetys.framework.system.service.IFkOrganizeService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.zhjg.company.model.CompanyHiddendangerModel;
import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.service.ICompanyHiddendangerService;
import com.safetys.zhjg.company.service.ICompanyInfoService;

/**
 * 重大危险源控制器 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyHiddendangerController")
public class CompanyHiddendangerController extends BaseController implements
		Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyHiddendanger = "/template/company/CompanyHiddendanger_Input.ftl";
	private static final String page_forward_showupdate_companyHiddendanger = "/template/company/CompanyHiddendanger_Input.ftl";
	private static final String page_forward_showdetail_companyHiddendanger = "/template/company/CompanyHiddendanger_Detail.ftl";
	private static final String page_forward_showlistingdetail_companyHiddendanger = "/template/company/CompanyHiddendanger_Listing_Detail.ftl";
	private static final String page_forward_tolists_companyHiddendanger = "/template/company/CompanyHiddendanger_List.ftl";
	private static final String page_forward_tomanagers_companyHiddendanger = "/template/company/CompanyHiddendanger_Manager.ftl";
	private static final String page_forward_hiddenListing_companyHiddendanger = "/template/company/CompanyHiddendanger_Listing_Input.ftl";
	private static final String page_forward_listinglists_companyInfo = "/template/company/CompanyHiddendanger_listing_List.ftl";
	private static final String page_forward_listingmanagers_companyInfo = "/template/company/CompanyHiddendanger_listing_Manager.ftl";
	private static final String page_forward_todiddendengermanagers_companyInfo = "/template/company/CompanyInfo_Hiddendanger_Manager.ftl";
	private static final String action_forward_listing_managers_companyHiddendanger = "companyHiddendanger_hiddenListingManager.xhtml";
//	private static final String action_forward_hidden_managers_companyHiddendanger = "companyHiddendanger_companySerach.xhtml";
	private static final String action_forward_managers_companyHiddendanger = "companyHiddendanger_manager.xhtml";
	private static final String PAGE_COMPANYHIDDEN_COMPANYHIDDENDANGER = "/template/company/CompanyHiddendanger_companyHidden.ftl";
	@Resource(name = "companyInfoService")
	private ICompanyInfoService companyInfoService;
	@Resource(name = "companyHiddendangerService")
	private ICompanyHiddendangerService companyHiddendangerService;
	@Resource(name="fkOrganizeService")
	private IFkOrganizeService fkOrganizeService;
	
	private CompanyInfoModel companyInfoModel;
	private CompanyHiddendangerModel companyHiddendangerModel;
	private FkOrganizeModel fkOrganizeModel;
	
	private List<CompanyInfoModel> companyInfoModels;
	private List<CompanyHiddendangerModel> companyHiddendangerModels;
	private List<FkOrganizeModel> fkOrganizeModels;
	
	
	/**
	 * 挂牌查询列表
	 * @return
	 * @throws Exception
	 */
	public String listingList() throws Exception{
		companyHiddendangerModels = companyHiddendangerService.getCompanyHiddendangerListingModels(companyHiddendangerModel);
		this.setParameters(page_forward_listinglists_companyInfo);
		return SUCCESS;
	}
	
	/**
	 * 重大危险源 浏览查询列表
	 * 
	 * @throws ActionException
	 */
	public String list() throws Exception {
		companyHiddendangerModels = companyHiddendangerService.getCompanyHiddendangerModels(companyHiddendangerModel);
		this.setParameters(page_forward_tolists_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 挂牌详情
	 * @return
	 * @throws Exception
	 */
	public String hiddenListingDetail() throws Exception{
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要查看的对象编号不可为空！");
		}
		companyHiddendangerModel = companyHiddendangerService.findById(this
				.getId());
		this.setParameters(page_forward_showlistingdetail_companyHiddendanger);
		return SUCCESS;
	}
	
	/**
	 * 删除隐患挂牌
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delHiddenListing() throws Exception{
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) {
			throw new ActionException("将要删除的对象编号不可为空！");
		}
		or = companyHiddendangerService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),
				action_forward_managers_companyHiddendanger);
		return SUCCESS;
	}
	
	
	/**
	 * 删除隐患
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delHidden() throws Exception{
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) {
			throw new ActionException("将要删除的对象编号不可为空！");
		}
		or = companyHiddendangerService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),
				"companyHiddendanger_companyHidden.xhtml?id="+request.getParameter("param"));
		return SUCCESS;
	}
	
	/**
	 * 修改导航--挂牌
	 * 
	 * @throws ActionException
	 */
	public String listingModify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要修改的对象编号不可为空！");
		}
		companyHiddendangerModel = companyHiddendangerService.findById(this
				.getId());
		this.setParameters(page_forward_showupdate_companyHiddendanger);
		return SUCCESS;
	}
	
	/**
	 * 修改导航--隐患
	 * 
	 * @throws ActionException
	 */
	public String hiddenModify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要修改的对象编号不可为空！");
		}
		companyHiddendangerModel = companyHiddendangerService.findById(this
				.getId());
		this.setParameters(page_forward_showupdate_companyHiddendanger);
		return SUCCESS;
	}
	
	/**
	 * 企业隐患列表
	 * @return
	 * @throws Exception
	 */
	public String companyHidden()throws Exception{
		companyInfoModel = companyInfoService.findById(getId());
		companyHiddendangerModel.setCompanyInfoModel(companyInfoModel);
		companyHiddendangerModels = companyHiddendangerService.companyHidden(companyHiddendangerModel);
		this.setParameters(PAGE_COMPANYHIDDEN_COMPANYHIDDENDANGER);
		return SUCCESS;
	}
	
	
	/**
	 * 隐患挂牌--挂牌列表
	 * @return
	 * @throws Exception
	 */
	public String hiddenListingManager()throws Exception{
		companyHiddendangerModels = companyHiddendangerService.getCompanyHiddendangerModels(companyHiddendangerModel);
		this.setParameters(page_forward_listingmanagers_companyInfo);
		return SUCCESS;
	}
	
	/**
	 * 挂牌
	 * @return
	 * @throws Exception
	 */
	public String addHiddenListing() throws Exception{
		OperateResult or = null;
		or = companyHiddendangerService.save(companyHiddendangerModel);
		this.setCompanyHiddendangerModel(null);
		this.setParameters(or.getMessage(),
				action_forward_listing_managers_companyHiddendanger);
		return SUCCESS;
	}
	
	/**
	 * 添加隐患
	 * @return
	 * @throws Exception
	 */
	public String addHidden() throws Exception{
		OperateResult or = null;
		Long cidLong= companyHiddendangerModel.getCompanyInfoModel().getId();
		or = companyHiddendangerService.save(companyHiddendangerModel);
//		this.setCompanyHiddendangerModel(null);
		this.setParameters(or.getMessage(),
				"companyHiddendanger_companyHidden.xhtml?id="+cidLong);
		return SUCCESS;
	}
	
	/**
	 * 挂牌导航
	 * @return
	 * @throws Exception
	 */
	public String hiddenListing() throws Exception{
		
		fkOrganizeModels = fkOrganizeService.getCollection(new FkOrganizeModel(),new String[]{"id,sortNum"},false);
		companyHiddendangerModel = companyHiddendangerService.findById(this.getId());
		this.setParameters(page_forward_hiddenListing_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 隐患企业列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String companySerach() throws Exception {
		companyInfoModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInfoModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInfoModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInfoModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInfoModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		this.setParameters(page_forward_todiddendengermanagers_companyInfo);
		return SUCCESS;
	}

	/**
	 * 添加导航
	 * 
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		companyInfoModel =  companyInfoService.findById(Long.parseLong(request.getParameter("param")));
		if(companyHiddendangerModel==null){
			companyHiddendangerModel = new CompanyHiddendangerModel();
		}
		companyHiddendangerModel.setCompanyInfoModel(companyInfoModel);
		companyHiddendangerModel.setCode(companyHiddendangerService.buildCode(companyHiddendangerModel));
		this.setParameters(page_forward_showinsert_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要修改的对象编号不可为空！");
		}
		companyHiddendangerModel = companyHiddendangerService.findById(this
				.getId());
		this.setParameters(page_forward_showupdate_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要查看的对象编号不可为空！");
		}
		companyHiddendangerModel = companyHiddendangerService.findById(this
				.getId());
		this.setParameters(page_forward_showdetail_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 保存到数据--挂牌
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = companyHiddendangerService.save(companyHiddendangerModel);
		this.setCompanyHiddendangerModel(null);
		this.setParameters(or.getMessage(),
				action_forward_managers_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * 
	 * @throws ActionException
	 */
	public String remove() throws Exception {
		OperateResult or = null;
		if (AppUtils.isNullOrEmptyString(this.getSelectedIds())) {
			throw new ActionException("将要删除的对象编号不可为空！");
		}
		or = companyHiddendangerService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),
				action_forward_managers_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyHiddendangerModel.setFirstArea(this.getCurrentUser()
				.getFirstArea());
		companyHiddendangerModel.setSecondArea(this.getCurrentUser()
				.getSecondArea());
		companyHiddendangerModel.setThirdArea(this.getCurrentUser()
				.getThirdArea());
		companyHiddendangerModel.setFourthArea(this.getCurrentUser()
				.getFourthArea());
		companyHiddendangerModel.setFifthArea(this.getCurrentUser()
				.getFifthArea());
		companyHiddendangerModels = companyHiddendangerService
				.getCollection(companyHiddendangerModel);
		this.setParameters(page_forward_tomanagers_companyHiddendanger);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyHiddendangerModels = companyHiddendangerService
				.getCollection(companyHiddendangerModel);
		TableFacade tableFacade = new TableFacade("companyHiddendangerModel",
				request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF,
				ExportType.CSV);
		String[] columns = { "companyId", "code", "isAbove", "dangerAddress",
				"dangerContact", "dangerPhone", "dangerMobile",
				"dangerContent", "dangerType", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyHiddendangerModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (companyHiddendangerModel == null) {
			companyHiddendangerModel = new CompanyHiddendangerModel(request, "companyHiddendangerModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}

	/**
	 * @return the companyHiddendangerModel
	 */
	public CompanyHiddendangerModel getCompanyHiddendangerModel() {
		return companyHiddendangerModel;
	}

	/**
	 * @param companyHiddendangerModel
	 *            the companyHiddendangerModel to set
	 */
	public void setCompanyHiddendangerModel(
			CompanyHiddendangerModel companyHiddendangerModel) {
		this.companyHiddendangerModel = companyHiddendangerModel;
	}

	/**
	 * @return the companyHiddendangerModels
	 */
	public List<CompanyHiddendangerModel> getCompanyHiddendangerModels() {
		return companyHiddendangerModels;
	}

	/**
	 * @param companyHiddendangerModels
	 *            the companyHiddendangerModels to set
	 */
	public void setCompanyHiddendangerModels(
			List<CompanyHiddendangerModel> companyHiddendangerModels) {
		this.companyHiddendangerModels = companyHiddendangerModels;
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
