package com.taotaoti.common.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;


public class RequestHeaderInterceptor extends WebCommonInterceptor {
    private List<String> notJsonPathList;
	
	private List<String> notInterceptPathList;
	private static final Log LOG = LogFactory.getLog(RequestHeaderInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String headerAccept=request.getHeader("Accept");
		return true;
	}

	public List<String> getNotJsonPathList() {
		return notJsonPathList;
	}

	public void setNotJsonPathList(List<String> notJsonPathList) {
		this.notJsonPathList = notJsonPathList;
	}

	public List<String> getNotInterceptPathList() {
		return notInterceptPathList;
	}

	public void setNotInterceptPathList(List<String> notInterceptPathList) {
		this.notInterceptPathList = notInterceptPathList;
	}

}
