package com.taotaoti.common.generic.dao.operator;

import java.util.List;

/**
 * 封装一个sql操作
 */
public class Query {
	
	/**
	 * 默认构造函数
	 * @param sql
	 * @param params
	 */
	public Query(String sql, List<Object> params) {
		super();
		this.sql = sql;
		this.params = params;
	}

	public String getSql() {
		return sql;
	}

	public List<Object> getParams() {
		return params;
	}

	private String sql;
	
	private List<Object> params;

}
