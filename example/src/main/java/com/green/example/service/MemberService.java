package com.green.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.example.dao.MemberDAO;
import com.green.example.dto.MemberDTO;

@Service
public class MemberService implements IMemberService{

	@Autowired
	MemberDAO mdao;
	
	@Override
	public void memberJoin(MemberDTO mdto) {
		// mdao.memInsert()에 입력한 데이터 저장
		mdao.memInsert(mdto);
	}

	@Override
	public MemberDTO memberSerch(MemberDTO mdto) {
		// mdao.memSelect( )에서 id를 기준으로 데이터를 검색
		MemberDTO mem = mdao.memSelect(mdto);
		return mem;
	}

}
