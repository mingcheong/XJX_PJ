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
import com.safetys.zhjg.company.model.CompanyComplaintsModel;
import com.safetys.zhjg.company.service.ICompanyComplaintsService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyComplaintsController")
public class CompanyComplaintsController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyComplaints = "/template/company/CompanyComplaints_Input.ftl";
	private static final String page_forward_showupdate_companyComplaints = "/template/company/CompanyComplaints_Input.ftl";
	private static final String page_forward_showdetail_companyComplaints = "/template/company/CompanyComplaints_Detail.ftl";
	private static final String page_forward_tomanagers_companyComplaints = "/template/company/CompanyComplaints_Manager.ftl";
	private static final String action_forward_managersList_companyComplaints = "/template/company/CompanyComplaints_ManagerList.ftl";
	private static final String action_forward_managers_companyComplaints = "companyComplaints_manager.xhtml";
	@Resource(name = "companyComplaintsService")
	private ICompanyComplaintsService companyComplaintsService;
	private CompanyComplaintsModel companyComplaintsModel;
	private List<CompanyComplaintsModel> companyComplaintsModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_companyComplaints);
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
		companyComplaintsModel = companyComplaintsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyComplaints);
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
		companyComplaintsModel = companyComplaintsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyComplaints);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = companyComplaintsService.save(companyComplaintsModel);
		this.setCompanyComplaintsModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_companyComplaints);
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
		or = companyComplaintsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_companyComplaints);
		return SUCCESS;
	}

	/**
	 * 查询列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyComplaintsModels = companyComplaintsService.getCollection(companyComplaintsModel);
		this.setParameters(page_forward_tomanagers_companyComplaints);
		return SUCCESS;
	}
	
	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String managerList() throws Exception {
		companyComplaintsModels = companyComplaintsService.getCollection(companyComplaintsModel);
		this.setParameters(action_forward_managersList_companyComplaints);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyComplaintsModels = companyComplaintsService.getCollection(companyComplaintsModel);
		TableFacade tableFacade = new TableFacade("companyComplaintsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"callsDate","paperNumber","digest","leaderName","complaintsName","supervisory","isAppropriate","remark",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyComplaintsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyComplaintsModel == null) {
			companyComplaintsModel = new CompanyComplaintsModel(request, "companyComplaintsModel");
		}
	}
	
	/**
	 * @return the companyComplaintsModel
	 */
	public CompanyComplaintsModel getCompanyComplaintsModel() {
		return companyComplaintsModel;
	}

	/**
	 * @param companyComplaintsModel the companyComplaintsModel to set
	 */
	public void setCompanyComplaintsModel(CompanyComplaintsModel companyComplaintsModel) {
		this.companyComplaintsModel = companyComplaintsModel;
	}

	/**
	 * @return the companyComplaintsModels
	 */
	public List<CompanyComplaintsModel> getCompanyComplaintsModels() {
		return companyComplaintsModels;
	}

	/**
	 * @param companyComplaintsModels the companyComplaintsModels to set
	 */
	public void setCompanyComplaintsModels(List<CompanyComplaintsModel> companyComplaintsModels) {
		this.companyComplaintsModels = companyComplaintsModels;
	}
}
