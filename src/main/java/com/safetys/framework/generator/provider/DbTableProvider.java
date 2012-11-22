package com.safetys.framework.generator.provider;

import com.safetys.framework.generator.IModelProvider;
import com.safetys.framework.generator.model.IModel;

/**
 * 数据库表模型数据的实现类
 * @author Stone
 *
 */
public class DbTableProvider implements IModelProvider {

	//表名
	private String dbTableName;

	public DbTableProvider(String dbTableName) {
		super();
		this.dbTableName = dbTableName;
	}

	public IModel getModel() throws Exception {
		return DbModelHelper.getInstance().getTable(dbTableName);
	}

}
