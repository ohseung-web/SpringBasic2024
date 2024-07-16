package com.green.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.simple.dao.SimpleDAO;
import com.green.simple.dto.SimpleDTO;

@Service
public class SimpleServiceImp implements SimpleService {

	@Autowired
	SimpleDAO sdao;
	
	@Override
	public void simpleInsert(SimpleDTO sdto) {
		sdao.insertSimple(sdto);
		
	}

	@Override
	public ArrayList<SimpleDTO> simpleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void simpleUpdate(SimpleDTO sdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simpleDelete(SimpleDTO sdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SimpleDTO simpleSelect(int bNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
