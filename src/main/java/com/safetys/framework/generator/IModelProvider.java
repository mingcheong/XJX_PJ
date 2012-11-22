package com.safetys.framework.generator;

import com.safetys.framework.generator.model.IModel;

/**
 * 提供模板数据模型
 */
public interface IModelProvider {

	/**
	 * 得到模板的数据模型
	 * 
	 * @return {@link IModel}
	 * @throws Exception
	 */
	public IModel getModel() throws Exception;
}
