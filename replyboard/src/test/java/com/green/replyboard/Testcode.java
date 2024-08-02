package com.green.replyboard;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.replyboard.dto.ReplyBoardDTO;
import com.mysql.cj.xdevapi.PreparableStatement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Testcode {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void insertBoard(){
		ReplyBoardDTO rdto = new ReplyBoardDTO("a","a","a","a",1,1,1,"a",1);
		deleteAll();
		insert(rdto);
		
		assertTrue(rdto != null); 
	}


	private void deleteAll() {
		try {
			Connection conn = dataSource.getConnection();
			
			String sql = "delete from replyBoard";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}


	public void insert(ReplyBoardDTO rdto) {
		
		try {
		Connection conn = dataSource.getConnection();
		
		String sql = "insert into replyBoard values(null,?,?,?,?,now(),?,?,?,0,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rdto.getWriter());
		pstmt.setString(2, rdto.getEmail());
		pstmt.setString(3, rdto.getSubject());
		pstmt.setString(4, rdto.getPassword());
		pstmt.setInt(5, 1);
		pstmt.setInt(6, 1);
		pstmt.setInt(7, 1);
		pstmt.setString(8, rdto.getContent());
		pstmt.setInt(9, 1);
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection conn=dataSource.getConnection()) {
			System.out.println("conn => " + conn);
			assertTrue(conn != null); //괄호안의 조건이 true이면 통과
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

