/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.xjx.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;


/**
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "jxGoodsModel")
@Table(name = "jx_goods")
@AttributeOverride(name = "id", column = @Column(name = "JG_ID"))
public class JxGoodsModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public JxGoodsModel(){ 
		super();
	}
	
	public JxGoodsModel(HttpServletRequest request, String tableId){
		super(request, tableId);
	}

	private java.lang.String jgIncode;
	private java.lang.String jgCode;
	private java.lang.String jgName;
	private java.lang.Integer jgDept;
	private JxUnitModel jgSunit;
	private JxUnitModel jgBunit;
	private java.lang.String jgSpec;
	private java.lang.String jgOrigin;
	private java.lang.String jgFactory;
	private java.lang.Integer jgRate;
	private java.lang.Float jgGuided;
	private java.lang.Integer jgShelf;
	private java.lang.Integer jgPcycle;
	private java.lang.Integer jgSeway;
	private java.lang.Boolean jgCansell;
	private java.lang.Boolean jgSpare;
	private java.lang.Boolean jgIntsell;
	private java.lang.String jgRemark;
	private JxDeptModel jxDept;
	private JxSettlementTypeModel jgStype;
	private JxProductCateModel jgCate;
	private JxPuchaseTypeModel jgPtype;
	private List<JxInventoryModel> jxInventorys;
	
	@Column(name = "JG_INCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJgIncode() {
		return this.jgIncode;
	}
	
	public void setJgIncode(java.lang.String jgIncode) {
		this.jgIncode = jgIncode;
	}
	
	@Column(name = "JG_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJgCode() {
		return this.jgCode;
	}
	
	public void setJgCode(java.lang.String jgCode) {
		this.jgCode = jgCode;
	}
	
	@Column(name = "JG_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public java.lang.String getJgName() {
		return this.jgName;
	}
	
	public void setJgName(java.lang.String jgName) {
		this.jgName = jgName;
	}
	
	@Column(name = "JG_DEPT", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJgDept() {
		return this.jgDept;
	}
	
	public void setJgDept(java.lang.Integer jgDept) {
		this.jgDept = jgDept;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JG_SUNIT", nullable = false, insertable = false, updatable = false)
	public JxUnitModel getJgSunit() {
		return this.jgSunit;
	}
	
	public void setJgSunit(JxUnitModel jgSunit) {
		this.jgSunit = jgSunit;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JG_BUNIT", nullable = false, insertable = false, updatable = false)
	public JxUnitModel getJgBunit() {
		return this.jgBunit;
	}
	
	public void setJgBunit(JxUnitModel jgBunit) {
		this.jgBunit = jgBunit;
	}
	
	@Column(name = "JG_SPEC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJgSpec() {
		return this.jgSpec;
	}
	
	public void setJgSpec(java.lang.String jgSpec) {
		this.jgSpec = jgSpec;
	}
	
	@Column(name = "JG_ORIGIN", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJgOrigin() {
		return this.jgOrigin;
	}
	
	public void setJgOrigin(java.lang.String jgOrigin) {
		this.jgOrigin = jgOrigin;
	}
	
	@Column(name = "JG_FACTORY", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJgFactory() {
		return this.jgFactory;
	}
	
	public void setJgFactory(java.lang.String jgFactory) {
		this.jgFactory = jgFactory;
	}
	
	@Column(name = "JG_RATE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJgRate() {
		return this.jgRate;
	}
	
	public void setJgRate(java.lang.Integer jgRate) {
		this.jgRate = jgRate;
	}
	
	@Column(name = "JG_GUIDED", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public java.lang.Float getJgGuided() {
		return this.jgGuided;
	}
	
	public void setJgGuided(java.lang.Float jgGuided) {
		this.jgGuided = jgGuided;
	}
	
	@Column(name = "JG_SHELF", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJgShelf() {
		return this.jgShelf;
	}
	
	public void setJgShelf(java.lang.Integer jgShelf) {
		this.jgShelf = jgShelf;
	}
	
	
	@Column(name = "JG_PCYCLE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJgPcycle() {
		return this.jgPcycle;
	}
	
	public void setJgPcycle(java.lang.Integer jgPcycle) {
		this.jgPcycle = jgPcycle;
	}
	
	
	@Column(name = "JG_SEWAY", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJgSeway() {
		return this.jgSeway;
	}
	
	public void setJgSeway(java.lang.Integer jgSeway) {
		this.jgSeway = jgSeway;
	}
	
	@Column(name = "JG_CANSELL", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJgCansell() {
		return this.jgCansell;
	}
	
	public void setJgCansell(java.lang.Boolean jgCansell) {
		this.jgCansell = jgCansell;
	}
	
	@Column(name = "JG_SPARE", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJgSpare() {
		return this.jgSpare;
	}
	
	public void setJgSpare(java.lang.Boolean jgSpare) {
		this.jgSpare = jgSpare;
	}
	
	@Column(name = "JG_INTSELL", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJgIntsell() {
		return this.jgIntsell;
	}
	
	public void setJgIntsell(java.lang.Boolean jgIntsell) {
		this.jgIntsell = jgIntsell;
	}
	
	@Column(name = "JG_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJgRemark() {
		return this.jgRemark;
	}
	
	public void setJgRemark(java.lang.String jgRemark) {
		this.jgRemark = jgRemark;
	}
	
	
	public void setJxDept(JxDeptModel jxDept){
		this.jxDept = jxDept;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JG_DEPT", nullable = false, insertable = false, updatable = false)
	public JxDeptModel getJxDept() {
		return jxDept;
	}
	
	
	public void setJgStype(JxSettlementTypeModel jgStype){
		this.jgStype = jgStype;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JG_STYPE", nullable = false, insertable = false, updatable = false)
	public JxSettlementTypeModel getJgStype() {
		return jgStype;
	}
	
	public void setJgCate(JxProductCateModel jgCate){
		this.jgCate = jgCate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JG_CATE", nullable = false, insertable = false, updatable = false)
	public JxProductCateModel getJgCate() {
		return jgCate;
	}
	
	public void setJgPtype(JxPuchaseTypeModel jgPtype){
		this.jgPtype = jgPtype;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "JG_PTYPE", nullable = false, insertable = false, updatable = false)
	public JxPuchaseTypeModel getJgPtype() {
		return jgPtype;
	}
	
	public void setJxInventorys(List<JxInventoryModel> jxInventorys){
		this.jxInventorys = jxInventorys;
	}
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="jiGoods")
	public List<JxInventoryModel> getJxInventorys() {
		return jxInventorys;
	}
}

