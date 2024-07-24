package com.green.codingboard.dto;

import java.sql.Timestamp;

public class CommentDTO {
   private long id; //댓글번호
   private String commentWriter; //작성자
   private String commentContents; //내용
   private long boardId; // 게시글의 id번호
   private Timestamp commentCreateTeime;//댓글작성 시간

   public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public Timestamp getCommentCreateTeime() {
		return commentCreateTeime;
	}
	public void setCommentCreateTeime(Timestamp commentCreateTeime) {
		this.commentCreateTeime = commentCreateTeime;
	}
	   
   
   
   
}
