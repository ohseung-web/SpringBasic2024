package com.green.mvc01.dto;

public class ContextDTO {
	    //�������
		private String phone;
		private String add;
		
		//����Ʈ������
		public ContextDTO() {
			
		}
		public ContextDTO(String phone, String add) {
			this.phone = phone;
			this.add = add;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAdd() {
			return add;
		}
		public void setAdd(String add) {
			this.add = add;
		}	
		
}
