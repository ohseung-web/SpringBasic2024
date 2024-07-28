package com.green.replyboard.dao;

import java.util.List;
import java.util.Map;

import com.green.replyboard.dto.ReplyBoardDTO;

public interface ReplyBoardDAO {
       //전체 게시글 조회	
	   public List<ReplyBoardDTO> getList();
	   // 게시글 삽입
	   public void insert(ReplyBoardDTO rdto);
	   // 하나의 게시글 조회
	   public ReplyBoardDTO read(int num);
	   // 게시글 조회수 증가
	   public void readcount(int num);
	    // 게시글 페이징
	    public List<ReplyBoardDTO> pagingList(Map<String, Integer> pagingParams); 
	    // 게시글 전체 갯수 
	    public int boardCount(); 
	   
	   public void update(ReplyBoardDTO rdto);
	   public void delete(int num);
	   public void replySeqUpdate(ReplyBoardDTO parent);
	   public void replyInsert(ReplyBoardDTO rdto);
	   public void insertSelectKey(ReplyBoardDTO rdto); 
}
