package testPerson;

public class Person {

	//맴버 변수
		 private String name;  // 이름
		 private int age;  // 나이
		 private char gender; // 성별
		 private String phone;//전화번호
		 
		 //디폴트생성자
		 public Person() {
			 
		 }
		//매개변수 생성자
		 public Person(String name, int age, char gender, String phone) {
			 super();
			 this.name = name;
			 this.age = age;
			 this.gender = gender;
			 this.phone = phone;
			 
		 }
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public char getGender() {
			return gender;
		}
		public void setGender(char gender) {
			this.gender = gender;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
}
