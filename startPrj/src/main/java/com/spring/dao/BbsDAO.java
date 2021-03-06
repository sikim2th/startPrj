package com.spring.dao;

import java.util.List;

import com.spring.vo.BbsVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

public interface BbsDAO {
	
	public void insert(BbsVO bvo) throws Exception;
	public BbsVO read(Integer bid) throws Exception;
	public void update(BbsVO bvo) throws Exception;
	public void delete(Integer bid) throws Exception;
	public List<BbsVO> list() throws Exception;
	public List<BbsVO> listPage(int page) throws Exception;
	public List<BbsVO> listCriteria(PageCriteria pageCria) throws Exception;
	public int countData(PageCriteria pageCria) throws Exception;
	
	public List<BbsVO> listFind(FindCriteria findCriteria) throws Exception;
	public int findCountData(FindCriteria findCriteria) throws Exception;
	

}
