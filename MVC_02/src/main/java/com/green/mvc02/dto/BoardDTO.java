package com.green.mvc02.dto;

public class BoardDTO {
   //filed
	private String title;
	private String content;
	private int hit;
	
	//»ý¼ºÀÚ
	public BoardDTO() {}
	public BoardDTO(String title,String content,int hit) {
		this.title = title;
		this.content = content;
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
