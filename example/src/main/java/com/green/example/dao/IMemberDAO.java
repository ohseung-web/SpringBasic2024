package com.green.example.dao;

import java.util.Map;

import com.green.example.dto.MemberDTO;

public interface IMemberDAO {
   Map<String, MemberDTO> memInsert(MemberDTO mdto);
   MemberDTO memSelect(MemberDTO mdto);
}
