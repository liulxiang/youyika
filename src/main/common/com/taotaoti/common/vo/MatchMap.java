package com.taotaoti.common.vo;

import org.apache.poi.ss.formula.functions.T;

/**
 * 一对参数
 * 
 */
public class MatchMap{
	
	/**
	 * @param column
	 * @param value
	 */
	public MatchMap(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	private String key;
	private Object value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}