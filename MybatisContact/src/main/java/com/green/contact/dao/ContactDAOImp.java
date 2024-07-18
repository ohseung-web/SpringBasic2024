package com.green.contact.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.contact.dto.ContactDTO;

@Repository
public class ContactDAOImp implements ContactDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	@Override
	public List<ContactDTO> selectContactList() {
		return sql.selectList("Contact.findAll");
	}

	@Override
	public ContactDTO selectContactBycNo(int cNo) {
		
		return sql.selectOne("Contact.findBycNo", cNo);
	}

	@Override
	public int contactInsert(ContactDTO cdto) {
		return sql.insert("Contact.insert", cdto);
	}

	@Override
	public void contactDelete(int cNo) {
		sql.delete("Contact.delete", cNo);
	}

	@Override
	public int contactUpdate(ContactDTO cdto) {
		int result = sql.update("Contact.update", cdto);
		System.out.println(result);
		return sql.update("Contact.update", cdto);
	}

}
