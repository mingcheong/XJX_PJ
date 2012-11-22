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
@Entity(name = "jxInInventoryModel")
@Table(name = "jx_in_inventory")
@AttributeOverride(name = "id", column = @Column(name = "JI_ID"))
public class JxInInventoryModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public JxInInventoryModel(){ 
		super();
	}
	
	public JxInInventoryModel(HttpServletRequest request, String tableId){
		super(request, tableId);
	}

	private java.lang.String jiCode;
	private java.lang.String jiLastCode;
	private java.lang.String jiOcode;
	private java.lang.String jiCodemark;
	private java.lang.Integer jiDept;
	private java.lang.Integer jiSupplier;
	private java.lang.Integer jiUser;
	private java.util.Date jiDate;
	private java.lang.Integer jiCheckuser;
	private java.lang.Integer jiWarehouse;
	private java.lang.String jiRemark;
	private JxDeptModel jxDept;
	private JxSupplierModel jxSupplier;
	private JxWarehouseModel jxWarehouse;
	private JxEmployeeModel jxEmployee;
	private List<JxInInventoryDetailsModel> jxInInventoryDetailss;
	


	@Column(name = "JI_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJiCode() {
		return this.jiCode;
	}
	
	public void setJiCode(java.lang.String jiCode) {
		this.jiCode = jiCode;
	}
	
	@Column(name = "JI_LAST_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJiLastCode() {
		return this.jiLastCode;
	}
	
	public void setJiLastCode(java.lang.String jiLastCode) {
		this.jiLastCode = jiLastCode;
	}
	
	@Column(name = "JI_OCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJiOcode() {
		return this.jiOcode;
	}
	
	public void setJiOcode(java.lang.String jiOcode) {
		this.jiOcode = jiOcode;
	}
	
	@Column(name = "JI_CODEMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJiCodemark() {
		return this.jiCodemark;
	}
	
	public void setJiCodemark(java.lang.String jiCodemark) {
		this.jiCodemark = jiCodemark;
	}
	
	@Column(name = "JI_DEPT", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJiDept() {
		return this.jiDept;
	}
	
	public void setJiDept(java.lang.Integer jiDept) {
		this.jiDept = jiDept;
	}
	
	@Column(name = "JI_SUPPLIER", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJiSupplier() {
		return this.jiSupplier;
	}
	
	public void setJiSupplier(java.lang.Integer jiSupplier) {
		this.jiSupplier = jiSupplier;
	}
	
	@Column(name = "JI_USER", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJiUser() {
		return this.jiUser;
	}
	
	public void setJiUser(java.lang.Integer jiUser) {
		this.jiUser = jiUser;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "JI_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.util.Date getJiDate() {
		return this.jiDate;
	}
	
	public void setJiDate(java.util.Date jiDate) {
		this.jiDate = jiDate;
	}
	
	@Column(name = "JI_CHECKUSER", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJiCheckuser() {
		return this.jiCheckuser;
	}
	
	public void setJiCheckuser(java.lang.Integer jiCheckuser) {
		this.jiCheckuser = jiCheckuser;
	}
	
	@Column(name = "JI_WAREHOUSE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJiWarehouse() {
		return this.jiWarehouse;
	}
	
	public void setJiWarehouse(java.lang.Integer jiWarehouse) {
		this.jiWarehouse = jiWarehouse;
	}
	
	@Column(name = "JI_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJiRemark() {
		return this.jiRemark;
	}
	
	public void setJiRemark(java.lang.String jiRemark) {
		this.jiRemark = jiRemark;
	}
	
	
	public void setJxDept(JxDeptModel jxDept){
		this.jxDept = jxDept;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JI_DEPT", nullable = false, insertable = false, updatable = false)
	public JxDeptModel getJxDept() {
		return jxDept;
	}
	
	public void setJxSupplier(JxSupplierModel jxSupplier){
		this.jxSupplier = jxSupplier;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JI_SUPPLIER", nullable = false, insertable = false, updatable = false)
	public JxSupplierModel getJxSupplier() {
		return jxSupplier;
	}
	
	public void setJxWarehouse(JxWarehouseModel jxWarehouse){
		this.jxWarehouse = jxWarehouse;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JI_WAREHOUSE", nullable = false, insertable = false, updatable = false)
	public JxWarehouseModel getJxWarehouse() {
		return jxWarehouse;
	}
	
	public void setJxEmployee(JxEmployeeModel jxEmployee){
		this.jxEmployee = jxEmployee;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JI_USER", nullable = false, insertable = false, updatable = false)
	public JxEmployeeModel getJxEmployee() {
		return jxEmployee;
	}
	
	public void setJxInInventoryDetailss(List<JxInInventoryDetailsModel> jxInInventoryDetailss){
		this.jxInInventoryDetailss = jxInInventoryDetailss;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jidInInventory")
	public List<JxInInventoryDetailsModel> getJxInInventoryDetailss() {
		return jxInInventoryDetailss;
	}
}

