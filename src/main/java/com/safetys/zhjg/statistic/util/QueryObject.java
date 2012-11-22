package com.safetys.zhjg.statistic.util;

import java.io.Serializable;

/**
 * 统计查询对象（查询参数封装）
 * @author Stone
 *
 */
public class QueryObject implements Serializable {

	private static final long serialVersionUID = 2239198834116023178L;

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
