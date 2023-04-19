package com.ssafy.openbook.model.service;

import com.ssafy.openbook.model.dto.UserDto;

public interface UserService {
	UserDto getUserInfo(String userId, String userPwd) throws Exception;
}
