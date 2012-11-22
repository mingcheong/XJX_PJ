package com.safetys.framework.generator.model;

import java.util.Map;

/**
 * 模板数据模型
 * 
 * @author Linlin Yu
 * @email yulinlincom(a)gmail.com
 */
public interface IModel {

	/**
	 * model描述
	 * 
	 * @return {@link String}
	 */
	public String getDisplayDescription();

	/**
	 * 为模板路径提供数据
	 * 
	 * @param fileModel
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void mergeFilePathModel(Map fileModel) throws Exception;

	/**
	 * 数据模型描述
	 * 
	 * @return {@link String}
	 */
	public String getTemplateModelName();

}
