package com.taotaoti.common.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.taotaoti.common.constant.WebResponseConstant;
import com.taotaoti.common.vo.JsonObject;

public class JSonBaseController implements ApplicationContextAware {
	
	protected ApplicationContext context;
	public JsonObject jsonObject;;
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
	protected String getMessage(String resourceMessage) {
		String message = context.getMessage(resourceMessage, null, Locale.SIMPLIFIED_CHINESE);
		return message;
	}
	
	protected <T> JsonObject buildSuccessAndCache(String key, T value) {
		jsonObject=new JsonObject();
		jsonObject.addData(key, value);
		jsonObject.addData("cache", 1);
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_OK);
		return jsonObject;
	}
	
	protected <T> JsonObject buildSuccess(String key, T value) {
		jsonObject=new JsonObject();
		jsonObject.addData(key, value);
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
	
	protected JsonObject paramError(String field, String message){
		Map<String, Object> errors = new HashMap<String, Object>();
		errors.put(field, message);
		return paramError(errors);
	}
	
	protected JsonObject sysError(){
		jsonObject=new JsonObject();
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_SYSTEM_ERROR);
		return jsonObject;
	}
		
	protected JsonObject paramError(Map<String, Object> errors){
		jsonObject=new JsonObject();
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_BUSINESS_ERROR);
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("field", errors);
		jsonObject.setStatusInfo(error);
		return jsonObject;
	}
	
	protected JsonObject businessError(String message){
		jsonObject=new JsonObject();
		jsonObject.setMsg(Arrays.asList(message));
		jsonObject.setStatus(WebResponseConstant.RESPONSE_STATUS_BUSINESS_ERROR);
		return jsonObject;
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
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public JsonObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
	}

}
