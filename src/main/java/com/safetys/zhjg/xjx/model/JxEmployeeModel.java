/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import javax.persistence.AttributeOverride;
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




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "jxEmployeeModel")
@Table(name = "jx_employee")
@AttributeOverride(name = "id", column = @Column(name = "JE_ID"))
public class JxEmployeeModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxEmployeeModel()
	{
		super();
	}


	public JxEmployeeModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jeCode;
	private java.lang.String jePlace;
	private java.lang.String jeClazz;
	private java.lang.String jeName;
	private java.lang.Boolean jeSex;
	private java.lang.String jeIdcard;
	private java.lang.Short jeDegree;
	private java.lang.Short jeJob;
	private java.util.Date jeBirthday;
	private java.lang.String jeAddress;
	private java.lang.String jePost;
	private java.lang.String jePhone;
	private java.lang.Boolean jeIsjob;
	private java.lang.Boolean jeLevel;
	private java.util.Date jeWorkdate;
	private java.util.Date jeIndate;
	private java.lang.String jeResume;
	private java.lang.String jeRelation;
	private java.lang.String jeRemark;
	private JxDeptModel jeDept;



	@Column(name = "JE_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJeCode()
	{
		return this.jeCode;
	}


	public void setJeCode(java.lang.String jeCode)
	{
		this.jeCode = jeCode;
	}


	@Column(name = "JE_PLACE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJePlace()
	{
		return this.jePlace;
	}


	public void setJePlace(java.lang.String jePlace)
	{
		this.jePlace = jePlace;
	}


	@Column(name = "JE_CLAZZ", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
	public java.lang.String getJeClazz()
	{
		return this.jeClazz;
	}


	public void setJeClazz(java.lang.String jeClazz)
	{
		this.jeClazz = jeClazz;
	}


	@Column(name = "JE_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJeName()
	{
		return this.jeName;
	}


	public void setJeName(java.lang.String jeName)
	{
		this.jeName = jeName;
	}


	@Column(name = "JE_SEX", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJeSex()
	{
		return this.jeSex;
	}


	public void setJeSex(java.lang.Boolean jeSex)
	{
		this.jeSex = jeSex;
	}


	@Column(name = "JE_IDCARD", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public java.lang.String getJeIdcard()
	{
		return this.jeIdcard;
	}


	public void setJeIdcard(java.lang.String jeIdcard)
	{
		this.jeIdcard = jeIdcard;
	}


	@Column(name = "JE_DEGREE", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
	public java.lang.Short getJeDegree()
	{
		return this.jeDegree;
	}


	public void setJeDegree(java.lang.Short jeDegree)
	{
		this.jeDegree = jeDegree;
	}


	@Column(name = "JE_JOB", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Short getJeJob()
	{
		return this.jeJob;
	}


	public void setJeJob(java.lang.Short jeJob)
	{
		this.jeJob = jeJob;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JE_BIRTHDAY", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getJeBirthday()
	{
		return this.jeBirthday;
	}


	public void setJeBirthday(java.util.Date jeBirthday)
	{
		this.jeBirthday = jeBirthday;
	}


	@Column(name = "JE_ADDRESS", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getJeAddress()
	{
		return this.jeAddress;
	}


	public void setJeAddress(java.lang.String jeAddress)
	{
		this.jeAddress = jeAddress;
	}


	@Column(name = "JE_POST", unique = false, nullable = true, insertable = true, updatable = true, length = 6)
	public java.lang.String getJePost()
	{
		return this.jePost;
	}


	public void setJePost(java.lang.String jePost)
	{
		this.jePost = jePost;
	}


	@Column(name = "JE_PHONE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public java.lang.String getJePhone()
	{
		return this.jePhone;
	}


	public void setJePhone(java.lang.String jePhone)
	{
		this.jePhone = jePhone;
	}


	@Column(name = "JE_ISJOB", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJeIsjob()
	{
		return this.jeIsjob;
	}


	public void setJeIsjob(java.lang.Boolean jeIsjob)
	{
		this.jeIsjob = jeIsjob;
	}


	@Column(name = "JE_LEVEL", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
	public java.lang.Boolean getJeLevel()
	{
		return this.jeLevel;
	}


	public void setJeLevel(java.lang.Boolean jeLevel)
	{
		this.jeLevel = jeLevel;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JE_WORKDATE", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getJeWorkdate()
	{
		return this.jeWorkdate;
	}


	public void setJeWorkdate(java.util.Date jeWorkdate)
	{
		this.jeWorkdate = jeWorkdate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JE_INDATE", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public java.util.Date getJeIndate()
	{
		return this.jeIndate;
	}


	public void setJeIndate(java.util.Date jeIndate)
	{
		this.jeIndate = jeIndate;
	}


	@Column(name = "JE_RESUME", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getJeResume()
	{
		return this.jeResume;
	}


	public void setJeResume(java.lang.String jeResume)
	{
		this.jeResume = jeResume;
	}


	@Column(name = "JE_RELATION", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJeRelation()
	{
		return this.jeRelation;
	}


	public void setJeRelation(java.lang.String jeRelation)
	{
		this.jeRelation = jeRelation;
	}


	@Column(name = "JE_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJeRemark()
	{
		return this.jeRemark;
	}


	public void setJeRemark(java.lang.String jeRemark)
	{
		this.jeRemark = jeRemark;
	}


	public void setJeDept(JxDeptModel jeDept)
	{
		this.jeDept = jeDept;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JE_DEPT", nullable = false, insertable = true, updatable = true)
	public JxDeptModel getJeDept()
	{
		return jeDept;
	}
}
