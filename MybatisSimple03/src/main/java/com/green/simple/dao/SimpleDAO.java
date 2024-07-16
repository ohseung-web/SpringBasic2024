package com.green.simple.dao;

import java.util.ArrayList;

import com.green.simple.dto.SimpleDTO;

public interface SimpleDAO {
    //1.전체목록
	ArrayList<SimpleDTO> selectSimpleList();
	
	//2.개별항목
	SimpleDTO selectBybNo(int bNo);
	
	//3.수정
   public void updateSimple(String bTitle, String bContent, int bNo);
   
   //4.삭제
   public void deleteSimple(int bNo);
   
   //5.삽입
   int insertSimple(SimpleDTO sdto);
   
}
