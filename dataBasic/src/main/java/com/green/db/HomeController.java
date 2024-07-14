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
		
		// MySQL을 JDBC(java DataBase Conneter) 연결하기 :=======================================================
//	    String URL="jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
//		String userId ="root";
//		String userPw ="12345678";
//			
//		 Connection con = null; //데이터 베이스에 접근할수 있도록 설정
//		 PreparedStatement pstmt = null; //데이터 베이스에서 쿼리를 실행시켜주는 객체
//		 ResultSet rs = null; //데이터 베이스의 테이블의 결과를 리턴받아 자바에 저장해주는 객체
//	     
//		 try {
//				//1. 해당 데이터 베이스를 사용한다고 선언(클래스를 등록=mysql을 사용)
//					  Class.forName("com.mysql.cj.jdbc.Driver");
//			    //2. 해당 데이터 베이스에 접속 반드시 java.sql에 존재하는 Connection을 사용한다.
//					  con = DriverManager.getConnection(URL, userId, userPw);
//					  
//					  //====== 샘플 DB연결 확인코드
//					  String query = "SELECT now()"; // 시스템의 현재 날짜시간을 출력하는 쿼리(query)
//					  pstmt = con.prepareStatement(query);
//					  rs = pstmt.executeQuery();
//				     // rs = pstmt.executeQuery(query); // query를 실행한 결과를 rs에 담는다.
//				      
//				      // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
//				        while (rs.next()) {
//				            String curDate = rs.getString(1);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
//				            System.out.println(curDate);       // 2022-01-11 13:53:00.0
//				        }
//
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		
		//=============== MySQL을 Spring JDBC로 연결 =================
		 
       // 스키마의 이름(springbasic)이 다른 경우 알맞게 변경
//       String DB_URL = "jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
//
//       // DB의 userid와 pwd를 알맞게 변경
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
         Connection conn = ds.getConnection(); // 데이터베이스의 연결을 얻는다.
         
        System.out.println("conn = " + conn);
    //   assertTrue(conn!=null);	 
		
		
		return "home";
	}
	
}
