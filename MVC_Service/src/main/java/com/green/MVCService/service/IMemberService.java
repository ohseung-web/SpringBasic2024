package com.green.MVCService.service;

import com.green.MVCService.member.Member;

public interface IMemberService {
	//회원등록
	void memberRegister(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
	//회원검색
	Member memberSearch(String memId, String memPw);
	//회원정보 수정
	void memberModify();
	//회원정보 삭제
	void memberRemove();
}
