package com.green.member03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.member03.dao.Member03DAO;
import com.green.member03.dto.Member03DTO;

@Service
public class Member03service implements IMember03Service{
   
	@Autowired
	Member03DAO memdao;
	
	 public int save(Member03DTO memberDTO) {
	        return memdao.save(memberDTO);
	    }
	 
	 public boolean login(Member03DTO memberDTO) {
	        Member03DTO loginMember = memdao.login(memberDTO);
	        if (loginMember != null) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	 
	 public Member03DTO findById(Long id) {
	        return memdao.findById(id);
	    }

	    public void delete(Long id) {
	    	memdao.delete(id);
	    }

	    public Member03DTO findByMemberEmail(String loginEmail) {
	        return memdao.findByMemberEmail(loginEmail);
	    }

	    public boolean update(Member03DTO memberDTO) {
	        int result = memdao.update(memberDTO);
	        if (result > 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public String emailCheck(String memberEmail) {
	        Member03DTO memberDTO = memdao.findByMemberEmail(memberEmail);
	        if (memberDTO == null) {
	            return "ok";
	        } else {
	            return "no";
	        }
	    }

		public List<Member03DTO> findAll() {
			return memdao.findAll();
		}
}
