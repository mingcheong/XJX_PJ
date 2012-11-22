package com.safetys.framework.generator.model.java;


/**
 * JAVA属性解析
 * 
 * @author Stone
 */
public class JavaClassField {
	// 属性对应的JAVA类文件
	private JavaClass classDto;
	// JAVA类型
	private String javaType;
	// 属性名称
	private String fieldName;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public JavaClass getClassDto() {
		return classDto;
	}

	public void setClassDto(JavaClass classDto) {
		this.classDto = classDto;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public boolean getIsDateTimeField() {
		return javaType.equalsIgnoreCase("java.sql.Date") || javaType.equalsIgnoreCase("java.util.Date");
	}

}
