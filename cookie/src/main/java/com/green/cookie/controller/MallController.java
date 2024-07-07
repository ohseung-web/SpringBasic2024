package com.green.cookie.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.cookie.dto.Mall;

@Controller
@RequestMapping("/mall")
public class MallController {
   
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		  return request.getContextPath();
	}
	
	// 쿠키 읽기
    // request.getCookie()를 이용하지 않고 @CookieValue()어노테이션을 이용할 수 있다.
	//annotation을 통해서 cookieValue를 손쉽게 가져올수 있다.
	@RequestMapping("/index")
	public String mallIndex(Mall malldto, 
			@CookieValue(value="gender",required=false) Cookie genderCookie) {
		
		if(genderCookie != null) {
			malldto.setGender(genderCookie.getValue());
		}
		
		return "/mall/index";
	}
	
	    // 쿠키 생성
		@RequestMapping("/main")
		public String mallMain(@ModelAttribute("m") Mall malldto, 
				HttpServletResponse response) {
			
			//쿠키를 genderCookie로 생성 Cookie("id", "abcd") => id="abcd"의 의미
			Cookie genderCookie = new Cookie("gender", malldto.getGender());
			
			//isCookieDel()메서드가 true이면 쿠키가 삭제되었다는 의미
			if(malldto.isCookieDel()) {
				genderCookie.setMaxAge(0);
				malldto.setGender(null);
			}else {
		 		//초 * 분 * 시 * 일 =>60*60*24*30 => 한달을 의미
				genderCookie.setMaxAge(60*60*24*30);
			}
			
			//쿠키 객체를 response에 담아서 보내준다.
			response.addCookie(genderCookie);
			System.out.println("쿠키값 :" + genderCookie.getValue());
			return "/mall/main";
		}
	
	
}
