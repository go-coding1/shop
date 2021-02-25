package com.shop.shopping.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.shopping.domain.CategoryVO;
import com.shop.shopping.domain.GoodsVO;
import com.shop.shopping.domain.GoodsViewVO;
import com.shop.shopping.domain.OrderListVO;
import com.shop.shopping.domain.OrderVO;
import com.shop.shopping.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;

	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return dao.category();
	}

	@Override
	public void register(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.register(vo);
	}

	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		// TODO Auto-generated method stub
		return dao.goodslist();
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.goodsView(gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.goodsModify(vo);
	}

	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		dao.goodsDelete(gdsNum);
	}

	@Override
	public List<OrderVO> orderList() throws Exception {
		// TODO Auto-generated method stub
		return dao.orderList();
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		return dao.orderView(order);
	}

	@Override
	public void delivery(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		dao.delivery(order);
	}

}
