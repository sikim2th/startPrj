package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.BbsDAO;
import com.spring.vo.BbsVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Inject
	private BbsDAO bdao;

	@Override
	public void write(BbsVO bvo) throws Exception {
		// TODO Auto-generated method stub
		bdao.insert(bvo);

	}

	@Override
	public BbsVO read(Integer bid) throws Exception {
		// TODO Auto-generated method stub
		return bdao.read(bid);
	}

	@Override
	public void modify(BbsVO bvo) throws Exception {
		// TODO Auto-generated method stub
		bdao.update(bvo);

	}

	@Override
	public void remove(Integer bid) throws Exception {
		// TODO Auto-generated method stub
		bdao.delete(bid);

	}

	@Override
	public List<BbsVO> list() throws Exception {
		// TODO Auto-generated method stub
		return bdao.list();
	}

	@Override
	public List<BbsVO> listCriteria(PageCriteria pageCria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.listCriteria(pageCria);
	}

	@Override
	public int listCountData(PageCriteria pageCria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.countData(pageCria);
	}

	@Override
	public List<BbsVO> listFind(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.listFind(findCriteria);
	}

	@Override
	public int findCountData(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return bdao.findCountData(findCriteria);
	}

}
