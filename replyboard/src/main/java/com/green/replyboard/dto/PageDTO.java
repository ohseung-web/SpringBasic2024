package com.green.replyboard.dto;

public class PageDTO {
	private int page; // ���� ������
	private int maxPage; // ��ü �ʿ��� ������ ����
	private int startpage; //���� ������ ���� ���� ������ ��
	private int endPage; // ���� ������ ���� ������ ������ ��
	private int number;
	
	// �˻���ɽ� �ʿ��� ����
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
