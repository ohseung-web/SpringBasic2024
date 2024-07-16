package com.green.test.dao;

import java.util.ArrayList;

import com.green.test.dto.SimpleDTO02;

public interface SimpleDAO {
	//1.전체목록
		ArrayList<SimpleDTO02> selectSimpleList();
		
		//2.개별항목
		SimpleDTO02 selectBybNo(int bNo);
		
		//3.수정
	   public void updateSimple(String bTitle, String bContent, int bNo);
	   
	   //4.삭제
	   public void deleteSimple(int bNo);
	   
	   //5.삽입
	   public void insertSimple(SimpleDTO02 sdto);
}
