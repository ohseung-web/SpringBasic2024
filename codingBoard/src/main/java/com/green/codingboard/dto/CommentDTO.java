package com.green.codingboard.dto;

import java.sql.Timestamp;

public class CommentDTO {
   private long id; //��۹�ȣ
   private String commentWriter; //�ۼ���
   private String commentContents; //����
   private long boardId; // �Խñ��� id��ȣ
   private Timestamp commentCreateTeime;//����ۼ� �ð�

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
