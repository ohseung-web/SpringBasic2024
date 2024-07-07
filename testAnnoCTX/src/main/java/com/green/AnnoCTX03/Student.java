package com.green.AnnoCTX03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Student {

	//filed
	private String name; //학생이름
	private ArrayList<Integer> score; //3개의 점수 저장
	private HashSet<String> volunteers;//3개의 봉사활동 저장
	private HashMap<String, String> homeInfo;//adderss,phone
	
	
	//HashSet<>:순서와 관계없이 중복을 허용하지 않고 유일한 값을 관리, 순서가 없다.
	//HashMap<> : 순서를 보장하지 않는다.
	
	//default Constructor
	public Student() {}
	public Student(String name,ArrayList<Integer> score,
			HashSet<String> volunteers, HashMap<String, String> homeInfo) {
		this.name = name;
		this.score = score;
		this.volunteers = volunteers;
		this.homeInfo = homeInfo;
	}
	
	//method
	public void StudentInfo() {
		List<String> vol = new ArrayList<>(volunteers);
		Collections.sort(vol);
		
		System.out.println("학생이름 : "+ name);
		System.out.println("학생점수 : "+ score);
		System.out.println("봉사활동 : "+ vol);
		
        //HashMap<>으로 작성한 데이터를 오름차순 정렬하기위한 방법
		// 1] 최상위 객체인 Object[] 객체의 toArray()메소드 이용하여 작성
		//    Arrays.sort(arr); => 오름차순
		//    Arrays.sort(arr,Collections.reverseOrder()); // => 내림차순 
		// 단, 확장 for문작성시 데이터 타입은 반드시 Object로 변경하여야 한다.
		Object[] arr = homeInfo.keySet().toArray();
		Arrays.sort(arr,Collections.reverseOrder()); // => 내림차순
		for(Object key : arr) {
			String value = homeInfo.get(key);
			System.out.println(key + ":" + value);
		}
		
		// 2] ArrayList<>() 객체배열을 이용하여 작성
		//Collections.sort(keySet) => key값으로 오름차순 정렬
		//Collections.reverse(keySet) => key값으로 내림차순 정렬
		List<String> keySet = new ArrayList<>(homeInfo.keySet());
		Collections.sort(keySet);
		for(String key : keySet) {
			String value = homeInfo.get(key);
			System.out.println(key + ":" + value);
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getScore() {
		return score;
	}
	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}
	public HashSet<String> getVolunteers() {
		return volunteers;
	}
	public void setVolunteers(HashSet<String> volunteers) {
		this.volunteers = volunteers;
	}
	public HashMap<String, String> getHomeInfo() {
		return homeInfo;
	}
	public void setHomeInfo(HashMap<String, String> homeInfo) {
		this.homeInfo = homeInfo;
	}
	
    
}
