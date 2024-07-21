package com.green.board.dto;

public class PageHandler {
  private int totalCnt; //�� �Խù� ����
  private int pageSize; // �� �������� ũ��
  private int naviSize = 10; // ������ �׺���̼��� ũ��
  private int totalPage; //��ü �������� ����
  private int page; // ���� ������
  private int beginPage; // �׺���̼��� ù��° ������
  private int endPage; // �׺���̼��� ������ ������
  private  boolean showPrev; // ���� �������� �̵��ϴ� ��ũ�� �����ٰ����� ����
  private boolean showNext; // ���� �������� �̵��ϴ� ��ũ�� �����ٰ����� ����
   
   public PageHandler(int totalCnt, int page) {
	 //  this(totalCnt,page, pageSize=10);
	   this.totalCnt = 10;
	   this.page = 10;
   }
   public PageHandler(int totalCnt, int page, int pageSize) {
	   this.totalCnt = totalCnt;
	   this.page = page;
	   this.pageSize = pageSize;
	   
	   totalPage =(int)Math.ceil( totalCnt / pageSize );
	   beginPage = page / naviSize * naviSize + 1;
	   endPage = Math.min(beginPage + naviSize - 1, totalPage) ; //�� �߿� ���� ���� ����Ѵ�.
	   
	   // �������� �̵��ϴ� �������� beginPage�� 1�������� �ƴϸ� ��
	   showPrev = beginPage != 1;
	   // �������� �̵��ϴ� �������� endPage�� totalPage�� �ƴϸ� ��
	   showNext = endPage != totalPage;
   }
   
  public void print() {
	  System.out.println("page = " + page);
	  System.out.println(showPrev ? "[PREV]": "");
	  for(int i=beginPage; i<=endPage ; i++) {
		  System.out.println(i+" ");
	  }
	  System.out.println(showNext ? "[NEXT]":"");
  }
  
  public int getTotalCnt() {
	return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNaviSize() {
		return naviSize;
	}
	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isShowPrev() {
		return showPrev;
	}
	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}
	public boolean isShowNext() {
		return showNext;
	}
	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}
@Override
  public String toString() {
	  return "PageHandler{" +
              ", totalCnt=" + totalCnt +
              ", showNext=" + showNext +
              ", beginPage=" + beginPage +
              ", naviSize=" + naviSize +
              ", totalPage=" + totalPage +
              ", endPage=" + endPage +
              ", showPrev=" + showPrev +
              '}';
  }
}
