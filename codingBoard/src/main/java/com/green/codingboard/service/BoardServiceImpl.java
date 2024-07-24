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

	int pageSize = 3; // �� �������� �������� �� ����
	int blockSize = 3; // �ϴܿ� ������ ������ ��ȣ ����
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
		 //Map�� �̿��Ͽ� ���ÿ� 2���̻��� �Ķ���� ���� �����Ͽ� ���� �� �ִ�.
		 Map<String, Integer> pagingParams = new HashMap<String, Integer>();
		 pagingParams.put("start", StartRow); //���� ������ ��
		 pagingParams.put("end", endRow); // ���� ������ ��
		 
		 List<BoardDTO> pagingList = bdao.pagingList(pagingParams);
		 
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		
		 // ��ü �� ���� ��ȸ
        int boardCount = bdao.boardCount();
        // ��ü ������ ���� ���(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageSize));
        // ���� ������ �� ���(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockSize))) - 1) * blockSize + 1;
        // �� ������ �� ���(3, 6, 9, 12, ~~~~)
        int endPage = Math.min(startPage + blockSize - 1, maxPage) ; //�� �߿� ���� ���� ����Ѵ�.
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
