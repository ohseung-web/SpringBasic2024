package com.green.Anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX02 {
  
  //메소드
	//<bean id="mySong" class="com.green.spring.Song" />
	@Bean
	public Song mySong() {
		Song song = new Song();
		song.setTitle("Hello");
		song.setGenre("Balad");
		song.setPlayTime(4.5);
		return song;
	}
	
	//<bean id="singer" class="com.green.spring.Singer" />
		@Bean
		public Singer singer() {
			Singer singer = new Singer();
			singer.setName("Abba"); //<property name="name" value="Abba" />
			singer.setSong(mySong());// <property name="song" ref="mySong" />
			return singer;
		}
}
