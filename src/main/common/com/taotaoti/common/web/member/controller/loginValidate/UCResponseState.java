package com.taotaoti.common.web.member.controller.loginValidate;

public abstract class UCResponseState {

	/** objCcr == null：可能未登录，里面已设置sendredirect */
	public static final Integer STATE_NOT_LOGIN_HAS_REDIRECT = null;
	
	/** NotLoginException 一定未登录 */
	public static final Integer STATE_NOT_LOGIN_NOT_REDIRECT = -1;
	
	/** McpackException ，IOException ：真异常 */
	public static final Integer STATE_UNEXPECTED_EXCEPTION = -2;
	
	/**
	 * isLoginUserId:判断用户是否已经登陆
	 *
	 * @param userId 用户ID
	 * @return 是否是已经登陆
	*/
	public static final boolean isLoginUserId(Integer userId)  {
		return userId != null && userId > 0;
	}
}