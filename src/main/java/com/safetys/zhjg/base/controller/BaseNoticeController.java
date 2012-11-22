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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.system.model.FkAnnexModel;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkAnnexService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import com.safetys.framework.utils.StaticMember;
import com.safetys.zhjg.base.model.BaseNoticeModel;
import com.safetys.zhjg.base.model.BaseNoticeUsersModel;
import com.safetys.zhjg.base.service.IBaseNoticeService;
import com.safetys.zhjg.base.service.IBaseNoticeUsersService;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 通知公告
 * 
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("baseNoticeController")
public class BaseNoticeController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_showinsert_baseNotice = "/template/base/BaseNotice_Input.ftl";
	private static final String page_forward_showupdate_baseNotice = "/template/base/BaseNotice_Input.ftl";
	private static final String page_forward_showdetail_baseNotice = "/template/base/BaseNotice_Detail.ftl";
	private static final String page_forward_tomanagers_baseNotice = "/template/base/BaseNotice_Manager.ftl";
	private static final String page_forward_tolists_baseNotice = "/template/base/BaseNotice_List.ftl";
	private static final String PAGE_FORWARD_MYNOTICE_BASENOTICE = "/template/base/BaseNotice_myNotice.ftl";
	private static final String PAGE_FORWARD_SHOWMOTICE_BASENOTICE = "/template/base/BaseNotice_showNotice.ftl";
	private static final String action_forward_managers_baseNotice = "baseNotice_manager.xhtml";
	private static final String ACTION_FORWARD_MYNOTICE_BASENOTICE = "baseNotice_myNotice.xhtml";
	
	@Resource(name = "baseNoticeService")
	private IBaseNoticeService baseNoticeService;
	@Resource(name = "baseNoticeUsersService")
	private IBaseNoticeUsersService baseNoticeUsersService;
	@Resource(name="fkAnnexService")
	private IFkAnnexService fkAnnexService;
	private BaseNoticeModel baseNoticeModel;
	private BaseNoticeUsersModel baseNoticeUsersModel;
	private List<BaseNoticeModel> baseNoticeModels;
	private List<FkAnnexModel> fkAnnexModels;
	
	
	/**
	 * 查看后反馈--保存更新
	 * @return
	 * @throws Exception
	 */
	public String feedback()throws Exception{
		baseNoticeUsersService.save(baseNoticeUsersModel);
		this.setParameters("反馈成功！",ACTION_FORWARD_MYNOTICE_BASENOTICE);
		return SUCCESS;
	}
	
	/**
	 * 查看我的通知详细--反馈
	 * @return
	 * @throws Exception
	 */
	public String showNotice() throws Exception{
		baseNoticeModel = baseNoticeService.findById(this.getId());
		baseNoticeUsersModel = baseNoticeUsersService.getCollection("select o from baseNoticeUsersModel o where o.deleted = false and o.fkUserModel.id = "+this.getCurrentUser().getId()+" and o.baseNoticeModel.id =  "+this.getId(), false).get(0);
		baseNoticeUsersModel.setState(true);
		baseNoticeUsersModel = (BaseNoticeUsersModel)baseNoticeUsersService.save(baseNoticeUsersModel).getResult();
		fkAnnexModels = fkAnnexService.getCollection("select o from fkAnnexModel o where o.deleted = false and o.objectId = "+baseNoticeModel.getId()+" and o.objectType = " + StaticMember.NOTICE_TYPE_ANNEX , false);
		this.setParameters(PAGE_FORWARD_SHOWMOTICE_BASENOTICE);
		return SUCCESS;
	}
	
	/**
	 * 我的通知
	 * @return
	 * @throws Exception
	 */
	public String myNotice() throws Exception{
		String jpql = "select o from baseNoticeModel o where o.deleted = false and  o.id in (select u.baseNoticeModel.id from baseNoticeUsersModel u where u.deleted = false and u.fkUserModel.id = "+this.getCurrentUser().getId()+") ";
		baseNoticeModels = baseNoticeService.getCollection(jpql, baseNoticeModel);
		this.setParameters(PAGE_FORWARD_MYNOTICE_BASENOTICE);
		return SUCCESS;
	}

	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		baseNoticeModel.setReleaseDate(new Date());
		this.setParameters(page_forward_showinsert_baseNotice);
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
		baseNoticeModel = baseNoticeService.findById(this.getId());
		List<BaseNoticeUsersModel> lists = baseNoticeUsersService.getCollection("select o from baseNoticeUsersModel o where o.baseNoticeModel.deleted = false and  o.deleted = false and o.baseNoticeModel.id = "+baseNoticeModel.getId(),false);
		String usersIds = "";
		String usersNames ="";
		for(BaseNoticeUsersModel o : lists){
			usersIds += o.getFkUserModel().getId()+",";
			usersNames += o.getFkUserModel().getTruename()+",";
			o=null;
		}
		if(!usersIds.equals("")&&usersIds.lastIndexOf(",")==usersIds.length()-1){
			baseNoticeModel.setUserIds(usersIds.substring(0, usersIds.lastIndexOf(",")));
			baseNoticeModel.setUserNames( usersNames.substring(0,usersNames.lastIndexOf(",")));
		}
		fkAnnexModels = fkAnnexService.getCollection("select o from fkAnnexModel o where o.deleted = false and o.objectId = "+baseNoticeModel.getId()+" and o.objectType = " + StaticMember.NOTICE_TYPE_ANNEX , false);
		lists.clear();usersIds=null;usersNames=null;
		this.setParameters(page_forward_showupdate_baseNotice);
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
		baseNoticeModel = baseNoticeService.findById(this.getId());
		baseNoticeModel.setBaseNoticeUsersModels(baseNoticeUsersService.getCollection("select o from baseNoticeUsersModel o where o.baseNoticeModel.deleted = false and  o.deleted = false and o.baseNoticeModel.id = "+baseNoticeModel.getId(),false));
		fkAnnexModels = fkAnnexService.getCollection("select o from fkAnnexModel o where o.deleted = false and o.objectId = "+baseNoticeModel.getId()+" and o.objectType = " + StaticMember.NOTICE_TYPE_ANNEX , false);
		this.setParameters(page_forward_showdetail_baseNotice);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		baseNoticeModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseNoticeModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseNoticeModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseNoticeModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseNoticeModel.setFifthArea(this.getCurrentUser().getFifthArea());
		or = baseNoticeService.save(baseNoticeModel);
		baseNoticeModel = (BaseNoticeModel)or.getResult();
		List<Long> ids = AppUtils.idsStringToList(baseNoticeModel.getUserIds());
		List<BaseNoticeUsersModel> lists = baseNoticeUsersService.getCollection("select o from baseNoticeUsersModel o where o.baseNoticeModel.deleted = false and o.deleted = false and o.baseNoticeModel.id = "+baseNoticeModel.getId(),false);
		if(lists!=null&&lists.size()>0){
			for(int i = 0 ; i < lists.size(); i++){
				boolean b = false;
				for(int j = 0 ; j<ids.size();j++){
					if(lists.get(i).getFkUserModel().getId()==ids.get(j)){
						b=true;
						break;
					}
				}
				if(!b){
					baseNoticeUsersService.remove(lists.get(i));
				}
			}
		}
		for (int i = 0; i < ids.size(); i++) {
			boolean b = false;
			if(lists!=null&&lists.size()>0){
				for(int j = 0 ;j <lists.size();j++){
					if(ids.get(i)==lists.get(j).getFkUserModel().getId()){
						b=true;
						break;
					}
				}
			}
			if(!b){
		        BaseNoticeUsersModel userModel = new BaseNoticeUsersModel();
		        FkUserModel fkUserModel = new FkUserModel();
		        fkUserModel.setId(ids.get(i));
		        userModel.setFkUserModel(fkUserModel);
		        userModel.setBaseNoticeModel(baseNoticeModel);
		        baseNoticeUsersService.save(userModel);
			}
        }
		if(this.Filedata!=null&&this.Filedata.size()>0){
			if(this.Filedata.get(0)!=null){
				InputStream in = null;
				OutputStream out = null;
				String noticeAnnexPath = request.getSession().getServletContext().getRealPath(StaticMember.NOTICE_PATH_ANNEX);
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
					fkAnnexModel.setAnnexPath(StaticMember.NOTICE_PATH_ANNEX+"/"+saveFileName);
					fkAnnexModel.setObjectId(this.baseNoticeModel.getId());
					fkAnnexModel.setObjectType(StaticMember.NOTICE_TYPE_ANNEX);
					fkAnnexModel.setAnnexSize(Float.parseFloat(this.Filedata.get(i).length() + ""));
					fkAnnexService.save(fkAnnexModel);
				}
			}
		}
		this.setBaseNoticeModel(null);
		this.setParameters("",action_forward_managers_baseNotice);
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
		or = baseNoticeService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_baseNotice);
		return SUCCESS;
	}

	/**
	 * 浏览列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String list() throws Exception {
		baseNoticeModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseNoticeModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseNoticeModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseNoticeModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseNoticeModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseNoticeModels = baseNoticeService.getCollection(baseNoticeModel);
		this.setParameters(page_forward_tolists_baseNotice);
		return SUCCESS;
	}
	
	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		baseNoticeModel.setFirstArea(this.getCurrentUser().getFirstArea());
		baseNoticeModel.setSecondArea(this.getCurrentUser().getSecondArea());
		baseNoticeModel.setThirdArea(this.getCurrentUser().getThirdArea());
		baseNoticeModel.setFourthArea(this.getCurrentUser().getFourthArea());
		baseNoticeModel.setFifthArea(this.getCurrentUser().getFifthArea());
		baseNoticeModels = baseNoticeService.getCollection(baseNoticeModel);
		this.setParameters(page_forward_tomanagers_baseNotice);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		baseNoticeModels = baseNoticeService.getCollection(baseNoticeModel);
		TableFacade tableFacade = new TableFacade("baseNoticeModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"name","ruleUnit","implUnit","type","releaseDate","content","remark","orgsId","userId",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(baseNoticeModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (baseNoticeModel == null) {
			baseNoticeModel = new BaseNoticeModel(request, "baseNoticeModel");
		}
	}
	
	/**
	 * @return the baseNoticeModel
	 */
	public BaseNoticeModel getBaseNoticeModel() {
		return baseNoticeModel;
	}

	/**
	 * @param baseNoticeModel the baseNoticeModel to set
	 */
	public void setBaseNoticeModel(BaseNoticeModel baseNoticeModel) {
		this.baseNoticeModel = baseNoticeModel;
	}

	/**
	 * @return the baseNoticeModels
	 */
	public List<BaseNoticeModel> getBaseNoticeModels() {
		return baseNoticeModels;
	}

	/**
	 * @param baseNoticeModels the baseNoticeModels to set
	 */
	public void setBaseNoticeModels(List<BaseNoticeModel> baseNoticeModels) {
		this.baseNoticeModels = baseNoticeModels;
	}

	public BaseNoticeUsersModel getBaseNoticeUsersModel() {
		return baseNoticeUsersModel;
	}

	public void setBaseNoticeUsersModel(BaseNoticeUsersModel baseNoticeUsersModel) {
		this.baseNoticeUsersModel = baseNoticeUsersModel;
	}

	public List<FkAnnexModel> getFkAnnexModels() {
		return fkAnnexModels;
	}

	public void setFkAnnexModels(List<FkAnnexModel> fkAnnexModels) {
		this.fkAnnexModels = fkAnnexModels;
	}
}
