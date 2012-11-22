/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 特种设备
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyEquipmentModel")
@Table(name = "C003")
public class CompanyEquipmentModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyEquipmentModel() {
		super();
	}

	public CompanyEquipmentModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//设备名称
	private java.lang.String name;
	//安全管理人员
	private java.lang.String safetyPerson;
	//设备使用地点
	private java.lang.String usedAddress;
	//设备注册代码
	private java.lang.String regCode;
	//设备状态
	private java.lang.String state;
	//注册登记机构
	private java.lang.String regUnit;
	//注册登记日期
	private java.util.Date regDate;
	//维保单位
	private java.lang.String preserveUnit;
	//制造单位
	private java.lang.String produceUnit;
	//检验单位
	private java.lang.String inspectionUnit;
	//检验日期
	private java.util.Date inspectionDate;
	//维保电话
	private java.lang.String preserverPhone;
	//设备类型
	private java.lang.String equipentType;
	//使用单位
	private java.lang.String usedUnit;
	//使用地址
	private java.lang.String usingAddress;
	//设备型号
	private java.lang.String model;

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

	@Column(name = "CN", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@Column(name = "SP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSafetyPerson() {
		return this.safetyPerson;
	}

	public void setSafetyPerson(java.lang.String safetyPerson) {
		this.safetyPerson = safetyPerson;
	}

	@Column(name = "UA", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getUsedAddress() {
		return this.usedAddress;
	}

	public void setUsedAddress(java.lang.String usedAddress) {
		this.usedAddress = usedAddress;
	}

	@Column(name = "RC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getRegCode() {
		return this.regCode;
	}

	public void setRegCode(java.lang.String regCode) {
		this.regCode = regCode;
	}

	@Column(name = "CS", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	@Column(name = "RU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getRegUnit() {
		return this.regUnit;
	}

	public void setRegUnit(java.lang.String regUnit) {
		this.regUnit = regUnit;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RDE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}

	@Column(name = "PU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getPreserveUnit() {
		return this.preserveUnit;
	}

	public void setPreserveUnit(java.lang.String preserveUnit) {
		this.preserveUnit = preserveUnit;
	}

	@Column(name = "PDU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getProduceUnit() {
		return this.produceUnit;
	}

	public void setProduceUnit(java.lang.String produceUnit) {
		this.produceUnit = produceUnit;
	}

	@Column(name = "IPU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getInspectionUnit() {
		return this.inspectionUnit;
	}

	public void setInspectionUnit(java.lang.String inspectionUnit) {
		this.inspectionUnit = inspectionUnit;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IPD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getInspectionDate() {
		return this.inspectionDate;
	}

	public void setInspectionDate(java.util.Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Column(name = "CPP", unique = false, nullable = true, insertable = true, updatable = true, length = 15)
	public java.lang.String getPreserverPhone() {
		return this.preserverPhone;
	}

	public void setPreserverPhone(java.lang.String preserverPhone) {
		this.preserverPhone = preserverPhone;
	}

	@Column(name = "CET", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getEquipentType() {
		return this.equipentType;
	}

	public void setEquipentType(java.lang.String equipentType) {
		this.equipentType = equipentType;
	}

	@Column(name = "CUN", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getUsedUnit() {
		return this.usedUnit;
	}

	public void setUsedUnit(java.lang.String usedUnit) {
		this.usedUnit = usedUnit;
	}

	@Column(name = "CUA", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getUsingAddress() {
		return this.usingAddress;
	}

	public void setUsingAddress(java.lang.String usingAddress) {
		this.usingAddress = usingAddress;
	}

	@Column(name = "CML", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getModel() {
		return this.model;
	}

	public void setModel(java.lang.String model) {
		this.model = model;
	}

}
