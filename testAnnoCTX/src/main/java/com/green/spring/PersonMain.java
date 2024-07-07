package com.green.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ax = 
				new AnnotationConfigApplicationContext(AnnoCTX01.class);
		
		PersonHandler ph1 = ax.getBean("perh1",PersonHandler.class);
		PersonHandler ph2 = ax.getBean("perh2",PersonHandler.class);
		PersonHandler ph3 = ax.getBean("perh3",PersonHandler.class);
		
		ph1.personInfo();
		System.out.println("=============");
		
		ph2.personInfo();
		System.out.println("=============");
		
		ph3.personInfo();
		ax.close();
		
	}

}
