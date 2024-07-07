package com.green.MVCService.dao;

import com.green.MVCService.member.Member;

public interface IMemberDAO {
   // 데이터 삽입	
   void memberInsert(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
   // 데이터 조회
   Member memberSelect(String memId, String memPw);
   // 데이터 수정
   void memberUpdate();
   // 데이터 삭제
   void memberDelete();
}
