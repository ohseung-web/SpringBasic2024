package quiz_01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext gxt 
		= new GenericXmlApplicationContext("classpath:appCTX.xml");

		Person person = gxt.getBean("person", Person.class);
		person.personInfo();
	
		gxt.close();
	}
}
