/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.Preparable;
import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.jmesa.facade.TableFacade;
import com.safetys.framework.jmesa.limit.ExportType;
import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.system.model.FkEnumModel;
import com.safetys.framework.utils.AppUtils;
import com.safetys.framework.utils.OperateResult;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.safetys.zhjg.company.model.CompanyReportsModel;
import com.safetys.zhjg.company.service.ICompanyReportsService;

/**
 * 数据上报 控制器
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Scope("prototype")
@Controller("companyReportsController")
public class CompanyReportsController extends BaseController implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final String page_forward_show_companyReports = "/template/company/CompanyReports_show.ftl";
	private static final String page_forward_showinsert_companyReports = "/template/company/CompanyReports_Input.ftl";
	private static final String page_forward_showupdate_companyReports = "/template/company/CompanyReports_Input.ftl";
	private static final String page_forward_showdetail_companyReports = "/template/company/CompanyReports_Detail.ftl";
	private static final String page_forward_tomanagers_companyReports = "/template/company/CompanyReports_Manager.ftl";
	private static final String action_forward_insert_companyReports = "companyReports_insert.xhtml";
	private static final String action_forward_managers_companyReports = "companyReports_manager.xhtml";
	@Resource(name = "companyReportsService")
	private ICompanyReportsService companyReportsService;
	private CompanyReportsModel companyReportsModel;
	private List<CompanyReportsModel> companyReportsModels;

	
	/**
	 * 浏览
	 * @throws ActionException
	 */
	public String show() throws Exception {
		String startdate = request.getParameter("startdate");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		if(startdate==null){
			startdate = df.format(new Date());
		}
		Calendar c =Calendar.getInstance();
		c.setTime(df.parse(startdate));
		companyReportsModel.setStartYear(String.valueOf(c.get(Calendar.YEAR)));
		companyReportsModel.setStartMonth(String.valueOf(c.get(Calendar.MONTH)+1));
//		companyReportsModel.setFillDate(new Date());
		companyReportsModels = companyReportsService.getByYM(companyReportsModel.getStartYear(), companyReportsModel.getStartMonth(),getCurrentUser());
		if(companyReportsModels!=null&&companyReportsModels.size()>0){
			for(int i = 0 ; i<companyReportsModels.size();i++){
				if(companyReportsModels.get(i).getId()!=null&&companyReportsModels.get(i).getId()>0){
					companyReportsModel = companyReportsModels.get(i);
					break;
				}
			}
		}
		request.setAttribute("startdate", startdate);
		this.setParameters(page_forward_show_companyReports);
		return SUCCESS;
	}
	
	/**
	 * 添加导航
	 * @throws ActionException
	 */
	public String insert() throws Exception {
		String startdate = request.getParameter("startdate");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		if(startdate==null){
			startdate = df.format(new Date());
		}
		Calendar c =Calendar.getInstance();
		c.setTime(df.parse(startdate));
		companyReportsModel.setStartYear(String.valueOf(c.get(Calendar.YEAR)));
		companyReportsModel.setStartMonth(String.valueOf(c.get(Calendar.MONTH)+1));
		companyReportsModel.setFillDate(new Date());
		companyReportsModels = companyReportsService.getByYM(companyReportsModel.getStartYear(), companyReportsModel.getStartMonth(),getCurrentUser());
		if(companyReportsModels!=null&&companyReportsModels.size()>0){
			for(int i = 0 ; i<companyReportsModels.size();i++){
				if(companyReportsModels.get(i).getId()!=null&&companyReportsModels.get(i).getId()>0){
					companyReportsModel = companyReportsModels.get(i);
					break;
				}
			}
		}
//		companyReportsModel.setUnitResponsible("");
//		companyReportsModel.setFillDate(null);
		request.setAttribute("startdate", startdate);
		this.setParameters(page_forward_showinsert_companyReports);
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
		companyReportsModel = companyReportsService.findById(this.getId());
		this.setParameters(page_forward_showupdate_companyReports);
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
		companyReportsModel = companyReportsService.findById(this.getId());
		this.setParameters(page_forward_showdetail_companyReports);
		return SUCCESS;
	}

	/**
	 * 保存到数据
	 * @throws ActionException
	 */
	public String save() throws Exception {
		OperateResult or = null;
		String startdate = request.getParameter("startdate");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		if(startdate==null){
			startdate = df.format(new Date());
		}
		Calendar c =Calendar.getInstance();
		c.setTime(df.parse(startdate));
		companyReportsModel.setStartYear(String.valueOf(c.get(Calendar.YEAR)));
		companyReportsModel.setStartMonth(String.valueOf(c.get(Calendar.MONTH)+1));
		String[] mid = request.getParameterValues("mid");//companyReportsModel.id
		String[] eid = request.getParameterValues("eid");//companyReportsModel.fkEnumModel.id
		String[] ety = request.getParameterValues("ety");//companyReportsModel.fkEnumModel.enumCode
		String[] hsc = request.getParameterValues("hsc");//companyReportsModel.fkEnumModel.hasChildren
		String[] efi = request.getParameterValues("efi");//companyReportsModel.fkEnumModel.fatherId
		
		String[] n1 = request.getParameterValues("n1");
		String[] n2 = request.getParameterValues("n2");
		String[] n3 = request.getParameterValues("n3");
		String[] n4 = request.getParameterValues("n4");
		String[] n5 = request.getParameterValues("n5");
		String[] n6 = request.getParameterValues("n6");
		String[] n7 = request.getParameterValues("n7");
		String[] n8 = request.getParameterValues("n8");
		String[] n9 = request.getParameterValues("n9");
		String[] n10 = request.getParameterValues("n10");
		String[] n11 = request.getParameterValues("n11");
		String[] n12 = request.getParameterValues("n12");
		String[] n13 = request.getParameterValues("n13");
		String[] n14 = request.getParameterValues("n14");
		String[] n15 = request.getParameterValues("n15");
		String[] n16 = request.getParameterValues("n16");
		String[] n17 = request.getParameterValues("n17");
		String[] n18 = request.getParameterValues("n18");
		String[] n19 = request.getParameterValues("n19");
		String[] n20 = request.getParameterValues("n20");
		CompanyReportsModel crm = new CompanyReportsModel();
//		crm.setContactPhone(companyReportsModel.getContactPhone());//第一次保存的记录
		crm.setContactPhone(this.getCurrentUser().getUserPhone());//每次修改人的数据记录
		crm.setFillDate(companyReportsModel.getFillDate());
//		crm.setFillPerson(companyReportsModel.getFillPerson());//第一次保存的记录
		crm.setFillPerson(this.getCurrentUser().getTruename());//每次修改人的数据记录
		crm.setModifyDate(new Date());
		crm.setStartYear(companyReportsModel.getStartYear());
		crm.setStartMonth(companyReportsModel.getStartMonth());
//		crm.setFkOrganizeModel(companyReportsModel.getFkOrganizeModel());//第一次保存的记录
		crm.setFkOrganizeModel(this.getCurrentUser().getFkOrganize());//每次修改人的数据记录
		crm.setUnitResponsible(companyReportsModel.getUnitResponsible());
		CompanyReportsModel father = new CompanyReportsModel();
		for(int i = 0;i<mid.length;i++){
			FkEnumModel enumModel = new FkEnumModel();
			crm.setIndustryType(ety[i]);
			enumModel.setId(Long.parseLong(eid[i]));
			enumModel.setFatherId(Long.parseLong(efi[i]));
			crm.setFkEnumModel(enumModel);
			crm.setId(Long.parseLong(mid[i]));
			
			if(hsc[i].equals("true")){
//				father.setContactPhone(companyReportsModel.getContactPhone());//第一次保存的记录
				father.setContactPhone(this.getCurrentUser().getUserPhone());//每次修改人的数据记录
				father.setFillDate(companyReportsModel.getFillDate());
//				father.setFillPerson(companyReportsModel.getFillPerson());//第一次保存的记录
				father.setFillPerson(this.getCurrentUser().getTruename());//每次修改人的数据记录
				father.setModifyDate(new Date());
				father.setStartYear(companyReportsModel.getStartYear());
				father.setStartMonth(companyReportsModel.getStartMonth());
//				father.setFkOrganizeModel(companyReportsModel.getFkOrganizeModel());//第一次保存的记录
				father.setFkOrganizeModel(this.getCurrentUser().getFkOrganize());//每次修改人的数据记录
				father.setUnitResponsible(companyReportsModel.getUnitResponsible());
				father.setIndustryType(ety[i]);
				father.setFkEnumModel(enumModel);
				father.setId(Long.parseLong(mid[i]));
				father.setFirstArea(this.getCurrentUser().getFirstArea());
				father.setSecondArea(this.getCurrentUser().getSecondArea());
				father.setThirdArea(this.getCurrentUser().getThirdArea());
				father.setFourthArea(this.getCurrentUser().getFourthArea());
				father.setFifthArea(this.getCurrentUser().getFifthArea());
			}else{
				crm.setFirstArea(this.getCurrentUser().getFirstArea());
				crm.setSecondArea(this.getCurrentUser().getSecondArea());
				crm.setThirdArea(this.getCurrentUser().getThirdArea());
				crm.setFourthArea(this.getCurrentUser().getFourthArea());
				crm.setFifthArea(this.getCurrentUser().getFifthArea());
				crm.setN1(Integer.parseInt(n1[i]));
				crm.setN2(Integer.parseInt(n2[i]));
				crm.setN3(Integer.parseInt(n3[i]));
				crm.setN4(Integer.parseInt(n4[i]));
				crm.setN5(Integer.parseInt(n5[i]));
				crm.setN6(Integer.parseInt(n6[i]));
				crm.setN7(Integer.parseInt(n7[i]));
				crm.setN8(Integer.parseInt(n8[i]));
				crm.setN9(Integer.parseInt(n9[i]));
				crm.setN10(Integer.parseInt(n10[i]));
				crm.setN11(Integer.parseInt(n11[i]));
				crm.setN12(Integer.parseInt(n12[i]));
				crm.setN13(Integer.parseInt(n13[i]));
				crm.setN14(Integer.parseInt(n14[i]));
				crm.setN15(Integer.parseInt(n15[i]));
				crm.setN16(Integer.parseInt(n16[i]));
				crm.setN17(Integer.parseInt(n17[i]));
				crm.setN18(Integer.parseInt(n18[i]));
				crm.setN19(Integer.parseInt(n19[i]));
				crm.setN20(Integer.parseInt(n20[i]));
				if(father!=null&&father.getFkEnumModel()!=null&&father.getFkEnumModel().getId()==crm.getFkEnumModel().getFatherId()){
					father.setN1(father.getN1()+crm.getN1());
					father.setN2(father.getN2()+crm.getN2());
					father.setN3(father.getN3()+crm.getN3());
					father.setN4(father.getN4()+crm.getN4());
					father.setN5(father.getN5()+crm.getN5());
					father.setN6(father.getN6()+crm.getN6());
					father.setN7(father.getN7()+crm.getN7());
					father.setN8(father.getN8()+crm.getN8());
					father.setN9(father.getN9()+crm.getN9());
					father.setN10(father.getN10()+crm.getN10());
					father.setN11(father.getN11()+crm.getN11());
					father.setN12(father.getN12()+crm.getN12());
					father.setN13(father.getN13()+crm.getN13());
					father.setN14(father.getN14()+crm.getN14());
					father.setN15(father.getN15()+crm.getN15());
					father.setN16(father.getN16()+crm.getN16());
					father.setN17(father.getN17()+crm.getN17());
					father.setN18(father.getN18()+crm.getN18());
					father.setN19(father.getN19()+crm.getN19());
					father.setN20(father.getN20()+crm.getN20());
				}else if(father !=null&&father.getIndustryType()!=null&&!father.getIndustryType().equals("")){
					companyReportsService.save(father);
					father = new CompanyReportsModel();
				}
				or = companyReportsService.save(crm);
			}
		}
//		or = companyReportsService.save(companyReportsModel);
		
		this.setCompanyReportsModel(null);
		this.setParameters(or.getMessage(),action_forward_insert_companyReports+"?startdate="+startdate);
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
		or = companyReportsService.remove(this.getSelectedIds());
		this.setParameters(or.getMessage(),action_forward_managers_companyReports);
		return SUCCESS;
	}

	/**
	 * 管理及列表
	 * 加入用户操作的数据范围
	 * @throws ActionException
	 */
	public String manager() throws Exception {
		companyReportsModel.setFirstArea(this.getCurrentUser().getFirstArea());
		companyReportsModel.setSecondArea(this.getCurrentUser().getSecondArea());
		companyReportsModel.setThirdArea(this.getCurrentUser().getThirdArea());
		companyReportsModel.setFourthArea(this.getCurrentUser().getFourthArea());
		companyReportsModel.setFifthArea(this.getCurrentUser().getFifthArea());
		companyReportsModels = companyReportsService.getCollection(companyReportsModel);
		this.setParameters(page_forward_tomanagers_companyReports);
		return SUCCESS;
	}
	
	/**
	 * 导出当前列表的数据（EXCEL、PDF、CSV）
	 * 如果须要导出其它数据，只须将数据集和导出的列做一定量调整及可
	 * @throws ActionException
	 */@SuppressWarnings("deprecation")
	public String report() throws Exception {
		companyReportsModels = companyReportsService.getCollection(companyReportsModel);
		TableFacade tableFacade = new TableFacade("companyReportsModel", request);
		tableFacade.setExportTypes(response, ExportType.EXCEL, ExportType.PDF, ExportType.CSV);
		String[] columns = {"industryType","startMonth","startYear","unitResponsible","fillPerson","contactPhone","fillDate","n1","n2","n3","n4","n5","n6","n7","n8","n9","n10","n11","n12","n13","n14","n15","n16","n17","n18","n19","n20",};
		tableFacade.setColumnProperties(columns);
		tableFacade.setItems(companyReportsModels);
		Limit limit = tableFacade.getLimit();
		if (limit.isExported()) {
			tableFacade.render();
		}
		return NONE;
	}
	
	
	public void prepare() throws Exception {
		if (companyReportsModel == null) {
			companyReportsModel = new CompanyReportsModel(request, "companyReportsModel");
		}
	}
	
	/**
	 * @return the companyReportsModel
	 */
	public CompanyReportsModel getCompanyReportsModel() {
		return companyReportsModel;
	}

	/**
	 * @param companyReportsModel the companyReportsModel to set
	 */
	public void setCompanyReportsModel(CompanyReportsModel companyReportsModel) {
		this.companyReportsModel = companyReportsModel;
	}

	/**
	 * @return the companyReportsModels
	 */
	public List<CompanyReportsModel> getCompanyReportsModels() {
		return companyReportsModels;
	}

	/**
	 * @param companyReportsModels the companyReportsModels to set
	 */
	public void setCompanyReportsModels(List<CompanyReportsModel> companyReportsModels) {
		this.companyReportsModels = companyReportsModels;
	}
}
