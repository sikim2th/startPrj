package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.dao.BbsDAO;
import com.spring.vo.BbsVO;
import com.spring.vo.FindCriteria;
import com.spring.vo.PageCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class BbsDAOTest {
	
	@Inject
	private BbsDAO bdao;
	
	private static Logger logger= LoggerFactory.getLogger(BbsDAOTest.class);
	
//	@Test
	public void insertTest() throws Exception{
		BbsVO bvo = new BbsVO();
		bvo.setSubject("테스트 제목입니다.");
		bvo.setContent("테스트 내용입니다.");
		bvo.setWriter("홍길동");
		
		bdao.insert(bvo);
		
	}
	
//	@Test
	public void readTest() throws Exception{
		
		logger.info(bdao.read(16).toString());
	}
	
//	@Test
	public void updateTest() throws Exception{
		BbsVO bvo = new BbsVO();
		bvo.setBid(16);
		bvo.setSubject("수정된 제목입니다");
		bvo.setContent("수정된 내용입니다");
		
		bdao.update(bvo);
		
	}
	
//	@Test
	public void listTest() throws Exception{
		logger.info(bdao.list().toString());
	}
	
//	@Test
	public void listPageTest() throws Exception{
		int page = 5;
		List<BbsVO> list = bdao.listPage(page);
		
		for(BbsVO bvo : list){
			logger.info(bvo.getBid() + " : " + bvo.getSubject() );
		}
	}
	
//	@Test
	public void listCriteriaTest() throws Exception{
		
		PageCriteria pageCria = new PageCriteria();
		pageCria.setPage(3);
		pageCria.setNumPerPage(15); 
		
		List<BbsVO> list = bdao.listCriteria(pageCria);
		
		for(BbsVO bvo : list){
			logger.info(bvo.getBid() + " : " + bvo.getSubject());
		}
	}
	
	//UriComponentsBuilde를 이용하는 방법: org.srpingframework.web.util 패키지 에 있음.
//	@Test
	public void uriTest() throws Exception{
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
										.path("/bbs/read")
										.queryParam("bid", 100)
										.queryParam("numPerPage", 20)
										.build(); 
		
		logger.info("/bbs/read?bid=100&numPerPage=20");
		
		logger.info(uriComponents.toString());
	}
	
//	@Test
	public void uriTest2() throws Exception{
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
										.path("/{moduel}/{page}")
										.queryParam("bid", 100)
										.queryParam("numPerPage", 20)
										.build()
										.expand("bbs","read")
										.encode();
		
		logger.info("/bbs/read?bid=100&numPerPage=20");
		logger.info(uriComponents.toString());
		logger.info("uriComponents uri >>> " + uriComponents.toUriString());
	}
	
	@Test
	public void findTest() throws Exception{
		FindCriteria findCriteria = new FindCriteria();
		findCriteria.setPage(1);
		findCriteria.setFindType("C");
		findCriteria.setKeyword("내용");
		
		logger.info("############## 테스트 글목록 출력 ################");
		
		List<BbsVO> list = bdao.listFind(findCriteria);
		
		for(BbsVO bvo : list){
			logger.info(bvo.getBid() + " : " + bvo.getSubject());
		}
		
		logger.info("############## 테스트 countdata 출력 ################");
		
		logger.info("countdata : " + bdao.findCountData(findCriteria));
		
		
		
	}
	

}
