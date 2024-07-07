package com.green.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MyCalMain {

	public static void main(String[] args) {
		
		String resource ="classpath:appCTX.xml";
		GenericXmlApplicationContext gxt = 
				new GenericXmlApplicationContext(resource);
		MyCalculator myCalculator = gxt.getBean("mycal",MyCalculator.class);
		
		myCalculator.addtion(1, 2);
		myCalculator.subtraction(10, 7);
		myCalculator.multplication(3, 4);
		myCalculator.division(10, 5);
		
		gxt.close();
	}

}
