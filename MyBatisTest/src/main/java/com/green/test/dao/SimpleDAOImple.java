package com.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.test.dto.SimpleDTO02;

@Repository
public class SimpleDAOImple implements SimpleDAO {

	private static final String NAMESPACE = "mapper.simpletestMapper";
	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public ArrayList<SimpleDTO02> selectSimpleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleDTO02 selectBybNo(int bNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSimple(String bTitle, String bContent, int bNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSimple(int bNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertSimple(SimpleDTO02 sdto) {
	     sqlsession.insert(NAMESPACE, sdto);
	}

}
