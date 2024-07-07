package com.green.person2;

import java.util.ArrayList;

public class Person {

	 private String name;
	 private ArrayList<String> hobbies;
	 
	 //디폴트 생성자
	 public Person() {}
	 public Person(String name, ArrayList<String> hobbies) {
		 this.name = name;
		 this.hobbies  = hobbies;
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	 
	 
}
