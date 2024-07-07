package com.green.quiz04;

public class Gun {
	    //filed
		private String model;//총모델
		private int bullet;//총알
		
		//디폴트생성자
		public Gun() {}
		public Gun(String model, int bullet) {
			this.model  = model;
			this.bullet  = bullet;
			
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getBullet() {
			return bullet;
		}
		public void setBullet(int bullet) {
			this.bullet = bullet;
		}
		
		
}
