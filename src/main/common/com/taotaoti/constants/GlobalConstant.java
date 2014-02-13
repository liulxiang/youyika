package com.taotaoti.constants;
public class GlobalConstant {
	
	private static String UC_SESSION_SERVERS = "";
	private static int UC_SERVER_TIMEOUT=500;
	
	private static String UC_LOGIN_URL = "";
	private static String UC_LOGOUT_URL = "";
	private static String UC_JUMP_URL = "";
	private static String UC_HOME_URL = "";
	
	private static String ADMIN_UC_LOGIN_URL = "";
	private static String ADMIN_UC_LOGOUT_URL = "";
	private static String ADMIN_UC_JUMP_URL = "";
	private static String ADMIN_UC_HOME_URL = "";
	
	
	private static String ERROR="";
	private static String ERROR_404="";
	private static String SYSERROR="";
	
	
	public static String getERROR() {
		return ERROR;
	}
	public static void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	public static String getERROR_404() {
		return ERROR_404;
	}
	public static void setERROR_404(String eRROR_404) {
		ERROR_404 = eRROR_404;
	}
	public static String getSYSERROR() {
		return SYSERROR;
	}
	public static void setSYSERROR(String sYSERROR) {
		SYSERROR = sYSERROR;
	}
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
	public static String getADMIN_UC_LOGIN_URL() {
		return ADMIN_UC_LOGIN_URL;
	}
	public static void setADMIN_UC_LOGIN_URL(String aDMIN_UC_LOGIN_URL) {
		ADMIN_UC_LOGIN_URL = aDMIN_UC_LOGIN_URL;
	}
	public static String getADMIN_UC_LOGOUT_URL() {
		return ADMIN_UC_LOGOUT_URL;
	}
	public static void setADMIN_UC_LOGOUT_URL(String aDMIN_UC_LOGOUT_URL) {
		ADMIN_UC_LOGOUT_URL = aDMIN_UC_LOGOUT_URL;
	}
	public static String getADMIN_UC_JUMP_URL() {
		return ADMIN_UC_JUMP_URL;
	}
	public static void setADMIN_UC_JUMP_URL(String aDMIN_UC_JUMP_URL) {
		ADMIN_UC_JUMP_URL = aDMIN_UC_JUMP_URL;
	}
	public static String getUC_HOME_URL() {
		return UC_HOME_URL;
	}
	public static void setUC_HOME_URL(String uC_HOME_URL) {
		UC_HOME_URL = uC_HOME_URL;
	}
	public static String getADMIN_UC_HOME_URL() {
		return ADMIN_UC_HOME_URL;
	}
	public static void setADMIN_UC_HOME_URL(String aDMIN_UC_HOME_URL) {
		ADMIN_UC_HOME_URL = aDMIN_UC_HOME_URL;
	}
}