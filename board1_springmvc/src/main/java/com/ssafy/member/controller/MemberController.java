package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	private MemberService memberservice;

	@Autowired
	public MemberController(MemberService memberservice) {
		super();
		this.memberservice = memberservice;
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userid") String userId, @RequestParam("userpwd") String userPwd,HttpSession session, Model model) throws Exception {
		
		MemberDto memberdto = memberservice.loginMember(userId, userPwd);
		if(memberdto != null) {
			session.setAttribute("userinfo", memberdto);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "아이디 혹은 비밀번호를 확인 후 로그인하세요!!!");
			return "/login";
		}	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/join")
	public String join(String username, String userid, String userpwd, String emailid, String emaildomain) throws Exception {
		MemberDto memberdto = new MemberDto();
		
		memberdto.setUserName(username);
		memberdto.setUserId(userid);
		memberdto.setUserPwd(userpwd);
		memberdto.setEmailId(emailid);
		memberdto.setEmailDomain(emaildomain);
		
		memberservice.joinMember(memberdto);
		
		return "index";
	}
}
