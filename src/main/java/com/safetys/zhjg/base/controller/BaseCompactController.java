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
import com.safetys.zhjg.base.model.BaseCompactModel;
import com.safetys.zhjg.base.service.IBaseCompactService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseCompactController")
public class BaseCompactController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseCompact = "/template/base/BaseCompact_Input.ftl";
	private static final String page_forward_showupdate_baseCompact = "/template/base/BaseCompact_Input.ftl";
	private static final String page_forward_showdetail_baseCompact = "/template/base/BaseCompact_Detail.ftl";
	private static final String page_forward_tomanagers_baseCompact = "/template/base/BaseCompact_Manager.ftl";
	private static final String action_forward_managers_baseCompact = "baseCompact_manager.xhtml";
	@Resource(name = "baseCompactService")
	private IBaseCompactService baseCompactService;
	private BaseCompactModel baseCompactModel;
	private List<BaseCompactModel> baseCompactModels;

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		this.setParameters(page_forward_showinsert_baseCompact);
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
		baseCompactModel = baseCompactService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseCompact);
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
		baseCompactModel = baseCompactService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseCompact);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseCompactModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseCompactModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseCompactModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseCompactModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseCompactModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseCompactService.save(baseCompactModel);
		this.setBaseCompactModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseCompact);
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
		or = baseCompactService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseCompact);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseCompactModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseCompactModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseCompactModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseCompactModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseCompactModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseCompactModels = baseCompactService.getCollection(baseCompactModel);
		this.setParameters(page_forward_tomanagers_baseCompact);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseCompactModels = baseCompactService.getCollection(baseCompactModel);
		TableFacade tableFacade = new TableFacade("baseCompactModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"compactType","industryTypes","unitChief","preparer","phone",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseCompactModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseCompactModel == null) {
			baseCompactModel = new BaseCompactModel(request, "baseCompactModel");
		}
	}
	
	/**
	 * @return the baseCompactModel
	 */
	public BaseCompactModel getBaseCompactModel() {
		return baseCompactModel;
	}

	/**
	 * @param baseCompactModel the baseCompactModel to set
	 */
	public void setBaseCompactModel(BaseCompactModel baseCompactModel) {
		this.baseCompactModel = baseCompactModel;
	}

	/**
	 * @return the baseCompactModels
	 */
	public List<BaseCompactModel> getBaseCompactModels() {
		return baseCompactModels;
	}

	/**
	 * @param baseCompactModels the baseCompactModels to set
	 */
	public void setBaseCompactModels(List<BaseCompactModel> baseCompactModels) {
		this.baseCompactModels = baseCompactModels;
	}
}
