package com.green.Anno02;

public class Singer {
    //멤버변수
	private String name;//가수이름
	private Song song;
	
	//디폴트 생성자
	public Singer() {}
	public Singer(String name, Song song) {
		this.name = name;
		this.song = song;
	}
	
	//메소드
	public void singerInfo() {
		System.out.println("이름 :"+ name);
		song.songInfo();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	
}
