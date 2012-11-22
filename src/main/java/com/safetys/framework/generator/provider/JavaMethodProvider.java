package com.safetys.framework.generator.provider;

import com.safetys.framework.generator.IModelProvider;
import com.safetys.framework.generator.model.IModel;

/**
 * JAVA方法模型提供器
 * @author Stone
 *
 */
@SuppressWarnings("rawtypes")
public class JavaMethodProvider implements IModelProvider {

	private String methodName;

	private Class clazz;

	public JavaMethodProvider(Class clazz, String methodName) {
		super();
		this.clazz = clazz;
		this.methodName = methodName;
	}

	public IModel getModel() {
		return JavaModelHelper.getInstance().createJavaMethod(clazz, methodName);
	}

}
