package com.taotaoti.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.constant.WebResponseConstant;
import com.taotaoti.common.vo.JsonObject;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;

public class BaseController implements ApplicationContextAware {
	
	protected ApplicationContext context;
	public Map<String, Object> errors;
	public Map<String, Object> datas;
	public Visitor visitor;
	public JsonObject jsonObject;
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
	protected String getMessage(String resourceMessage) {
		String message = context.getMessage(resourceMessage, null, Locale.SIMPLIFIED_CHINESE);
		return message;
	}
	
	protected <T>String buildSuccessOnlyUrl(String pageUrl){
		return pageUrl;
	}
	/**
	 * @param pageUrl "other/syserror.jsp"
	 * @return
	 */
	protected <T>ModelAndView buildSuccessByRedirectOnlyUrl(String pageUrl){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("redirect:"+pageUrl);
		return modelAndView;
	}
	/**
	 * @param pageUrl "other/syserror.jsp"
	 * @return  othter/syserror.jsp?add=b
	 */
	protected <T>ModelAndView buildSuccessByRedirectAndParam(String pageUrl,ModelMap model,String key,T value){
		model.addAttribute(key, value);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("redirect:"+pageUrl);
		return modelAndView;
	}
	protected <T>ModelAndView buildSuccessByRedirectAndParam(String pageUrl,ModelMap model, List<MatchMap> listMaps){
		if(listMaps!=null&&listMaps.size()>0)
			for(MatchMap m:listMaps){
				model.addAttribute(m.getKey(), m.getValue());
		}
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("redirect:"+pageUrl);
		return modelAndView;
	}

	protected <T> JsonObject buildSuccess(String key,T value){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addData(key, value);
		return jsonObject;
	}
	protected <T> JsonObject buildSuccess(){
		jsonObject=new JsonObject();
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_OK);
		return jsonObject;
	}
	protected <T> JsonObject buildSuccess(String key, T value,String key2,T value2) {
		jsonObject=new JsonObject();
		jsonObject.addData(key, value);
		jsonObject.addData(key2, value2);
		
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_OK);
		return jsonObject;
	}
	protected <T> JsonObject buildSuccess(List<MatchMap> listMaps) {
		jsonObject=new JsonObject();
		if(listMaps!=null&&listMaps.size()>0)
			for(MatchMap m:listMaps){
				jsonObject.addData(m.getKey(), m.getValue());
			}
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_OK);
		return jsonObject;
	}
	
	protected <T> String buildSuccess(ModelMap model,String pageUrl,String key,T value){
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_OK);
		model.addAttribute(key, value);
		return pageUrl;
	}
	protected <T> String buildSuccess(ModelMap model,String pageUrl, List<MatchMap> listMaps){
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_OK);
		if(listMaps!=null&&listMaps.size()>0)
			for(MatchMap m:listMaps){
				model.addAttribute(m.getKey(), m.getValue());
			}
		return pageUrl;
	}
	protected <T> String buildSuccessAsHashData(ModelMap model,String pageUrl){
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_OK);
		model.addAllAttributes(datas);
		return pageUrl;
	}
	protected <T> String buildSysError(ModelMap model,String pageUrl){
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_SYSTEM_ERROR);
		return pageUrl;
	}
	protected <T> String buildParamError(ModelMap model,String pageUrl,HashMap<String, Object> errors){
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_SYSTEM_ERROR);
		model.addAllAttributes(errors);
		return pageUrl;
	}
	protected <T> String buildParamError(ModelMap model,String pageUrl,String field,String message){
		errors = new HashMap<String, Object>();
		errors.put(field, message);
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_BUSINESS_ERROR);
		model.addAllAttributes(errors);
		return pageUrl;
	}
	protected <T> String buildBusinessError(ModelMap model,String pageUrl,String message){
		model.addAttribute("message", message);
		model.addAttribute("status", WebResponseConstant.RESPONSE_STATUS_BUSINESS_ERROR);
		return pageUrl;
	}
	
	
	
	
	@InitBinder
	protected void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	
	/**
	 * 获取当前操作人的用户ID
	 * @return
	 */
	protected Integer getVisitorId(){
		Visitor visitor = ThreadContext.getSessionVisitor();
		return visitor == null ? null : visitor.getUserid();
	}
	protected Visitor getVisitor(){
		Visitor visitor = ThreadContext.getSessionVisitor();
		return visitor == null ? null : visitor;
	}
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
