/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.base.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.system.model.FkAnnexModel;
import com.safetys.framework.system.service.IFkAnnexService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.framework.utils.StaticMember;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.safetys.zhjg.base.model.BaseRulesModel;
import com.safetys.zhjg.base.service.IBaseRulesService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseRulesController")
public class BaseRulesController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseRules = "/template/base/BaseRules_Input.ftl";
	private static final String page_forward_showupdate_baseRules = "/template/base/BaseRules_Input.ftl";
	private static final String page_forward_showdetail_baseRules = "/template/base/BaseRules_Detail.ftl";
	private static final String page_forward_tomanagers_baseRules = "/template/base/BaseRules_Manager.ftl";
	private static final String page_forward_tolist_baseRules = "/template/base/BaseRules_List.ftl";
	private static final String action_forward_managers_baseRules = "baseRules_manager.xhtml";
	@Resource(name = "baseRulesService")
	private IBaseRulesService baseRulesService;
	@Resource(name="fkAnnexService")
	private IFkAnnexService fkAnnexService;
	private BaseRulesModel baseRulesModel;
	private List<BaseRulesModel> baseRulesModels;
	private List<FkAnnexModel> fkAnnexModels;
	
	/**
	 * 法律法规列表
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		baseRulesModels = baseRulesService.getCollection(baseRulesModel);
		this.setParameters(page_forward_tolist_baseRules);
		return SUCCESS;
	}

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		baseRulesModel.setReleaseDate(new Date());
		this.setParameters(page_forward_showinsert_baseRules);
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
		baseRulesModel = baseRulesService.findById(this.getId());
		fkAnnexModels = fkAnnexService.getCollection("select o from fkAnnexModel o where o.deleted = false and o.objectId = "+baseRulesModel.getId()+" and o.objectType = " + StaticMember.RULES_TYPE_ANNEX , false);
		this.setParameters(page_forward_showupdate_baseRules);
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
		baseRulesModel = baseRulesService.findById(this.getId());
		fkAnnexModels = fkAnnexService.getCollection("select o from fkAnnexModel o where o.deleted = false and o.objectId = "+baseRulesModel.getId()+" and o.objectType = " + StaticMember.RULES_TYPE_ANNEX , false);
		this.setParameters(page_forward_showdetail_baseRules);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseRulesModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseRulesModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseRulesModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseRulesModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseRulesModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseRulesService.save(baseRulesModel);
		baseRulesModel = (BaseRulesModel)or.getResult();
		if(this.Filedata!=null&&this.Filedata.size()>0){
			if(this.Filedata.get(0)!=null){
				InputStream in = null;
				OutputStream out = null;
				String noticeAnnexPath = request.getSession().getServletContext().getRealPath(StaticMember.RULES_PATH_ANNEX );
				File saveDir = new File(noticeAnnexPath);
				if (!saveDir.exists()) {
					saveDir.mkdirs();
				}
				
				for(int i = 0 ; i < Filedata.size(); i++){
					String saveFileName = AppUtils.getFullDate()+this.FiledataFileName.get(i);
					in = new FileInputStream(this.Filedata.get(i).toString());
					out = new FileOutputStream(noticeAnnexPath+"/"+saveFileName);
					byte[] by = new byte[1024];
					int len = 0;
					while ((len = in.read(by)) != -1) {
						out.write(by, 0, len);
					}
					FkAnnexModel fkAnnexModel = new FkAnnexModel();
					fkAnnexModel.setAnnexName(this.FiledataFileName.get(i));
					fkAnnexModel.setAnnexType(this.FiledataContentType.get(i));
					fkAnnexModel.setAnnexPath(StaticMember.RULES_PATH_ANNEX+"/"+saveFileName);
					fkAnnexModel.setObjectId(this.baseRulesModel.getId());
					fkAnnexModel.setObjectType(StaticMember.RULES_TYPE_ANNEX);
					fkAnnexModel.setAnnexSize(Float.parseFloat(this.Filedata.get(i).length() + ""));
					fkAnnexService.save(fkAnnexModel);
				}
			}
		}
		this.setBaseRulesModel(null);
		this.setParameters(or.getMessage(),action_forward_managers_baseRules);
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
		or = baseRulesService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseRules);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseRulesModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseRulesModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseRulesModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseRulesModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseRulesModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseRulesModels = baseRulesService.getCollection(baseRulesModel);
		this.setParameters(page_forward_tomanagers_baseRules);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseRulesModels = baseRulesService.getCollection(baseRulesModel);
		TableFacade tableFacade = new TableFacade("baseRulesModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"title","formUnit","implUnit","rulesType","releaseDate","content",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseRulesModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseRulesModel == null) {
			baseRulesModel = new BaseRulesModel(request, "baseRulesModel");
		}
	}
	
	/**
	 * @return the baseRulesModel
	 */
	public BaseRulesModel getBaseRulesModel() {
		return baseRulesModel;
	}

	/**
	 * @param baseRulesModel the baseRulesModel to set
	 */
	public void setBaseRulesModel(BaseRulesModel baseRulesModel) {
		this.baseRulesModel = baseRulesModel;
	}

	/**
	 * @return the baseRulesModels
	 */
	public List<BaseRulesModel> getBaseRulesModels() {
		return baseRulesModels;
	}

	/**
	 * @param baseRulesModels the baseRulesModels to set
	 */
	public void setBaseRulesModels(List<BaseRulesModel> baseRulesModels) {
		this.baseRulesModels = baseRulesModels;
	}

	public List<FkAnnexModel> getFkAnnexModels() {
		return fkAnnexModels;
	}

	public void setFkAnnexModels(List<FkAnnexModel> fkAnnexModels) {
		this.fkAnnexModels = fkAnnexModels;
	}
}
