package com.green.replyboard.dao;

import java.util.List;
import java.util.Map;

import com.green.replyboard.dto.ReplyBoardDTO;

public interface ReplyBoardDAO {
       //��ü �Խñ� ��ȸ	
	   public List<ReplyBoardDTO> getList();
	   // �Խñ� ����
	   public void insert(ReplyBoardDTO rdto);
	   // �ϳ��� �Խñ� ��ȸ
	   public ReplyBoardDTO read(int num);
	   // �Խñ� ��ȸ�� ����
	   public void readcount(int num);
	    // �Խñ� ����¡
	    public List<ReplyBoardDTO> pagingList(Map<String, Integer> pagingParams); 
	    // �Խñ� ��ü ���� 
	    public int boardCount(); 
	    // �Խñ� ����
	   public void update(ReplyBoardDTO rdto);
	   // �Խñ� ���� 
	   public void delete(int num);
	   // �Խñ� ��� ������Ʈ
	   public void replySeqUpdate(ReplyBoardDTO parent);
	   // �Խñ� ����
	   public void replyInsert(ReplyBoardDTO rdto);
	   // �Խ� ��� ����
	   public void replydelete(int ref);
	   public void insertSelectKey(ReplyBoardDTO rdto); 
}
