package com.wisco.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wisco.entity.User;

public interface UserService {
	public boolean checkUserExsit(String username , String password);
}
