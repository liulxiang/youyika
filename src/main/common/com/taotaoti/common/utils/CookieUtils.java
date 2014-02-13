package com.taotaoti.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CookieUtils {
	
	public static String getCookieValue(HttpServletRequest request,
			String cookieName) {
		if (cookieName == null || request == null) {
			return null;
		}
		Cookie[] cks = request.getCookies();
		if (cks == null) {
			return null;
		}
		for (Cookie cookie : cks) {
			if (cookieName.equals(cookie.getName()))
				return cookie.getValue();
		}
		return null;
	}

	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		if (cookieName == null || request == null) {
			return null;
		}
		Cookie[] cks = request.getCookies();
		if (cks == null) {
			return null;
		}
		for (Cookie cookie : cks) {
			if (cookieName.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
	public static HttpServletResponse removeCookie(HttpServletRequest request,HttpServletResponse response, String cookieName) {
		if (cookieName == null || request == null) {
			return response;
		}
		Cookie[] cks = request.getCookies();
		if (cks == null) {
			return response;
		}
		for (Cookie cookie : cks) {
			if (cookieName.equals(cookie.getName())) {
				cookie = new Cookie(cookieName, null); 
				cookie.setMaxAge(-1);
				response.addCookie(cookie); 
				
				return response;
			}
		}
		return response;
	}
}
