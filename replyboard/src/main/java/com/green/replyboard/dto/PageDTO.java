package com.green.replyboard.dto;

public class PageDTO {
	private int page; // 현재 페이지
	private int maxPage; // 전체 필요한 페이지 갯수
	private int startpage; //현재 페이지 기준 시작 페이지 값
	private int endPage; // 현재 페이지 기준 마지막 페이지 값
	private int number;
	
	// 검색기능시 필요한 변수
	private String searchType;
	private String keyword;
	
	public PageDTO() {}
	public PageDTO(String searchType, String keyword) {
		this.searchType = searchType;
		this.keyword = keyword;
	}
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
