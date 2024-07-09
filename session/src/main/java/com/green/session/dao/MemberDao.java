package com.green.session.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.green.session.dto.Member;

@Repository
public class MemberDao implements IMemberDao {
	
//	 // 스키마의 이름(springbasic)이 다른 경우 알맞게 변경해야 함
//    String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8";
//
//    // DB의 userid와 pwd를 알맞게 변경해야 함
//    String DB_USER = "asdf";
//    String DB_PASSWORD = "1234";
//
//    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
//    Statement stmt  = conn.createStatement(); // Statement를 생성한다.
//
//    String query = "SELECT now()"; // 시스템의 현재 날짜시간을 출력하는 쿼리(query)
//  //  ResultSet rs = stmt.executeQuery(query); // query를 실행한 결과를 rs에 담는다.
//
//    // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
//    while (rs.next()) {
//        String curDate = rs.getString(1);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
//        System.out.println(curDate);       // 2022-01-11 13:53:00.0
//    }
	
    //JDBC 연결하기  =======================================================
    private String URL="jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
	private String userId ="root";
	private String userPw ="12345678";
	
	private Connection con = null; //데이터 베이스에 접근할수 있도록 설정
	private PreparedStatement pstmt = null; //데이터 베이스에서 쿼리를 실행시켜주는 객체
	private ResultSet rs = null; //데이터 베이스의 테이블의 결과를 리턴받아 자바에 저장해주는 객체
	
	public void getCon() {
		
		try {
			//1. 해당 데이터 베이스를 사용한다고 선언(클래스를 등록=mysql을 사용)
				  Class.forName("com.mysql.cj.jdbc.Driver");
		    //2. 해당 데이터 베이스에 접속 반드시 java.sql에 존재하는 Connection을 사용한다.
				  con = DriverManager.getConnection(URL, userId, userPw);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//======================================================================

	private HashMap<String, Member> dbMap;
	public MemberDao() {
		//dbMap = new HashMap<String, Member>();
	}

	@Override
	public int memberInsert(Member member) {
		getCon();
		int result = 0;
		
		try {
		      String sql = "insert into member(memId,memPw,memMail) values(?,?,?)";
		     // 쿼리를 사용하도록 설정 , spring에서 쿼리를 사용하도록 설정 
		      pstmt = con.prepareStatement(sql);
		     // ?에 맞게 데이터를 연결
		      pstmt.setString(1, member.getMemId());
		      pstmt.setString(2, member.getMemPw());
		      pstmt.setString(3, member.getMemMail());
		     //mysql에서 쿼리를 실행하시오.
		     // result = 1, DB에 데이터가 삽입되는 횟수를 말한다.
		      result = pstmt.executeUpdate(); //insert, delete, update시 사용하는 메서도
		      
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException s) {
				s.printStackTrace();
			}
		}
		 
		//dbMap.put(member.getMemId(), member);
		return result;
	}

	@Override
	public Member memberSelect(Member member) {
		getCon();
		Member mem = null;
		
		try {
			 String sql ="select * from member where memId=? and memPw=?";
			 pstmt = con.prepareStatement(sql);
			 // ?대응
			 pstmt.setString(1, member.getMemId());
			 pstmt.setString(2, member.getMemPw());
			 rs = pstmt.executeQuery(); //select문은 ResultSet 객체사용한다.
			 //테이블에 저장된 데이터를 while문을 이용하여 비교한다.
			 while(rs.next()) {
				 String memId = rs.getString("memid");
				 String memPw = rs.getString("mempw");
				 String memMail = rs.getString("memMail");
				 
				 mem = new Member();
				 mem.setMemId(memId);
				 mem.setMemPw(memPw);
				 mem.setMemMail(memMail);
			 }
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException s) {
				s.printStackTrace();
			}
		}
		
		//dbMap.get(member.getMemId()); 
		return mem;
	}

	@Override
	public int memberUpdate(Member member) {
		getCon();
		int result = 0;
		try {
			 String sql ="update member set memPw=?, memMail=?";
			 pstmt = con.prepareStatement(sql);
			 // ?대응
			 //pstmt.setString(1, member.getMemId());
			 pstmt.setString(1, member.getMemPw());
			 pstmt.setString(2, member.getMemMail());
			 result = pstmt.executeUpdate(); //select문은 ResultSet 객체사용한다.
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int memberDelete(Member member) {
		getCon();
		int result = 0;
		try {
			 String sql ="delete member where memId=? and memPw=?";
			 pstmt = con.prepareStatement(sql);
			 // ?대응
			 pstmt.setString(1, member.getMemId());
			 pstmt.setString(2, member.getMemPw());
			 result = pstmt.executeUpdate(); //select문은 ResultSet 객체사용한다.
			 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)  rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return result;
	}

}
