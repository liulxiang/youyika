package com.taotaoti.common.web.member.auth.interceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.annotation.MultiPrivilege;
import com.taotaoti.common.annotation.Privilege;
import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.interceptor.WebCommonInterceptor;
import com.taotaoti.common.web.session.SessionProvider;

public class UserOperateInterceptor extends WebCommonInterceptor {

	private static final Log LOG = LogFactory.getLog(UserOperateInterceptor.class);
	private List<String> notInterceptPathList;
	
	@Autowired
	private SessionProvider session;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 去掉不需拦截的path
		String requestPath = request.getRequestURI();
		if (notInterceptPathList != null
				&& notInterceptPathList.contains(requestPath)) {
			return true;
		}
		// 获取visitor权限
		//Visitor visitor = ThreadContext.getSessionVisitor();
		Visitor visitor = session.getSessionVisitor(request);
		String[] authStr = visitor.getAuthArr();
		if(ArrayUtils.isEmpty(authStr)){
			LOG.error("visitor do not get any auth, userid is : " + visitor.getUserid());
			return false;
		}
		// 获取方法权限
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Privilege privilege = handlerMethod.getMethodAnnotation(Privilege.class);
		if(privilege != null){
			if(Arrays.asList(authStr).contains(privilege.value())){
				return true;
			}
			return returnError(request, response, visitor, privilege);
		}
		// 获取方法多重权限，模块间action复用
		MultiPrivilege multiPri = handlerMethod.getMethodAnnotation(MultiPrivilege.class);
		if(multiPri != null){
			for(String val : multiPri.value()){
				if(Arrays.asList(authStr).contains(val)){
					return true;
				}
			}
			return returnError(request, response, visitor, multiPri);
		}
		
		// 获取类权限
		privilege = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Privilege.class);
		if(privilege != null){
			if(Arrays.asList(authStr).contains(privilege.value())){
				return true;
			}
			return returnError(request, response, visitor, privilege);
		}
		
		// 获取类多重权限，模块间action复用
		multiPri = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), MultiPrivilege.class);
		if(privilege == null && multiPri == null){
			LOG.warn("requestUrl " + request.getRequestURI() + " do not config operate privilege");
			return true;
		}
		
		if(Arrays.asList(authStr).contains(multiPri.value())){
			return true;
		}
		return returnError(request, response, visitor, multiPri);
	}

	private boolean returnError(HttpServletRequest request, HttpServletResponse response, Visitor visitor, Privilege privilege) throws IOException{
		String message = "对不起，您没有此项服务的权限";
		LOG.error("user:" + visitor.getUserid() + " do not have privilege " + privilege.value() + " " + Arrays.deepToString(visitor.getAuthArr()));
		returnJsonSystemError(request, response, message);
		
		return false;
	}
	
	private boolean returnError(HttpServletRequest request, HttpServletResponse response, Visitor visitor, MultiPrivilege multiPrivilege) throws IOException{
		String message = "对不起，您没有此项服务的权限";
		LOG.error("user:" + visitor.getUserid() + " do not have privilege " + multiPrivilege.value() + " " + Arrays.deepToString(visitor.getAuthArr()));
		returnJsonSystemError(request, response, message);
		
		return false;
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
