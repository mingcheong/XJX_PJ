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
import com.safetys.zhjg.company.model.CompanyTrainModel;
import com.safetys.zhjg.company.service.ICompanyInfoService;
import com.safetys.zhjg.company.service.ICompanyTrainService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyTrainController")
public class CompanyTrainController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyTrain = "/template/company/CompanyTrain_Input.ftl";
	private static final String page_forward_showupdate_companyTrain = "/template/company/CompanyTrain_Input.ftl";
	private static final String page_forward_showdetail_companyTrain = "/template/company/CompanyTrain_Detail.ftl";
	private static final String page_forward_tomanagers_companyTrain = "/template/company/CompanyTrain_Manager.ftl";
	private static final String page_forward_managerList_companyTrain = "/template/company/CompanyTrain_ManagerList.ftl";
	private static final String page_forward_companyList_companyTrain = "/template/company/CompanyTrain_CompanyList.ftl";
	private static final String action_forward_managers_companyTrain = "companyTrain_manager.xhtml";
	@Resource(name = "companyTrainService")
	private ICompanyTrainService companyTrainService;
	private CompanyTrainModel companyTrainModel;
	private List<CompanyTrainModel> companyTrainModels;
	
	
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
		this.setParameters(page_forward_showinsert_companyTrain);
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
		companyTrainModel = companyTrainService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyTrain);
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
		companyTrainModel = companyTrainService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyTrain);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		long cId = companyTrainModel.getCompanyInfo().getId();
		or = companyTrainService.save(companyTrainModel);
		this.setCompanyTrainModel(null);
		this.setParameters(or.getMessage(),"companyTrain_managerList.xhtml?id=" + cId);
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
		or = companyTrainService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),"companyTrain_managerList.xhtml?id=" + this.getId());
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		
		companyTrainModels = companyTrainService.getCompanyTrainModels(this.getCurrentUser(),companyTrainModel);
		this.setParameters(page_forward_tomanagers_companyTrain);
		return SUCCESS;
	}
	
	/**
	 * 针对某一个企业的企业管理列表
	 * 
	 * @throws ActionException
	 */
	public String managerList() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		companyTrainModels = companyTrainService.getTrainByCompanyId(this.getId(), companyTrainModel);
		this.setParameters(page_forward_managerList_companyTrain);
		return SUCCESS;
	}
	
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyTrainModels = companyTrainService.getCollection(companyTrainModel);
		TableFacade tableFacade = new TableFacade("companyTrainModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"companyId","personName","personIdcard","personPhone","certificateCode","score","state",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyTrainModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	 
	 /**
	  * 企业列表
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
		this.setParameters(page_forward_companyList_companyTrain);
		return SUCCESS;
	}
	
	
	public void prepare() throws Exception {
		if (companyTrainModel == null) {
			companyTrainModel = new CompanyTrainModel(request, "companyTrainModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}
	
	/**
	 * @return the companyTrainModel
	 */
	public CompanyTrainModel getCompanyTrainModel() {
		return companyTrainModel;
	}

	/**
	 * @param companyTrainModel the companyTrainModel to set
	 */
	public void setCompanyTrainModel(CompanyTrainModel companyTrainModel) {
		this.companyTrainModel = companyTrainModel;
	}

	/**
	 * @return the companyTrainModels
	 */
	public List<CompanyTrainModel> getCompanyTrainModels() {
		return companyTrainModels;
	}

	/**
	 * @param companyTrainModels the companyTrainModels to set
	 */
	public void setCompanyTrainModels(List<CompanyTrainModel> companyTrainModels) {
		this.companyTrainModels = companyTrainModels;
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
