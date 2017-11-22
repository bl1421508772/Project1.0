package com.wisco.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisco.entity.Tbmenu;
import com.wisco.service.MainFrameService;

@Controller
@RequestMapping("/admin")
public class MainFrameController {
	@Autowired
	private MainFrameService mainFrame;
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tbmenu> getNavTreeInfo(HttpServletRequest request){
		//System.out.println(mainFrame.getNavTreeByParentId(request).toString());
		return mainFrame.getNavTreeByParentId(request);
	}
}
