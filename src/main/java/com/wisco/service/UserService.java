package com.wisco.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.wisco.entity.User;

public interface UserService {
	public boolean checkUserExsit(String username , String password , HttpServletRequest request);
	
	public List<Map<String , Object>> getOnlineUser(HttpServletRequest request);
	
	public void underLine(String user , HttpServletRequest request);
}
