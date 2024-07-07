package com.green.quiz05;

public class Car {

	   //멤버변수
		private String model;
		private  Engine engine;
		
		//디폴트 생성자
		public Car() {}
	    public Car(String model, Engine engine) {
	    	this.model  = model;
	    	this.engine = engine;
	    }
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public Engine getEngine() {
			return engine;
		}
		public void setEngine(Engine engine) {
			this.engine = engine;
		}
	    
	    
	    
}
