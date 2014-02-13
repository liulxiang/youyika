package com.taotaoti.common.generic.dao.operator;

/**
 * 一个字段的update操作
 */
public class Modify implements Pair{

	/**
	 * @param column
	 * @param value
	 */
	public Modify(String column, Object value) {
		this.column = column;
		this.value = value;
	}
	private String column;
	private Object value;
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
