package com.taotaoti.common.web.interceptor;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class SqlParamInterceptor extends HandlerInterceptorAdapter {
	private static final Log log = LogFactory.getLog(SqlParamInterceptor.class);
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
		HttpServletRequest req=request;
		 //获得所有请求参数名
		 Enumeration params = req.getParameterNames();
		 String sql = "";
		 while (params.hasMoreElements()) {
		//得到参数名
		 String name = params.nextElement().toString();
		//得到参数对应值
		String[] value = req.getParameterValues(name);
		for (int i = 0; i < value.length; i++) {
		sql = sql + value[i];
	     }
		}
		 log.info("request param is "+sql);
		if (sqlValidate(sql)) {
			String indexPage="index";//request.getContextPath();
			log.info("servlet path="+request.getServletPath());
			response.sendRedirect(indexPage);
		   // throw new IOException("您发送请求中的参数中含有非法字符");
		    return super.preHandle(request, response, handler);
		} else {
			return super.preHandle(request, response, handler);
		 }
		
	}
	
	protected static boolean sqlValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|"
				+
				"char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|"
				+
				"table|from|grant|use|group_concat|column_name|"
				+
				"information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
				+
				"chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.indexOf(badStrs[i]) >= 0) {
				return true;
			}
		}
		return false;
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
