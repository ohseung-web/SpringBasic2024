package com.green.person2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext ax = 
				new AnnotationConfigApplicationContext(PersonCTX.class);
		
		Person p1 = ax.getBean("person1",Person.class);
		System.out.println("이름:"+p1.getName());
		System.out.println("취미 :"+p1.getHobbies());
		System.out.println("=====================");
		Person p2 = ax.getBean("person2",Person.class);
		System.out.println("이름 :"+p2.getName());
		System.out.println("취미 :"+p2.getHobbies());
		
		ax.close();

	}

}
