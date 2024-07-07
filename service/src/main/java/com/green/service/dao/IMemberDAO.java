package com.green.service.dao;

import java.util.Map;

import com.green.service.dto.MemberDTO;

public interface IMemberDAO {

   //데이터 추가
  // Map<String, MemberDTO> memberInsert(MemberDTO mdto);
//   void memberInsert(String memId, String memPw, String memMail, 
//		   String memPhone1, String memPhone2, String memPhone3);
//   //데이터 검색
//   MemberDTO memberSelect(String memId, String memPw);
//   //데이터 수정
//   void memberUpdate();
//   //데이터 삭제
//   void memberDelete();
   
   
   Map<String, MemberDTO> memberInsert(MemberDTO mdto);
   MemberDTO memberSelect(MemberDTO mdto);
   MemberDTO memberUpdate(MemberDTO mdto);
   Map<String, MemberDTO> memberDelete(MemberDTO mdto);
   
}


