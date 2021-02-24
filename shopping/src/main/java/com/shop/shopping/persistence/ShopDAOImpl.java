package com.shop.shopping.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shop.shopping.domain.CartListVO;
import com.shop.shopping.domain.CartVO;
import com.shop.shopping.domain.GoodsViewVO;
import com.shop.shopping.domain.OrderDetailVO;
import com.shop.shopping.domain.OrderVO;
import com.shop.shopping.domain.ReplyListVO;
import com.shop.shopping.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	@Inject
	private SqlSession sql;

	//매퍼
	private static String namespace = "com.shop.mappers.shopMapper";
	
	//카테고리별 상품 리스트 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode" , cateCode);
		map.put("cateCodeRef" , cateCodeRef);
		return sql.selectList(namespace + ".list_1", map);
	}
	
	//카테고리별 상품 리스트 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace+".list_2", cateCode);
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("com.shop.mappers.adminMapper" + ".goodsView", gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace+".registerReply", reply);
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace+".replyList", gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".deleteReply", reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".modifyReply", reply);
	}

	@Override
	public void addCart(CartVO caart) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".addCart",caart);
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace+".cartList", userId);
	}

	@Override
	public void deleteCart(CartVO cart) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace+".deleteCart", cart);
		
	}

	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
	}

	@Override
	public void orderInfo(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace+".orderInfo", order);
	}
	
	
}
