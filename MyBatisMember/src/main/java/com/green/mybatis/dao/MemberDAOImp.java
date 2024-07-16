package com.green.mybatis.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.mybatis.dto.MemberDTO;

@Repository // 서버가 startup 될 때 이 클래스가 메모리에 자동으로 등록됨
public class MemberDAOImp implements MemberDAO {

	// sqlSession 객체를 개발자가 직접 생성하지 않고 스프링에서 연결시켜 줌
	@Autowired 
	private SqlSession session;
	
	@Override
	public ArrayList<MemberDTO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(String mId, String mName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO selectBymNo(int mNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(String mName, int mNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(int mNo) {
		// TODO Auto-generated method stub
		
	}

}
