package com.wisco.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisco.dao.UserDao;
import com.wisco.entity.User;
import com.wisco.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean checkUserExsit(String username, String password , HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(userDao.checkUser(username , password) == 1){
			session.setAttribute("user" , username);//成功登录后，将用户存放在session
		}
		addLoginUser(request);//实现单点登录
		return userDao.checkUser(username, password) == 1;
	}
	
	/**
	 * 操作用户
	 * @param request
	 */
	public void addLoginUser(HttpServletRequest request){
		ServletContext application = request.getSession().getServletContext();
		  Collection<HttpSession> sessions = null;
		  if(application.getAttribute("user") == null ){ //判断用户是否存在于application域中
			  //不存在，当前只有一个登录
			  sessions = new ArrayList<HttpSession>();//创建一个HttpSession集合
			  sessions.add(request.getSession());
			  application.setAttribute("user" , sessions);//key=用户名;value=session
		  } else {
			  //如果已经存在对象于域
			  sessions = (Collection<HttpSession>) application.getAttribute("user");//获取当前域的session对象
		  }
		  loginManager(sessions , request.getSession());
	}
	
	 public HttpSession loginManager(Collection<HttpSession> sessions,  HttpSession session){
		 List<HttpSession> sessionde = new ArrayList<HttpSession>(); //创建一个session集合
		 for (HttpSession s : sessions) { //遍历sessions集合
			 try{
				 //获取用户sessionId
				 String hoistoryuser = (String) s.getAttribute("user");//之前影虎的user的session
				 String nowuser = (String) session.getAttribute("user");//现在登录的用户的session
				 if(nowuser.equals(hoistoryuser)){
					 sessions.remove(s);//相等就移除之前的session
					 if(!session.equals(s)){ //如果不是同一浏览器
						 s.invalidate();// 废弃之前登陆的session
					 }
					 break;
				 }
			 } catch(Exception e) {
				 sessionde.add(s);
			 }
		}
		 for (int i = 0; i < sessionde.size(); i++) {
		      sessions.remove((HttpSession) sessionde.get(i)); 
		 }
			  sessions.add(session);
		return null;
	 }
	 /**
	  * 获取在线用户
	  * @param request
	  * @return
	  */
	 public List<User> getOnlineUser(HttpServletRequest request){
		 List<User> users = userDao.checkAllUser();
		 for (User user : users) {
			 if(!checkOnline(user , request)){
				 users.remove(user);
			 }
		}
		 return users;
	 }

	
	private boolean checkOnline(User admin , HttpServletRequest request){
		ServletContext application = request.getSession().getServletContext();
		 Collection<HttpSession> sessions = (Collection<HttpSession>) application.getAttribute("user");
		 List<User> list = new ArrayList<User>();
		 for (HttpSession httpSession : sessions) {
			String SessionName = (String) httpSession.getAttribute("user");
			
			if(SessionName.isEmpty()){
				return false;
			}
			return true;
		 }
		return false;
	}
}
