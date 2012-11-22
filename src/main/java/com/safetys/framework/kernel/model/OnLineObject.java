package com.safetys.framework.kernel.model;

import java.io.Serializable;
import java.util.List;

import com.safetys.framework.system.model.FkUserModel;

/**
 * 当前用户信息
 * 
 * @author Stone
 */
public class OnLineObject implements Serializable {

	private static final long serialVersionUID = -6697824837344132038L;

	/**
	 * 当前用户信息
	 */
	private FkUserModel currentUser;

	/**
	 * 所拥有的菜单资源
	 */
	private String selfResource;

	/**
	 * 所拥有的操作权限
	 */
	private List<String> actionNames;

	public FkUserModel getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(FkUserModel currentUser) {
		this.currentUser = currentUser;
	}

	public String getSelfResource() {
		return selfResource;
	}

	public void setSelfResource(String selfResource) {
		this.selfResource = selfResource;
	}

	public List<String> getActionNames() {
		return actionNames;
	}

	public void setActionNames(List<String> actionNames) {
		this.actionNames = actionNames;
	}

}
