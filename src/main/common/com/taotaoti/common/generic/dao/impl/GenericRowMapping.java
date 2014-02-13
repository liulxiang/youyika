/**
 * 
 */
package com.taotaoti.common.generic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * ResultSet到自定义类的映射接口，加入了泛型。
 * 
 * @version 1.0.0
 */
public interface GenericRowMapping<T> extends RowMapper {
	
	/** 
	 * Implementations must implement this method to map each row of data
	 * in the ResultSet. This method should not call <code>next()</code> on
	 * the ResultSet; it is only supposed to map values of the current row.
	 * @param rs the ResultSet to map (pre-initialized for the current row)
	 * @param rowNum the number of the current row
	 * @return the result object for the current row
	 * @throws SQLException if a SQLException is encountered getting
	 * column values (that is, there's no need to catch SQLException)
	 */
	public T mapRow(ResultSet rs, int rowNum) throws SQLException ;
}
