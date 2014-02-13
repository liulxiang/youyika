package com.taotaoti.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.constant.UserWebConstant;

/**
 * HttpSession提供类
 * 
 * @author liulxiang
 * 
 */
public class HttpSessionProvider implements SessionProvider {

	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		} else {
			return null;
		}
	}

	public void setAttribute(HttpServletRequest request,
			HttpServletResponse response, String name, Serializable value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	public String getSessionId(HttpServletRequest request,
			HttpServletResponse response) {
		return request.getSession().getId();
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	@Override
	public void setAttributeAsVisitor(HttpServletRequest request, Visitor visitor) {
		HttpSession session = request.getSession();
		session.setAttribute(UserWebConstant.USER_KEY, visitor);
		ThreadContext.init();
		ThreadContext.putSessionVisitor(visitor);
	}
	@Override
	public Visitor getSessionVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Visitor visitor = (Visitor)session.getAttribute(UserWebConstant.USER_KEY);
		return visitor;
	}
	@Override
	public Visitor getSessionVisitor(HttpServletRequest request ) {
		HttpSession session = request.getSession();
		Visitor visitor = (Visitor)session.getAttribute(UserWebConstant.USER_KEY);
		return visitor;
	}
	@Override
	public void clearSessionVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		ThreadContext.clean();
	}
	@Override
	public void clearSessionVisitor(HttpServletRequest request) {
		request.getSession().invalidate();
		ThreadContext.clean();
	}

	
}
