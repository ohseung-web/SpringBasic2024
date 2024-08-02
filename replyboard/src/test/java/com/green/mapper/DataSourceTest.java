package com.green.mapper;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.cj.log.Log;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
   
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn=dataSource.getConnection()) {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
