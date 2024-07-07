package com.green.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@Import(AnnoCTX01.class)
public class AnnoCTX02 {
	
	@Autowired
	Person p1;
	@Autowired
	Person p2;
	
	//<bean id="perh1" class="com.green.spring.PersonHandler">
		@Bean
		public PersonHandler perh1() {
			PersonHandler ph = new PersonHandler();
			ph.setPerson(p1);
			return ph;
		}
		//<bean id="perh2" class="com.green.spring.PersonHandler">
		@Bean
		public PersonHandler perh2() {
			PersonHandler ph = new PersonHandler();
			ph.setPerson(p2);
			return ph;
		}
		@Bean
		public PersonHandler perh3() {
			PersonHandler ph = new PersonHandler();
			ph.setPerson(new Person("엘리스", 25));
			return ph;
		}
}

