package com.green.test.service;

import java.util.ArrayList;

import com.green.test.dto.SimpleDTO02;

public interface SimpleServicetest {

	public void simpleInsert(SimpleDTO02 sdto);
	public ArrayList<SimpleDTO02> simpleList();
	public void simpleUpdate(SimpleDTO02 sdto);
	public void simpleDelete(SimpleDTO02 sdto);
	public SimpleDTO02 simpleSelect(int bNo);
}
