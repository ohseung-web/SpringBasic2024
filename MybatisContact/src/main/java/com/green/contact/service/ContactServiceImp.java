package com.green.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.contact.dao.ContactDAOImp;
import com.green.contact.dto.ContactDTO;

@Service
public class ContactServiceImp implements ContactService{

	@Autowired
	ContactDAOImp cdao;
	
	//테이블에 insert하기
	@Override
	public int insert(ContactDTO cdto) {
		return cdao.contactInsert(cdto);
	}

	@Override
	public ContactDTO selectContactBycNo(int cNo) {
		return cdao.selectContactBycNo(cNo);
	}

	@Override
	public void delete(int cNo) {
		cdao.contactDelete(cNo);
	}

	@Override
	public boolean update(ContactDTO cdto) {
		int result = cdao.contactUpdate(cdto);
		System.out.println("업데이트"+ result);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<ContactDTO> findAll() {
		return cdao.selectContactList();
	}

}
