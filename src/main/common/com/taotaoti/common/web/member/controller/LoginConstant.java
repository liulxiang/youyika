package com.taotaoti.common.web.member.controller;

/**
 *
 */
public class LoginConstant {

	/** objCcr == null：可能未登录，里面已设置sendredirect */
	public static final Integer STATE_NOT_LOGIN_HAS_REDIRECT = null;
	
	/** NotLoginException 一定未登录 */
	public static final Integer STATE_NOT_LOGIN_NOT_REDIRECT = -1;
	
	/** McpackException ，IOException ：真异常 */
	public static final Integer STATE_UNEXPECTED_EXCEPTION = -2;
	
	public static final String TAOTAOTI_COOKIE_NAME = "TAOTAOTI";
	public static final String TAOTAOTI_COOKIE_USERID = "TAOTAOTI_USERID";
	/** taotaoti Email**/
	public static final String TAOTAOTI_COOKIE_EMAIL="TAOTAOTI_EMAIL";
	
	/** taotaoti password**/
	public static final String TAOTAOTI_COOKIE_PASSWORD="TAOTAOTI_PASSWORD";
	
	
	/** 存在Redis中的过期时间 */
	public static final int SESSION_EXPIRE_TIME = 1800;
	
	
	
	
	private static String UC_LOGIN_URL = "";
	private static String UC_LOGOUT_URL = "";
	private static String UC_JUMP_URL = "";
	
	private static String ERROR="";
	private static String ERROR_404="";
	private static String SYSERROR="";
	
	private static String ACCOUNT_SETTINGS_URL="";
	private static String ACCOUNT_PROFILE_URL="";
	private static String ACCOUNT_HOME_URL="";
	
	
	public static void setACCOUNT_HOME_URL(String aCCOUNT_HOME_URL) {
		ACCOUNT_HOME_URL = aCCOUNT_HOME_URL;
	}



	public static String getACCOUNT_HOME_URL() {
		return ACCOUNT_HOME_URL;
	}
	
	
	
	public static String getACCOUNT_SETTINGS_URL() {
		return ACCOUNT_SETTINGS_URL;
	}
	public static void setACCOUNT_SETTINGS_URL(String aCCOUNT_SETTINGS_URL) {
		ACCOUNT_SETTINGS_URL = aCCOUNT_SETTINGS_URL;
	}
	public static String getACCOUNT_PROFILE_URL() {
		return ACCOUNT_PROFILE_URL;
	}
	public static void setACCOUNT_PROFILE_URL(String aCCOUNT_PROFILE_URL) {
		ACCOUNT_PROFILE_URL = aCCOUNT_PROFILE_URL;
	}
	/**
	 * @return the uC_LOGIN_URL
	 */
	public static String getUC_LOGIN_URL() {
		return UC_LOGIN_URL;
	}
	/**
	 * @param uC_LOGIN_URL the uC_LOGIN_URL to set
	 */
	public void setUC_LOGIN_URL(String uC_LOGIN_URL) {
		UC_LOGIN_URL = uC_LOGIN_URL;
	}
	/**
	 * @return the uC_LOGOUT_URL
	 */
	public static String getUC_LOGOUT_URL() {
		return UC_LOGOUT_URL;
	}
	/**
	 * @param uC_LOGOUT_URL the uC_LOGOUT_URL to set
	 */
	public void setUC_LOGOUT_URL(String uC_LOGOUT_URL) {
		UC_LOGOUT_URL = uC_LOGOUT_URL;
	}
	/**
	 * @return the uC_JUMP_URL
	 */
	public static String getUC_JUMP_URL() {
		return UC_JUMP_URL;
	}
	/**
	 * @param uC_JUMP_URL the uC_JUMP_URL to set
	 */
	public void setUC_JUMP_URL(String uC_JUMP_URL) {
		UC_JUMP_URL = uC_JUMP_URL;
	}
	public static String getSYSERROR() {
		return SYSERROR;
	}
	public static void setSYSERROR(String sYSERROR) {
		SYSERROR = sYSERROR;
	}
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
	
}
