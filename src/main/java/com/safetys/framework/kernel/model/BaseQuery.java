package com.safetys.framework.kernel.model;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.safetys.framework.jmesa.limit.Limit;
import com.safetys.framework.jmesa.limit.LimitFactory;
import com.safetys.framework.jmesa.limit.RowSelect;
import com.safetys.framework.jmesa.web.HttpServletRequestWebContext;
import com.safetys.framework.jmesa.web.WebContext;

public class BaseQuery implements Serializable {

	private static final long serialVersionUID = 1056630481712968715L;

	private Limit limit;
	private LimitFactory factory;
	private int pageSize = 20;// 页面大小
	private int pageNo = 1;// 页号
	private int totalRows = -1;// 总记录数

	public BaseQuery() {
	}

	public BaseQuery(HttpServletRequest request, String tableId) {
		WebContext webContext = new HttpServletRequestWebContext(request);
		factory = new LimitFactory(tableId, webContext);
		limit = factory.createLimit();
	}

	public int getEndSize() {
		return this.pageSize * (this.pageNo - 1);
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the totalRows
	 */
	public int getTotalRows() {
		return totalRows;
	}

	/**
	 * @param totalRows the totalRows to set
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		RowSelect rowSelect = factory.createRowSelect(pageSize, totalRows);
		this.pageSize = rowSelect.getMaxRows();
		this.pageNo = rowSelect.getPage();
		limit.setRowSelect(rowSelect);
	}

	/**
	 * @return the limit
	 */
	public Limit getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Limit limit) {
		this.limit = limit;
	}

}
