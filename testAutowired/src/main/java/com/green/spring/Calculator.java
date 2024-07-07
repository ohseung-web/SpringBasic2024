package com.green.spring;

import org.springframework.stereotype.Component;

@Component("cal") //내가 cal이다 라고 이름 지정 함	
public class Calculator {
	
  // 사칙연산 전용 클래스로 작성되어있다.	
  //filed
	
  //default constructor
  public Calculator() {}
  //method
  public void addtion(int num1, int num2) {
	  int result = num1 + num2;
	  System.out.println(num1 + "+" + num2 +"="+result);
  }
  public void subtraction(int num1, int num2) {
		int result = num1 - num2;
		System.out.println(num1+"-"+num2+"="+result);
	}
	public void multplication(int num1, int num2) {
		int result = num1 * num2;
		System.out.println(num1+"*"+num2+"="+result);
	}
	public void division(int num1, int num2) {
		int result = num1 / num2;
		System.out.println(num1+"/"+num2+"="+result);
	}
}
