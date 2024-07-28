package com.green.replyboard.service;

import java.util.List;

import com.green.replyboard.dto.PageDTO;
import com.green.replyboard.dto.ReplyBoardDTO;

public interface ReplyBoardService {
	//��ü�Խñ� 
	public List<ReplyBoardDTO> getList();
	//�Խñ� ����
	public void register(ReplyBoardDTO rdto);
	//�ϳ��� �Խñ� 
	public ReplyBoardDTO get(int num);
	// �Խñ� ��ȸ�� ����
	public void readcount(int num);
	// �Խñ� ����¡ ��� ���
    public List<ReplyBoardDTO> pagingList(int page);
    // ������
    public PageDTO pagingParam(int page);
    
    public void modify(ReplyBoardDTO rdto);
	public void remove(int num);
	public void replyProcess(ReplyBoardDTO rdto);
}
