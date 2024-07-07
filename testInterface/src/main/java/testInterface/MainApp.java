package testInterface;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext gxt 
		   = new GenericXmlApplicationContext("classpath:appContext1.xml");
         //	인터페이스 타입으로 Bean객체를 생성하면 MainApp.java를 변경할 필요가 없다.
		App app = gxt.getBean("app",App.class);
		app.play();
		gxt.close();

	}

}
