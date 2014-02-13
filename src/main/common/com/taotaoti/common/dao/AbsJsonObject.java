package com.taotaoti.common.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AbsJsonObject implements Serializable {

	private static final long serialVersionUID = 3924928037939744014L;

	/**
	 * status map : 
	 * success: 0 
	 * noauth : 126 
	 * nologin : 127 
	 * businessError: 2
	 * systemError : 1 
	 * nofound: 404
	 */
	private int status = 0;

	private String msg;
	private Map<String, String> fieldMsgs = null;

	private Map<String, Object> data;

	public AbsJsonObject() {
		status = 0;
		this.msg = "";
		this.fieldMsgs = new HashMap<String, String>();
		this.data = new HashMap<String, Object>();
	}

	public void addFieldMsg(String key, String value) {
		if (key == null) {
			return;
		}
		this.fieldMsgs.put(key, value);
	}

	public void addData(String key, Object value) {
		if (key == null) {
			return;
		}
		if (this.data == null) {
			this.data = new HashMap<String, Object>();
		}
		this.data.put(key, value);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, String> getFieldMsgs() {
		return fieldMsgs;
	}

	public void setFieldMsgs(Map<String, String> fieldMsgs) {
		this.fieldMsgs = fieldMsgs;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
