package com.green.spring02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainComputer {

	public static void main(String[] args) {
	
	  String resource = "classpath:appCTX.xml";
	  GenericXmlApplicationContext gxt = 
			  new GenericXmlApplicationContext(resource);
	  
	  Computer computer = gxt.getBean("computer", Computer.class);
	  computer.playGame();
	  computer.developApp();
	  computer.volumeUp();
	  computer.volumeDown();
	  
	  gxt.close();
	

	}

}
