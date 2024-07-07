package testPerson;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext gxt = new GenericXmlApplicationContext("classpath:appContext.xml");
		PersonHandler ph1 = gxt.getBean("handler1",PersonHandler.class);
		PersonHandler ph2 = gxt.getBean("handler2", PersonHandler.class);
		
		ph1.personInfo();
		System.out.println("====================");
		ph2.personInfo();

	}

}
