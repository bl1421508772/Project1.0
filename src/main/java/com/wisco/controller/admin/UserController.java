package com.wisco.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisco.entity.User;
import com.wisco.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/sign")
	@ResponseBody
	public boolean checkCurrentUser(String username , String password , HttpServletRequest request){
		return userService.checkUserExsit(username , password);
	}
}
