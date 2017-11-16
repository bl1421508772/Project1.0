package com.wisco.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	public boolean checkUserExsit(String username, String password) {
		return userDao.checkUser(username, password) == 1;
	}
}
