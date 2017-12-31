package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.BbsVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

@Repository
public class BbsDAOImpl implements BbsDAO {
	
	@Inject
	private SqlSession sqlSession;
	

	@Override
	public void insert(BbsVO bvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("insert", bvo);
		
	}

	@Override
	public BbsVO read(Integer bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("read",bid);
	}

	@Override
	public void update(BbsVO bvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("update", bvo);
		
	}

	@Override
	public void delete(Integer bid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("delete",bid);
		
	}

	@Override
	public List<BbsVO> list() throws Exception {
		// TODO Auto-generated method stub
		List<BbsVO> list = sqlSession.selectList("list");
		return list;
	}

	@Override
	public List<BbsVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if(page <= 0){
			page = 1;
		}
		
		page = (page - 1 ) * 10;
		
		return sqlSession.selectList("listPage", page);
	}

	@Override
	public List<BbsVO> listCriteria(PageCriteria pageCria) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listCriteria", pageCria);
	}

	@Override
	public int countData(PageCriteria pageCria) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("countData", pageCria);
	}

	@Override
	public List<BbsVO> listFind(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listFind", findCriteria);
	}

	@Override
	public int findCountData(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("findCountData", findCriteria);
	}

}
