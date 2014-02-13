package com.taotaoti.common.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.vo.JsonObject;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {
	 private static final Log log = LogFactory.getLog(DemoController.class);
	@RequestMapping(value = "/Home")
	public String initHome(){
		System.out.println("initHome");
		ModelMap model=new ModelMap();// 如果自己new 一个 不会当做值传入
		return	this.buildSuccess(model, "other/error", "error", "sb");
		//return "other/error";
	}
	@RequestMapping(value = "/Home2")
	public String initHome2(ModelMap model){// 这个可以传入参数
		System.out.println("initHome");
		return this.buildSuccess(model, "other/error", "error", "sb");
		//return "other/error";
	}
	@RequestMapping(value = "/Home3")
	public String initHome3(ModelMap model){// 这个可以传入参数
		System.out.println("initHome");
		return this.buildSuccess(model, "/other/error", "error", "sb");
		//return "other/error";
	}
	@RequestMapping(value = "/Home4")
	public String initHome4(ModelMap model){// 这个可以传入参数
		System.out.println("initHome");
		return this.buildSuccess(model, "redirect:/other/error", "error", "sb");
		//return "other/error";
	}
	@RequestMapping(value = "/Home5")
	public String initHome5(ModelMap model){// 这个可以传入参数
		System.out.println("initHome5");
		
		return this.buildSuccess(model, "forward:/other/error", "error", "sb");
		//return "other/error";
	}
	@RequestMapping(value = "/HomeRedirct")
	public ModelAndView initHomeRedirct(){
		System.out.println("initHome");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("redirect:/other/error.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/HomeForward")
	public ModelAndView initHomeForward(){
		System.out.println("initHome");
		ModelAndView modelAndView=new ModelAndView();
		JsonObject jsonObject=this.buildSuccess("error", "1111111111111111111111111");
		modelAndView.addObject(jsonObject);
		modelAndView.setViewName("forward:/404");
		return modelAndView;
	}
	@RequestMapping(value = "/HomeForward2")
	public ModelAndView initHomeForward2(){
		System.out.println("initHome");
		ModelAndView modelAndView=new ModelAndView();
//		jsonObject=this.buildSuccess("error", "1111111111111111111111111");
//		modelAndView.addObject(jsonObject);
		modelAndView.setViewName("forward:/other/error.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/HomeRoot")
	public ModelAndView initHomeRootPath(){
		System.out.println("initHome");
		ModelAndView modelAndView=new ModelAndView();
//		jsonObject=this.buildSuccess("error", "1111111111111111111111111");
//		modelAndView.addObject(jsonObject);
		modelAndView.setViewName("/other/error");
		return modelAndView;
	}
	@RequestMapping(value = "/HomePath")
	public ModelAndView initHomePath(){
		System.out.println("initHome");
		ModelAndView modelAndView=new ModelAndView();
//		jsonObject=this.buildSuccess("error", "1111111111111111111111111");
//		modelAndView.addObject(jsonObject);
		modelAndView.setViewName("other/error");
		return modelAndView;
	}
	
	
	
}
