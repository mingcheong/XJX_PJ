/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.controller;

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
import com.safetys.zhjg.base.model.BaseCompactDataModel;
import com.safetys.zhjg.base.service.IBaseCompactDataService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseCompactDataController")
public class BaseCompactDataController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseCompactData = "/template/base/BaseCompactData_Input.ftl";
	private static final String page_forward_showupdate_baseCompactData = "/template/base/BaseCompactData_Input.ftl";
	private static final String page_forward_showdetail_baseCompactData = "/template/base/BaseCompactData_Detail.ftl";
	private static final String page_forward_tomanagers_baseCompactData = "/template/base/BaseCompactData_Manager.ftl";
	private static final String action_forward_managers_baseCompactData = "baseCompactData_manager.xhtml";
	@Resource(name = "baseCompactDataService")
	private IBaseCompactDataService baseCompactDataService;
	private BaseCompactDataModel baseCompactDataModel;
	private List<BaseCompactDataModel> baseCompactDataModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_baseCompactData);
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
		baseCompactDataModel = baseCompactDataService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseCompactData);
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
		baseCompactDataModel = baseCompactDataService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseCompactData);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		or = baseCompactDataService.save(baseCompactDataModel);
		this.setBaseCompactDataModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseCompactData);
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
		or = baseCompactDataService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseCompactData);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseCompactDataModels = baseCompactDataService.getCollection(baseCompactDataModel);
		this.setParameters(page_forward_tomanagers_baseCompactData);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseCompactDataModels = baseCompactDataService.getCollection(baseCompactDataModel);
		TableFacade tableFacade = new TableFacade("baseCompactDataModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"compactId","holdNumber","clampNumber","holdingNumber",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseCompactDataModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseCompactDataModel == null) {
			baseCompactDataModel = new BaseCompactDataModel(request, "baseCompactDataModel");
		}
	}
	
	/**
	 * @return the baseCompactDataModel
	 */
	public BaseCompactDataModel getBaseCompactDataModel() {
		return baseCompactDataModel;
	}

	/**
	 * @param baseCompactDataModel the baseCompactDataModel to set
	 */
	public void setBaseCompactDataModel(BaseCompactDataModel baseCompactDataModel) {
		this.baseCompactDataModel = baseCompactDataModel;
	}

	/**
	 * @return the baseCompactDataModels
	 */
	public List<BaseCompactDataModel> getBaseCompactDataModels() {
		return baseCompactDataModels;
	}

	/**
	 * @param baseCompactDataModels the baseCompactDataModels to set
	 */
	public void setBaseCompactDataModels(List<BaseCompactDataModel> baseCompactDataModels) {
		this.baseCompactDataModels = baseCompactDataModels;
	}
}
