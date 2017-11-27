package com.wisco.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		return userService.checkUserExsit(username , password, request);
	}
	
	@RequestMapping("/datagrid")
	@ResponseBody
	public List<Map<String , Object>> getLoginUser(HttpServletRequest request){
		return userService.getOnlineUser(request);
	}
	/**
	 * 注销
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/loginOut")
	public void logOut(HttpServletRequest request , HttpServletResponse response) throws IOException{
		 request.getSession().invalidate();
		 response.sendRedirect(request.getContextPath()+"/pages/admin/login.jsp");
	}
	/**
	 * 下线功能
	 * @param user
	 */
	@RequestMapping("/dropin")
	@ResponseBody
	public boolean dropin(String user , HttpServletRequest request){
		userService.underLine(user , request);
		return true;
	}
}
