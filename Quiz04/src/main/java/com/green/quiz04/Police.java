package com.green.quiz04;

import java.util.HashMap;

public class Police {
    	//멤버변수
		private String name;//이름
		private HashMap<String, String> deptInfo;//부서명, 부서위치
		private Gun pistol;//권총
		
		//디폴트생성자
		public Police() {
			
		}
		public Police(String name, HashMap<String, String> deftInfo, Gun pistol) {
			this.name = name;
			this.deptInfo  = deptInfo;
			this.pistol = pistol;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public HashMap<String, String> getDeptInfo() {
			return deptInfo;
		}
		public void setDeptInfo(HashMap<String, String> deptInfo) {
			this.deptInfo = deptInfo;
		}
		public Gun getPistol() {
			return pistol;
		}
		public void setPistol(Gun pistol) {
			this.pistol = pistol;
		}
		
		
}
