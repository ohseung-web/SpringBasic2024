package com.green.quiz05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		
     AbstractApplicationContext  ctx = 
    		 new AnnotationConfigApplicationContext(AnnoCTX.class);
		
		Car car = ctx.getBean("mycar",Car.class);
		System.out.println("모델 :" + car.getModel());
		System.out.println("엔진:"+car.getEngine().getFuelType());
		System.out.println("배기량 :"+car.getEngine().getCc());
		System.out.println("마력 :"+car.getEngine().getHp());
		System.out.println("연비 :"+car.getEngine().getFuelEffciency());
		
		ctx.close();

	}

}
