package com.green.simple.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.simple.dto.SimpleDTO;

@Repository
public class SimpleDAOImp implements SimpleDAO{
	
	private static final String NAMESPACE = "com.green.simple.mapper.simpleMapper";

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public ArrayList<SimpleDTO> selectSimpleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleDTO selectBybNo(int bNo) {
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

//	@Override
//	public int insertSimple(String bWriter, String bTitle, String Content) {
//		sqlsession.insert(Content);
//		return 0;
//	}

	@Override
	public int insertSimple(SimpleDTO sdto) {
		sqlsession.insert(NAMESPACE+".insertSimple", sdto);
		return 0;
	}

}
