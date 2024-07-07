package com.green.quiz04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {

	@Bean
    public Gun gun() {   // <bean id ="gun" class="com.green.quiz04.Gun" />
		
		Gun gun = new Gun();
		gun.setModel("베레타");
		 gun.setBullet(6);
		 return gun;
		 // Gun gun = new Grun("베레타",6);
	}
}
