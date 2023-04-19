package com.ssafy.member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	
	@Override
	public ArrayList<MemberDto> listMember() throws SQLException{
//		System.out.println("=====Service listMember Call=====");
		return memberDao.listMember();
	}

	@Override
	public MemberDto getMember(String ID) throws SQLException{
//		System.out.println("=====Service getMember Call=====");
		return memberDao.getMember(ID);
	}

	@Override
	public void modifyMember(MemberDto member) throws SQLException{
//		System.out.println("=====Service modifyMember Call=====");
		memberDao.modifyMember(member);
	}

	@Override
	public void deleteMember(String ID,String PASSWORD) throws SQLException{
//		System.out.println("=====Service deleteMember Call=====");
		memberDao.deleteMember(ID,PASSWORD);
	}

	@Override
	public void registerMember(MemberDto member) throws SQLException {
//		System.out.println("=====Service registerMember Call=====");
		memberDao.registerMember(member);
	}

}
