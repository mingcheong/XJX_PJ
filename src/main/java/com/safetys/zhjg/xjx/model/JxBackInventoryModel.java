/*
 * Copyright 2012 [SAFETYS], Inc. All rights reserved. WebSite:
 * http://www.safetys.cn/
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
@Entity(name = "jxBackInventoryModel")
@Table(name = "jx_back_inventory")
@AttributeOverride(name = "id", column = @Column(name = "JB_ID"))
public class JxBackInventoryModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxBackInventoryModel()
	{
		super();
	}


	public JxBackInventoryModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jbCode;
	private java.lang.String jbLastCode;
	private java.lang.String jbOcode;
	private java.lang.String jbCodemark;
	private JxEmployeeModel jbUser;
	private java.util.Date jbDate;
	private JxEmployeeModel jbCheckuser;
	private java.lang.String jbRemark;
	private JxDeptModel jbDept;
	private JxSupplierModel jbSupplier;
	private JxWarehouseModel jbWarehouse;
	private List<JxBackInventoryDetailsModel> jxBackInventoryDetailss;



	@Column(name = "JB_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJbCode()
	{
		return this.jbCode;
	}


	public void setJbCode(java.lang.String jbCode)
	{
		this.jbCode = jbCode;
	}


	@Column(name = "JB_LAST_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJbLastCode()
	{
		return this.jbLastCode;
	}


	public void setJbLastCode(java.lang.String jbLastCode)
	{
		this.jbLastCode = jbLastCode;
	}


	@Column(name = "JB_OCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJbOcode()
	{
		return this.jbOcode;
	}


	public void setJbOcode(java.lang.String jbOcode)
	{
		this.jbOcode = jbOcode;
	}


	@Column(name = "JB_CODEMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJbCodemark()
	{
		return this.jbCodemark;
	}


	public void setJbCodemark(java.lang.String jbCodemark)
	{
		this.jbCodemark = jbCodemark;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JB_USER", nullable = false, insertable = true, updatable = true)
	public JxEmployeeModel getJbUser()
	{
		return this.jbUser;
	}


	public void setJbUser(JxEmployeeModel jbUser)
	{
		this.jbUser = jbUser;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JB_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.util.Date getJbDate()
	{
		return this.jbDate;
	}


	public void setJbDate(java.util.Date jbDate)
	{
		this.jbDate = jbDate;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JB_CHECKUSER", nullable = false, insertable = true, updatable = true)
	public JxEmployeeModel getJbCheckuser()
	{
		return this.jbCheckuser;
	}


	public void setJbCheckuser(JxEmployeeModel jbCheckuser)
	{
		this.jbCheckuser = jbCheckuser;
	}


	@Column(name = "JB_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJbRemark()
	{
		return this.jbRemark;
	}


	public void setJbRemark(java.lang.String jbRemark)
	{
		this.jbRemark = jbRemark;
	}


	public void setJbDept(JxDeptModel jbDept)
	{
		this.jbDept = jbDept;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JB_DEPT", nullable = false, insertable = true, updatable = true)
	public JxDeptModel getJbDept()
	{
		return jbDept;
	}


	public void setJbSupplier(JxSupplierModel jbSupplier)
	{
		this.jbSupplier = jbSupplier;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JB_SUPPLIER", nullable = false, insertable = true, updatable = true)
	public JxSupplierModel getJbSupplier()
	{
		return jbSupplier;
	}


	public void setJbWarehouse(JxWarehouseModel jbWarehouse)
	{
		this.jbWarehouse = jbWarehouse;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JB_WAREHOUSE", nullable = false, insertable = true, updatable = true)
	public JxWarehouseModel getJbWarehouse()
	{
		return jbWarehouse;
	}


	public void setJxBackInventoryDetailss(List<JxBackInventoryDetailsModel> jxBackInventoryDetailss)
	{
		this.jxBackInventoryDetailss = jxBackInventoryDetailss;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jbdBackInventory")
	public List<JxBackInventoryDetailsModel> getJxBackInventoryDetailss()
	{
		return jxBackInventoryDetailss;
	}
}
