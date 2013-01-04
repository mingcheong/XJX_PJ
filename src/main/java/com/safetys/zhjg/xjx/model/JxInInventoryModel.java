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
@Entity(name = "jxInInventoryModel")
@Table(name = "jx_in_inventory")
@AttributeOverride(name = "id", column = @Column(name = "JI_ID"))
public class JxInInventoryModel extends BaseModel
{

	private static final long serialVersionUID = 1L;



	public JxInInventoryModel()
	{
		super();
	}


	public JxInInventoryModel(HttpServletRequest request, String tableId)
	{
		super(request, tableId);
	}



	private java.lang.String jiCode;
	private java.lang.String jiLastCode;
	private java.lang.String jiOcode;
	private java.lang.String jiCodemark;
	private java.util.Date jiDate;
	private java.lang.String jiRemark;
	private JxDeptModel jiDept;
	private JxSupplierModel jiSupplier;
	private JxWarehouseModel jiWarehouse;
	private JxEmployeeModel jiUser;
	private JxEmployeeModel jiCheckuser;
	private List<JxInInventoryDetailsModel> jxInInventoryDetailss;



	@Column(name = "JI_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJiCode()
	{
		return this.jiCode;
	}


	public void setJiCode(java.lang.String jiCode)
	{
		this.jiCode = jiCode;
	}


	@Column(name = "JI_LAST_CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJiLastCode()
	{
		return this.jiLastCode;
	}


	public void setJiLastCode(java.lang.String jiLastCode)
	{
		this.jiLastCode = jiLastCode;
	}


	@Column(name = "JI_OCODE", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public java.lang.String getJiOcode()
	{
		return this.jiOcode;
	}


	public void setJiOcode(java.lang.String jiOcode)
	{
		this.jiOcode = jiOcode;
	}


	@Column(name = "JI_CODEMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getJiCodemark()
	{
		return this.jiCodemark;
	}


	public void setJiCodemark(java.lang.String jiCodemark)
	{
		this.jiCodemark = jiCodemark;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "JI_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public java.util.Date getJiDate()
	{
		return this.jiDate;
	}


	public void setJiDate(java.util.Date jiDate)
	{
		this.jiDate = jiDate;
	}


	@Column(name = "JI_REMARK", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public java.lang.String getJiRemark()
	{
		return this.jiRemark;
	}


	public void setJiRemark(java.lang.String jiRemark)
	{
		this.jiRemark = jiRemark;
	}


	public void setJiDept(JxDeptModel jiDept)
	{
		this.jiDept = jiDept;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_DEPT", nullable = false, insertable = true, updatable = true)
	public JxDeptModel getJiDept()
	{
		return jiDept;
	}


	public void setJiSupplier(JxSupplierModel jiSupplier)
	{
		this.jiSupplier = jiSupplier;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_SUPPLIER", nullable = false, insertable = true, updatable = true)
	public JxSupplierModel getJiSupplier()
	{
		return jiSupplier;
	}


	public void setJiWarehouse(JxWarehouseModel jiWarehouse)
	{
		this.jiWarehouse = jiWarehouse;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_WAREHOUSE", nullable = false, insertable = true, updatable = true)
	public JxWarehouseModel getJiWarehouse()
	{
		return jiWarehouse;
	}


	public void setJiCheckuser(JxEmployeeModel jiCheckuser)
	{
		this.jiCheckuser = jiCheckuser;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_CHECKUSER", nullable = false, insertable = true, updatable = true)
	public JxEmployeeModel getJiCheckuser()
	{
		return jiCheckuser;
	}


	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "JI_USER", nullable = false, insertable = true, updatable = true)
	public JxEmployeeModel getJiUser()
	{
		return jiUser;
	}


	public void setJiUser(JxEmployeeModel jiUser)
	{
		this.jiUser = jiUser;
	}


	public void setJxInInventoryDetailss(List<JxInInventoryDetailsModel> jxInInventoryDetailss)
	{
		this.jxInInventoryDetailss = jxInInventoryDetailss;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jidInInventory")
	public List<JxInInventoryDetailsModel> getJxInInventoryDetailss()
	{
		return jxInInventoryDetailss;
	}
}
