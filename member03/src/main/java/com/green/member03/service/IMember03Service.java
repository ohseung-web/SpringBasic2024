package com.green.member03.service;

import java.util.List;

import com.green.member03.dto.Member03DTO;

public interface IMember03Service {
	public int save(Member03DTO memberDTO);
	public boolean login(Member03DTO memberDTO);
	public Member03DTO findById(Long id);
	public void delete(Long id);
	public Member03DTO findByMemberEmail(String loginEmail);
	public boolean update(Member03DTO memberDTO);
	public String emailCheck(String memberEmail);
	public List<Member03DTO> findAll();
	
}
