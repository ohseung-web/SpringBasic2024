package com.green.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.green.example.dto.MemberDTO;

@Repository
public class MemberDAO implements IMemberDAO {
	 //hashMap<>�� �̿��Ͽ� ������ �ӽ����̺��� ����
     private HashMap<String, MemberDTO> db;
     public MemberDAO() {
    	 db = new HashMap<String, MemberDTO>();
     }
    // �ӽ÷� ������ db�� ������ �����Ѵ�.  
	@Override
	public Map<String, MemberDTO> memInsert(MemberDTO mdto) {
		//key:id, value:memberDTO
		db.put(mdto.getId(), mdto);
		return db;
	}
    // �ӽ÷� ������ db���� ������ �����Ѵ�. 
	@Override
	public MemberDTO memSelect(MemberDTO mdto) {
		MemberDTO mem = db.get(mdto.getId());
		return mem;
	}

}
