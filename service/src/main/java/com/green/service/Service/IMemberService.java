package com.green.service.Service;


import com.green.service.dto.MemberDTO;

public interface IMemberService {
//	    //ȸ�����
//		void memberRegister(String memId, String memPw, String memMail, 
//				            String memPhone1, String memPhone2, String memPhone3);
//		//ȸ���˻�
//		MemberDTO memberSearch(String memId, String memPw);
//		//ȸ������ ����
//		void memberModify();
//		//ȸ������ ����
//		void memberRemove();
		
		
		//MemberDTO �̿��Ͽ�
		void memberRegister(MemberDTO mdto);
		void memberSearch(MemberDTO mdto);
		void memberModify(MemberDTO mdto);
		void memberRemove(MemberDTO mdto);
}
