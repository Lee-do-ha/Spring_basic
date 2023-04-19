package com.ssafy.openbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.openbook.model.dto.UserDto;
import com.ssafy.openbook.util.DBUtil;

@Repository
public class UserDaoImpl implements UserDao {
	
	private final DataSource dataSource;
	private final DBUtil dbUtil;
	
	@Autowired
	private UserDaoImpl(DataSource dataSource, DBUtil dbUtil) {
		super();
		this.dataSource = dataSource;
		this.dbUtil = dbUtil;
	}
	
	@Override
	public UserDto getUserInfo(String userId, String userPwd) throws Exception {
		// 조회할 상품 가져오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto userInfo = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from members \n");
			sql.append("where user_id = ? and user_password = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userInfo = new UserDto();
				userInfo.setUserId(rs.getString("user_id"));
				userInfo.setUserName(rs.getString("user_name"));
				userInfo.setEmailId(rs.getString("email_id"));
				userInfo.setEmailDomain(rs.getString("email_domain"));
				userInfo.setJoinDate(rs.getString("join_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return userInfo;
	}
	
}
