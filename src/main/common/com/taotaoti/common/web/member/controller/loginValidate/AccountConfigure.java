package com.taotaoti.common.web.member.controller.loginValidate;
public class AccountConfigure {
	
	private static String UC_SESSION_SERVERS = "";
	private static int UC_SERVER_TIMEOUT=500;
	private static String UC_LOGIN_URL = "";
	private static String UC_LOGOUT_URL = "";
	private static String UC_JUMP_URL = "";
	private static String UC_BEIDOU_APPID;
	private static String UC_BEIDOU_APPKEY;
	private static String UC_BEIDOU_COOKIE_DOMAIN;
	
	
	public static String getUC_SESSION_SERVERS() {
		return UC_SESSION_SERVERS;
	}
	public static void setUC_SESSION_SERVERS(String uc_session_servers) {
		UC_SESSION_SERVERS = uc_session_servers;
	}
	public static int getUC_SERVER_TIMEOUT() {
		return UC_SERVER_TIMEOUT;
	}
	public static void setUC_SERVER_TIMEOUT(int uc_server_timeout) {
		UC_SERVER_TIMEOUT = uc_server_timeout;
	}
	public static String getUC_LOGIN_URL() {
		return UC_LOGIN_URL;
	}
	public static void setUC_LOGIN_URL(String uc_login_url) {
		UC_LOGIN_URL = uc_login_url;
	}
	public static String getUC_LOGOUT_URL() {
		return UC_LOGOUT_URL;
	}
	public static void setUC_LOGOUT_URL(String uc_logout_url) {
		UC_LOGOUT_URL = uc_logout_url;
	}
	public static String getUC_JUMP_URL() {
		return UC_JUMP_URL;
	}
	public static void setUC_JUMP_URL(String uc_jump_url) {
		UC_JUMP_URL = uc_jump_url;
	}
	public static String getUC_BEIDOU_APPID() {
		return UC_BEIDOU_APPID;
	}
	public static void setUC_BEIDOU_APPID(String uc_beidou_appid) {
		UC_BEIDOU_APPID = uc_beidou_appid;
	}
	public static String getUC_BEIDOU_APPKEY() {
		return UC_BEIDOU_APPKEY;
	}
	public static void setUC_BEIDOU_APPKEY(String uc_beidou_appkey) {
		UC_BEIDOU_APPKEY = uc_beidou_appkey;
	}
	public static String getUC_BEIDOU_COOKIE_DOMAIN() {
		return UC_BEIDOU_COOKIE_DOMAIN;
	}
	public static void setUC_BEIDOU_COOKIE_DOMAIN(String uc_beidou_cookie_domain) {
		UC_BEIDOU_COOKIE_DOMAIN = uc_beidou_cookie_domain;
	}
	
	
}