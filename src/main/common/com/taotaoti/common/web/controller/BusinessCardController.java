package com.taotaoti.common.web.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotaoti.common.controller.BaseController;

@Controller
@RequestMapping("/u")
public class BusinessCardController extends BaseController{
	
	@RequestMapping("/{userUrl}")
	public String download(@PathVariable("userUrl")String userUrl ,ModelMap model) {
		//model.addAttribute("user", exUser);
		return buildSuccessOnlyUrl("member/businesscard");
	}
}
