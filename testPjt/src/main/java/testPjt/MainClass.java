package testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		TransportationWalk transportationwalk = new TransportationWalk();
//		transportationwalk.move();
		

		// applicationContext.xml에 만들어진 스프링 컨테이너에 접근하는 방법
		// 컨테이너안에 생성된 객체는 Bean이다.
		// GenericXmlApplicationContext 클래스를 이용하여 컨테이너에 접근한다.
		// classpath:applicationContext.xml는 컨테이너의 자원(resources)이다.
		// 아래처럼 컨테이너를 생성시킨다.
		GenericXmlApplicationContext ctx = 
		new GenericXmlApplicationContext("classpath:applicationContext.xml");

		//ctx.getBean():id가 tWalk이고, 데이터타입 TransportationWalk라는 객체를 가져오는 메서드이다.
		TransportationWalk transpotationwalk = ctx.getBean("tWalk", TransportationWalk.class);
		transpotationwalk.move();

		//사용한 외부자원은 반환한다.
		ctx.close();
		
	}
}
