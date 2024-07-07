package com.green.quiz05;

public class Engine {

	    //멤버변수
		private String fuelType; //가솔린, 디젤
		private int cc; //배기량, 1991
		private int hp; //마력 245
		private double fuelEffciency; // 연비 12.5
		
		//디폴트 생성자
		public Engine() {}
		public Engine(String fuelType, int cc, int hp, double fuelEffciency) {
			this.fuelType  = fuelType;
			this.cc = cc;
			this.hp = hp;
			this.fuelEffciency = fuelEffciency;
		}
		public String getFuelType() {
			return fuelType;
		}
		public void setFuelType(String fuelType) {
			this.fuelType = fuelType;
		}
		public int getCc() {
			return cc;
		}
		public void setCc(int cc) {
			this.cc = cc;
		}
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public double getFuelEffciency() {
			return fuelEffciency;
		}
		public void setFuelEffciency(double fuelEffciency) {
			this.fuelEffciency = fuelEffciency;
		}
		
		
		
}
