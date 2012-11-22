/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.controller;

import java.util.Date;
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
import com.safetys.zhjg.base.model.BaseSummaryModel;
import com.safetys.zhjg.base.service.IBaseSummaryService;

/**
 * 此文件通过快速开发平台自动生成
 * 工作总结
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseSummaryController")
public class BaseSummaryController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseSummary = "/template/base/BaseSummary_Input.ftl";
	private static final String page_forward_showupdate_baseSummary = "/template/base/BaseSummary_Input.ftl";
	private static final String page_forward_showdetail_baseSummary = "/template/base/BaseSummary_Detail.ftl";
	private static final String page_forward_tolists_baseSummary = "/template/base/BaseSummary_List.ftl";
	private static final String page_forward_tomanagers_baseSummary = "/template/base/BaseSummary_Manager.ftl";
	private static final String action_forward_managers_baseSummary = "baseSummary_manager.xhtml";
	@Resource(name = "baseSummaryService")
	private IBaseSummaryService baseSummaryService;
	private BaseSummaryModel baseSummaryModel;
	private List<BaseSummaryModel> baseSummaryModels;

	/**
	 * 浏览列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String list() throws Exception {
		baseSummaryModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseSummaryModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseSummaryModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseSummaryModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseSummaryModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseSummaryModels = baseSummaryService.getCollection(baseSummaryModel);
		this.setParameters(page_forward_tolists_baseSummary);
		return SUCCESS;
	}
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		baseSummaryModel.setReleaseDate(new Date());
		this.setParameters(page_forward_showinsert_baseSummary);
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
		baseSummaryModel = baseSummaryService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseSummary);
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
		baseSummaryModel = baseSummaryService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseSummary);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseSummaryModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseSummaryModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseSummaryModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseSummaryModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseSummaryModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseSummaryService.save(baseSummaryModel);
		this.setBaseSummaryModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseSummary);
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
		or = baseSummaryService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseSummary);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseSummaryModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseSummaryModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseSummaryModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseSummaryModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseSummaryModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseSummaryModels = baseSummaryService.getCollection(baseSummaryModel);
		this.setParameters(page_forward_tomanagers_baseSummary);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseSummaryModels = baseSummaryService.getCollection(baseSummaryModel);
		TableFacade tableFacade = new TableFacade("baseSummaryModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"name","ruleUnit","implUnit","summaryType","releaseDate","content","remark","orgsId","userId",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseSummaryModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseSummaryModel == null) {
			baseSummaryModel = new BaseSummaryModel(request, "baseSummaryModel");
		}
	}
	
	/**
	 * @return the baseSummaryModel
	 */
	public BaseSummaryModel getBaseSummaryModel() {
		return baseSummaryModel;
	}

	/**
	 * @param baseSummaryModel the baseSummaryModel to set
	 */
	public void setBaseSummaryModel(BaseSummaryModel baseSummaryModel) {
		this.baseSummaryModel = baseSummaryModel;
	}

	/**
	 * @return the baseSummaryModels
	 */
	public List<BaseSummaryModel> getBaseSummaryModels() {
		return baseSummaryModels;
	}

	/**
	 * @param baseSummaryModels the baseSummaryModels to set
	 */
	public void setBaseSummaryModels(List<BaseSummaryModel> baseSummaryModels) {
		this.baseSummaryModels = baseSummaryModels;
	}
}
