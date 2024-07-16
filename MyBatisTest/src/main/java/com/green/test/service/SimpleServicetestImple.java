package com.green.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.test.dao.SimpleDAOImple;
import com.green.test.dto.SimpleDTO02;

@Service
public class SimpleServicetestImple implements SimpleServicetest {

	@Autowired
	SimpleDAOImple sdao;
	
	@Override
	public void simpleInsert(SimpleDTO02 sdto) {
		sdao.insertSimple(sdto);
	}

	@Override
	public ArrayList<SimpleDTO02> simpleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void simpleUpdate(SimpleDTO02 sdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simpleDelete(SimpleDTO02 sdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SimpleDTO02 simpleSelect(int bNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
