/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.framework.system.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.safetys.framework.exception.ActionException;
import com.safetys.framework.exception.DaoException;
import com.safetys.framework.exception.ServicesException;
import com.safetys.framework.kernel.service.impl.BaseServiceImpl;
import com.safetys.framework.system.dao.IFkAreaDao;
import com.safetys.framework.system.model.FkAreaModel;
import com.safetys.framework.system.service.IFkAreaService;
import com.safetys.framework.utils.ConfigUtil;
import com.safetys.framework.utils.FileUtils;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Service("fkAreaService")
@Transactional(propagation = Propagation.REQUIRED)
public class FkAreaServiceImpl extends BaseServiceImpl<FkAreaModel, Long> implements IFkAreaService {

	@Resource(name = "fkAreaDao")
	protected IFkAreaDao fkAreaDao;

	@Autowired
	public FkAreaServiceImpl(@Qualifier("fkAreaDao") IFkAreaDao fkAreaDao) {
		super(fkAreaDao);
	}

	public boolean datasToXml(FkAreaModel model, List<FkAreaModel> datas) {
		try {
			String jpql = "select o from fkAreaModel o where o.fatherId=";
			final Document document = DocumentHelper.createDocument();
			final Element firstElement = document.addElement("first-area");
			firstElement.addAttribute("name", model.getAreaName());
			firstElement.addAttribute("code", model.getAreaCode());
			if (datas != null && datas.size() > 0) {
				for (FkAreaModel secondData : datas) {
					Element secondElement = firstElement.addElement("second-area");
					secondElement.addAttribute("name", secondData.getAreaName());
					secondElement.addAttribute("code", secondData.getAreaCode());
					if (secondData.getHasChildren()) {
						List<FkAreaModel> thirdDatas = fkAreaDao.getCollection(jpql + secondData.getId(), new String[] { "id" }, false);
						if (thirdDatas != null && thirdDatas.size() > 0) {
							for (FkAreaModel thirdData : thirdDatas) {
								Element thirdElement = secondElement.addElement("third-area");
								thirdElement.addAttribute("name", thirdData.getAreaName());
								thirdElement.addAttribute("code", thirdData.getAreaCode());
								if (thirdData.getHasChildren()) {
									List<FkAreaModel> fouthDatas = fkAreaDao.getCollection(jpql + thirdData.getId(), new String[] { "id" }, false);
									if (fouthDatas != null && fouthDatas.size() > 0) {
										for (FkAreaModel fouthData : fouthDatas) {
											Element fouthElement = thirdElement.addElement("fouth-area");
											fouthElement.addAttribute("name", fouthData.getAreaName());
											fouthElement.addAttribute("code", fouthData.getAreaCode());
											if (fouthData.getHasChildren()) {
												List<FkAreaModel> fifthDatas = fkAreaDao.getCollection(jpql + fouthData.getId(), new String[] { "id" }, false);
												if (fifthDatas != null && fifthDatas.size() > 0) {
													for (FkAreaModel fifthData : fifthDatas) {
														Element fifthElement = fouthElement.addElement("fifth-area");
														fifthElement.addAttribute("name", fifthData.getAreaName());
														fifthElement.addAttribute("code", fifthData.getAreaCode());
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			FileUtils.writerBufferToLocalFile(document.asXML(), ConfigUtil.getGlobalPropertyValue("file.release.dir") + File.separator + "area.xml");
			return true;
		} catch (Exception e) {
			new ActionException("文件生成失败！", e);
		}
		return false;
	}

	public boolean saveByXml(List<FkAreaModel> fkAreaModels,FkAreaModel fkAreaModel) throws ServicesException{
		boolean b = true;
		try {
			for(FkAreaModel m : fkAreaModels){
				m.setFatherId(fkAreaModel.getId());
				if(m.getChildren()!=null&&m.getChildren().size()>0){
					m.setHasChildren(true);
					m =fkAreaDao.save(m);
					saveByXml(m.getChildren(),m);
				}else{
					fkAreaDao.save(m);
				}
			}
		} catch (DaoException e) {
			throw new ServicesException(e);
		}
		return b;
	}
}