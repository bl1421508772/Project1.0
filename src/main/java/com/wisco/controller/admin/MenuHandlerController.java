package com.wisco.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wisco.entity.Tbmenu;

@Controller
@RequestMapping("admin/")
public class MenuHandlerController {
	@RequestMapping("/saveMenu")
	public String saveMenu(Tbmenu tbmenu){
		
		return null;
	}
}
