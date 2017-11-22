package com.wisco.dao;

import java.util.List;
import java.util.Map;

import com.wisco.entity.User;

public interface UserDao {
	public int checkUser(String username , String password);
	
	public List<User> checkAllUser();
}
