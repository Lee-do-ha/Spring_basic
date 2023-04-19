package com.ssafy.openbook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.openbook.model.dto.ProductDto;
import com.ssafy.openbook.util.DBUtil;

@Repository
public class ProductDaoImpl implements ProductDao {

	private final DataSource dataSource;
	private final DBUtil dbUtil;
	
	@Autowired
	private ProductDaoImpl(DataSource dataSource, DBUtil dbUtil) {
		super();
		this.dataSource = dataSource;
		this.dbUtil = dbUtil;
	}
	
	// �긽�뭹 �벑濡�
	@Override
	public int registerProduct(ProductDto productDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {			
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into product \n");
			sql.append("values(?, ?, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getCode());
			pstmt.setString(2, productDto.getModel());
			pstmt.setInt(3, productDto.getPrice());
			
			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	// �긽�뭹 紐⑸줉 媛��졇�삤湲�
	@Override
	public List<ProductDto> getProductList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> products = new ArrayList<ProductDto>();
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from product \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto product = new ProductDto();
				product.setCode(rs.getString("code"));
				product.setModel(rs.getString("model"));
				product.setPrice(rs.getInt("price"));
				
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return products;
	}
	
	// 議고쉶�븷 �긽�뭹 媛��졇�삤湲�
	@Override
	public ProductDto getProduct(String code) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto product = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from product \n");
			sql.append("where code = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new ProductDto();
				product.setCode(rs.getString("code"));
				product.setModel(rs.getString("model"));
				product.setPrice(rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return product;
	}
	
	// �긽�뭹 �닔�젙
	@Override
	public int modifyProduct(ProductDto productDto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			System.out.println(productDto);
			
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update product \n");
			sql.append("set model = ?, price = ? \n");
			sql.append("where code = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getModel());
			pstmt.setInt(2, productDto.getPrice());
			pstmt.setString(3, productDto.getCode());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	// �긽�뭹 �궘�젣
	@Override
	public int deleteProduct(String code) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from product \n");
			sql.append("where code = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return cnt;
	}
}
