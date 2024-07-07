package com.green.spring02;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
    //filed
	//@Autowired(required=false) //Speaker 데이터 타입의 bean을 찾아서 자동으로 주입해주세요
	
	private Speaker speaker;
	
	//default Constructor
	public Computer() {}
	
	//method
	public void playGame() {
		System.out.println("게임을 한다.");
	}
	public void developApp() {
		System.out.println("앱을 개발한다.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
}
