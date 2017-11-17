package com.wisco.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		if(userService.checkUserExsit(username , password)){
			session.setAttribute("user" , username);//成功登录后，将用户存放在session
		}
		return userService.checkUserExsit(username , password);
	}
}
