package com.wisco.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
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
import com.wisco.entity.ApplicationConstants;
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
		return userDao.checkUser(username, password) == 1;
	}
	 /**
	  * 获取在线用户
	  * @param request
	  * @return
	  */
	 public List<Map<String , Object>> getOnlineUser(HttpServletRequest request){
		 List<Map<String , Object>> list = new ArrayList<Map<String , Object>>();
		 for (Map.Entry<String , HttpSession> entry : ApplicationConstants.SESSION_MAP.entrySet()) {
			 Map<String , Object> hashMap = new HashMap<String , Object>();
			 String key = entry.getKey();
			 HttpSession session = entry.getValue(); 
			 System.out.println(key + "+" + session );
			 hashMap.put("user" , session.getAttribute("user"));
			 hashMap.put("ip" , session.getAttribute("ip"));
			 hashMap.put("activeTimes", session.getAttribute("activeTimes"));
			 hashMap.put("state", "在线");
			 hashMap.put("Manager", "下线");
			 list.add(hashMap);
		 }
		 return list;
	 }
	 
	 public void underLine(String user , HttpServletRequest request){
		 for (Map.Entry<String , HttpSession> entry : ApplicationConstants.SESSION_MAP.entrySet()) {
			 if(user.equals(entry.getValue().getAttribute("user"))){
				 ApplicationConstants.SESSION_MAP.remove(entry.getValue());
				 entry.getValue().invalidate();
			 }
		 }
		 getOnlineUser(request);
	 }
	
}
