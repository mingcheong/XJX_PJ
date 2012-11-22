package com.safetys.framework.generator.model.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.safetys.framework.generator.model.IModel;

/**
 * JAVA类解析
 * 
 * @author Stone
 */
public class JavaClass implements IModel {
	// 类名
	private String className;
	// 包名
	private String packageName;
	// 首字母大写
	private String superclassName;
	// 属性
	private List<JavaClassField> fields = new ArrayList<JavaClassField>();
	// 方法
	private List<JavaMethod> methods = new ArrayList<JavaMethod>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<JavaClassField> getFields() {
		return fields;
	}

	public void setFields(List<JavaClassField> fields) {
		this.fields = fields;
	}

	public String getSuperclassName() {
		return superclassName;
	}

	public void setSuperclassName(String superclassName) {
		this.superclassName = superclassName;
	}

	public List<JavaMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<JavaMethod> methods) {
		this.methods = methods;
	}

	public String getPackagePath() {
		return getPackageName().replace(".", "/");
	}

	public String getDelegateClassName() {
		return className + "Delegate";
	}

	public String getDisplayDescription() {
		return "javaclass:" + getClassName();
	}

	public String getTemplateModelName() {
		return "clazz";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void mergeFilePathModel(Map fileModel) throws Exception {
		fileModel.putAll(BeanUtils.describe(this));
	}

	public String getParentPackageName() {
		return packageName.substring(0, packageName.lastIndexOf("."));
	}

	public String getParentPackagePath() {
		return getParentPackageName().replace(".", "/");
	}

}
