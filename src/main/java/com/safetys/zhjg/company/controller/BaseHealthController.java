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
import com.safetys.zhjg.company.model.BaseHealthModel;
import com.safetys.zhjg.company.model.CompanyInfoModel;
import com.safetys.zhjg.company.service.IBaseHealthService;
import com.safetys.zhjg.company.service.ICompanyInfoService;

/**
 * 职业健康防治
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseHealthController")
public class BaseHealthController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseHealth = "/template/company/BaseHealth_Input.ftl";
	private static final String page_forward_showupdate_baseHealth = "/template/company/BaseHealth_Input.ftl";
	private static final String page_forward_showdetail_baseHealth = "/template/company/BaseHealth_Detail.ftl";
	private static final String page_forward_tomanagers_baseHealth = "/template/company/BaseHealth_Manager.ftl";
	private static final String page_forward_managerList_baseHealth = "/template/company/BaseHealth_ManagerList.ftl";
    private static final String page_forward_companyList_baseHealth = "/template/company/BaseHealth_companyList.ftl";
	private static final String action_forward_managers_baseHealth = "baseHealth_manager.xhtml";
	@Resource(name = "baseHealthService")
	private IBaseHealthService baseHealthService;
	private BaseHealthModel baseHealthModel;
	private List<BaseHealthModel> baseHealthModels;
	
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
		this.setParameters(page_forward_showinsert_baseHealth);
		return SUCCESS;
	}

	/**
	 * 修改导航
	 * 
	 * @throws ActionException
	 */
	public String modify() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要修改的对象编号不可为空！"); }
		baseHealthModel = baseHealthService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseHealth);
		return SUCCESS;
	}

	/**
	 * 显示详情
	 * 
	 * @throws ActionException
	 */
	public String detail() throws Exception {
		if (AppUtils.isNullOrEmptyString(this.getId())) { throw new ActionException("将要查看的对象编号不可为空！"); }
		baseHealthModel = baseHealthService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseHealth);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * 
	 * @throws ActionException
	 */
	public String save() throws Exception {
		long cId = baseHealthModel.getCompanyInfo().getId();
		OperateResult or = null;
		or = baseHealthService.save(baseHealthModel);
		this.setBaseHealthModel(null);
		this.setParameters(or.getMessage(), "baseHealth_managerList.xhtml?id=" + cId);
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
		or = baseHealthService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),"baseHealth_managerList.xhtml?id=" + this.getId());//企业ID
		return SUCCESS;
	}

	public String managerList() throws Exception {
		companyInfoModel = companyInfoService.findById(this.getId());
		baseHealthModels = baseHealthService.getBaseHealthByCompanyId(this.getId(),baseHealthModel);
		this.setParameters(page_forward_managerList_baseHealth);
		return SUCCESS;
	}
	
	/**
	 * 管理及列表 加入用户操作的数据范围
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseHealthModels = baseHealthService.getCompanyBaseHealthModels(this.getCurrentUser(),baseHealthModel);
		this.setParameters(page_forward_tomanagers_baseHealth);
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
		this.setParameters(page_forward_companyList_baseHealth);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseHealthModels = baseHealthService.getCollection(baseHealthModel);
		TableFacade tableFacade = new TableFacade("baseHealthModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "companyInfo.companyName","companyInfo.address","staffNum", "workPlace", "workType", "scription"};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseHealthModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.getTable().setCaption("健康防治");
			tableFacade.getTable().getRow().getColumn("companyInfo.companyName").setTitle("企业名称");
			tableFacade.getTable().getRow().getColumn("companyInfo.address").setTitle("地址");
			tableFacade.getTable().getRow().getColumn("staffNum").setTitle("职工人数");
			tableFacade.getTable().getRow().getColumn("workPlace").setTitle("工作场所");
			tableFacade.getTable().getRow().getColumn("workType").setTitle("工种");
			tableFacade.getTable().getRow().getColumn("scription").setTitle("健康情况");
			
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (baseHealthModel == null) {
			baseHealthModel = new BaseHealthModel(request, "baseHealthModel");
		}
		if (companyInfoModel == null) {
			companyInfoModel = new CompanyInfoModel(request, "companyInfoModel");
		}
	}

	/**
	 * @return the baseHealthModel
	 */
	public BaseHealthModel getBaseHealthModel() {
		return baseHealthModel;
	}

	/**
	 * @param baseHealthModel
	 *            the baseHealthModel to set
	 */
	public void setBaseHealthModel(BaseHealthModel baseHealthModel) {
		this.baseHealthModel = baseHealthModel;
	}

	/**
	 * @return the baseHealthModels
	 */
	public List<BaseHealthModel> getBaseHealthModels() {
		return baseHealthModels;
	}

	/**
	 * @param baseHealthModels
	 *            the baseHealthModels to set
	 */
	public void setBaseHealthModels(List<BaseHealthModel> baseHealthModels) {
		this.baseHealthModels = baseHealthModels;
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
