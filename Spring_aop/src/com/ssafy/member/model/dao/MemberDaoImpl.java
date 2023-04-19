package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao{

	private final DataSource datasource;
	private final DBUtil dbUtil;
	
	public MemberDaoImpl(DataSource datasource, DBUtil dbUtil) {
		super();
		this.datasource = datasource;
		this.dbUtil = dbUtil;
	}

	@Override
	public ArrayList<MemberDto> listMember() throws SQLException{
//		System.out.println("=====MemberDao listMember Call=====");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		try {
			conn = datasource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from members \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("user_id"));
				member.setName(rs.getString("user_name"));
				member.setPassword(rs.getString("user_password"));
				member.setEmail_id(rs.getString("email_id"));
				member.setEmail_domain(rs.getString("email_domain"));
				member.setJoin_date(rs.getString("join_date"));
				list.add(member);
			}
		} catch (Exception e) {
			dbUtil.close(pstmt, conn, rs);
		}
		return list;
	}

	@Override
	public MemberDto getMember(String ID) throws SQLException{
//		System.out.println("=====MemberDao getMember Call=====");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = null;
		try {
			conn = datasource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from members \n");
			sql.append("where user_id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("user_id"));
				member.setName(rs.getString("user_name"));
				member.setPassword(rs.getString("user_password"));
				member.setEmail_id(rs.getString("email_id"));
				member.setEmail_domain(rs.getString("email_domain"));
				member.setJoin_date(rs.getString("join_date"));
			}
		} catch (Exception e) {
			dbUtil.close(pstmt, conn, rs);
		}
		return member;
	}

	@Override
	public void modifyMember(MemberDto member) throws SQLException{
//		System.out.println("=====MemberDao modifyMember Call=====");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = datasource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update members \n");
			sql.append("set user_name = ?, user_password = ?, email_id = ?, email_domain = ? \n");
			sql.append("where user_id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail_id());
			pstmt.setString(4, member.getEmail_domain());
			pstmt.setString(5, member.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void deleteMember(String ID, String PASSWORD) throws SQLException{
//		System.out.println("=====MemberDao deleteMember Call=====");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = datasource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from members \n");
			sql.append("where user_id = ? and user_password = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, ID);
			pstmt.setString(2, PASSWORD);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void registerMember(MemberDto member) throws SQLException {
//		System.out.println("=====MemberDao registerMember Call=====");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = datasource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into members \n");
			sql.append("values (?, ?, ?, ? ,?, now()) \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail_id());
			pstmt.setString(5, member.getEmail_domain());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
