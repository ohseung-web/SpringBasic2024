package com.green.session.dao;

import java.util.Map;

import com.green.session.dto.Member;

public interface IMemberDao02 {
   Map<String, Member> memberInsert(Member member);
   Member memberSelect(Member member);
   Member memberUpdate(Member member);
   Map<String, Member> memberDelete(Member member);
}

