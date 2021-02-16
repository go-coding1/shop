package com.shop.shopping.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shop.shopping.domain.MemberVO;

@Repository	
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sql;

	//매퍼
	private static String namespace = "com.shop.mappers.memberMapper";
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".signup",vo);
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".signin", vo);
	}	

}
