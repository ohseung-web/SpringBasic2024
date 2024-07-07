package com.green.quiz05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:appCTX.xml")
public class AnnoCTX {

	/*@Autowired
    private Engine myengine;
   
    @Bean
    public Car mycar() {
    	Car car = new Car();
    	car.setModel("520d");
    	car.setEngine(myengine);
    	return car;
    }*/
//-------------------------------------------------------------------------------	     
//   @Bean
//    public Engine myengine() {
//    	return new Engine();
//    }
    
   @Autowired
    Engine myengine;
   
    @Bean
    public Car mycar() {
    	Car car = new Car();
    	car.setModel("520d");
    	car.setEngine(myengine);
    	return car;
    }
    
}
