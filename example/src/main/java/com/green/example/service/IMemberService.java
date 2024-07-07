package com.green.example.service;

import com.green.example.dto.MemberDTO;

public interface IMemberService {
   void memberJoin(MemberDTO mdto);
   MemberDTO memberSerch(MemberDTO mdto);
}
