package com.shop.shopping.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shop.shopping.domain.CartListVO;
import com.shop.shopping.domain.CartVO;
import com.shop.shopping.domain.GoodsViewVO;
import com.shop.shopping.domain.OrderDetailVO;
import com.shop.shopping.domain.OrderVO;
import com.shop.shopping.domain.ReplyListVO;
import com.shop.shopping.domain.ReplyVO;
import com.shop.shopping.persistence.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {

	@Inject
	private ShopDAO dao;
	
	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		// TODO Auto-generated method stub
		
		int cateCodeRef=0;
		if(level == 1) {	//1차 분류
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		}else {
			return dao.list(cateCode);
		}
	}

	//상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.goodsView(gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		dao.registReply(reply);
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyList(gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteReply(reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.idCheck(repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		dao.modifyReply(reply);
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		// TODO Auto-generated method stub
		dao.addCart(cart);
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		// TODO Auto-generated method stub
		return dao.cartList(userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteCart(cart);
	}

	@Override
	public void orderInfo(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		dao.orderInfo(order);
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		// TODO Auto-generated method stub
		dao.orderInfo_Details(orderDetail);
	}

	@Override
	public void cartAllDelete(String userId) throws Exception {
		// TODO Auto-generated method stub
		dao.cartAllDelete(userId);
	}

}
