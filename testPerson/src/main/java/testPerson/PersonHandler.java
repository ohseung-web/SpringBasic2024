package testPerson;

public class PersonHandler {

	//맴버변수
		private Person person;
		
		//디폴트 생성자
		public PersonHandler() {
			
		}
		//매개변수 생성자
		public PersonHandler(Person person) {
			//super();
			this.person = person;
		}
		//메소드
		public void personInfo() {
			System.out.println("이름 : "+person.getName() );
			System.out.println("나이 :" + person.getAge());
			System.out.println("성별 :"+ person.getGender());
			System.out.println("전화번호 :"+ person.getPhone());
		}
		public Person getPerson() {
			return person;
		}
		public void setPerson(Person person) {
			this.person = person;
		}
		
		
	
}
