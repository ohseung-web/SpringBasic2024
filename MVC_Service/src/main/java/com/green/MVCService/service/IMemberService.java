package com.green.MVCService.service;

import com.green.MVCService.member.Member;

public interface IMemberService {
	//ȸ�����
	void memberRegister(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
	//ȸ���˻�
	Member memberSearch(String memId, String memPw);
	//ȸ������ ����
	void memberModify();
	//ȸ������ ����
	void memberRemove();
}
