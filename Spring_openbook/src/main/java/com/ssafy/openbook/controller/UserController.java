package com.ssafy.openbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.openbook.model.dto.UserDto;
import com.ssafy.openbook.model.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	private UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	
	@PostMapping("/login")
	public String login(UserDto userDto, HttpSession session, Model model) {
		try {
			UserDto userInfo = userService.getUserInfo(userDto.getUserId(), userDto.getUserPwd());
			if(userInfo == null) {
				// 로그인 정보가 잘못 된 경우
				model.addAttribute("msg", "아이디 또는 비밀번호가 잘못 되었습니다.");
				return "/error/error";
			} else {
				session.setAttribute("userInfo", userInfo);
				return "redirect:/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/index";
	}
	
}
