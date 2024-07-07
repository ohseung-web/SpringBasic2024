package com.green.cookie.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
   

	// ��Ű�� ����
	@RequestMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		//logger.info("��Ű ����");
		Cookie cookie = new Cookie("useremail","blueskii");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		// 30�ʰ� ����
		cookie.setMaxAge(30*60);
		cookie.setSecure(true);
		response.addCookie(cookie);
		
		return "cookie";
	}
	
	//��Ű �б�
	@RequestMapping("/getCookie1")
	public String getCookie1(@CookieValue String useremail, @CookieValue("useremail") String umail) {
	//	logger.info("����");
	//	logger.info(umail);
		return "cookie";
	}
}
