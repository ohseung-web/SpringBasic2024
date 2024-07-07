package com.green.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.green.example.dto.MemberDTO;

@Repository
public class MemberDAO implements IMemberDAO {
	 //hashMap<>을 이용하여 저장할 임시테이블을 생성
     private HashMap<String, MemberDTO> db;
     public MemberDAO() {
    	 db = new HashMap<String, MemberDTO>();
     }
    // 임시로 생성한 db에 데이터 삽입한다.  
	@Override
	public Map<String, MemberDTO> memInsert(MemberDTO mdto) {
		//key:id, value:memberDTO
		db.put(mdto.getId(), mdto);
		return db;
	}
    // 임시로 생성한 db에서 데이터 선택한다. 
	@Override
	public MemberDTO memSelect(MemberDTO mdto) {
		MemberDTO mem = db.get(mdto.getId());
		return mem;
	}

}
