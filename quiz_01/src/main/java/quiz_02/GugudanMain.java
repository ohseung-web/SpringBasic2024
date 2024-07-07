package quiz_02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class GugudanMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext gxt = new GenericXmlApplicationContext("classpath:appCTX.xml");
		Gugudan gugudan = gxt.getBean("gugudan", Gugudan.class);
		gugudan.gugudanInfo();
		gxt.close();

	}

}
