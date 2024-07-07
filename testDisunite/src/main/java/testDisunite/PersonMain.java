package testDisunite;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		String [] appctx = {"appCTX1.xml","appCTX2.xml"};
		GenericXmlApplicationContext gxt = 
				new GenericXmlApplicationContext(appctx[0],appctx[1]);
		Person person = gxt.getBean("person", Person.class);
		person.personInfo();
		gxt.close();

	}

}
