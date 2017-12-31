package com.spring.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingMaker {
	
	private int totalData; //전체 데이터 갯수 
	private int startPage; //페이지목록의 시작번호
	private int endPage; //페이지목록의 끝번
	private boolean prev; //이전 버튼을 나타내는 부울 값 
	private boolean next; //다음 버튼을 나태내는 부울 
	
	private int displayPageNum = 10; //페이지 목록에 나타낼 페이지 수 
	
	private PageCriteria pageCriteria;

	public int getTotalData() {
		return totalData;
	}

	public void setTotalData(int totalData) {
		this.totalData = totalData;
		
		this.getPagingData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public PageCriteria getPageCriteria() {
		return pageCriteria;
	}

	public void setPageCriteria(PageCriteria pageCriteria) {
		this.pageCriteria = pageCriteria;
	}

	public void getPagingData(){
		//(Math.ceil(현재페이번호 / 페이지 목록에 나타낼 페이지 수 ) * 페이지 목록에 나타낼 페이지 수 
		endPage = (int) Math.ceil(pageCriteria.getPage() / (double) displayPageNum) * displayPageNum;
		
		//(endPage - 페이지 목록에 나타낼 페이지 수 ) + 1
		startPage = (endPage - displayPageNum) + 1;
		
		/*
		finalEndPage = Math.ceil(totalData / 한페이지당 보여줄 글의 수)
		if(endPage > finalEndPage){
			endPage = finalEndPage;
		}
		*/
		
		int finalEndPage = (int) Math.ceil(totalData / (double) pageCriteria.getNumPerPage());
		if(endPage > finalEndPage){
			endPage = finalEndPage; 
		}
		
		/*
		prev = start == 1 ? false : true;
		next = endPage * 한페이지당 보여줄 글의 수 > totalData ? false : true;
		 */
		prev = startPage == 1 ? false : true;
		next = endPage * pageCriteria.getNumPerPage() > totalData ? false : true;
	}
	
	public String makeUri(int page){
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
										.queryParam("page", page)
										.queryParam("numPerPage", this.getPageCriteria().getNumPerPage())
										.build();
		
		return uriComponents.toUriString();
	}
	
	public String makeFind(int page){
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
										.queryParam("page", page)
										.queryParam("numPerPage", this.getPageCriteria().getNumPerPage())
										.queryParam("findType", ((FindCriteria)pageCriteria).getFindType())
										.queryParam("keyword", ((FindCriteria)pageCriteria).getKeyword())
										.build();
		
		return uriComponents.toUriString();
	}
	

}
