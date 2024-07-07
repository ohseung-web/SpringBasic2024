package com.green.Anno02;

public class Song {

	 //멤버변수
		private String title; //노래제목
		private String genre; //노래장르
		private double playTime;//재생시간
		
		//디폴트 생성자
		public Song() {}
		public Song(String title, String genre,double playTime) {
			this.title = title;
			this.genre = genre;
			this.playTime = playTime;
		}
		// 메소드
		public void songInfo() {
			System.out.println("노래제목 :"+title);
			System.out.println("노래장르 :"+ genre);
			System.out.println("재생 시간 :"+ playTime);
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public double getPlayTime() {
			return playTime;
		}
		public void setPlayTime(double playTime) {
			this.playTime = playTime;
		}
	    
	
}
