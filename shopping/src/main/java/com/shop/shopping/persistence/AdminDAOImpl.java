package com.shop.shopping.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shop.shopping.domain.CategoryVO;
import com.shop.shopping.domain.GoodsVO;
import com.shop.shopping.domain.GoodsViewVO;
import com.shop.shopping.domain.OrderListVO;
import com.shop.shopping.domain.OrderVO;

@Repository	
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.shop.mappers.adminMapper";

	@Override
	public List<CategoryVO> category() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".category");
	}

	@Override
	public void register(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace+".register",vo);
	}

	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".goodslist");
	}

	//상품 조회 + 카테고리 조인
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".goodsModify",vo);
	}

	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace +".goodsDelete",gdsNum);
	}

	@Override
	public List<OrderVO> orderList() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".orderList" );
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".orderView", order);
	}

	@Override
	public void delivery(OrderVO order) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".delivery", order);
	}

}
