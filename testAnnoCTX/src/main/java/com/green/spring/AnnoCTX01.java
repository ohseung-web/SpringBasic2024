package com.green.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@Import(AnnoCTX02.class)
public class AnnoCTX01 {
   
	//@Bean : Bean을 만드는 어노테이션이다.
		//<bean id="p1" class="com.green.spring.Person">
		@Bean
		public Person p1() {
			Person p1 = new Person();
			p1.setName("에밀리"); //<property name="name" value="에밀리" />
			p1.setAge(20); //<property name="age" value="20" />
			return p1;
		}
		//<bean id="p2" class="com.green.spring.Person">
		@Bean
		public Person p2() {
			Person p2 = new Person();
			p2.setName("제임스");
			p2.setAge(30);
			return p2;
		}
}

