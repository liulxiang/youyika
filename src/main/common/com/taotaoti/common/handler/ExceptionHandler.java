package com.taotaoti.common.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.taotaoti.common.constant.WebResponseConstant;
import com.taotaoti.common.utils.ClassUtils;
import com.taotaoti.constants.GlobalConstant;

/**
 * 
 * 全局异常处理类
 *
 */
public class ExceptionHandler extends SimpleMappingExceptionResolver  implements ApplicationContextAware {
	
	protected ApplicationContext context;

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
	
	protected String getMessage(String resourceMessage) {
		String message = context.getMessage(resourceMessage, null, Locale.SIMPLIFIED_CHINESE);
		return message;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
		if (isAjax(request)) {

		}
		
		logger.error("System Error Occurred. " + e.getMessage(), e);
		ModelAndView model = new ModelAndView();
	
		//参数类型转换错误
		if (e instanceof TypeMismatchException) {
			return getParamErrors((TypeMismatchException)e, model);
			
		//参数绑定错误
		} else if (e instanceof BindException) {
			return getParamErrors((BindException)e, model);
			
		//系统错误
		} else if (e instanceof HttpRequestMethodNotSupportedException) {
			model.addObject("msg", getMessage("syserror.httpmethod"));
		} else if(e instanceof MissingServletRequestParameterException) {
			model.addObject("msg", getMessage("syserror.param.miss"));
		} else {
			model.addObject("msg", getMessage("syserror.inner"));
		}
		
		model.addObject("data", Collections.emptyList());
		model.addObject("status", WebResponseConstant.RESPONSE_STATUS_SYSTEM_ERROR);
		model.setViewName(GlobalConstant.getSYSERROR());
		return model;
	}

	/**
	 * TypeMismatchException中获取到参数错误类型
	 * @param e
	 * @param model
	 * @return
	 */
	private ModelAndView getParamErrors(TypeMismatchException e,
			ModelAndView model) {
		
		Throwable t = e.getCause();
		if(t instanceof ConversionFailedException){
			ConversionFailedException x = (ConversionFailedException)t;
			TypeDescriptor type = x.getTargetType();
			Annotation[] annotations = type != null ? type.getAnnotations() : new Annotation[0];
			Map<String, Object> errors = new HashMap<String, Object>();
			for(Annotation a: annotations){
				if(a instanceof RequestParam){
					errors.put(((RequestParam) a).value(), "参数类型错误!");
				}
			}
			if(errors.size() > 0){
				return paramError(model, errors);
			}
		}
		
		//构造error的映射
		model.addObject("status", WebResponseConstant.RESPONSE_STATUS_SYSTEM_ERROR);
		model.addObject("msg", "参数类型错误!");
		
		model.setViewName(GlobalConstant.getSYSERROR());
		return model;
	}

	/**
	 * 从bindException中获取到参数错误类型
	 * @param be
	 */
	private ModelAndView getParamErrors(BindException be, ModelAndView mvc) {
		
		//构造error的映射
		Map<String, Object> paramErrors = new HashMap<String, Object>();
		Object o = be.getTarget();
		for(Object error : be.getAllErrors()){
			if(error instanceof FieldError){
				FieldError fe = (FieldError) error;
				String field = fe.getField();
				Field oField = ClassUtils.getFieldFromClass(field, o.getClass());
				if(oField == null){
					paramErrors.put(field, "参数错误!");
				}else if(oField.getType().equals(Integer.class) || oField.getType().equals(Long.class) || oField.getType().equals(Short.class)){
					paramErrors.put(field, "必须是整数!");
				}else if(oField.getType().equals(Float.class) || oField.getType().equals(Double.class)){
					paramErrors.put(field, "必须是数字!");
				}else{
					paramErrors.put(field, "参数类型错误!");
				}
				
			}
		}
		
		return paramError(mvc, paramErrors);
	}

	/**
	 * @param mvc
	 * @param paramErrors
	 * @return
	 */
	private ModelAndView paramError(ModelAndView mvc,
			Map<String, Object> paramErrors) {
		//构造json中的errorMap
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("field", paramErrors);
		
		//构造mvc返回值
		mvc.addObject("status", WebResponseConstant.RESPONSE_STATUS_BUSINESS_ERROR);
		mvc.addObject("statusInfo", error);
		mvc.setViewName(GlobalConstant.getSYSERROR());
		return mvc;
	}
	

	private boolean isAjax(HttpServletRequest request) {
		return "baidu.ajax".equals(request.getHeader("X-Request-By"));
	}

}
