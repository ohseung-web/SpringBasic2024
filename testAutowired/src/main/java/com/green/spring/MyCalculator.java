package com.green.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyCalculator {
   //filed
	@Qualifier("cal") //cal이라는 bean을 
	@Autowired(required = false) // 자동으로 주입해주세요
	private Calculator calculator;
	
	//default Constructor
	public MyCalculator() {}
	
	//method
	public void alarm() {
		System.out.println("alarm");
	}
	public void addtion(int num1, int num2) {
		calculator.addtion(num1, num2);
	}
	public void subtraction(int num1, int num2) {
		calculator.subtraction(num1, num2);
	}
	public void multplication(int num1, int num2) {
		calculator.multplication(num1, num2);
	}
	public void division(int num1, int num2) {
		calculator.division(num1, num2);
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
}
