package com.green.AnnoCTX03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX03 {

	@Bean
	public Student st01() {
		Student student = new Student();
		student.setName("홍길동");
		
		ArrayList<Integer> scorelist = new ArrayList<>();
		scorelist.add(100);
		scorelist.add(80);
		scorelist.add(90);
		
		HashSet<String> set = new HashSet<>();
		set.add("교육청소");
		set.add("병원청소");
		set.add("환경미화");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("adderss", "서울시 종로구");
		map.put("phone", "010-1111-5555");
		
		student.setScore(scorelist);
		student.setVolunteers(set);
		student.setHomeInfo(map);
		return student;
	}
}
