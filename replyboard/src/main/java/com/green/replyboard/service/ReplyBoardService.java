package com.green.replyboard.service;

import java.util.List;

import com.green.replyboard.dto.PageDTO;
import com.green.replyboard.dto.ReplyBoardDTO;

public interface ReplyBoardService {
	//전체게시글 
	public List<ReplyBoardDTO> getList();
	//게시글 삽입
	public void register(ReplyBoardDTO rdto);
	//하나의 게시글 
	public ReplyBoardDTO get(int num);
	// 게시글 조회수 증가
	public void readcount(int num);
	// 게시글 페이징 목록 담기
    public List<ReplyBoardDTO> pagingList(int page);
    // 페이지
    public PageDTO pagingParam(int page);
    // 게시글 수정
    public void modify(ReplyBoardDTO rdto);
    // 게시글 삭제
	public void remove(int num);
	public void repyRemove(int ref);
	// 답글 처리
	public void replyProcess(ReplyBoardDTO rdto);
}
