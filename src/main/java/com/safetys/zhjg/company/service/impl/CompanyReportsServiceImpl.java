/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.safetys.framework.exception.DaoException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.model.FkEnumModel;
import com.safetys.framework.system.model.FkUserModel;
import com.safetys.framework.system.service.IFkEnumService;
import com.safetys.framework.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.safetys.zhjg.company.dao.ICompanyReportsDao;
import com.safetys.zhjg.company.model.CompanyReportsModel;
import com.safetys.zhjg.company.service.ICompanyReportsService;

/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("companyReportsService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyReportsServiceImpl extends BaseServiceImpl<CompanyReportsModel, Long> implements ICompanyReportsService {

	
	@Resource(name = "companyReportsDao")
	protected ICompanyReportsDao companyReportsDao;
	@Resource(name="fkEnumService")
	protected IFkEnumService fkEnumService;
	
	@Autowired
	public CompanyReportsServiceImpl(@Qualifier("companyReportsDao") ICompanyReportsDao companyReportsDao) {
		super(companyReportsDao);
	}
	
	public List<CompanyReportsModel> getByYM(String Y, String M,FkUserModel fkUserModel) {
		
		//查出来的数据，主要用于操作（可能里面枚举里新增的没有，或者顺序不对）
		List<CompanyReportsModel> companyReportsModels = new ArrayList<CompanyReportsModel>();
		//返回的list，会和枚举中的排序一致顺序
		List<CompanyReportsModel> list = new ArrayList<CompanyReportsModel>();
		try {
			//根据年月查出记录集
			String SQL = "select o from companyReportsModel o where o.deleted = false and o.startYear = '"+Y+"' and o.startMonth = '"+M+"' ";
			SQL+=AppUtils.buildSqlByUser(fkUserModel, "o");
			companyReportsModels = companyReportsDao.getCollection(SQL,false);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		List<FkEnumModel> enums = new ArrayList<FkEnumModel>();
		enums = fkEnumService.getAllByTypeCode("industrial");//查出数据上报中的所有枚举
		if(companyReportsModels==null||companyReportsModels.size()<1){//如果没有数据，初始化枚举对应的数据
			if(enums!=null&&enums.size()>0){
				for(int i = 0;i<enums.size();i++){
					CompanyReportsModel crf = new CompanyReportsModel();
					crf.setFkEnumModel(enums.get(i));
					list.add(crf);
					if(enums.get(i).getHasChildren()){
						for(int j=0;j<enums.get(i).getChildern().size();j++){
//							if(crf.getChildren()==null){
//								crf.setChildren(new ArrayList<CompanyReportsModel>());
//							}
							CompanyReportsModel crc = new CompanyReportsModel();
							crc.setFkEnumModel(enums.get(i).getChildern().get(j));
//							crf.getChildren().add(crc);
							list.add(crc);
						}
					}
				}
			}
		}else{//如果有数据，将数据根据枚举排序顺序重新排序，对应枚举没有的初始化数据
			for(int i = 0;i<enums.size();i++){
				boolean b = false;
				for(int j=0;j<companyReportsModels.size();j++){
					if(enums.get(i).getEnumCode().equals(companyReportsModels.get(j).getIndustryType())){
						list.add(companyReportsModels.get(j));
						companyReportsModels.remove(j);
						b=true;
						break;
					}
				}
				if(!b){
					CompanyReportsModel crc = new CompanyReportsModel();
					crc.setFkEnumModel(enums.get(i));
					list.add(crc);
				}
				if(enums.get(i).getHasChildren()){
					for(int j=0;j<enums.get(i).getChildern().size();j++){
						boolean bl = false;
						for(int k = 0 ;k<companyReportsModels.size();k++){
							if(enums.get(i).getChildern().get(j).getEnumCode().equals(companyReportsModels.get(k).getIndustryType())){
								list.add(companyReportsModels.get(k));
								companyReportsModels.remove(k);
								bl=true;
								break;
							}
						}
						if(!bl){
							CompanyReportsModel crc = new CompanyReportsModel();
							crc.setFkEnumModel(enums.get(i).getChildern().get(j));
							list.add(crc);
						}
					}
				}
			}
		}
		return list;
	}
	
}