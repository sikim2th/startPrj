package com.spring.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CertifiDAOImpl implements CertifiDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void deleteTempKey(String phone) {
		sqlSession.delete("deleteTempKey",phone);

	}

	@Override
	public void insertCertificationKey(Map<Object, Object> param) {
		// TODO Auto-generated method stub
		sqlSession.insert("insertCertificationKey", param);

	}

	@Override
	public String getTempKey(String phone) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getTempKey",phone);
	}

}
