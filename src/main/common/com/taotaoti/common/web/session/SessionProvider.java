package com.taotaoti.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotaoti.common.vo.Visitor;

/**
 * Session提供者
 * 
 * @author liulxiang
 * 
 */
public interface SessionProvider {
	public Serializable getAttribute(HttpServletRequest request, String name);

	public void setAttribute(HttpServletRequest request,
			HttpServletResponse response, String name, Serializable value);
	
	public void setAttributeAsVisitor(HttpServletRequest request,Visitor visitor);

	public String getSessionId(HttpServletRequest request,
			HttpServletResponse response);
	
	public Visitor getSessionVisitor(HttpServletRequest request,
			HttpServletResponse response);
	public Visitor getSessionVisitor(HttpServletRequest request );
	public void clearSessionVisitor(HttpServletRequest request,
			HttpServletResponse response);
	public void clearSessionVisitor(HttpServletRequest request );

	public void logout(HttpServletRequest request, HttpServletResponse response);
}
