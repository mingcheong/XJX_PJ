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
import com.safetys.zhjg.base.model.BaseWorkplanModel;
import com.safetys.zhjg.base.service.IBaseWorkplanService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseWorkplanController")
public class BaseWorkplanController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseWorkplan = "/template/base/BaseWorkplan_Input.ftl";
	private static final String page_forward_showupdate_baseWorkplan = "/template/base/BaseWorkplan_Input.ftl";
	private static final String page_forward_showdetail_baseWorkplan = "/template/base/BaseWorkplan_Detail.ftl";
	private static final String page_forward_tolists_baseWorkplan = "/template/base/BaseWorkplan_List.ftl";
	private static final String page_forward_tomanagers_baseWorkplan = "/template/base/BaseWorkplan_Manager.ftl";
	private static final String action_forward_managers_baseWorkplan = "baseWorkplan_manager.xhtml";
	@Resource(name = "baseWorkplanService")
	private IBaseWorkplanService baseWorkplanService;
	private BaseWorkplanModel baseWorkplanModel;
	private List<BaseWorkplanModel> baseWorkplanModels;

	/**
	 * 浏览列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String list() throws Exception {
		baseWorkplanModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseWorkplanModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseWorkplanModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseWorkplanModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseWorkplanModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseWorkplanModels = baseWorkplanService.getCollection(baseWorkplanModel);
		this.setParameters(page_forward_tolists_baseWorkplan);
		return SUCCESS;
	}
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		baseWorkplanModel.setReleaseDate(new Date());
		this.setParameters(page_forward_showinsert_baseWorkplan);
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
		baseWorkplanModel = baseWorkplanService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseWorkplan);
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
		baseWorkplanModel = baseWorkplanService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseWorkplan);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseWorkplanModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseWorkplanModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseWorkplanModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseWorkplanModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseWorkplanModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseWorkplanService.save(baseWorkplanModel);
		this.setBaseWorkplanModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseWorkplan);
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
		or = baseWorkplanService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseWorkplan);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseWorkplanModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseWorkplanModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseWorkplanModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseWorkplanModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseWorkplanModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseWorkplanModels = baseWorkplanService.getCollection(baseWorkplanModel);
		this.setParameters(page_forward_tomanagers_baseWorkplan);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseWorkplanModels = baseWorkplanService.getCollection(baseWorkplanModel);
		TableFacade tableFacade = new TableFacade("baseWorkplanModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"name","ruleUnit","implUnit","type","releaseDate","content","remark","orgsId","userId",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseWorkplanModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseWorkplanModel == null) {
			baseWorkplanModel = new BaseWorkplanModel(request, "baseWorkplanModel");
		}
	}
	
	/**
	 * @return the baseWorkplanModel
	 */
	public BaseWorkplanModel getBaseWorkplanModel() {
		return baseWorkplanModel;
	}

	/**
	 * @param baseWorkplanModel the baseWorkplanModel to set
	 */
	public void setBaseWorkplanModel(BaseWorkplanModel baseWorkplanModel) {
		this.baseWorkplanModel = baseWorkplanModel;
	}

	/**
	 * @return the baseWorkplanModels
	 */
	public List<BaseWorkplanModel> getBaseWorkplanModels() {
		return baseWorkplanModels;
	}

	/**
	 * @param baseWorkplanModels the baseWorkplanModels to set
	 */
	public void setBaseWorkplanModels(List<BaseWorkplanModel> baseWorkplanModels) {
		this.baseWorkplanModels = baseWorkplanModels;
	}
}
