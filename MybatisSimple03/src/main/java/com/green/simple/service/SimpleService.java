package com.green.simple.service;

import java.util.ArrayList;

import com.green.simple.dto.SimpleDTO;

public interface SimpleService {

	public void simpleInsert(SimpleDTO sdto);
	public ArrayList<SimpleDTO> simpleList();
	public void simpleUpdate(SimpleDTO sdto);
	public void simpleDelete(SimpleDTO sdto);
	public SimpleDTO simpleSelect(int bNo);
	
}
