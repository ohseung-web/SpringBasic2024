package quiz_03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCTX.xml");
		Student s = ctx.getBean("student", Student.class);
		s.studentInfo();
		ctx.close();

	}

}
