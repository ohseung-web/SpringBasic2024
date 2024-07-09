package com.green.session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.session.dao.MemberDao;
import com.green.session.dto.Member;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(Member member) {
		int result = dao.memberInsert(member);
		
		if(result == 0) { //insert 실패
			System.out.println("join fali!!");
		}else { //insert 성공
			System.out.println("join sucess!!");
		}
	}

	@Override
	public Member memberSearch(Member member) {
		Member mem = dao.memberSelect(member);
		
		if(mem == null) {
			System.out.println("Login Fail!! ");
		}else {
			System.out.println("Login sucess!!");
		}
		
		return mem;
	}

	@Override
	public Member memberModify(Member member) {
        
		int result = dao.memberUpdate(member);
		
		if(result == 0 ) {
			System.out.println("Modify Fail!!");
			return null;
		} else {
			System.out.println("Modify Success!!");
		}
		return member;
	}

	@Override
	public int memberRemove(Member member) {
        
		int result = dao.memberDelete(member);
		
		if(result == 0 ) {
			System.out.println("Remove Fail!!");
		} else {
			System.out.println("Remove Success!!");
		}
		
		return result;
		
	}
    
}
