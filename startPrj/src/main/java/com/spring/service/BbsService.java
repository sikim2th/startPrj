package com.spring.service;

import java.util.List;

import com.spring.vo.BbsVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

public interface BbsService {
	
	public void write(BbsVO bvo) throws Exception;
	
	public BbsVO read(Integer bid) throws Exception;
	
	public void modify(BbsVO bvo) throws Exception;
	
	public void remove(Integer bid) throws Exception;
	
	public List<BbsVO> list() throws Exception;
	
	public List<BbsVO> listCriteria(PageCriteria pageCria) throws Exception;
	
	public int listCountData(PageCriteria pageCria) throws Exception;
	
	public List<BbsVO> listFind(FindCriteria findCriteria) throws Exception;
	
	public int findCountData(FindCriteria findCriteria) throws Exception;
	

}
