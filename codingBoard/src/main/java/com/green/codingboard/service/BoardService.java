package com.green.codingboard.service;

import java.util.List;
import java.util.Map;

import com.green.codingboard.dto.BoardDTO;

public interface BoardService {
    
	 // �Խ��� ����
    public int insert(BoardDTO bdto);
    // �Խ��� ��ü��� �˻�
    public List<BoardDTO> findAll();
    // �Խ��� �Խñ� �Ѱ� �˻�
    public BoardDTO findById(Long id);
    // �Խñ� ��ȸ�� ����
    public void updateHits(Long id);
    // �Խñ� �Ѱ� ����
    public void delete(Long id);
    // �Խñ� ����
    public void update(BoardDTO bdto);
    // �Խñ� ����¡
    public List<BoardDTO> pagingList(int page);


   
}
