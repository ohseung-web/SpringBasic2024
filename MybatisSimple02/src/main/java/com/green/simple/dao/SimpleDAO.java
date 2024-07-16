package com.green.simple.dao;

import java.util.ArrayList;

import com.green.simple.dto.SimpleDTO;

public interface SimpleDAO {
    //1.��ü���
	ArrayList<SimpleDTO> selectSimpleList();
	
	//2.�����׸�
	SimpleDTO selectBybNo(int bNo);
	
	//3.����
   public void updateSimple(String bTitle, String bContent, int bNo);
   
   //4.����
   public void deleteSimple(int bNo);
   
   //5.����
   int insertSimple(SimpleDTO sdto);
   
}
