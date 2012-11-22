package com.safetys.framework.intercept;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.safetys.framework.kernel.controller.RandomController;
import com.safetys.framework.kernel.model.OnLineObject;
import com.safetys.framework.system.controller.AuthorizController;
import com.safetys.framework.system.controller.DispatchController;

public class BaseIntercept extends AbstractInterceptor {

	Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 默认的安全拦截器
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 目前只拦截到控制器，如果要细化到方法，须扩展资源实
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public String intercept(ActionInvocation invocation) throws Exception {
		final Map session = invocation.getInvocationContext().getSession();
		final OnLineObject onLineObject = (OnLineObject) session.get("onLineObject");
		ActionSupport action = (ActionSupport) invocation.getAction();
		final Object object = invocation.getAction();
		if (object instanceof RandomController) {
			return invocation.invoke();
		} else if (object instanceof DispatchController) {
			return invocation.invoke();
		} else if (object instanceof AuthorizController) {
			return invocation.invoke();
		} else {
			if (onLineObject != null) {
				String actionNames = onLineObject.getActionNames().toString();
				String actionName = invocation.getInvocationContext().getName();
				if (actionName.lastIndexOf("_") > 0) {
					actionName = actionName.substring(0, actionName.indexOf("_") + 1);
				}
				if (actionNames.contains(actionName)) {
					return invocation.invoke();
				} else {
					action.addActionError("您无权限访问当前请求的地址，如有需要请联系管理员！");
					return Action.ERROR;
				}
			} else {
				action.addActionError("您还没有登陆，不能访问当前请求的地址！");
				return Action.INPUT;
			}
		}
	}
}
