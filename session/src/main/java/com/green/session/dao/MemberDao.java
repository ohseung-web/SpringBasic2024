package com.green.session.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.green.session.dto.Member;

@Repository
public class MemberDao implements IMemberDao {
	
	private HashMap<String, Member> dbMap;
	public MemberDao() {
		dbMap = new HashMap<String, Member>();
	}

	@Override
	public Map<String, Member> memberInsert(Member member) {
		dbMap.put(member.getMemId(), member);
		return dbMap;
	}

	@Override
	public Member memberSelect(Member member) {
		Member mem = dbMap.get(member.getMemId()); 
		return mem;
	}

	@Override
	public Member memberUpdate(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Member> memberDelete(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

}
