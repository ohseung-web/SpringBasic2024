package testDisunite;

public class Car {
	//멤버변수
		private String model;
		private int price;
		
		//디폴트생성자
		public Car() {}
		//매개변수 생성자
		public Car(String model, int price) {
			this.model = model;
			this.price = price;
		}
		
		//메소드 : 출력문
		public void carInfo() {
			System.out.println("자동차 모델 :"+ model);
			System.out.println("자동차 가격 :"+ price);
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		
}
