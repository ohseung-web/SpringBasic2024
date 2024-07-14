package com.green.db;

//import java.sql.Connection;

//import java.sql.SQLException;

import java.util.Locale;

import javax.sql.*;
import java.sql.*;

import org.springframework.jdbc.datasource.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mchange.v2.c3p0.DataSources;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws SQLException {
		
		// MySQL�� JDBC(java DataBase Conneter) �����ϱ� :=======================================================
//	    String URL="jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
//		String userId ="root";
//		String userPw ="12345678";
//			
//		 Connection con = null; //������ ���̽��� �����Ҽ� �ֵ��� ����
//		 PreparedStatement pstmt = null; //������ ���̽����� ������ ��������ִ� ��ü
//		 ResultSet rs = null; //������ ���̽��� ���̺��� ����� ���Ϲ޾� �ڹٿ� �������ִ� ��ü
//	     
//		 try {
//				//1. �ش� ������ ���̽��� ����Ѵٰ� ����(Ŭ������ ���=mysql�� ���)
//					  Class.forName("com.mysql.cj.jdbc.Driver");
//			    //2. �ش� ������ ���̽��� ���� �ݵ�� java.sql�� �����ϴ� Connection�� ����Ѵ�.
//					  con = DriverManager.getConnection(URL, userId, userPw);
//					  
//					  //====== ���� DB���� Ȯ���ڵ�
//					  String query = "SELECT now()"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
//					  pstmt = con.prepareStatement(query);
//					  rs = pstmt.executeQuery();
//				     // rs = pstmt.executeQuery(query); // query�� ������ ����� rs�� ��´�.
//				      
//				      // �������� ��� rs���� �� �پ� �о ���
//				        while (rs.next()) {
//				            String curDate = rs.getString(1);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
//				            System.out.println(curDate);       // 2022-01-11 13:53:00.0
//				        }
//
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		
		//=============== MySQL�� Spring JDBC�� ���� =================
		 
       // ��Ű���� �̸�(springbasic)�� �ٸ� ��� �˸°� ����
//       String DB_URL = "jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
//
//       // DB�� userid�� pwd�� �˸°� ����
//       String DB_USER = "root";
//       String DB_PASSWORD = "12345678";
//       String DB_DRIVER = "com.mysql.jdbc.Driver";
//
//       DriverManagerDataSource ds = new DriverManagerDataSource();
//       ds.setDriverClassName(DB_DRIVER);
//       ds.setUrl(DB_URL);
//       ds.setUsername(DB_USER);
//       ds.setPassword(DB_PASSWORD);
	    
	
	 ApplicationContext ac = 
          new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
       
	    DataSource ds = ac.getBean(DataSource.class);
         Connection conn = ds.getConnection(); // �����ͺ��̽��� ������ ��´�.
         
        System.out.println("conn = " + conn);
    //   assertTrue(conn!=null);	 
		
		
		return "home";
	}
	
}
