package com.safetys.framework.kernel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

/**
 * 基础对象
 * 
 * @author Stone
 */
@MappedSuperclass
public class BaseModel extends BaseQuery {

	private static final long serialVersionUID = 5524502611369354582L;
	/**
	 * 主键标识
	 */
	private java.lang.Long id = -1l;
	/**
	 * 删除标识
	 */
	private boolean deleted = false;

	/**
	 * 时间段查询
	 */
	private DateFields dateFields;

	/**
	 * 创建时间
	 */
	private java.util.Date createDate = new Date();

	/**
	 * 修改时间
	 */
	private java.util.Date modifyDate = new Date();

	/**
	 * 排序
	 */
	private int sortNum;

	public BaseModel() {
		super();
	}

	public BaseModel(HttpServletRequest request, String tableId) {
		super(request, tableId);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tableGenerator")
	@TableGenerator(name = "tableGenerator", table = "A001", pkColumnName = "A", valueColumnName = "B", allocationSize = 1, initialValue = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the {@link Date}
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the {@link Date}
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MD", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.util.Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the deleted
	 */
	@Column(name = "RD", unique = false, nullable = true, insertable = true, updatable = true)
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the sortnum
	 */
	@Column(name = "SN", precision = 10, scale = 0)
	public int getSortNum() {
		return sortNum;
	}

	/**
	 * @param sortnum
	 *            the sortnum to set
	 */
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

	@Transient
	public DateFields getDateFields() {
		return dateFields;
	}

	public void setDateFields(DateFields dateFields) {
		this.dateFields = dateFields;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		BaseModel other = (BaseModel) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseModel [id=" + id + "]";
	}

}
