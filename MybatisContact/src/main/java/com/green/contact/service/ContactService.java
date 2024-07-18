package com.green.contact.service;

import java.util.List;

import com.green.contact.dto.ContactDTO;

public interface ContactService {
    
	public int insert(ContactDTO cdto);
	public ContactDTO selectContactBycNo(int cNo);
	public void delete(int cNo);
	public boolean update(ContactDTO cdto);
	public List<ContactDTO> findAll();
}
