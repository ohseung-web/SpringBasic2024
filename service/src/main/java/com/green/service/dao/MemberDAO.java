package com.green.service.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.green.service.dto.MemberDTO;


//@Repository 어노테이션은 @Service 어노테이션과 같은 역활을 한다.
// @Repository 어노테이션을 이용하여 서비스 객체 생성 및 의존객체 자동주입을 할 수 있다.

@Repository 
public class MemberDAO implements IMemberDAO {
	
	private HashMap<String, MemberDTO> dbMap;
	
	public MemberDAO() {
		dbMap = new HashMap<String, MemberDTO>();
	}

	//@Override
//	public void memberInsert(String memId, String memPw, String memMail, 
//			   String memPhone1, String memPhone2, String memPhone3) {
//		System.out.println("memberInsert()");
//		System.out.println("memId : " + memId);
//		System.out.println("memPw : " + memPw);
//		System.out.println("memMail : " + memMail);
//		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);
//		
//		MemberDTO mdto = new MemberDTO();
//		mdto.setMemId(memId);
//		mdto.setMemPw(memPw);
//		mdto.setMemMail(memMail);
//		mdto.setMemPhone1(memPhone1);
//		mdto.setMemPhone2(memPhone2);
//		mdto.setMemPhone3(memPhone3);
//		
//		//dbMap에 입력된 memId을 저장한다.
//		 dbMap.put(memId, mdto);
//		 
//		for(String key : dbMap.keySet()) {
//			MemberDTO value = dbMap.get(key);
//			System.out.print("memberId:" + value.getMemId() + "\t");
//			System.out.print("|memberPw:" + value.getMemPw() + "\t");
//			System.out.print("|memberMail:" + value.getMemMail() + "\t");
//			System.out.print("|memberPhone:" + value.getMemPhone1() + " - " + 
//					                           value.getMemPhone2() + " - " + 
//					                           value.getMemPhone3() + "\n");
//		}
//		
//		
//		
////		Set<String> keys = dbMap.keySet();
////		Iterator<String> iterator = keys.iterator();
////		
////		while (iterator.hasNext()) {
////			String key = iterator.next();
////			Member mem = dbMap.get(key);
////			System.out.print("memberId:" + mem.getMemId() + "\t");
////			System.out.print("|memberPw:" + mem.getMemPw() + "\t");
////			System.out.print("|memberMail:" + mem.getMemMail() + "\t");
////			System.out.print("|memberPhone:" + mem.getMemPhone1() + " - " + 
////											   mem.getMemPhone2() + " - " + 
////											   mem.getMemPhone3() + "\n");
////		}
//		
//	}

//	@Override
//	public MemberDTO memberSelect(String memId, String memPw) {
//		MemberDTO mdto = dbMap.get(memId);
//		return mdto;
//	}

//	@Override
//	public void memberUpdate() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void memberDelete() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public Map<String, MemberDTO> memberInsert(MemberDTO mdto) {
		dbMap.put(mdto.getMemId(), mdto);
		return dbMap;
	}

	@Override
	public MemberDTO memberSelect(MemberDTO mdto) {
		MemberDTO mem = dbMap.get(mdto.getMemId());
		return mem;
	}

	@Override
	public MemberDTO memberUpdate(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, MemberDTO> memberDelete(MemberDTO mdto) {
		// TODO Auto-generated method stub
		return null;
	}

}
