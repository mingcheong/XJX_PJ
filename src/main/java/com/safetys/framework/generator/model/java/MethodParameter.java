package com.safetys.framework.generator.model.java;

/**
 * JAVA参数解析
 * @author Stone
 *
 */
public class MethodParameter {
	// 对应的方法
	private JavaMethod method;
	// JAVA类型
	private String javaType;
	// 方法名称
	private String name;

	public JavaMethod getMethod() {
		return method;
	}

	public void setMethod(JavaMethod method) {
		this.method = method;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
