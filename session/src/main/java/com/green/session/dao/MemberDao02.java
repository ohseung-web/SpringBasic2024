package com.green.session.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.green.session.dto.Member;

@Repository
public class MemberDao02 implements IMemberDao02 {
	

	private HashMap<String, Member> dbMap;
	public MemberDao02() {
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
