package com.green.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.service.dao.MemberDAO;
import com.green.service.dto.MemberDTO;

@Service //Service 객체로 스프링 컨테이너에 담긴다.
public class MemberService implements IMemberService {
   
	@Autowired
	MemberDAO mdao;

	@Override
	public void memberRegister(MemberDTO mdto) {
		mdao.memberInsert(mdto);
	}

	@Override
	public void memberSearch(MemberDTO mdto) {
		mdao.memberSelect(mdto);
	}

	@Override
	public void memberModify(MemberDTO mdto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void memberRemove(MemberDTO mdto) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void memberRegister(String memId, String memPw, String memMail, 
//			                   String memPhone1, String memPhone2,
//			                   String memPhone3) {
//		System.out.println("memberRegister()");
//		System.out.println("memId : " + memId);
//		System.out.println("memPw : " + memPw);
//		System.out.println("memMail : " + memMail);
//		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);
//		
//		mdao.memberInsert(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
//		
//	}
//
//	@Override
//	public MemberDTO memberSearch(String memId, String memPw) {
//		System.out.println("memberSearch()");
//		System.out.println("memId : " + memId);
//		System.out.println("memPw : " + memPw);
//		
//		MemberDTO mdto = mdao.memberSelect(memId, memPw);
//		return mdto;
//	}
//
//	@Override
//	public void memberModify() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void memberRemove() {
//		// TODO Auto-generated method stub
//		
//	}
//

}
