package com.green.session.service;

import com.green.session.dto.Member;

public interface IMemberService02 {
  void memberRegister(Member member);
  Member memberSearch(Member member);
  Member memberModify(Member member);
  void memberRemove(Member member);
  
}
