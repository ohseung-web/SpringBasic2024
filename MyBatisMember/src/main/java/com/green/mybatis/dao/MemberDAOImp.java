package com.green.mybatis.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.mybatis.dto.MemberDTO;

@Repository // ������ startup �� �� �� Ŭ������ �޸𸮿� �ڵ����� ��ϵ�
public class MemberDAOImp implements MemberDAO {

	// sqlSession ��ü�� �����ڰ� ���� �������� �ʰ� ���������� ������� ��
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
