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
import com.safetys.zhjg.base.model.BaseMeetingModel;
import com.safetys.zhjg.base.service.IBaseMeetingService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 会议记录
 * 
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseMeetingController")
public class BaseMeetingController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseMeeting = "/template/base/BaseMeeting_Input.ftl";
	private static final String page_forward_showupdate_baseMeeting = "/template/base/BaseMeeting_Input.ftl";
	private static final String page_forward_showdetail_baseMeeting = "/template/base/BaseMeeting_Detail.ftl";
	private static final String page_forward_tolists_baseMeeting = "/template/base/BaseMeeting_List.ftl";
	private static final String page_forward_tomanagers_baseMeeting = "/template/base/BaseMeeting_Manager.ftl";
	private static final String action_forward_managers_baseMeeting = "baseMeeting_manager.xhtml";
	@Resource(name = "baseMeetingService")
	private IBaseMeetingService baseMeetingService;
	private BaseMeetingModel baseMeetingModel;
	private List<BaseMeetingModel> baseMeetingModels;

	
	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String list() throws Exception {
		baseMeetingModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseMeetingModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseMeetingModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseMeetingModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseMeetingModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseMeetingModels = baseMeetingService.getCollection(baseMeetingModel);
		this.setParameters(page_forward_tolists_baseMeeting);
		return SUCCESS;
	}
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		baseMeetingModel.setReleaseDate(new Date());
		this.setParameters(page_forward_showinsert_baseMeeting);
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
		baseMeetingModel = baseMeetingService.findById(this.getId());
		this.setParameters(page_forward_showupdate_baseMeeting);
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
		baseMeetingModel = baseMeetingService.findById(this.getId());
		this.setParameters(page_forward_showdetail_baseMeeting);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseMeetingModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseMeetingModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseMeetingModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseMeetingModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseMeetingModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseMeetingService.save(baseMeetingModel);
		this.setBaseMeetingModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseMeeting);
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
		or = baseMeetingService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseMeeting);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseMeetingModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseMeetingModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseMeetingModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseMeetingModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseMeetingModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseMeetingModels = baseMeetingService.getCollection(baseMeetingModel);
		this.setParameters(page_forward_tomanagers_baseMeeting);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseMeetingModels = baseMeetingService.getCollection(baseMeetingModel);
		TableFacade tableFacade = new TableFacade("baseMeetingModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"name","ruleUnit","implUnit","type","releaseDate","content","remark","orgsId","userId",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseMeetingModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseMeetingModel == null) {
			baseMeetingModel = new BaseMeetingModel(request, "baseMeetingModel");
		}
	}
	
	/**
	 * @return the baseMeetingModel
	 */
	public BaseMeetingModel getBaseMeetingModel() {
		return baseMeetingModel;
	}

	/**
	 * @param baseMeetingModel the baseMeetingModel to set
	 */
	public void setBaseMeetingModel(BaseMeetingModel baseMeetingModel) {
		this.baseMeetingModel = baseMeetingModel;
	}

	/**
	 * @return the baseMeetingModels
	 */
	public List<BaseMeetingModel> getBaseMeetingModels() {
		return baseMeetingModels;
	}

	/**
	 * @param baseMeetingModels the baseMeetingModels to set
	 */
	public void setBaseMeetingModels(List<BaseMeetingModel> baseMeetingModels) {
		this.baseMeetingModels = baseMeetingModels;
	}
}
