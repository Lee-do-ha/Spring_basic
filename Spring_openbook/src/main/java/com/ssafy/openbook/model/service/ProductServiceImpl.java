package com.ssafy.openbook.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.openbook.model.dao.ProductDao;
import com.ssafy.openbook.model.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductDao productDao;
	
	@Autowired
	private ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	// 상품 등록
	@Override
	public int registerProduct(ProductDto productDto) throws Exception {
		return productDao.registerProduct(productDto);
	}
	
	// 상품 목록 가져오기
	@Override
	public List<ProductDto> getProductList() throws Exception {
		return productDao.getProductList();
	}
	
	// 조회할 상품 가져오기
	@Override
	public ProductDto getProduct(String code) throws Exception {
		return productDao.getProduct(code);
	}
	
	// 상품 수정
	@Override
	public int modifyProduct(ProductDto productDto) throws Exception {
		return productDao.modifyProduct(productDto);
	}
	
	// 상품 삭제
	@Override
	public int deleteProduct(String code) throws Exception {
		return productDao.deleteProduct(code);
	}
}
