package com.safetys.zhjg.statistic.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.IBaseService;
import com.safetys.framework.system.model.FkUserModel;

/**
 * 基本的统计服务接口
 * @author Stone
 *
 */
@SuppressWarnings("rawtypes")
public interface IBaseStatisticService extends IBaseService{
	
	/**
	 * 根据当前用户取统计区域
	 * @param user
	 * @throws ServicesException
	 */
	public List<?> getAreaModelsByStatistic(FkUserModel user)throws ServicesException;

	/**
	 * 企业陪训统计
	 * @param object   用户信息
	 * @param state	   培训状态 0:未培训    1:已培训
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyTrainStatistic(FkUserModel object,int state) throws ServicesException ;
	
	/**
	 * 企业行业类型统计
	 * @param object
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCompanyIndustrialStatistic(FkUserModel object)throws ServicesException;
	
	/**
	 * 事故上报统计
	 * @param object
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCompanyAccidentByStatistic(FkUserModel object)throws ServicesException;
	
	/**
	 * 标准化统计
	 * @param object
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCompanyStatandsByStatistic(FkUserModel object)throws ServicesException;
	
	/**
	 * 行政许可统计
	 * @param object
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCompanyLicensingByStatistic(FkUserModel object) throws ServicesException;
	
	/**
	 * 首页chart图形统计区域类型
	 * date暂不使用
	 * @param fkUserModel
	 * @param date
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyIndustrialStatisticByDate(FkUserModel fkUserModel,Date date,List<?> enums,HttpServletRequest request) throws ServicesException;
	
	/**
	 * GIS根据当前用户统计
	 * @param fkUserModel
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyGISStatistic(FkUserModel fkUserModel)throws ServicesException;
	
	/**
	 * 根据区域和枚举获取企业信息
	 * @param fkUserModel
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getCompanyGISStatistic(String areaCode,String enumCode,FkUserModel fkUserModel)throws ServicesException;
	
	/**
	 * 根据父枚举编号返回子类枚举
	 * @param code
	 * @return
	 * @throws ServicesException
	 */
	public List<?> getEnumByFatherCode(String code) throws ServicesException;
	
	/**
	 * 重大危险源
	 * @param object
	 * @return {@link List}
	 * @throws ServicesException
	 */
	public List<?> getCompanyDangerByStatistic(FkUserModel object) throws ServicesException ;
}
