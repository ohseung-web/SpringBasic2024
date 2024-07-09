package com.green.session.dao;

import java.util.Map;

import com.green.session.dto.Member;

public interface IMemberDao {
   int memberInsert(Member member);
   Member memberSelect(Member member);
   int memberUpdate(Member member);
   int memberDelete(Member member);
}

