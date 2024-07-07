package testList;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainList {

	public static void main(String[] args) {
		
//		DI란 외부파일 appContext2.xml에서 의존하고 싶은 bean객체를 생성하여 Main에 주입하는 것을 의미한다.
		GenericXmlApplicationContext gxt = 
				new GenericXmlApplicationContext("classpath:appContext2.xml");
		
		MapHandler maphandler = gxt.getBean("maphandler", MapHandler.class);
		maphandler.mapInfo();
		
		
		
		
		
		
//		ListArray listarry = gxt.getBean("listarry", ListArray.class);
//		listarry.ListInfo();
		gxt.close();

	}

}
