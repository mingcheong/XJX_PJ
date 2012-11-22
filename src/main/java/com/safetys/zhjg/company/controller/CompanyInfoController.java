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
import com.safetys.zhjg.company.service.ICompanyInfoService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 企业
 * 
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyInfoController")
public class CompanyInfoController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyInfo = "/template/company/CompanyInfo_Input.ftl";
	private static final String page_forward_showupdate_companyInfo = "/template/company/CompanyInfo_Input.ftl";
	private static final String page_forward_showdetail_GIS_companyInfo = "/template/company/CompanyInfo_DetailForGIS.ftl";
	private static final String page_forward_showdetail_companyInfo = "/template/company/CompanyInfo_Detail.ftl";
	private static final String page_forward_tolists_companyInfo = "/template/company/CompanyInfo_List.ftl";
	private static final String page_forward_tomanagers_companyInfo = "/template/company/CompanyInfo_Manager.ftl";
	private static final String action_forward_managers_companyInfo = "companyInfo_manager.xhtml";
	@Resource(name = "companyInfoService")
	private ICompanyInfoService companyInfoService;
	private CompanyInfoModel companyInfoModel;
	private List<CompanyInfoModel> companyInfoModels;

	/**
	 * 显示详情---GIS
	 * @throws ActionException
	 */
	public String detailForGIS() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) {
			throw new ActionException("将要查看的对象编号不可为空！");
        }
		companyInfoModel = companyInfoService.findById(this.getId());
		this.setParameters(page_forward_showdetail_GIS_companyInfo);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 隐患挂牌查询列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listingList()throws Exception{
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		this.setParameters(page_forward_tolists_companyInfo);
		return SUCCESS;
	}
	
	/**
	 * 查询列表
	 * 
	 * @throws ActionException
	 */
	public String list() throws Exception {
		companyInfoModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInfoModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInfoModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInfoModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInfoModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		this.setParameters(page_forward_tolists_companyInfo);
		return SUCCESS;
	}
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_companyInfo);
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
		companyInfoModel = companyInfoService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyInfo);
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
		companyInfoModel = companyInfoService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyInfo);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = companyInfoService.save(companyInfoModel);
		this.setCompanyInfoModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_companyInfo);
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
		or = companyInfoService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_companyInfo);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyInfoModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyInfoModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyInfoModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyInfoModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyInfoModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		this.setParameters(page_forward_tomanagers_companyInfo);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyInfoModels = companyInfoService.getCollection(companyInfoModel);
		TableFacade tableFacade = new TableFacade("companyInfoModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"companyName","address","registration","character","industrial","legalPerson","legalContact","principalPerson","principalMobile","staffNumber","safetyName","safetyMobile","migrantNumber","postsNumber","insure","insureNumber","outputNumber","isAgreement","isOrgs","safetyNumber","isDense","isFirekey","equipmentIds","facilities","isAccount","isDangerous","isChemicals","safetyStandards","isSafetyAccount","safetyRules",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyInfoModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}
	
	/**
	 * @return the companyInfoModel
	 */
	public CompanyInfoModel getCompanyInfoModel() {
		return companyInfoModel;
	}

	/**
	 * @param companyInfoModel the companyInfoModel to set
	 */
	public void setCompanyInfoModel(CompanyInfoModel companyInfoModel) {
		this.companyInfoModel = companyInfoModel;
	}

	/**
	 * @return the companyInfoModels
	 */
	public List<CompanyInfoModel> getCompanyInfoModels() {
		return companyInfoModels;
	}

	/**
	 * @param companyInfoModels the companyInfoModels to set
	 */
	public void setCompanyInfoModels(List<CompanyInfoModel> companyInfoModels) {
		this.companyInfoModels = companyInfoModels;
	}
}
