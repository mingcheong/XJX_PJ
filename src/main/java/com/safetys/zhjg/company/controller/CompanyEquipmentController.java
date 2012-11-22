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
import com.safetys.zhjg.company.model.CompanyEquipmentModel;
import com.safetys.zhjg.company.service.ICompanyEquipmentService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyEquipmentController")
public class CompanyEquipmentController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_companyEquipment = "/template/company/CompanyEquipment_Input.ftl";
	private static final String page_forward_showupdate_companyEquipment = "/template/company/CompanyEquipment_Input.ftl";
	private static final String page_forward_showdetail_companyEquipment = "/template/company/CompanyEquipment_Detail.ftl";
	private static final String page_forward_tomanagers_companyEquipment = "/template/company/CompanyEquipment_Manager.ftl";
	private static final String action_forward_managers_companyEquipment = "companyEquipment_manager.xhtml";
	@Resource(name = "companyEquipmentService")
	private ICompanyEquipmentService companyEquipmentService;
	private CompanyEquipmentModel companyEquipmentModel;
	private List<CompanyEquipmentModel> companyEquipmentModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_companyEquipment);
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
		companyEquipmentModel = companyEquipmentService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyEquipment);
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
		companyEquipmentModel = companyEquipmentService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyEquipment);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = companyEquipmentService.save(companyEquipmentModel);
		this.setCompanyEquipmentModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_companyEquipment);
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
		or = companyEquipmentService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_companyEquipment);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		/*companyEquipmentModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyEquipmentModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyEquipmentModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyEquipmentModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyEquipmentModel.setFifthArea(this.getCurrentUser().getFifthArea());*/
		companyEquipmentModels = companyEquipmentService.getCollection(companyEquipmentModel);
		this.setParameters(page_forward_tomanagers_companyEquipment);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyEquipmentModels = companyEquipmentService.getCollection(companyEquipmentModel);
		TableFacade tableFacade = new TableFacade("companyEquipmentModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"name","safetyPerson","usedAddress","regCode","state","regUnit","regDate","preserveUnit","produceUnit","inspectionUnit","inspectionDate","preserverPhone","equipentType","usedUnit","usingAddress","model",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyEquipmentModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyEquipmentModel == null) {
			companyEquipmentModel = new CompanyEquipmentModel(request, "companyEquipmentModel");
		}
	}
	
	/**
	 * @return the companyEquipmentModel
	 */
	public CompanyEquipmentModel getCompanyEquipmentModel() {
		return companyEquipmentModel;
	}

	/**
	 * @param companyEquipmentModel the companyEquipmentModel to set
	 */
	public void setCompanyEquipmentModel(CompanyEquipmentModel companyEquipmentModel) {
		this.companyEquipmentModel = companyEquipmentModel;
	}

	/**
	 * @return the companyEquipmentModels
	 */
	public List<CompanyEquipmentModel> getCompanyEquipmentModels() {
		return companyEquipmentModels;
	}

	/**
	 * @param companyEquipmentModels the companyEquipmentModels to set
	 */
	public void setCompanyEquipmentModels(List<CompanyEquipmentModel> companyEquipmentModels) {
		this.companyEquipmentModels = companyEquipmentModels;
	}
}
