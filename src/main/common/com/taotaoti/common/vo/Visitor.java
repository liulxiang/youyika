package com.taotaoti.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.taotaoti.common.commons.BaseObject;

/**
 * 2013-5-6
 */
public class Visitor extends BaseObject<Integer> implements Serializable {

	private static final long serialVersionUID = 5621993194031128338L;
	
	private String[] authArr = new String[]{};
	private String[] roleArr = new String[]{};
	private Integer userid;
	private String taotaotiId;

	private String username;

	private String ip;
	private String email;
	
	private boolean isTeacher;
	
	private Date loginTime;
	
	public boolean isTeacher() {
		return isTeacher;
	}
	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}
	public String[] getAuthArr() {
		return authArr;
	}
	public void setAuthArr(String[] authArr) {
		this.authArr = authArr;
	}
	public String[] getRoleArr() {
		return roleArr;
	}
	public void setRoleArr(String[] roleArr) {
		this.roleArr = roleArr;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getTaotaotiId() {
		return taotaotiId;
	}
	public void setTaotaotiId(String taotaotiId) {
		this.taotaotiId = taotaotiId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


	
}
