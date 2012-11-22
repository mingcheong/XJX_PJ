package com.safetys.framework.generator.model.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.safetys.framework.generator.model.IModel;

/**
 * JAVA方法解析
 * 
 * @author Stone
 */
public class JavaMethod implements IModel {
	// 方法对应的JAVA类文件
	private JavaClass clazz;
	// 方法名称
	private String methodName;
	// 返回类型
	private MethodParameter returnType;
	// 参数
	private List<MethodParameter> parameters = new ArrayList<MethodParameter>();

	public JavaClass getClazz() {
		return clazz;
	}

	public void setClazz(JavaClass javaClass) {
		this.clazz = javaClass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public MethodParameter getReturnType() {
		return returnType;
	}

	public void setReturnType(MethodParameter returnValue) {
		this.returnType = returnValue;
	}

	public List<MethodParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<MethodParameter> parameters) {
		this.parameters = parameters;
	}

	public String getDisplayDescription() {
		return "java method:" + getMethodName();
	}

	public String getTemplateModelName() {
		return "method";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mergeFilePathModel(Map fileModel) throws Exception {
		fileModel.putAll(BeanUtils.describe(this));
		fileModel.putAll(BeanUtils.describe(getClazz()));
	}

	public String getMethodNameUpper() {
		return Character.toUpperCase(getMethodName().charAt(0)) + getMethodName().substring(1);
	}

}
