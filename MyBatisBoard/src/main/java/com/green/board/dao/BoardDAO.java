package com.green.board.dao;

import java.util.List;
import java.util.Map;

import com.green.board.dto.BoardDTO;

public interface BoardDAO {
	// service Ŭ������ Exception�� ���� �־�� �ϱ⶧���� throws Exception�� �ۼ��Ѵ�.
    // �Խ��� �Ѱ��� �� �˻�  
	BoardDTO select(Integer bno) throws Exception;
	// �Խ��� ��ȣ�� �������� ����
	int delete(Integer bno, String writer) throws Exception ;
	// �Խ��� ����
	int insert(BoardDTO bdto) throws Exception;
	// �Խ��� ����
	int update(BoardDTO bdto) throws Exception;
	// �Խ��� ��ȣ�� �������� ��ȸ�� ����
	int increaseViewCnt(Integer bno) throws Exception;
	// �Խ��� ��ü��� �˻�
	List<BoardDTO> selectAll() throws Exception;
	// �Խ��� ��ü ����
    int deleteAll() throws Exception;
    // �Խ��� �Խñ� ��ü ���� 
    int count() throws Exception;
    // �Խ��� ����¡
    List<BoardDTO> selectPage(Map map) throws Exception;
}
