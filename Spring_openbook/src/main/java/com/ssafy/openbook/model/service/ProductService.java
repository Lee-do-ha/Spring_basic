package com.ssafy.openbook.model.service;

import java.util.List;

import com.ssafy.openbook.model.dto.ProductDto;

public interface ProductService {
	
	// 상품 등록
	int registerProduct(ProductDto productDto) throws Exception;
	// 상품 목록 가져오기
	List<ProductDto> getProductList() throws Exception;
	// 조회할 상품 가져오기
	ProductDto getProduct(String code) throws Exception;
	// 상품 수정
	int modifyProduct(ProductDto productDto) throws Exception;
	// 상품 삭제
	int deleteProduct(String code) throws Exception;
}
