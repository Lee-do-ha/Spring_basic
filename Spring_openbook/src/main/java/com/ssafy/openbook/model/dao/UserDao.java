package com.ssafy.openbook.model.dao;

import com.ssafy.openbook.model.dto.UserDto;

public interface UserDao {
	UserDto getUserInfo(String userId, String userPwd) throws Exception;
}
