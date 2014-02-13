package com.taotaoti.common.utils;

public class SystemConstant {
	
	/** 系统级异常 */
	public static final int JSON_OPERATE_SUCCESS = 0;
	public static final int JSON_OPERATE_FAILED = 1;
	
	/** 业务异常 */
	public static final int JSON_OPERATE_FAILED_SERVER = 2;
	public static final int JSON_OPERATE_FAILED_NOAUTH = 126;
	public static final int JSON_OPERATE_FAILED_NOTLOGIN = 127;
	
	/**
	 * 全局的json错误跳转
	 */
	public static final String SYSTEM_ERROR_JSON= "system_error_json";
	public static final String BUSINESS_FAILURE_JSON= "business_failure_json";
	public static final String NO_AUTH_JSON= "no_auth_json";
	public static final String NO_LOGIN_JSON= "no_login_json";
	public static final String NO_FOUND_JSON= "no_found_json";
	
	/**
	 * 当前请求是否为json请求，存入context的名称
	 */
	public static final String INTERCEPTOR_JSON_ENABLED = "INTERCEPTOR_JSON_ENABLED";

}
