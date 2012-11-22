/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.system.model.FkOrganizeModel;

/**
 * 隐患挂牌实体对象 
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyHiddenlistingModel")
@Table(name = "C010")
public class CompanyHiddenlistingModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyHiddenlistingModel() {
		super();
	}

	public CompanyHiddenlistingModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//挂牌级别
	private java.lang.String level;
	//督办部门
	private java.lang.String supervise;
	//督办完成时间
	private java.util.Date completionDate;
	//督办单位
	private FkOrganizeModel fkOrganizeModel;
	
	private CompanyHiddendangerModel companyHiddendangerModel;

	@Column(name = "A1", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFirstArea() {
		return firstArea;
	}

	public void setFirstArea(java.lang.String firstArea) {
		this.firstArea = firstArea;
	}

	@Column(name = "A2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSecondArea() {
		return secondArea;
	}

	public void setSecondArea(java.lang.String secondArea) {
		this.secondArea = secondArea;
	}

	@Column(name = "A3", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getThirdArea() {
		return thirdArea;
	}

	public void setThirdArea(java.lang.String thirdArea) {
		this.thirdArea = thirdArea;
	}

	@Column(name = "A4", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFourthArea() {
		return fourthArea;
	}

	public void setFourthArea(java.lang.String fourthArea) {
		this.fourthArea = fourthArea;
	}

	@Column(name = "A5", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFifthArea() {
		return fifthArea;
	}

	public void setFifthArea(java.lang.String fifthArea) {
		this.fifthArea = fifthArea;
	}

	@Column(name = "CL", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getLevel() {
		return this.level;
	}

	public void setLevel(java.lang.String level) {
		this.level = level;
	}

	@Column(name = "CS", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getSupervise() {
		return this.supervise;
	}

	public void setSupervise(java.lang.String supervise) {
		this.supervise = supervise;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CDE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.util.Date getCompletionDate() {
		return this.completionDate;
	}

	public void setCompletionDate(java.util.Date completionDate) {
		this.completionDate = completionDate;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "OI", insertable = true, updatable = true)
	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}

	@OneToOne(cascade=CascadeType.REFRESH,optional=true)
	@JoinColumn(name="HI")
	public CompanyHiddendangerModel getCompanyHiddendangerModel() {
		return companyHiddendangerModel;
	}

	public void setCompanyHiddendangerModel(
			CompanyHiddendangerModel companyHiddendangerModel) {
		this.companyHiddendangerModel = companyHiddendangerModel;
	}

}
