package com.ssafy.openbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.openbook.model.dto.ProductDto;
import com.ssafy.openbook.model.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService; 
	
	@Autowired
	private ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/view")
	public String view(String code, Model model) {
		try {
			ProductDto product = productService.getProduct(code);
			if(product == null) {
				// 해당 상품이 없는 경우
				return "/error/error";
			} else {
				model.addAttribute("product", product);
				return "/product/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "/product/register";
	}
	
	@PostMapping("/register")
	public String register(ProductDto productDto, Model model) {
		try {
			if(productService.registerProduct(productDto) == 0) {
				// 등록에서 에러 발생
				return "/error/error";
			} else {
				model.addAttribute("code", productDto.getCode());
				return "redirect:/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		try {
			model.addAttribute("products", productService.getProductList());
			return "/product/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
	
	
	@GetMapping("/modify")
	public String modify(String code, Model model) {
		try {
			ProductDto product = productService.getProduct(code);
			model.addAttribute("product", product);
			return "/product/modify";
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
	@PostMapping("/modify")
	public String modify(ProductDto productDto, Model model) {
		try {
			if(productService.modifyProduct(productDto) == 0) {
				// 수정에서 에러 발생
				return "/error/error";
			} else {
				model.addAttribute("code", productDto.getCode());
				return "redirect:/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
	@GetMapping("/delete")
	public String delete(String code) {
		try {
			if(productService.deleteProduct(code) == 0) {
				// 삭제에서 에러 발생
				return "/error/error";
			} else {
				return "redirect:/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/error/error";
		}
	}
	
}
