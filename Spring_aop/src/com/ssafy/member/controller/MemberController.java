package com.ssafy.member.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

public class MemberController {

	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	public ArrayList<MemberDto> listMember() throws SQLException{
//		System.out.println("=====Controller listMember Call=====");
		return memberService.listMember();
	}

	public MemberDto getMember(String ID) throws SQLException{
//		System.out.println("=====Controller getMember Call=====");
		return memberService.getMember(ID);
	}

	public void modifyMember(MemberDto member) throws SQLException{
//		System.out.println("=====Controller modifyMember Call=====");
		memberService.modifyMember(member);
	}

	public void deleteMember(String ID,String PASSWORD) throws SQLException{
//		System.out.println("=====Controller deleteMember Call=====");
		memberService.deleteMember(ID,PASSWORD);
	}
	
	public void registerMember(MemberDto member) throws SQLException{
//		System.out.println("=====Controller registerMember Call=====");
		memberService.registerMember(member);
	}
}
