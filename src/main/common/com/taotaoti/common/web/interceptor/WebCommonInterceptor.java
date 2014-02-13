package com.taotaoti.common.web.interceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.taotaoti.common.constant.WebResponseConstant;
import com.taotaoti.common.utils.JsonUtils;
import com.taotaoti.common.vo.JsonObject;

public class WebCommonInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return false;
	}
	
	protected void returnJsonSystemError(HttpServletRequest request, HttpServletResponse response, String message) throws IOException{
		Map<String, Object> errors = new HashMap<String, Object>();
		errors.put("global", message);
		JsonObject json = new JsonObject();
		json.setStatus(WebResponseConstant.RESPONSE_STATUS_SYSTEM_ERROR);
		json.setStatusInfo(errors);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(JsonUtils.toJson(json));
	}
}
