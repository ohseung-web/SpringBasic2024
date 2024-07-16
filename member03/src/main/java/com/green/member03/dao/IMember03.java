package com.green.member03.dao;

import java.util.List;

import com.green.member03.dto.Member03DTO;

public interface IMember03 {
  
	public int save(Member03DTO memberDTO);
	public Member03DTO login(Member03DTO memberDTO);
	public List<Member03DTO> findAll();
	public Member03DTO findById(Long id);
	public void delete(Long id);
	public Member03DTO findByMemberEmail(String loginEmail);
	public int update(Member03DTO memberDTO);
	
}
