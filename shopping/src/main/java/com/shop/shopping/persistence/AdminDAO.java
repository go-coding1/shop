package com.shop.shopping.persistence;

import java.util.List;

import com.shop.shopping.domain.CategoryVO;

public interface AdminDAO {

	//카테고리
	public List<CategoryVO> category() throws Exception;
}
