package com.green.AnnoCTX03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ax = 
				new AnnotationConfigApplicationContext(AnnoCTX03.class);
		Student student = ax.getBean("st01",Student.class);
		student.StudentInfo();
		ax.close();

	}

}
