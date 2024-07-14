package com.green.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionTest  {
   public static void main(String[] args) {
	   
   
	//JDBC �����ϱ�  =======================================================
    String URL="jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
	String userId ="root";
	String userPw ="12345678";
	
	 Connection con = null; //������ ���̽��� �����Ҽ� �ֵ��� ����
	 PreparedStatement pstmt = null; //������ ���̽����� ������ ��������ִ� ��ü
	 ResultSet rs = null; //������ ���̽��� ���̺��� ����� ���Ϲ޾� �ڹٿ� �������ִ� ��ü
	
//	public void getCon() {
		
		try {
			//1. �ش� ������ ���̽��� ����Ѵٰ� ����(Ŭ������ ���=mysql�� ���)
				  Class.forName("com.mysql.cj.jdbc.Driver");
		    //2. �ش� ������ ���̽��� ���� �ݵ�� java.sql�� �����ϴ� Connection�� ����Ѵ�.
				  con = DriverManager.getConnection(URL, userId, userPw);
				  
				  //====== ���� DB���� Ȯ���ڵ�
				  String query = "SELECT now()"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
			      rs = pstmt.executeQuery(query); // query�� ������ ����� rs�� ��´�.
			      
			      // �������� ��� rs���� �� �پ� �о ���
			        while (rs.next()) {
			            String curDate = rs.getString(1);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
			            System.out.println(curDate);       // 2022-01-11 13:53:00.0
			        }

		}catch(Exception e) {
			e.printStackTrace();
		}
//	}
	
   }	
	//======================================================================
}
