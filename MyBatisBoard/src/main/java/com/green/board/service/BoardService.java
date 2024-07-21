package com.green.board.service;

import java.util.List;
import java.util.Map;

import com.green.board.dto.BoardDTO;

public interface BoardService {
	 // �Խ��� �Խñ� ��ü ����
     int getCount() throws Exception;
     // �Խ��� ����
     int remove(Integer bno, String writer) throws Exception;
     // �Խ��� �ۼ�
     int write(BoardDTO bdto) throws Exception;
     // �Խ��� ��ü ���
     List<BoardDTO> getList() throws Exception;
     // �Խ��� ��ȣ�� �������� �Ѱ��� �Խñ� �б�
     BoardDTO read(Integer bno) throws Exception;
     // �Խ��� ����¡
     List<BoardDTO> getPage(Map map) throws Exception;
     // �Խñ� ����
     int modity(BoardDTO bdto) throws Exception;
     
    
}
