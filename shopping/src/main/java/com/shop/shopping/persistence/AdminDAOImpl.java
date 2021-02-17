package com.shop.shopping.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shop.shopping.domain.CategoryVO;

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

}
