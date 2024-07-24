package com.green.codingboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.codingboard.dao.BoardDAOImpl;
import com.green.codingboard.dto.BoardDTO;
import com.green.codingboard.dto.PageDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAOImpl bdao;
	
	@Override
	public int insert(BoardDTO bdto) {
		return bdao.insert(bdto);
	}

	@Override
	public List<BoardDTO> findAll() {
		return bdao.findAll();
	}

	@Override
	public BoardDTO findById(Long id) {
		return bdao.findById(id);
	}

	@Override
	public void updateHits(Long id) {
		bdao.updateHits(id);
	}

	@Override
	public void delete(Long id) {
		bdao.delete(id);
		
	}

	@Override
	public void update(BoardDTO bdto) {
		bdao.update(bdto);
	}

	int pageSize = 3; // 한 페이지당 보여지는 글 갯수
	int blockSize = 3; // 하단에 보여줄 페이지 번호 갯수
	@Override
	public List<BoardDTO> pagingList(int page) {
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
		 
		 List<BoardDTO> pagingList = bdao.pagingList(pagingParams);
		 
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		
		 // 전체 글 갯수 조회
        int boardCount = bdao.boardCount();
        // 전체 페이지 갯수 계산(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageSize));
        // 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockSize))) - 1) * blockSize + 1;
        // 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
        int endPage = Math.min(startPage + blockSize - 1, maxPage) ; //둘 중에 작은 값을 출력한다.
         System.out.println("endPage" + (startPage + blockSize - 1));
         System.out.println("maxPage"+ maxPage);
       // int endPage = startPage + blockSize - 1;  
//        if (endPage > maxPage) {
//            endPage = maxPage;
//        }
 
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartpage(startPage);
        pageDTO.setEndPage(endPage);
        
        return pageDTO;
		
	}
	
}
