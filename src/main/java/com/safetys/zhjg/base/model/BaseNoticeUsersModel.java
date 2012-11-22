package com.safetys.zhjg.base.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.kernel.model.BaseModel;
import com.safetys.framework.system.model.FkUserModel;

/**
 * 通知人员对象实体
 * 
 * @author Stone
 */
@Entity(name = "baseNoticeUsersModel")
@Table(name = "B009")
public class BaseNoticeUsersModel extends BaseModel {

	private static final long serialVersionUID = -965748719367845948L;

	public BaseNoticeUsersModel() {
		super();
	}

	public BaseNoticeUsersModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	// 用户对象
	private FkUserModel fkUserModel;

	// 通知对象
	private BaseNoticeModel baseNoticeModel;

	// 未读
	private java.lang.Boolean state = false;
	
	//反馈内容
	private java.lang.String content;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "NI", insertable = true, updatable = true)
	public BaseNoticeModel getBaseNoticeModel() {
		return baseNoticeModel;
	}

	public void setBaseNoticeModel(BaseNoticeModel baseNoticeModel) {
		this.baseNoticeModel = baseNoticeModel;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "UI", insertable = true, updatable = true)
	public FkUserModel getFkUserModel() {
		return fkUserModel;
	}

	public void setFkUserModel(FkUserModel fkUserModel) {
		this.fkUserModel = fkUserModel;
	}

	
	@Column(name = "IR", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.Boolean getState() {
		return state;
	}

	public void setState(java.lang.Boolean state) {
		this.state = state;
	}
	
	@Lob()
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CT", unique = false, nullable = true, insertable = true, updatable = true)
	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

}
