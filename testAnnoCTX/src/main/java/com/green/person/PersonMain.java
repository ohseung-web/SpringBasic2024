package com.green.person;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext gxt = 
				new GenericXmlApplicationContext("classpath:pCTX.xml");
		
		Person p1 = gxt.getBean("person1",Person.class);
		System.out.println("이름:"+p1.getName());
		System.out.println("취미 :"+p1.getHobbies());
		System.out.println("=====================");
		Person p2 = gxt.getBean("person2",Person.class);
		System.out.println("이름 :"+p2.getName());
		System.out.println("취미 :"+p2.getHobbies());
		
		gxt.close();

	}

}
