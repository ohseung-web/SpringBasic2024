package com.green.test.dao;

import java.util.ArrayList;

import com.green.test.dto.SimpleDTO02;

public interface SimpleDAO {
	//1.��ü���
		ArrayList<SimpleDTO02> selectSimpleList();
		
		//2.�����׸�
		SimpleDTO02 selectBybNo(int bNo);
		
		//3.����
	   public void updateSimple(String bTitle, String bContent, int bNo);
	   
	   //4.����
	   public void deleteSimple(int bNo);
	   
	   //5.����
	   public void insertSimple(SimpleDTO02 sdto);
}
