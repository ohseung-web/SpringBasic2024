package com.green.board.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageHandlerTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		PageHandler ph = new PageHandler(250, 1);
		ph.print();
		assertTrue(ph.getBeginPage()==1);
		assertTrue(ph.getEndPage()==10);
		
	}



}
