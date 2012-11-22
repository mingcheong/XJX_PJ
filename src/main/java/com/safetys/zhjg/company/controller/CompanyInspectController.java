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
import com.safetys.zhjg.company.model.CompanyInspectModel;
import com.safetys.zhjg.company.service.ICompanyInfoService;
import com.safetys.zhjg.company.service.ICompanyInspectService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyInspectController")
public class CompanyInspectController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyInspect = "/template/company/CompanyInspect_Input.ftl";
	private static final String page_forward_showupdate_companyInspect = "/template/company/CompanyInspect_Input.ftl";
	private static final String page_forward_showdetail_companyInspect = "/template/company/CompanyInspect_Detail.ftl";
	private static final String page_forward_tolists_companyInspect = "/template/company/CompanyInspect_List.ftl";
	private static final String page_forward_tomanagers_companyInspect = "/template/company/CompanyInspect_Manager.ftl";
	private static final String page_forward_companyInfoManager_companyInspect = "/template/company/CompanyInspect_companyInfo_Manager.ftl";
	private static final String page_forward_inspectManager_companyInspect = "/template/company/CompanyInspect_inspectManager.ftl";
//	private static final String action_forward_managers_companyInspect = "companyInspect_manager.xhtml";
	private static final String action_forward_inspectManager_companyInspect = "companyInspect_inspectManager.xhtml";
	@Resource(name = "companyInspectService")
	private ICompanyInspectService companyInspectService;
	@Resource(name="companyInfoService")
	private ICompanyInfoService companyInfoService;
	
	private CompanyInspectModel companyInspectModel;
	private CompanyInfoModel companyInfoModel;
	
	private List<CompanyInspectModel> companyInspectModels;
	private List<CompanyInfoModel> companyInfoModels;
	
	/**
	 * 行政执法查询
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		companyInspectModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInspectModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInspectModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInspectModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInspectModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInspectModels = companyInspectService.getCollection(companyInspectModel);
		this.setParameters(page_forward_tolists_companyInspect);
		return SUCCESS;
	}

	/**
	 * 该企业下的执法记录
	 * @return
	 * @throws Exception
	 */
	public String inspectManager() throws Exception{
		companyInfoModel = companyInfoService.findById(getId());
		companyInspectModel.setCompanyInfoModel(companyInfoModel);
		companyInspectModels = companyInspectService.inspectManager(companyInspectModel);
		this.setParameters(page_forward_inspectManager_companyInspect);
		return SUCCESS;
	}
	
	/**
	 * 行政执法--企业列表
	 * @return
	 * @throws Exception
	 */
	public String companyInfoManager()throws Exception{
		companyInfoModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInfoModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInfoModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInfoModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInfoModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		this.setParameters(page_forward_companyInfoManager_companyInspect);
		return SUCCESS;
	}
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		String param = request.getParameter("param");
		companyInfoModel = companyInfoService.findById(Long.parseLong(param));
		companyInspectModel = new CompanyInspectModel();
		companyInspectModel.setCompanyInfoModel(companyInfoModel);
		this.setParameters(page_forward_showinsert_companyInspect);
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
		companyInspectModel = companyInspectService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyInspect);
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
		companyInspectModel = companyInspectService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyInspect);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		companyInspectModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInspectModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInspectModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInspectModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInspectModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = companyInspectService.save(companyInspectModel);
		companyInspectModel = (CompanyInspectModel)or.getResult();
		this.setParameters(or.getMessage(),action_forward_inspectManager_companyInspect+"?id="+companyInspectModel.getCompanyInfoModel().getId());
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
		or = companyInspectService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_inspectManager_companyInspect+"?id="+request.getParameter("param"));
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyInspectModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInspectModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInspectModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInspectModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInspectModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInspectModels = companyInspectService.getCollection(companyInspectModel);
		this.setParameters(page_forward_tomanagers_companyInspect);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyInspectModels = companyInspectService.getCollection(companyInspectModel);
		TableFacade tableFacade = new TableFacade("companyInspectModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"inspecttype","startdate","enddate","place","inspectors","recordors","enforceunit","remark",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyInspectModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyInspectModel == null) {
			companyInspectModel = new CompanyInspectModel(request, "companyInspectModel");
		}
		if(companyInfoModel == null){
			companyInfoModel = new CompanyInfoModel(request,"companyInfoModel");
		}
	}
	
	/**
	 * @return the companyInspectModel
	 */
	public CompanyInspectModel getCompanyInspectModel() {
		return companyInspectModel;
	}

	/**
	 * @param companyInspectModel the companyInspectModel to set
	 */
	public void setCompanyInspectModel(CompanyInspectModel companyInspectModel) {
		this.companyInspectModel = companyInspectModel;
	}

	/**
	 * @return the companyInspectModels
	 */
	public List<CompanyInspectModel> getCompanyInspectModels() {
		return companyInspectModels;
	}

	/**
	 * @param companyInspectModels the companyInspectModels to set
	 */
	public void setCompanyInspectModels(List<CompanyInspectModel> companyInspectModels) {
		this.companyInspectModels = companyInspectModels;
	}
	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}
	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}
	public List<CompanyInfoModel> getCompanyInfoModels() {
		return companyInfoModels;
	}
	public void setCompanyInfoModels(List<CompanyInfoModel> companyInfoModels) {
		this.companyInfoModels = companyInfoModels;
	}
}
