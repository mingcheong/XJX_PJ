/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.safetys.framework.system.service.IFkAnnexService;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("fkAnnexController")
public class FkAnnexController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_tomanagers_fkAnnex = "/template/system/FkAnnex_Manager.ftl";
	private static final String action_forward_managers_fkAnnex = "fkAnnex_manager.xhtml";
	@Resource(name = "fkAnnexService")
	private IFkAnnexService fkAnnexService;
	private FkAnnexModel fkAnnexModel;
	private List<FkAnnexModel> fkAnnexModels;
	
	
	/**
	 * ajax 删除附件
	 * @return
	 * @throws Exception
	 */
	public String ajaxRemove()throws Exception{
		this.response.setContentType("text/html;charset=utf-8");
		if (this.getId() == null || this.getId() <= 0) { throw new ActionException("将要删除的对象编号不可为空！"); }
		fkAnnexService.remove(this.getId());
		this.response.getWriter().print("<b>删除成功！</b>");
		this.response.getWriter().close();
		return NONE;
	}
	
	/**
	 * 文件下载
	 * 
	 * @return DOWNLOAD
	 * @throws SystemExceptions
	 * @throws IOException
	 */
	public String download() throws Exception {
		this.response.setContentType("text/html;charset=utf-8");
		if (AppUtils.isNullOrEmptyString((this.getId()))) { 
			throw new ActionException("没有找到对应的文件，请联系管理员！");
		}
		this.fkAnnexModel = this.fkAnnexService.findById(this.getId());
		File temp = new File(request.getSession().getServletContext().getRealPath(this.getFkAnnexModel().getAnnexPath()));
		if (temp.exists()) {
			String fileName = this.fkAnnexModel.getAnnexName();
			InputStream Stream = new BufferedInputStream(new FileInputStream(temp));
			this.setFileName(new String(fileName.getBytes(), "ISO8859-1"));
			this.setContentType(this.fkAnnexModel.getAnnexType());
			this.setDownloadFile(Stream);
			return DOWNLOAD;
		} else {
			this.response.setContentType("text/html;charset=utf-8");
			this.response.getWriter().print("<b>文件不存在,请联系管理员！</b>");
			this.response.getWriter().close();
			return NONE;
		}
	}

	/**
	 * 删除数据
	 * 
	 * @throws ActionException
	 */
	public String remove() throws Exception {
		OperateResult or = null;
		if (this.getSelectedIds() == null || this.getSelectedIds().length() <= 0) { throw new ActionException("将要删除的对象编号不可为空！"); }
		or = fkAnnexService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(), action_forward_managers_fkAnnex);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		fkAnnexModels = fkAnnexService.getCollection(fkAnnexModel);
		this.setParameters(page_forward_tomanagers_fkAnnex);
		return SUCCESS;
	}

	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV） 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * 
	 * @throws ActionException
	 */
	@SuppressWarnings("deprecation")
	public String report() throws Exception {
		fkAnnexModels = fkAnnexService.getCollection(fkAnnexModel);
		TableFacade tableFacade = new TableFacade("fkAnnexModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = { "objectType", "annexName", "annexPath", "annexType", "annexSize", "annexDesc", };
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(fkAnnexModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}

	public void prepare() throws Exception {
		if (fkAnnexModel == null) {
			fkAnnexModel = new FkAnnexModel(request, "fkAnnexModel");
		}
	}

	/**
	 * @return the fkAnnexModel
	 */
	public FkAnnexModel getFkAnnexModel() {
		return fkAnnexModel;
	}

	/**
	 * @param fkAnnexModel
	 *            the fkAnnexModel to set
	 */
	public void setFkAnnexModel(FkAnnexModel fkAnnexModel) {
		this.fkAnnexModel = fkAnnexModel;
	}

	/**
	 * @return the fkAnnexModels
	 */
	public List<FkAnnexModel> getFkAnnexModels() {
		return fkAnnexModels;
	}

	/**
	 * @param fkAnnexModels
	 *            the fkAnnexModels to set
	 */
	public void setFkAnnexModels(List<FkAnnexModel> fkAnnexModels) {
		this.fkAnnexModels = fkAnnexModels;
	}
}
