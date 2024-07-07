package testCal;

public class Calculator {
    //생성자
	public Calculator() {}
	//메소드
	public void addtion(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(num1+"+"+num2+"="+result);
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

