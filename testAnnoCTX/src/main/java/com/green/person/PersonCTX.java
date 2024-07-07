package com.green.person;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:pCTX.xml")
public class PersonCTX {
	@Bean
	public Person person2() {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("피파");
		list.add("스파");
		list.add("롤");
		
		Person person = new Person();
		person.setName("제임스");
		person.setHobbies(list);
		
		return person;
	}
	
	
}
