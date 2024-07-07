package testCal;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCal {

	public static void main(String[] args) {
		
		
	   GenericXmlApplicationContext gxt =  
			   new GenericXmlApplicationContext("classpath:applicationContext.xml");	
	   MyCalculator mycal1 = gxt.getBean("mycal1",MyCalculator.class);
		
//       MyCalculator mycal1 = new MyCalculator();
//       mycal1.setNum1(10);
//       mycal1.setNum2(3);
//       mycal1.setCal(new Calculator()); //주입(DI)
       mycal1.add();
       mycal1.sub();
       mycal1.mul();
       mycal1.div();
       System.out.println("==========");
       
       MyCalculator mycal2 = gxt.getBean("mycal2",MyCalculator.class);
//       MyCalculator mycal2 = new MyCalculator();
//       mycal2.setNum1(100);
//       mycal2.setNum2(30);
//       mycal2.setCal(new Calculator());//주입(DI)
       mycal2.add();
       mycal2.sub();
       mycal2.mul();
       mycal2.div();
       
       gxt.close();
	}

}

