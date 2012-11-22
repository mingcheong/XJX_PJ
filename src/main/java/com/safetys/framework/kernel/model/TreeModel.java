package com.safetys.framework.kernel.model;

import java.io.Serializable;

/**
 * ztree树形对象
 * 
 * @author Stone
 */
public class TreeModel implements Serializable {

	private static final long serialVersionUID = -1964822499622237891L;

	/**
	 * 主键编号
	 */
	private java.lang.Long id;

	/**
	 * 父编码
	 */
	private java.lang.Long pId;

	/**
	 * 资源名称
	 */
	private java.lang.String name;
	private java.lang.String font = "{color:black}";
	private java.lang.Boolean isParent = true;
	private java.lang.Boolean open = false;

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	/**
	 * @return the pId
	 */
	public java.lang.Long getpId() {
		return pId;
	}

	/**
	 * @param pId
	 *            the pId to set
	 */
	public void setpId(java.lang.Long pId) {
		this.pId = pId;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(java.lang.Boolean isParent) {
		this.isParent = isParent;
	}

	/**
	 * @return the open
	 */
	public java.lang.Boolean getOpen() {
		return open;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(java.lang.Boolean open) {
		this.open = open;
	}

	public java.lang.String getFont() {
		return font;
	}

	public void setFont(java.lang.String font) {
		this.font = font;
	}

}
