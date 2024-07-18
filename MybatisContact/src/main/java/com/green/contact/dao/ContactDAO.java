package com.green.contact.dao;

import java.util.List;

import com.green.contact.dto.ContactDTO;

public interface ContactDAO {
	
	public List<ContactDTO> selectContactList();
	public ContactDTO selectContactBycNo(int cNo);
	public int contactInsert(ContactDTO cdto);
	public void contactDelete(int cNo);
	public int contactUpdate(ContactDTO cdto);
}
