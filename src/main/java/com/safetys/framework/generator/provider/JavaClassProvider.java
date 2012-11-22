package com.safetys.framework.generator.provider;

import com.safetys.framework.generator.IModelProvider;
import com.safetys.framework.generator.model.IModel;

/**
 * JAVA 模型提供器
 * @author Stone
 *
 */
@SuppressWarnings("rawtypes")
public class JavaClassProvider implements IModelProvider {

	private Class clazz;

	public JavaClassProvider(Class clazz) {
		super();
		this.clazz = clazz;
	}

	public IModel getModel() {
		return JavaModelHelper.getInstance().createJaveClass(clazz);
	}

}
