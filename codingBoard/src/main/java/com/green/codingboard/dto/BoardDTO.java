package com.green.codingboard.dto;

import java.sql.Timestamp;

public class BoardDTO {
   private long id;
   private String boardWriter;
   private String boardPass;
   private String boardTitle;
   private String boardContents;
   private int boardHits;
   private Timestamp boardCreatedTime;
   
   public BoardDTO() {}
   public BoardDTO(long id, String boardWriter, String boardPass,
		   String boardTitle, String boardContents, int boardHits, Timestamp boardCreatedTime) {
	   
	   this.id = id;
	   this.boardWriter = boardWriter;
	   this.boardPass = boardPass;
	   this.boardTitle = boardTitle;
	   this.boardContents = boardContents;
	   this.boardHits = boardHits; //조회수
	   this.boardCreatedTime = boardCreatedTime; //등록일
	   
   }

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getBoardWriter() {
		return boardWriter;
	}
	
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public String getBoardPass() {
		return boardPass;
	}
	
	public void setBoardPass(String boardPass) {
		this.boardPass = boardPass;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public String getBoardContents() {
		return boardContents;
	}
	
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	
	public int getBoardHits() {
		return boardHits;
	}
	
	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}
	
	public Timestamp getBoardCreatedTime() {
		return boardCreatedTime;
	}
	
	public void setBoardCreatedTime(Timestamp boardCreatedTime) {
		this.boardCreatedTime = boardCreatedTime;
	}
	   
}
