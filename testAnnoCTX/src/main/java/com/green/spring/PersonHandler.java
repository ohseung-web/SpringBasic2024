package com.green.spring;

public class PersonHandler {
   //filed
   private Person person;
   //default Constructor
   public PersonHandler() {}
   public PersonHandler(Person person) {
	   this.person = person;
   }
   //method
   public void personInfo() {
	   System.out.println("이름 : "+ person.getName());
	   System.out.println("나이 : "+ person.getAge());
   }
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
   
}
