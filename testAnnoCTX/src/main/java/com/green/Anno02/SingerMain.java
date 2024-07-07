package com.green.Anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SingerMain {

	public static void main(String[] args) {
       AbstractApplicationContext ax = 
    		   new AnnotationConfigApplicationContext(AnnoCTX02.class);
		
		Singer s = ax.getBean("singer",Singer.class);
		s.singerInfo();
		ax.close();

	}

}
