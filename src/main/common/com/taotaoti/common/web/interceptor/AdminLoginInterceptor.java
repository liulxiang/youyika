package com.taotaoti.common.web.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.constant.UserWebConstant;
import com.taotaoti.common.web.session.SessionProvider;


public class AdminLoginInterceptor extends WebCommonInterceptor {

	private static final Log LOG = LogFactory.getLog(AdminLoginInterceptor.class);
	
	
	private List<String> notJsonPathList;
	
	private List<String> notInterceptPathList;
	@Autowired
	private SessionProvider session;
	@Resource
	private RedisCacheManager redisCacheMgr;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		ThreadContext.clean();
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String requestPath = request.getRequestURI();//'/womiga/admin/login'
		String contextPath=request.getContextPath();//'/womiga'
		String webPath=requestPath.replace(contextPath, "");
		if(notInterceptPathList != null && notInterceptPathList.contains(webPath)){
			return true;
		}
		/**
		 * 设置visitor
		 * 
		 */
		// 判断session中是否有visitor
		Visitor visitor =session.getSessionVisitor(request);
		if(visitor!=null){
			System.out.println("---------------------");
			session.setAttributeAsVisitor(request, visitor);
			return true;
		}
		
		// 没有获取到visitor，跳转到登录页
		String loginPage=request.getContextPath()+"/admin/login";
		LOG.error("do not get visitor, redirect to login page==" +loginPage);
		response.sendRedirect(loginPage);
		return false;
	}

	
	
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


	public RedisCacheManager getRedisCacheMgr() {
		return redisCacheMgr;
	}

	public void setRedisCacheMgr(RedisCacheManager redisCacheMgr) {
		this.redisCacheMgr = redisCacheMgr;
	}

	public SessionProvider getSession() {
		return session;
	}

	public void setSession(SessionProvider session) {
		this.session = session;
	}


	
}
