package com.green.mvc01.dto;

public class PersonDTO {

	//�������
	private String name;
	private int age;
	private ContextDTO cdto;
	
	//����Ʈ������
	public PersonDTO() {}
	public PersonDTO(String name, int age, ContextDTO cdto) {
		this.name  = name;
		this.age  = age;
		this.cdto = cdto;
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
	public ContextDTO getCdto() {
		return cdto;
	}
	public void setCdto(ContextDTO cdto) {
		this.cdto = cdto;
	}
	
	
}
