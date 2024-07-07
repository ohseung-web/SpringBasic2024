package testDisunite;

public class Person {
	//멤버변수
		private String name;
		private int age;
		private Car car;
		
		//디폴트생성자
		public Person() {}
		//매개변수 생성자
		public Person(String name, int age, Car car) {
			this.name = name;
			this.age = age;
			this.car  = car;
		}
		
		//출력 메소드
		public void personInfo() {
			System.out.println("이름 :"+ name);
			System.out.println("나이 :"+ age);
			car.carInfo();
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
		public Car getCar() {
			return car;
		}
		public void setCar(Car car) {
			this.car = car;
		}
		
		
}
