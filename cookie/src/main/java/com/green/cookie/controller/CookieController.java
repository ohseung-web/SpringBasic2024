package com.green.cookie.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
   

	// 쿠키를 생성
	@RequestMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		//logger.info("쿠키 생성");
		Cookie cookie = new Cookie("useremail","blueskii");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		// 30초간 저장
		cookie.setMaxAge(30*60);
		cookie.setSecure(true);
		response.addCookie(cookie);
		
		return "cookie";
	}
	
	//쿠키 읽기
	@RequestMapping("/getCookie1")
	public String getCookie1(@CookieValue String useremail, @CookieValue("useremail") String umail) {
	//	logger.info("실행");
	//	logger.info(umail);
		return "cookie";
	}
}
