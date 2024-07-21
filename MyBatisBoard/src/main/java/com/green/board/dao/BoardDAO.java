package com.green.board.dao;

import java.util.List;
import java.util.Map;

import com.green.board.dto.BoardDTO;

public interface BoardDAO {
	// service 클래스에 Exception을 던저 주어야 하기때문에 throws Exception을 작성한다.
    // 게시판 한개의 글 검색  
	BoardDTO select(Integer bno) throws Exception;
	// 게시판 번호를 기준으로 삭제
	int delete(Integer bno, String writer) throws Exception ;
	// 게시판 삽입
	int insert(BoardDTO bdto) throws Exception;
	// 게시판 수정
	int update(BoardDTO bdto) throws Exception;
	// 게시판 번호를 기준으로 조회수 증가
	int increaseViewCnt(Integer bno) throws Exception;
	// 게시판 전체목록 검색
	List<BoardDTO> selectAll() throws Exception;
	// 게시판 전체 삭제
    int deleteAll() throws Exception;
    // 게시판 게시글 전체 갯수 
    int count() throws Exception;
    // 게시판 페이징
    List<BoardDTO> selectPage(Map map) throws Exception;
}
