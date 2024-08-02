package com.green.replyboard.dao;

import java.util.List;
import java.util.Map;

import com.green.replyboard.dto.PageDTO;
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
	    public int boardCount(String searchType, String keyword); 
	    // 게시글 수정
	   public void update(ReplyBoardDTO rdto);
	   // 게시글 삭제 
	   public void delete(int num);
	   // 게시글 답글 업데이트
	   public void replySeqUpdate(ReplyBoardDTO parent);
	   // 게시글 삽입
	   public void replyInsert(ReplyBoardDTO rdto);
	   // 게시 댓글 삭제
	   public void replydelete(int ref);
	   public void insertSelectKey(ReplyBoardDTO rdto);
	   
	 //검색
	  public List<ReplyBoardDTO> search(String searchType, String keyword);
	// 검색 갯수
	  public int searchCount(String searchType, String keyword);
}
