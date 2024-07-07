package com.green.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/*
		1. @RequestMapping == url-mapping이다
		       => 메소드를 대상으로 붙이는 어노테이션이다.
		2. value ="/" 컨텍스트 패스를 의미한다.
		3. http://localhost:8090/mvc02 이 주소가 입력되면 이  메소드를 실행한다.
		4. method
		     => RequestMethod.GET : 생략하면 GET방식이다.      
		     => RequestMethod.POST
		5. home 메소드
		    => 아무의미 없음, 아무 이유도 없음
		6. 매개변수로 사용
		     Model model : request 의 attribute 역할을 수행하는 클래스이다.
    */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );// 뷰로 전달하는 값
		
		return "home";  // 뷰의 이름을 린턴한 것이다.
		// servlet-context.xml에서 ViewResolver 가 정해놓은 값
		// prefix : //WEB-INF/views/ => 접두사로서 시작해라
		// suffix : .jsp  =>접미사로 끝내라
		// 실제로 리턴되는 값은 
		// return : "WEB-INF/views/home.jsp;
	}
	
	@RequestMapping(value="/success",method=RequestMethod.GET)
	public String success(Model model) {
		return "success";
	}
	
	/* 
	 * 매핑하는 여러가지 방법
	 * 주소창에 http://localhost:8090/mvc02/a/b/c/d 가 입력되면 view01.jsp로 이동되도록 한다.
	     @RequestMapping(value="/a/b/c/d")
	     @RequestMapping("/a/b/c/d")
	*/
	@RequestMapping("/a/b/c/d")
	public String goView01() {
		return "view01";
	}
	
	@RequestMapping("x/y/z")
	public String goLoginPage() {
		return "member/loginPage";  //WEB-INF/views/member/loginPage.jsp 이경로
	}
	
	
	/*
	   1. Model 클래스
	        - request의 attribute 역할을 수행하는 클래스이다.
	        - addAttribute(속성이름, 값)형식으로 사용한다.
	        
	    *비교
	    * JSP
	    * HttpServletRequest request : request.setAttribute(속성이름,값)  
	    
	    * Spring
	    * Model model :  model.addAttirbute(속성이름,값)
	    * Model은 매개변수로 선언한다 
	    * Controller -> View 로 이동할 때 전달 할 값이 있으면 무조건 Model을 사용한다.

	*/
	@RequestMapping("view02")
	public String goView02(Model model) {
		model.addAttribute("name","에밀리"); // 실제로 저장되는 공간은 request이다.
		model.addAttribute("age", "20");
		return "view02"; //WEB-INF/views/view02.jsp로 이동한다.
	}
	
	//view03.jsp로 이동하면
	//PersonDTO, ContextDTO 정보를 확인할 수있다.
	@RequestMapping("view03")
	public String goView03() {
		return "view03"; // WEB-INF/views/wiew03.jsp로 이동한다.
	}
	
	//ModelAndView 클래스
//	스프링 2.0이전에 사용하던 클래스로 현재 많이 생산되 코드이다.
//	Model과 View(jsp)를 모두 저장한다.
//	Model에 attribute 추가 : addObject()
//	View 추가 : SetViewName("View이름")
	@RequestMapping("v04") //실제 이동할 페이지의 Mapping과 일치하지 않기때문에 보안에 유리하다.
	public ModelAndView goView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view04");//view이름 
		return mav;
	}
	
	@RequestMapping("v05")
	public ModelAndView goView02() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "홍길동");//view로 보낼 데이터 값
		mav.addObject("age", 26);
		mav.setViewName("board/view05");//view이름 
		return mav;
	}
}
