package com.green.board.service;

import java.util.List;
import java.util.Map;

import com.green.board.dto.BoardDTO;

public interface BoardService {
	 // 게시판 게시글 전체 갯수
     int getCount() throws Exception;
     // 게시판 삭제
     int remove(Integer bno, String writer) throws Exception;
     // 게시판 작성
     int write(BoardDTO bdto) throws Exception;
     // 게시판 전체 목록
     List<BoardDTO> getList() throws Exception;
     // 게시판 번호를 기준으로 한개의 게시글 읽기
     BoardDTO read(Integer bno) throws Exception;
     // 게시판 페이징
     List<BoardDTO> getPage(Map map) throws Exception;
     // 게시글 수정
     int modity(BoardDTO bdto) throws Exception;
     
    
}
