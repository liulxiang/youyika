package com.taotaoti.common.web.member.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.web.session.SessionProvider;

@Controller
public class LoginController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	@Resource 
	private SessionProvider session;
	
	@Resource
	private RedisCacheManager redisCacheMgr;
	
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("email") String email, 
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			ModelMap model){
		String dbPassword=MD5.getMd5(password);
		//ExUser exUser=exAccountService.registerCommonExUser(email, username, dbPassword);
		LOG.info("register");
//		if(exUser!=null){
//			initVisterSessionAndRedis(request,response,exUser);
//			return LoginConstant.getACCOUNT_SETTINGS_URL();
//		}else {
//			return this.buildParamError(model, LoginConstant.getERROR(), "index", "用户已经存在");
//		}  
		return null;
	}
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			ModelMap model){
		    errors=new HashMap<String, Object>();
//		if(validatorUser(email, password)){
//	    	String dbPassword=MD5.getMd5(password);
//	    	ExUser exUser=memberDao.loginExUser(email, dbPassword);
//			if(exUser!=null){
//				initVisterSessionAndRedis(request,response,exUser);
//				return LoginConstant.getACCOUNT_HOME_URL();
//			}else {
//				return this.buildBusinessError(model, LoginConstant.getUC_LOGIN_URL(), "用户不存在");
//			}
//	    }else{
//	    	
//	    	return this.buildBusinessError(model, LoginConstant.getUC_LOGIN_URL(), "用户不存在");
//	    }
	    	return "";
	}
	
	
	
	public boolean validatorUser(String email,String password){
		if(email!=null&& password!=null){
			if(email.contains("@")&&password.length()>=6){
				return true;
			}else{
				this.errors.put("validatorError", "参数验证不合法");
			}
		}else
		     this.errors.put("validatorError", "参数不能为空");
		return false;
	}
	
	public SessionProvider getSession() {
		return session;
	}
	public void setSession(SessionProvider session) {
		this.session = session;
	}
	public RedisCacheManager getRedisCacheMgr() {
		return redisCacheMgr;
	}
	public void setRedisCacheMgr(RedisCacheManager redisCacheMgr) {
		this.redisCacheMgr = redisCacheMgr;
	}
}
