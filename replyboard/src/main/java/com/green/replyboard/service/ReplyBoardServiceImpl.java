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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyProcess(ReplyBoardDTO rdto) {
		// TODO Auto-generated method stub
		
	}

	int pageSize = 3; // �� �������� �������� �� ����
	int blockSize = 3; // �ϴܿ� ������ ������ ��ȣ ����
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
		 //Map�� �̿��Ͽ� ���ÿ� 2���̻��� �Ķ���� ���� �����Ͽ� ���� �� �ִ�.
		 Map<String, Integer> pagingParams = new HashMap<String, Integer>();
		 pagingParams.put("start", StartRow); //���� ������ ��
		 pagingParams.put("end", endRow); // ���� ������ ��
		 
		 List<ReplyBoardDTO> pagingList = rdao.pagingList(pagingParams);
		 
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		 // ��ü �� ���� ��ȸ
        int boardCount = rdao.boardCount();
        // ��ü ������ ���� ���(10/3=3.33333 => 4)
        int maxPage = (int) (Math.ceil((double) boardCount / pageSize));
        // ���� ������ �� ���(1, 4, 7, 10, ~~~~)
        int startPage = (((int)(Math.ceil((double) page / blockSize))) - 1) * blockSize + 1;
        // �� ������ �� ���(3, 6, 9, 12, ~~~~)
        int endPage = Math.min(startPage + blockSize - 1, maxPage) ; //�� �߿� ���� ���� ����Ѵ�.
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

}
