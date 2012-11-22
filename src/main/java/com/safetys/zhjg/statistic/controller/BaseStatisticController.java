package com.safetys.zhjg.statistic.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.safetys.framework.kernel.controller.BaseController;
import com.safetys.framework.utils.AppUtils;
import com.safetys.zhjg.statistic.service.IBaseStatisticService;

/**
 * 基础的统计控制器
 * 
 * @author Stone
 */
@Scope("prototype")
@Controller("baseStatisticController")
public class BaseStatisticController extends BaseController {

	private static final long serialVersionUID = -3337586730915668232L;
	private static final String page_forward_company_train_statistic = "/template/statistic/company_train_statistic.ftl";
	private static final String page_forward_company_statands_statistic = "/template/statistic/company_statands_statistic.ftl";
	private static final String page_forward_company_industrial_statistic = "/template/statistic/company_industrial_statistic.ftl";
	private static final String page_forward_company_accident_statistic = "/template/statistic/company_accident_statistic.ftl";
	private static final String page_forward_company_chart_statistic = "/template/statistic/company_highcharts_statistic.ftl";
	private static final String page_forward_company_licensing_statistic = "/template/statistic/company_licensing_statistic.ftl";
	private static final String page_forward_company_danger_statistic = "/template/statistic/company_danger_statistic.ftl";
	private static final String page_forward_company_GIS_statistic = "/template/statistic/company_map_statistic.ftl";

	// 统计的记录集
	private List<?> statisticDatas;
	private List<?> areas;
	// 基本的统计服务接口
	@Resource(name = "baseStatisticService")
	private IBaseStatisticService baseStatisticService;
	private String ym;
	private List<?> enums;
	
	/**
	 * 根据区域和枚举获取企业信息
	 * @return
	 * @throws Exception
	 */
	public String cpmpsnyJosnForGIS()throws Exception{
		
		String areaCode = request.getParameter("ac");
		String enumCode = request.getParameter("ec");
		statisticDatas = baseStatisticService.getCompanyGISStatistic(areaCode, enumCode, getCurrentUser());
		if(statisticDatas!=null&&statisticDatas.size()>0){
			StringBuilder json = new StringBuilder();
			json.append("[");
			for(int i= 0;i<statisticDatas.size();i++){
				Object[] o = (Object[]) statisticDatas.get(i);
				
				json.append("{comname:'").append(AppUtils.isNullOrEmptyString(o[0])?"":o[0].toString()).append("',address:'").append(AppUtils.isNullOrEmptyString(o[1])?"":o[1].toString()).append("',content:'");
				json.append("企业名称：").append(AppUtils.isNullOrEmptyString(o[0])?"":"<a href=\"javascript:;\" id=\"selectHerf"+o[9].toString()+"\" onclick=\"javascript:selectHerf("+o[9].toString()+")\">"+o[0].toString()+"</a>");
				json.append("<br>企业地址：").append(AppUtils.isNullOrEmptyString(o[1])?"":o[1].toString());
				json.append("<br>所在区域：").append((AppUtils.isNullOrEmptyString(o[2])?"":o[2].toString())+(AppUtils.isNullOrEmptyString(o[3])?"":o[3].toString())+(AppUtils.isNullOrEmptyString(o[4])?"":o[4].toString()));
				json.append("<br>企业性质：").append(AppUtils.isNullOrEmptyString(o[5])?"":o[5].toString());
				json.append("<br>行业类型：").append(AppUtils.isNullOrEmptyString(o[6])?"":o[6].toString());
				json.append("<br>法人代表：").append(AppUtils.isNullOrEmptyString(o[7])?"":o[7].toString());
				json.append("<br>法人电话：").append(AppUtils.isNullOrEmptyString(o[8])?"":o[8].toString());
				json.append("'},");
			}
			response.setContentType("text/plain;charset=utf-8");
			response.getWriter().print(json.toString().substring(0,json.length()-1)+"]");
			response.getWriter().close();
		}
		return NONE;
	}

	/**
	 * 首页GIS地图
	 * @return
	 * @throws Exception
	 */
	public String company_maps()throws Exception{
		request.setAttribute("ac", AppUtils.getUserLastArea(getCurrentUser()).getValue());
		statisticDatas = baseStatisticService.getCompanyGISStatistic(getCurrentUser());
		this.setParameters(page_forward_company_GIS_statistic);
		return SUCCESS;
	}
	
	/**
	 * 首页hightcharts图形统计
	 * @return
	 * @throws Exception
	 */
	public String company_charts()throws Exception{
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		enums = baseStatisticService.getEnumByFatherCode("industrial");
		ym="2012-05";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date = sdf.parse(ym);
		statisticDatas = baseStatisticService.getCompanyIndustrialStatisticByDate(getCurrentUser(), date,enums,request);
		this.setParameters(page_forward_company_chart_statistic);
		return SUCCESS;
	}
	
	/**
	 * 标准化统计
	 * 
	 * @throws Exception
	 */
	public String company_statands() throws Exception {
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		statisticDatas = baseStatisticService.getCompanyStatandsByStatistic(getCurrentUser());
		this.setParameters(page_forward_company_statands_statistic);
		return SUCCESS;
	}
	
	/**
	 * 企业培训统计
	 * 
	 * @throws Exception
	 */
	public String company_train() throws Exception {
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		List<?> train = baseStatisticService.getCompanyTrainStatistic(getCurrentUser(), 1); // 已培训
		List<?> unTrian = baseStatisticService.getCompanyTrainStatistic(getCurrentUser(), 0); // 未培训
		this.request.setAttribute("sTrain", train);
		this.request.setAttribute("sUnTrian", unTrian);
		this.setParameters(page_forward_company_train_statistic);
		return SUCCESS;
	}

	/**
	 * 企业行业类型统计
	 * 
	 * @throws Exception
	 */
	public String company_industrial() throws Exception {
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		statisticDatas = baseStatisticService.getCompanyIndustrialStatistic(getCurrentUser());
		this.setParameters(page_forward_company_industrial_statistic);
		return SUCCESS;
	}

	/**
	 * 事故上报统计
	 * 
	 * @throws Exception
	 */
	public String company_accident() throws Exception {
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		statisticDatas = baseStatisticService.getCompanyAccidentByStatistic(getCurrentUser());
		this.setParameters(page_forward_company_accident_statistic);
		return SUCCESS;
	}

	/**
	 * 行政许可
	 * @throws Exception
	 */
	public String company_licensing()throws Exception{
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		statisticDatas = baseStatisticService.getCompanyLicensingByStatistic(getCurrentUser());
		this.setParameters(page_forward_company_licensing_statistic);
		return SUCCESS;
	}
	
	/**
	 * 重大危险源统计
	 * @throws Exception
	 */
	public String company_danger()throws Exception{
		areas = baseStatisticService.getAreaModelsByStatistic(getCurrentUser());
		statisticDatas = baseStatisticService.getCompanyDangerByStatistic(getCurrentUser());
		this.setParameters(page_forward_company_danger_statistic);
		return SUCCESS;
	}
	
	public List<?> getStatisticDatas() {
		return statisticDatas;
	}

	public void setStatisticDatas(List<?> statisticDatas) {
		this.statisticDatas = statisticDatas;
	}

	public List<?> getAreas() {
		return areas;
	}

	public void setAreas(List<?> areas) {
		this.areas = areas;
	}

	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}

	public List<?> getEnums() {
		return enums;
	}

	public void setEnums(List<?> enums) {
		this.enums = enums;
	}

}
