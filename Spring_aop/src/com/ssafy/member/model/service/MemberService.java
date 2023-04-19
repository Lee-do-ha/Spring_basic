package com.ssafy.member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.member.model.MemberDto;

public interface MemberService {
	ArrayList<MemberDto> listMember() throws SQLException;
	MemberDto getMember(String ID) throws SQLException;
	void modifyMember(MemberDto member) throws SQLException;
	void deleteMember(String ID, String PASSWORD) throws SQLException;
	void registerMember(MemberDto member) throws SQLException;
}
