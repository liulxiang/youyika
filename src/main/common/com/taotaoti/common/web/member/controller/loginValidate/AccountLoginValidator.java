package com.taotaoti.common.web.member.controller.loginValidate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.constant.UserWebConstant;

public final class AccountLoginValidator {

	private static final Logger log = LoggerFactory.getLogger(AccountLoginValidator.class);
	private static volatile AccountLoginValidator validator = null;

	private AccountLoginValidator() throws IOException {
	}

	public static AccountLoginValidator getInstance() {
		if(validator == null){
			synchronized (AccountLoginValidator.class) {
				if (validator == null) {
					try {
						validator = new AccountLoginValidator();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		}
		return validator;
	}

	public void logout(HttpServletRequest request){
		clearSession(request);
	}
	
	public Integer isLogin(HttpServletRequest request, HttpServletResponse response,boolean autoRedirect) {
		Integer userid = null;
		Visitor visitor = null;
		HttpSession session = request.getSession();
		visitor = (Visitor)session.getAttribute(UserWebConstant.USER_KEY);
		if(visitor!=null){
			userid=visitor.getUserid();
		    updateSession(session, visitor);
		}
		return userid;
	}
	
	public void clearSession(HttpServletRequest request){
		request.getSession().invalidate();
		ThreadContext.clean();
	}
	
	public Integer isLogin(HttpServletRequest request) {
		Integer userid = null;
		Visitor visitor = null;
		HttpSession session = request.getSession();
		visitor = (Visitor)session.getAttribute(UserWebConstant.USER_KEY);
		if(visitor!=null){
			ThreadContext.init();
			userid = visitor.getUserid();
			updateSession(session, visitor);
		}
		return userid;
	}
	public Integer initLogin(HttpServletRequest request,HttpSession session,Visitor visitor) {
		ThreadContext.init();
		int userid = visitor.getUserid();
		updateSession(session, visitor);
		return userid;
	}
	
	public void updateSession(HttpSession session, Visitor visitor) {
		if (session == null) {
			return ;
		}else{
		session.setAttribute(UserWebConstant.USER_KEY, visitor);
		ThreadContext.putSessionVisitor(visitor);
		}
	}
}

