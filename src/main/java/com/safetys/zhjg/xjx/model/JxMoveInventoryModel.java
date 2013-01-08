/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
 */
package com.safetys.zhjg.xjx.model;

import java.util.List;
import javax.persistence.*;

import com.safetys.framework.kernel.model.BaseModel;
import javax.servlet.http.HttpServletRequest;




/**
 * 此文件通过快速开发平台自动生成
 * 
 * @author Stone
 * @email wsgajl@163.com
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "jxMoveInventoryModel")
@Table(name = "jx_move_inventory")
@AttributeOverride(name = "id", column = @Column(name = "JM_ID"))
public class JxMoveInventoryModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxMoveInventoryModel()
	{
		super();
	}


	public JxMoveInventoryModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jmLastCode;
	private java.lang.String jmOcode;
	private java.lang.String jmNum;
	private JxWarehouseModel jmIwarehouse;
	private JxWarehouseModel jmOwarehouse;
	private JxEmployeeModel jmUser;
	private java.util.Date jmDate;
	private java.lang.String jmRemark;
	private JxDeptModel jmDept;
	private List<JxMoveInventoryDetailsModel> jxMoveInventoryDetailss;



	@Column(name = "JM_LAST_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJmLastCode()
	{
		return this.jmLastCode;
	}


	public void setJmLastCode(java.lang.String jmLastCode)
	{
		this.jmLastCode = jmLastCode;
	}


	@Column(name = "JM_OCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJmOcode()
	{
		return this.jmOcode;
	}


	public void setJmOcode(java.lang.String jmOcode)
	{
		this.jmOcode = jmOcode;
	}


	@Column(name = "JM_NUM", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJmNum()
	{
		return this.jmNum;
	}


	public void setJmNum(java.lang.String jmNum)
	{
		this.jmNum = jmNum;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JM_IWAREHOUSE", nullable = false, insertable = true, updatable = true)
	public JxWarehouseModel getJmIwarehouse()
	{
		return this.jmIwarehouse;
	}


	public void setJmIwarehouse(JxWarehouseModel jmIwarehouse)
	{
		this.jmIwarehouse = jmIwarehouse;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JM_OWAREHOUSE", nullable = false, insertable = true, updatable = true)
	public JxWarehouseModel getJmOwarehouse()
	{
		return this.jmOwarehouse;
	}


	public void setJmOwarehouse(JxWarehouseModel jmOwarehouse)
	{
		this.jmOwarehouse = jmOwarehouse;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JM_USER", nullable = false, insertable = true, updatable = true)
	public JxEmployeeModel getJmUser()
	{
		return this.jmUser;
	}


	public void setJmUser(JxEmployeeModel jmUser)
	{
		this.jmUser = jmUser;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JM_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.util.Date getJmDate()
	{
		return this.jmDate;
	}


	public void setJmDate(java.util.Date jmDate)
	{
		this.jmDate = jmDate;
	}


	@Column(name = "JM_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJmRemark()
	{
		return this.jmRemark;
	}


	public void setJmRemark(java.lang.String jmRemark)
	{
		this.jmRemark = jmRemark;
	}


	public void setJmDept(JxDeptModel jmDept)
	{
		this.jmDept = jmDept;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JM_DEPT", nullable = false, insertable = true, updatable = true)
	public JxDeptModel getJmDept()
	{
		return jmDept;
	}


	public void setJxMoveInventoryDetailss(List<JxMoveInventoryDetailsModel> jxMoveInventoryDetailss)
	{
		this.jxMoveInventoryDetailss = jxMoveInventoryDetailss;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jmdMoveInventory")
	public List<JxMoveInventoryDetailsModel> getJxMoveInventoryDetailss()
	{
		return jxMoveInventoryDetailss;
	}
}
