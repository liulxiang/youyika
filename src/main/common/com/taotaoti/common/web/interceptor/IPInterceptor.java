package com.taotaoti.common.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.utils.IPUtils;
import com.taotaoti.common.web.constant.UserWebConstant;


@Component
public class IPInterceptor extends HandlerInterceptorAdapter {
   private List<String> notJsonPathList;
	
	private List<String> notInterceptPathList;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//初始化ThreadLocal
		ThreadContext.init();
		String ip = IPUtils.getIpAddr(request);
		ThreadContext.putContext(UserWebConstant.API_VISITOR_IP_THREADCONTEXT_KEY, ip);
		return super.preHandle(request, response, handler);
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
