package com.green.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //appCTX.xml과 같은 역활을 수행하도록 하는 어노테이션이다.
public class AnnoCTX {

	//@Bean : Bean을 만드는 어노테이션이다.
	//<bean id="p1" class="com.green.spring.Person">
	@Bean
	public Person p1() {
		Person person = new Person();
		person.setName("에밀리"); //<property name="name" value="에밀리" />
		person.setAge(20); //<property name="age" value="20" />
		return person;
	}
	//<bean id="p2" class="com.green.spring.Person">
	@Bean
	public Person p2() {
		Person person = new Person();
		person.setName("제임스");
		person.setAge(30);
		return person;
	}
	//<bean id="perh1" class="com.green.spring.PersonHandler">
	@Bean
	public PersonHandler perh1() {
		PersonHandler ph = new PersonHandler();
		ph.setPerson(p1());
		return ph;
	}
	//<bean id="perh2" class="com.green.spring.PersonHandler">
	@Bean
	public PersonHandler perh2() {
		PersonHandler ph = new PersonHandler();
		ph.setPerson(p2());
		return ph;
	}
	@Bean
	public PersonHandler perh3() {
		PersonHandler ph = new PersonHandler();
		ph.setPerson(new Person("엘리스", 25));
		return ph;
	}
}
