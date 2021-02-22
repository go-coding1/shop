package com.shop.shopping.service;

import java.util.List;

import com.shop.shopping.domain.GoodsViewVO;

public interface ShopService {

	//카테고리별 상품 리스트
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
}
