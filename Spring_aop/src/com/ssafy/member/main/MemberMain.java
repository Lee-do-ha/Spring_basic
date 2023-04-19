package com.ssafy.member.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.member.controller.MemberController;
import com.ssafy.member.model.MemberDto;

public class MemberMain {
	public static void main(String[] args) throws SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/member/config/applicationContext.xml");
		MemberController memberController = context.getBean("memberController", MemberController.class);
		
		ArrayList<MemberDto> List = new ArrayList<MemberDto>();
		
		
		System.out.println("==================== 전체 멤버");
		List = memberController.listMember();
		for(MemberDto o : List) {
			System.out.println(o.toString());
		}
		System.out.println();
		
		
		System.out.println("==================== 멤버 등록");
		MemberDto newmem = new MemberDto();
		newmem.setId("asd");
		newmem.setName("asd");
		newmem.setPassword("asd");
		newmem.setEmail_id("asd");
		newmem.setEmail_domain("asd");
		memberController.registerMember(newmem);
		
		List = memberController.listMember();
		for(MemberDto o : List) {
			System.out.println(o.toString());
		}
		System.out.println();
		
		System.out.println("==================== 멤버 수정");
		newmem.setName("modifyname");
		newmem.setPassword("modifypassword");
		newmem.setEmail_id("modifyemail_id");
		newmem.setEmail_domain("modifyemail_domain");
		
		memberController.modifyMember(newmem);
		
		List = memberController.listMember();
		for(MemberDto o : List) {
			System.out.println(o.toString());
		}
		System.out.println();
		
		System.out.println("==================== 멤버 삭제");
		memberController.deleteMember("asd", "modifypassword");
		
		List = memberController.listMember();
		for(MemberDto o : List) {
			System.out.println(o.toString());
		}
		System.out.println();
		
		System.out.println("==================== 멤버 상세 조회");
		System.out.println(memberController.getMember("ssafy"));
		
		
	}

}
