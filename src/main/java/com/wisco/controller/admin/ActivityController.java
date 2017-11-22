package com.wisco.controller.admin;
/**
 * 检测用户登录信息
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
@Controller
public class ActivityController  {
	public void addLoginUser(HttpServletRequest request){
		ServletContext application = request.getSession().getServletContext();
		  Collection<HttpSession> sessions = null;
		  if(application.getAttribute("user") == null ){ //判断用户是否存在于application域中
			  //不存在，当前只有一个登录
			  sessions = new ArrayList<HttpSession>();//创建一个HttpSession集合
			  application.setAttribute("user", sessions);//key=用户名;value=session
		  } else {
			  //如果已经存在对象于域
			  sessions = (Collection<HttpSession>) application.getAttribute("user");//获取当前域的session对象
		  }
		  
	}

	private HttpServletRequest LoginManager() {
		// TODO Auto-generated method stub
		return null;
	}
}
