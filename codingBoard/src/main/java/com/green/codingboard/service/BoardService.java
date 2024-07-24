package com.green.codingboard.service;

import java.util.List;
import java.util.Map;

import com.green.codingboard.dto.BoardDTO;
import com.green.codingboard.dto.PageDTO;

public interface BoardService {
    
	 // 게시판 삽입
    public int insert(BoardDTO bdto);
    // 게시판 전체목록 검색
    public List<BoardDTO> findAll();
    // 게시판 게시글 한개 검색
    public BoardDTO findById(Long id);
    // 게시글 조회수 증가
    public void updateHits(Long id);
    // 게시글 한개 삭제
    public void delete(Long id);
    // 게시글 수정
    public void update(BoardDTO bdto);
    // 게시글 페이징 목록 담기
    public List<BoardDTO> pagingList(int page);
    // 페이지
    public PageDTO pagingParam(int page);
     
   
}
