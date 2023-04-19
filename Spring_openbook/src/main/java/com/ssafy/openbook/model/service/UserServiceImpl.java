package com.ssafy.openbook.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.openbook.model.dao.UserDao;
import com.ssafy.openbook.model.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	@Autowired
	private UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public UserDto getUserInfo(String userId, String userPwd) throws Exception {
		return userDao.getUserInfo(userId, userPwd);
	}
}
