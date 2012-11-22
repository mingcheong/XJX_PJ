package com.safetys.framework.generator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.safetys.framework.generator.model.db.Table;
import com.safetys.framework.generator.provider.DbModelHelper;
import com.safetys.framework.generator.provider.DbTableProvider;

/**
 * 生成文件
 * 
 * @author Stone
 */
public class GeneratorFile {

	GeneratorCore generator = new GeneratorCore();

	/**
	 * 删除文件夹
	 * @throws IOException
	 */
	public void clean() throws IOException {
		generator.removeJavaFile();
		generator.removePageFile();
	}

	/**
	 * 根据指定的表生成文件代码（指定单个表）
	 * @param tableName
	 * @throws Exception
	 */
	public void generateCRUDByTable(String tableName) throws Exception {
		generator.templateRootDir = new File("template/crud").getAbsoluteFile();
		generator.modelProvider = new DbTableProvider(tableName);
		generator.generateByModelProvider();
	}

	/**
	 * 根据指定的表生成文件代码(指定具体的一部份表)
	 * @param tableName
	 * @throws Exception
	 */
	public void generateCRUDByTables(String[] tableNames) throws Exception {
		for (String tableName : tableNames) {
			generator.templateRootDir = new File("template/crud").getAbsoluteFile();
			generator.modelProvider = new DbTableProvider(tableName);
			generator.generateByModelProvider();
		}
	}

	/**
	 * 生成数据库中所有表的文件及代码
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void generateCRUDByAllTable() throws Exception {
		generator.templateRootDir = new File("template/crud").getAbsoluteFile();
		List<Table> allTable = DbModelHelper.getInstance().getAllTables();
		for (Table t : allTable) {
			if(!"pk_table".equals(t.getSqlName())){
				generator.modelProvider = new DbTableProvider(t.getSqlName());
				generator.generateByModelProvider();
			}
		}
	}
}
