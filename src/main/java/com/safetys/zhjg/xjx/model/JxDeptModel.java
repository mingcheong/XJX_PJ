/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.xjx.model;

import java.util.List;
import javax.persistence.*;

import com.safetys.framework.kernel.model.BaseModel;
import javax.servlet.http.HttpServletRequest;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "jxDeptModel")
@Table(name = "jx_dept")
@AttributeOverride(name = "id", column = @Column(name = "JD_ID"))
public class JxDeptModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public JxDeptModel(){ 
		super();
	}
	
	public JxDeptModel(HttpServletRequest request, String tableId){
		super(request, tableId);
	}
	
	private java.lang.String jdCode;
	private java.lang.String jdName;
	private java.lang.Integer jdParent;
	private java.lang.Boolean jdCanuse;
	private java.lang.String jdRemark;
	private List<JxInInventoryModel> jxInInventorys;
	private List<JxSalesModel> jxSaless;
	private List<JxGoodsModel> jxGoodss;
	private List<JxEmployeeModel> jxEmployees;
	private List<JxBackInventoryModel> jxBackInventorys;
	private List<JxMoveInventoryModel> jxMoveInventorys;

	
	@Column(name = "JD_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJdCode() {
		return this.jdCode;
	}
	
	public void setJdCode(java.lang.String jdCode) {
		this.jdCode = jdCode;
	}
	
	@Column(name = "JD_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public java.lang.String getJdName() {
		return this.jdName;
	}
	
	public void setJdName(java.lang.String jdName) {
		this.jdName = jdName;
	}
	
	@Column(name = "JD_PARENT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJdParent() {
		return this.jdParent;
	}
	
	public void setJdParent(java.lang.Integer jdParent) {
		this.jdParent = jdParent;
	}
	
	@Column(name = "JD_CANUSE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJdCanuse() {
		return this.jdCanuse;
	}
	
	public void setJdCanuse(java.lang.Boolean jdCanuse) {
		this.jdCanuse = jdCanuse;
	}
	
	@Column(name = "JD_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJdRemark() {
		return this.jdRemark;
	}
	
	public void setJdRemark(java.lang.String jdRemark) {
		this.jdRemark = jdRemark;
	}
	
	
	public void setJxInInventorys(List<JxInInventoryModel> jxInInventorys){
		this.jxInInventorys = jxInInventorys;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jiDept")
	public List<JxInInventoryModel> getJxInInventorys() {
		return jxInInventorys;
	}
	
	public void setJxSaless(List<JxSalesModel> jxSaless){
		this.jxSaless = jxSaless;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jsDept")
	public List<JxSalesModel> getJxSaless() {
		return jxSaless;
	}
	
	public void setJxGoodss(List<JxGoodsModel> jxGoodss){
		this.jxGoodss = jxGoodss;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jgDept")
	public List<JxGoodsModel> getJxGoodss() {
		return jxGoodss;
	}
	
	public void setJxEmployees(List<JxEmployeeModel> jxEmployees){
		this.jxEmployees = jxEmployees;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jeDept")
	public List<JxEmployeeModel> getJxEmployees() {
		return jxEmployees;
	}
	
	public void setJxBackInventorys(List<JxBackInventoryModel> jxBackInventorys){
		this.jxBackInventorys = jxBackInventorys;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jbDept")
	public List<JxBackInventoryModel> getJxBackInventorys() {
		return jxBackInventorys;
	}
	
	public void setJxMoveInventorys(List<JxMoveInventoryModel> jxMoveInventorys){
		this.jxMoveInventorys = jxMoveInventorys;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jmDept")
	public List<JxMoveInventoryModel> getJxMoveInventorys() {
		return jxMoveInventorys;
	}
}

