package com.taotaoti.common.web.member.auth.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.interceptor.WebCommonInterceptor;
import com.taotaoti.common.web.session.SessionProvider;


public class UserManageInterceptor extends WebCommonInterceptor {

	private static final Log LOG = LogFactory.getLog(UserManageInterceptor.class);
	
	
	private List<String> notInterceptPathList;
	@Autowired
	private SessionProvider session;
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
//		if (notInterceptPathList != null
//				&& notInterceptPathList.contains(requestPath)) {
//			return true;
//		}
//		
//		Visitor visitor = session.getSessionVisitor(request);
//		boolean canManage = userMgr.hasDataPrivilege(null, visitor.getLoginUserId(), dspId);
//		if(canManage){
//			ThreadContext.putShardKey(dspId);
//			return true;
//		}
//		
//		String message = "您没有权限访问";
//		LOG.error("user " + visitor.getId() + " can not manage user ");
//		returnJsonSystemError(request, response, message);
//		return false;
		return true;
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
