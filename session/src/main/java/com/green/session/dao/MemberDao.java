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
	
//	 // ��Ű���� �̸�(springbasic)�� �ٸ� ��� �˸°� �����ؾ� ��
//    String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8";
//
//    // DB�� userid�� pwd�� �˸°� �����ؾ� ��
//    String DB_USER = "asdf";
//    String DB_PASSWORD = "1234";
//
//    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // �����ͺ��̽��� ������ ��´�.
//    Statement stmt  = conn.createStatement(); // Statement�� �����Ѵ�.
//
//    String query = "SELECT now()"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
//  //  ResultSet rs = stmt.executeQuery(query); // query�� ������ ����� rs�� ��´�.
//
//    // �������� ��� rs���� �� �پ� �о ���
//    while (rs.next()) {
//        String curDate = rs.getString(1);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
//        System.out.println(curDate);       // 2022-01-11 13:53:00.0
//    }
	
    //JDBC �����ϱ�  =======================================================
    private String URL="jdbc:mysql://localhost:3306/springdb?serverTimezone=UTC";
	private String userId ="root";
	private String userPw ="12345678";
	
	private Connection con = null; //������ ���̽��� �����Ҽ� �ֵ��� ����
	private PreparedStatement pstmt = null; //������ ���̽����� ������ ��������ִ� ��ü
	private ResultSet rs = null; //������ ���̽��� ���̺��� ����� ���Ϲ޾� �ڹٿ� �������ִ� ��ü
	
	public void getCon() {
		
		try {
			//1. �ش� ������ ���̽��� ����Ѵٰ� ����(Ŭ������ ���=mysql�� ���)
				  Class.forName("com.mysql.cj.jdbc.Driver");
		    //2. �ش� ������ ���̽��� ���� �ݵ�� java.sql�� �����ϴ� Connection�� ����Ѵ�.
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
		     // ������ ����ϵ��� ���� , spring���� ������ ����ϵ��� ���� 
		      pstmt = con.prepareStatement(sql);
		     // ?�� �°� �����͸� ����
		      pstmt.setString(1, member.getMemId());
		      pstmt.setString(2, member.getMemPw());
		      pstmt.setString(3, member.getMemMail());
		     //mysql���� ������ �����Ͻÿ�.
		     // result = 1, DB�� �����Ͱ� ���ԵǴ� Ƚ���� ���Ѵ�.
		      result = pstmt.executeUpdate(); //insert, delete, update�� ����ϴ� �޼���
		      
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
			 // ?����
			 pstmt.setString(1, member.getMemId());
			 pstmt.setString(2, member.getMemPw());
			 rs = pstmt.executeQuery(); //select���� ResultSet ��ü����Ѵ�.
			 //���̺� ����� �����͸� while���� �̿��Ͽ� ���Ѵ�.
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
			 // ?����
			 //pstmt.setString(1, member.getMemId());
			 pstmt.setString(1, member.getMemPw());
			 pstmt.setString(2, member.getMemMail());
			 result = pstmt.executeUpdate(); //select���� ResultSet ��ü����Ѵ�.
			 
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
			 // ?����
			 pstmt.setString(1, member.getMemId());
			 pstmt.setString(2, member.getMemPw());
			 result = pstmt.executeUpdate(); //select���� ResultSet ��ü����Ѵ�.
			 
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
