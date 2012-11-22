/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved.
 * WebSite: http://www.safetys.cn/
 *
 */
package com.safetys.zhjg.company.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.system.model.FkEnumModel;
import com.safetys.framework.system.model.FkOrganizeModel;


/**
 * 数据上报实体对象
 * 此文件通过快速开发平台自动生成
 * @author Stone 
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyReportsModel")
@Table(name = "B011")
public class CompanyReportsModel extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	public CompanyReportsModel(){ 
		super();
	}
	
	public CompanyReportsModel(HttpServletRequest request, String tableId){
		super(request, tableId);
	}
	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//行业类型
	private java.lang.String industryType;
	//起始年
	private java.lang.String startYear;
	//起始月
	private java.lang.String startMonth;
	//单位负责人
	private java.lang.String unitResponsible;
	//填报人
	private java.lang.String fillPerson;
	//联系电话
	private java.lang.String contactPhone;
	//填报时间
	private java.util.Date fillDate;
	
	private int n1;
	private int n2;
	private int n3;
	private int n4;
	private int n5;
	private int n6;
	private int n7;
	private int n8;
	private int n9;
	private int n10;
	private int n11;
	private int n12;
	private int n13;
	private int n14;
	private int n15;
	private int n16;
	private int n17;
	private int n18;
	private int n19;
	private int n20;
	
	//填报单位
	private FkOrganizeModel fkOrganizeModel;
	
	//枚举
	private FkEnumModel fkEnumModel;
	
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
	
	@Column(name = "IT", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getIndustryType() {
		return this.industryType;
	}
	
	public void setIndustryType(java.lang.String industryType) {
		this.industryType = industryType;
	}
	
	@Column(name = "SM", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	public java.lang.String getStartMonth() {
		return this.startMonth;
	}
	
	public void setStartMonth(java.lang.String startMonth) {
		this.startMonth = startMonth;
	}
	
	@Column(name = "SY", unique = false, nullable = false, insertable = true, updatable = true, length = 5)
	public java.lang.String getStartYear() {
		return this.startYear;
	}
	
	public void setStartYear(java.lang.String startYear) {
		this.startYear = startYear;
	}
	
	@Column(name = "UR", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getUnitResponsible() {
		return this.unitResponsible;
	}
	
	public void setUnitResponsible(java.lang.String unitResponsible) {
		this.unitResponsible = unitResponsible;
	}
	
	@Column(name = "FP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getFillPerson() {
		return this.fillPerson;
	}
	
	public void setFillPerson(java.lang.String fillPerson) {
		this.fillPerson = fillPerson;
	}
	
	@Column(name = "CP", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	public java.lang.String getContactPhone() {
		return this.contactPhone;
	}
	
	public void setContactPhone(java.lang.String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getFillDate() {
		return this.fillDate;
	}
	
	public void setFillDate(java.util.Date fillDate) {
		this.fillDate = fillDate;
	}
	
	@Column(name = "n1", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN1() {
		return this.n1;
	}
	
	public void setN1(int n1) {
		this.n1 = n1;
	}
	
	@Column(name = "n2", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN2() {
		return this.n2;
	}
	
	public void setN2(int n2) {
		this.n2 = n2;
	}
	
	@Column(name = "n3", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN3() {
		return this.n3;
	}
	
	public void setN3(int n3) {
		this.n3 = n3;
	}
	
	@Column(name = "n4", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN4() {
		return this.n4;
	}
	
	public void setN4(int n4) {
		this.n4 = n4;
	}
	
	@Column(name = "n5", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN5() {
		return this.n5;
	}
	
	public void setN5(int n5) {
		this.n5 = n5;
	}
	
	@Column(name = "n6", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN6() {
		return this.n6;
	}
	
	public void setN6(int n6) {
		this.n6 = n6;
	}
	
	@Column(name = "n7", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN7() {
		return this.n7;
	}
	
	public void setN7(int n7) {
		this.n7 = n7;
	}
	
	@Column(name = "n8", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN8() {
		return this.n8;
	}
	
	public void setN8(int n8) {
		this.n8 = n8;
	}
	
	@Column(name = "n9", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN9() {
		return this.n9;
	}
	
	public void setN9(int n9) {
		this.n9 = n9;
	}
	
	@Column(name = "n10", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN10() {
		return this.n10;
	}
	
	public void setN10(int n10) {
		this.n10 = n10;
	}
	
	@Column(name = "n11", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN11() {
		return this.n11;
	}
	
	public void setN11(int n11) {
		this.n11 = n11;
	}
	
	@Column(name = "n12", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN12() {
		return this.n12;
	}
	
	public void setN12(int n12) {
		this.n12 = n12;
	}
	
	@Column(name = "n13", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN13() {
		return this.n13;
	}
	
	public void setN13(int n13) {
		this.n13 = n13;
	}
	
	@Column(name = "n14", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN14() {
		return this.n14;
	}
	
	public void setN14(int n14) {
		this.n14 = n14;
	}
	
	@Column(name = "n15", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN15() {
		return this.n15;
	}
	
	public void setN15(int n15) {
		this.n15 = n15;
	}
	
	@Column(name = "n16", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN16() {
		return this.n16;
	}
	
	public void setN16(int n16) {
		this.n16 = n16;
	}
	
	@Column(name = "n17", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN17() {
		return this.n17;
	}
	
	public void setN17(int n17) {
		this.n17 = n17;
	}
	
	@Column(name = "n18", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN18() {
		return this.n18;
	}
	
	public void setN18(int n18) {
		this.n18 = n18;
	}
	
	@Column(name = "n19", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN19() {
		return this.n19;
	}
	
	public void setN19(int n19) {
		this.n19 = n19;
	}
	
	@Column(name = "n20", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public int getN20() {
		return this.n20;
	}
	
	public void setN20(int n20) {
		this.n20 = n20;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "OI", insertable = true, updatable = true)
	public FkOrganizeModel getFkOrganizeModel() {
		return fkOrganizeModel;
	}

	public void setFkOrganizeModel(FkOrganizeModel fkOrganizeModel) {
		this.fkOrganizeModel = fkOrganizeModel;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "EI", insertable = true, updatable = true)
	public FkEnumModel getFkEnumModel() {
		return fkEnumModel;
	}

	public void setFkEnumModel(FkEnumModel fkEnumModel) {
		this.fkEnumModel = fkEnumModel;
	}

}

