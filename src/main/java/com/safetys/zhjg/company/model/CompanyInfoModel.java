/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.company.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;

/**
 * 此文件通过快速开发平台自动生成
 * 
 * 企业基本信息
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "companyInfoModel")
@Table(name = "C001")
public class CompanyInfoModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	public CompanyInfoModel() {
		super();
	}

	public CompanyInfoModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	private java.lang.String firstArea;
	private java.lang.String secondArea;
	private java.lang.String thirdArea;
	private java.lang.String fourthArea;
	private java.lang.String fifthArea;
	//企业名称
	private java.lang.String companyName;
	//企业地址
	private java.lang.String address;
	//企业地址经纬度
	private java.lang.String latlng;
	//工商登记机关
	private java.lang.String registration;
	//经济性质
	private java.lang.String character;
	//行业类型
	private java.lang.String industrial;
	//法人代表姓名
	private java.lang.String legalPerson;
	//法人代表联系方式
	private java.lang.String legalContact;
	//安全生产主要负责人姓名
	private java.lang.String principalPerson;
	//安全生产主要负责人手机
	private java.lang.String principalMobile;
	//职工人数
	private java.lang.Integer staffNumber;
	//安全管理人员姓名
	private java.lang.String safetyName;
	//安全管理人手机
	private java.lang.String safetyMobile;
	//外来务工人数
	private java.lang.Integer migrantNumber;
	//持证上岗人数
	private java.lang.Integer postsNumber;
	//工伤保险
	private java.lang.Boolean insure;
	//参保人数
	private java.lang.Integer insureNumber;
	//技术管理人数
	private java.lang.Integer outputNumber;
	//与政府签订协议书
	private java.lang.Boolean isAgreement;
	//安全管理机构设置
	private java.lang.Boolean isOrgs;
	//安全生产管理人员人数 
	private java.lang.Integer safetyNumber;
	//人员密集场所
	private java.lang.Boolean isDense;
	//消防重点单位
	private java.lang.Boolean isFirekey;
	//特种设备
	private java.lang.String equipmentIds;
	//消防设施
	private java.lang.Long facilities;
	//设施、设备管理台帐
	private java.lang.Boolean isAccount;
	//使用危险化学品情况
	private java.lang.Boolean isDangerous;
	//危险化学品仓库
	private java.lang.Boolean isChemicals;
	//安全达标开展情况
	private java.lang.String safetyStandards;
	//是否建立安全生产管理台帐
	private java.lang.Boolean isSafetyAccount;
	//主要安全生产管理制度名称
	private java.lang.String safetyRules;
	//年产值或年销售额
	private java.lang.Integer yearSales;
	
	private List<CompanyLicensingModel> companyLicensingModels;

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

	@Column(name = "CN", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public java.lang.String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "CAD", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getAddress() {
		return this.address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	@Column(name = "LL", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getLatlng() {
		return latlng;
	}

	public void setLatlng(java.lang.String latlng) {
		this.latlng = latlng;
	}

	@Column(name = "CR", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getRegistration() {
		return this.registration;
	}

	public void setRegistration(java.lang.String registration) {
		this.registration = registration;
	}

	@Column(name = "CH", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getCharacter() {
		return this.character;
	}

	public void setCharacter(java.lang.String character) {
		this.character = character;
	}

	@Column(name = "CI", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getIndustrial() {
		return this.industrial;
	}

	public void setIndustrial(java.lang.String industrial) {
		this.industrial = industrial;
	}

	@Column(name = "LP", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getLegalPerson() {
		return this.legalPerson;
	}

	public void setLegalPerson(java.lang.String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name = "LC", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getLegalContact() {
		return this.legalContact;
	}

	public void setLegalContact(java.lang.String legalContact) {
		this.legalContact = legalContact;
	}

	@Column(name = "PP", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getPrincipalPerson() {
		return this.principalPerson;
	}

	public void setPrincipalPerson(java.lang.String principalPerson) {
		this.principalPerson = principalPerson;
	}

	@Column(name = "PM", unique = false, nullable = true, insertable = true, updatable = true, length = 15)
	public java.lang.String getPrincipalMobile() {
		return this.principalMobile;
	}

	public void setPrincipalMobile(java.lang.String principalMobile) {
		this.principalMobile = principalMobile;
	}

	@Column(name = "STN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(java.lang.Integer staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "SNA", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSafetyName() {
		return this.safetyName;
	}

	public void setSafetyName(java.lang.String safetyName) {
		this.safetyName = safetyName;
	}

	@Column(name = "SM", unique = false, nullable = true, insertable = true, updatable = true, length = 15)
	public java.lang.String getSafetyMobile() {
		return this.safetyMobile;
	}

	public void setSafetyMobile(java.lang.String safetyMobile) {
		this.safetyMobile = safetyMobile;
	}

	@Column(name = "MN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMigrantNumber() {
		return this.migrantNumber;
	}

	public void setMigrantNumber(java.lang.Integer migrantNumber) {
		this.migrantNumber = migrantNumber;
	}

	@Column(name = "PN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getPostsNumber() {
		return this.postsNumber;
	}

	public void setPostsNumber(java.lang.Integer postsNumber) {
		this.postsNumber = postsNumber;
	}

	@Column(name = "CIN", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getInsure() {
		return this.insure;
	}

	public void setInsure(java.lang.Boolean insure) {
		this.insure = insure;
	}

	@Column(name = "ISN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getInsureNumber() {
		return this.insureNumber;
	}

	public void setInsureNumber(java.lang.Integer insureNumber) {
		this.insureNumber = insureNumber;
	}

	@Column(name = "CON", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getOutputNumber() {
		return this.outputNumber;
	}

	public void setOutputNumber(java.lang.Integer outputNumber) {
		this.outputNumber = outputNumber;
	}

	@Column(name = "CIA", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsAgreement() {
		return this.isAgreement;
	}

	public void setIsAgreement(java.lang.Boolean isAgreement) {
		this.isAgreement = isAgreement;
	}

	@Column(name = "CIO", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsOrgs() {
		return this.isOrgs;
	}

	public void setIsOrgs(java.lang.Boolean isOrgs) {
		this.isOrgs = isOrgs;
	}

	@Column(name = "CSN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getSafetyNumber() {
		return this.safetyNumber;
	}

	public void setSafetyNumber(java.lang.Integer safetyNumber) {
		this.safetyNumber = safetyNumber;
	}

	@Column(name = "ISD", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsDense() {
		return this.isDense;
	}

	public void setIsDense(java.lang.Boolean isDense) {
		this.isDense = isDense;
	}

	@Column(name = "IFK", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsFirekey() {
		return this.isFirekey;
	}

	public void setIsFirekey(java.lang.Boolean isFirekey) {
		this.isFirekey = isFirekey;
	}

	@Column(name = "CFI", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getEquipmentIds() {
		return this.equipmentIds;
	}

	public void setEquipmentIds(java.lang.String equipmentIds) {
		this.equipmentIds = equipmentIds;
	}

	@Column(name = "CFT", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Long getFacilities() {
		return this.facilities;
	}

	public void setFacilities(java.lang.Long facilities) {
		this.facilities = facilities;
	}

	@Column(name = "IAC", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsAccount() {
		return this.isAccount;
	}

	public void setIsAccount(java.lang.Boolean isAccount) {
		this.isAccount = isAccount;
	}

	@Column(name = "IDG", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsDangerous() {
		return this.isDangerous;
	}

	public void setIsDangerous(java.lang.Boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

	@Column(name = "ICH", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsChemicals() {
		return this.isChemicals;
	}

	public void setIsChemicals(java.lang.Boolean isChemicals) {
		this.isChemicals = isChemicals;
	}

	@Column(name = "CSS", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getSafetyStandards() {
		return this.safetyStandards;
	}

	public void setSafetyStandards(java.lang.String safetyStandards) {
		this.safetyStandards = safetyStandards;
	}

	@Column(name = "ISA", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getIsSafetyAccount() {
		return this.isSafetyAccount;
	}

	public void setIsSafetyAccount(java.lang.Boolean isSafetyAccount) {
		this.isSafetyAccount = isSafetyAccount;
	}

	@Column(name = "CSR", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getSafetyRules() {
		return this.safetyRules;
	}

	public void setSafetyRules(java.lang.String safetyRules) {
		this.safetyRules = safetyRules;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="companyInfo")
	public List<CompanyLicensingModel> getCompanyLicensingModels() {
		return companyLicensingModels;
	}

	public void setCompanyLicensingModels(
			List<CompanyLicensingModel> companyLicensingModels) {
		this.companyLicensingModels = companyLicensingModels;
	}

	@Column(name = "YS", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getYearSales() {
		return yearSales;
	}

	public void setYearSales(java.lang.Integer yearSales) {
		this.yearSales = yearSales;
	}

}
