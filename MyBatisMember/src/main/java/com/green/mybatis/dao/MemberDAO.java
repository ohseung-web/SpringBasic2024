package com.green.mybatis.dao;

import java.util.ArrayList;

import com.green.mybatis.dto.MemberDTO;

public interface MemberDAO {
	    // DAO 는 인터페이스이다.
	
		// DAO 와 mapper 는 직접 연결된다.
		// DAO 의 메소드명이 mapper 의 id 가 된다.

		// 1. 전체 목록 가져오기
		public ArrayList<MemberDTO> selectMemberList();
		
		// 2. 삽입하기
		public void insertMember(String mId, String mName);
		// 매개변수 String mId, String mName
		// mapper   #{param1},  #{param2}
		
		// 3. 회원 정보 보기
		public MemberDTO selectBymNo(int mNo);
		
		// 4. 수정하기
		public void updateMember(String mName, int mNo);
		
		// 5. 삭제하기
		public void deleteMember(int mNo);



}
