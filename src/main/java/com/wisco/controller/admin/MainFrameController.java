package com.wisco.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisco.entity.Tbmenu;
import com.wisco.service.IconClsReadSerivce;
import com.wisco.service.MainFrameService;

@Controller
@RequestMapping("/admin")
public class MainFrameController {
	@Autowired
	private MainFrameService mainFrame;
	
	@Autowired
	private IconClsReadSerivce iconClsReadSerivce;
	@RequestMapping("/tree")
	
	@ResponseBody
	public List<Tbmenu> getNavTreeInfo(HttpServletRequest request){
		request.getSession().setAttribute("icons", iconClsReadSerivce.getIcons(request));
		return mainFrame.getNavTreeByParentId(request);
	}
	
}
