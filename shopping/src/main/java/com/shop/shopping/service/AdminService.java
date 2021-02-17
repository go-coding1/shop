package com.shop.shopping.service;

import java.util.List;

import com.shop.shopping.domain.CategoryVO;

public interface AdminService {
	
	//카테고리
	public List<CategoryVO> category() throws Exception;
}
