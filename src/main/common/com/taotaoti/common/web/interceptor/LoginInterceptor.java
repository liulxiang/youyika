package com.taotaoti.common.web.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.redis.RedisCacheManager;

public class LoginInterceptor extends WebCommonInterceptor {

	public class WebCommonInterceptor {

	}

	private static final Log LOG = LogFactory.getLog(LoginInterceptor.class);
//	@Resource
//	private UserMgr userMgr;
	
	@Resource
	private RedisCacheManager redisCacheMgr;
	
	private List<String> notJsonPathList;
	
	private List<String> notInterceptPathList;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		ThreadContext.clean();
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//		// 去掉不需拦截的path
//		String requestPath = request.getRequestURI();
//		if(notInterceptPathList != null && notInterceptPathList.contains(requestPath)){
//			return true;
//		}
//		
//		// 验证是否JSON请求
//		boolean jsonEnabled = true;
//		if(notJsonPathList != null && notJsonPathList.contains(requestPath)){
//			jsonEnabled = false;
//		}
//		
//		// 到UC登录
//		LoginValidator loginValidator = LoginValidator.getInstance();
//		Integer loginUserId = loginValidator.isLogin(request, response, !jsonEnabled);
//		
//		/**
//		 * 登录与否判断
//		 */
//		// 返回null，response已经被redirect
//		if (LoginConstant.STATE_NOT_LOGIN_HAS_REDIRECT == loginUserId) {
//			return false;
//		}
//
//		// 抛出没有登录的异常
//		if (LoginConstant.STATE_NOT_LOGIN_NOT_REDIRECT.equals(loginUserId)) {
//			if (jsonEnabled) {
//				returnJsonSystemError(request, response, "请登录系统");
//			}
//			else{
//				response.sendRedirect(LoginConstant.getUC_LOGIN_URL());
//			}
//			return false;
//		}
//
//		// 抛出mcpack等其他异常
//		if (LoginConstant.STATE_UNEXPECTED_EXCEPTION.equals(loginUserId)) {
//			returnJsonSystemError(request, response, "系统繁忙");
//			return false;
//		}
//		
//		/**
//		 * 设置visitor
//		 */
//		ThreadContext.init();
//		String baiduId = CookieUtils.getCookieValue(request, LoginConstant.BAIDU_COOKIE_NAME);
//		
//		// 判断session中是否有visitor
//		HttpSession session = request.getSession();
//		Visitor visitor = (Visitor)session.getAttribute(UserConstant.USER_KEY);
//		if(canDisposeVisitor(loginUserId, baiduId, session, visitor)){
//			return true;
//		}
//		
//		// 判断Redis中是否有visitor
//		if(baiduId != null){
//			visitor = (Visitor)redisCacheMgr.get(baiduId + UserConstant.USER_KEY);
//		}
//		if(canDisposeVisitor(loginUserId, baiduId, session, visitor)){
//			return true;
//		}
//
//		// 获取用户的visitor
//		if(updateUserVisitor(loginUserId, baiduId, session)){
//			return true;
//		}
//		
//		// 没有获取到visitor，跳转到登录页
//		LOG.error("do not get visitor, redirect to login page");
//		response.sendRedirect(LoginConstant.getUC_LOGIN_URL());
//		return false;
		return true;
	}

/*	private boolean canDisposeVisitor(Integer loginUserId, String baiduId, HttpSession session, Visitor visitor){
		if(visitor instanceof Visitor){
			if(!loginUserId.equals(visitor.getUserid())){
				updateUserVisitor(loginUserId, baiduId, session);
			}
			else{
				updateSessionVisitor(session, visitor);
			}
			return true;
		}
		
		return false;
	}
	
	private boolean updateUserVisitor(Integer loginUserId, String baiduId, HttpSession session){
		Visitor visitor = userMgr.getVisitor(loginUserId);
		if(visitor instanceof Visitor){
			if(baiduId != null){
				redisCacheMgr.put(baiduId + UserConstant.USER_KEY, LoginConstant.SESSION_EXPIRE_TIME, visitor);
			}
			session.setAttribute(UserConstant.USER_KEY, visitor);
			ThreadContext.putSessionVisitor(visitor);
			
			return true;
		}
		
		return false;
	}
	
	private void updateSessionVisitor(HttpSession session, Visitor visitor){
		session.setAttribute(UserConstant.USER_KEY, visitor);
		ThreadContext.putSessionVisitor(visitor);
	}*/
	
	/**
	 * @return the notJsonPathList
	 */
	public List<String> getNotJsonPathList() {
		return notJsonPathList;
	}

	/**
	 * @param notJsonPathList the notJsonPathList to set
	 */
	public void setNotJsonPathList(List<String> notJsonPathList) {
		this.notJsonPathList = notJsonPathList;
	}

	/**
	 * @return the notInterceptPathList
	 */
	public List<String> getNotInterceptPathList() {
		return notInterceptPathList;
	}

	/**
	 * @param notInterceptPathList the notInterceptPathList to set
	 */
	public void setNotInterceptPathList(List<String> notInterceptPathList) {
		this.notInterceptPathList = notInterceptPathList;
	}

	
}
