package com.green.replyboard.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.replyboard.dao.ReplyBoardDAO;
import com.green.replyboard.dto.PageDTO;
import com.green.replyboard.dto.ReplyBoardDTO;

@Service
public class ReplyBoardServiceImpl implements ReplyBoardService {

	@Autowired
	ReplyBoardDAO rdao;
	
	@Override
	public List<ReplyBoardDTO> getList() {
		return rdao.getList();
	}

	@Override
	public void register(ReplyBoardDTO rdto) {
	
		try {
			 rdao.insert(rdto);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ReplyBoardDTO get(int num) {
		return rdao.read(num);
	}

	@Override
	public void modify(ReplyBoardDTO rdto) {
		rdao.update(rdto);
		
	}

	@Override
	public void remove(int num) {
	    rdao.delete(num);
	}

	@Override
	public void replyProcess(ReplyBoardDTO rdto) {
 	//  부모글의 re_level 보다 큰 값들을 모두 1씩 업데이트하기
		rdao.replySeqUpdate(rdto);
	//  답변글 삽입시 re_step+1, re_level+1	
		rdao.replyInsert(rdto);
	}

	int pageSize = 3; // 한 페이지당 보여지는 글 갯수
	int blockSize = 3; // 하단에 보여줄 페이지 번호 갯수
	@Override
	public List<ReplyBoardDTO> pagingList(int page) {
		/*
		 * Limit 0, 3
		 * 1page => 0 1 2
		 * 2page => 3 4 5
		 * 3page => 6 7 8
		 * 
		 */		
		 int StartRow = (page-1) * pageSize;
		 int endRow = pageSize;
		 //Map을 이용하여 동시에 2개이상의 파라미터 값을 저장하여 보낼 수 있다.
		 Map<String, Integer> pagingParams = new HashMap<String, Integer>();
		 pagingParams.put("start", StartRow); //시직 페이지 수
		 pagingParams.put("end", endRow); // 종료 페이지 수
		 
		 List<ReplyBoardDTO> pagingList = rdao.pagingList(pagingParams);
		 
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		 // 전체 글 갯수 조회
        int boardCount = rdao.boardCount();
        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageSize));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockSize))) - 1) * blockSize + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = Math.min(startPage + blockSize - 1, maxPage) ; //둘 중에 작은 값을 출력한다.
         System.out.println("endPage" + (startPage + blockSize - 1));
         System.out.println("maxPage"+ maxPage);
 
        int number = boardCount - (page -1)*pageSize;
         
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartpage(startPage);
        pageDTO.setEndPage(endPage);
        pageDTO.setNumber(number);
        
        return pageDTO;
	}

	@Override
	public void readcount(int num) {
		rdao.readcount(num);
	}

	@Override
	public void repyRemove(int ref) {
		rdao.replydelete(ref);
	}

	
	
//	public void replyProcess(Board vo) {
//		// - 답글만들기
//		// 1. 부모글(원글)의 정보를 가져오기(vo->idx)
//		Board parent=boardMapper.read(vo.getIdx());
//		// 2. 부모글의 boardGroup의 값을->답글(vo)정보에 저장하기
//		vo.setBoardGroup(parent.getBoardGroup());
//		// 3. 부모글의 boardSequence의 값을 1을 더해서 ->답글(vo)정보에 저장하기
//		vo.setBoardSequence(parent.getBoardSequence()+1);
//		// 4. 부모글의 boardLevel의 값을 1을 더해서 ->답글(vo)정보에 저장하기
//        vo.setBoardLevel(parent.getBoardLevel()+1);
//        // 5. 같은 boardGroup에 있는 글 중에서
//        //    부모글의 boardSequence보다 큰 값들을 모두 1씩 업데이트하기
//		boardMapper.replySeqUpdate(parent);
//		// 6. 답글(vo)을 저정하기
//		boardMapper.replyInsert(vo);
//	}
	
	
}
