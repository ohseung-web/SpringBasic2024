package com.green.session.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.green.session.dto.Member;
import com.green.session.service.MemberService;

@Controller
@RequestMapping("/member") //모든 공통적인 경로인 member를 지정함
public class MemberController {
	
      @Autowired
      MemberService service;
      
     //	request.getContextPath()  = 프로젝트 Path (컨텍스트 path) 만 가져온다.
     //	예)  http://localhost:8080/project/list.jsp
     //		[return] /project 
     // 고로 현재 출력되는 request.getContextpath()는 /session이다. 
      @ModelAttribute("cp")
  	   public String getContextPath(HttpServletRequest request) {
    	  System.out.println("path :" + request.getContextPath());
    	  return request.getContextPath();
  	   }
      
      //join
      @RequestMapping(value="/joinForm")
      public String joinForm(Member member){
    	  return "member/joinForm";
      }
      
      @RequestMapping(value="/join", method=RequestMethod.POST)
      public String joinReg(Member member) {
    	  service.memberRegister(member);
    	  return "member/joinOk";
      }
      
      //Login
      @RequestMapping("/loginForm")
      public String loginFrom(Member member) {
    	  return "member/loginForm";
      }
      
      //session으로 로그인 정보 가져온다.
      @RequestMapping(value="/login", method=RequestMethod.POST)
      public String memLogin(Member member, HttpSession session) {
    	  // session.setAttribute()는 session에 값을 저장해준다.
    	  Member mem = service.memberSearch(member);
    	  if(mem == null) {
    		  return "member/loginForm";
    	  }
    	  session.setAttribute("member", mem);
    	  System.out.println("member1 : "+ member.getMemId());
    	  return "member/loginOk";
      }
      
      /*
  	@RequestMapping(value = "/login", method = RequestMethod.POST)
  	public String memLogin(Member member, HttpServletRequest request) {
  		
  		Member mem = service.memberSearch(member);
  		
  		HttpSession session = request.getSession();
  		session.setAttribute("member", mem);
  		
  		return "/member/loginOk";
  	}
  	*/
      
      
      //로그아웃 하면 session 삭제한다.
      @RequestMapping("/logout")
      public String memLogout(Member member, HttpSession session) {
    	  session.invalidate();
    	  return "member/logoutOk";
      }
      
      //회원 정보 수정
      @RequestMapping(value="/modifyForm")
      public String modifyForm(HttpServletRequest request, Model model) {
    	  
    	  HttpSession session = request.getSession();
  		  Member member = (Member) session.getAttribute("member");
  		
  		if(null == member) {
  			return "redirect:/";
  		} else {
  			model.addAttribute("member", service.memberSearch(member));
  		}
  		
  		return "/member/modifyForm";
    	  
      }
      
      @RequestMapping(value = "/modify", method = RequestMethod.POST)
  	  public ModelAndView modify(Member member, HttpServletRequest request) {
  		
  		ModelAndView mav = new ModelAndView();
  		HttpSession session = request.getSession();
  		
  		Member mem = service.memberModify(member);
  		if(mem == null) {
  			mav.setViewName("/member/modifyForm");
  		} else { 
  			session.setAttribute("member", mem);
  			
  			mav.addObject("memAft", mem);
  			mav.setViewName("/member/modifyOk");
  		}
  		
  		return mav;
  	 }
      
      //회원탈퇴(삭제)
      @RequestMapping("/removeForm")
      public ModelAndView removeForm(HttpServletRequest request) {
    	  
    	ModelAndView mav = new ModelAndView();
  		
  		HttpSession session =  request.getSession();
  		Member member = (Member) session.getAttribute("member");
  		
  		mav.addObject("member", member);
  		mav.setViewName("/member/removeForm");
  		
  		return mav;
      }
      
      @RequestMapping(value = "/remove", method = RequestMethod.POST)
  	  public String memRemove(Member member, HttpServletRequest request) {
  		
  		int result = service.memberRemove(member);
  		
  		if(result == 0)
  			return "/member/removeForm";
  		
  		HttpSession session = request.getSession();
  		session.invalidate();
  		
  		return "/member/removeOk";
  	 }
      
      //MyPage로 이동
      @RequestMapping("/mypageForm")
      public String mypageForm(Model model, HttpSession session) {
    	  
    	 // 현재 로그인된 id와 pw session의 저장된 값을 session.getAttribute()로 꺼내서 mem담아 사용한다.
    	 // 반드시 다운캐스팅 해야 함
    	 // Member mem = (Member) session.getAttribute("member"); 
//       
//    	  if(mem == null) {
//    		  return "redirect:/member/loginForm";
//    	  }else {
//    		  model.addAttribute("memId", mem.getMemId());
//    		  System.out.println(mem.getMemId());
//    	  }
    	  
		return "/member/mypageForm";
    	  
      }
      
    //board로 이동
      @RequestMapping("/bordForm")
      public String boardForm(HttpSession session) {
    	 // Member mem = (Member) session.getAttribute("member"); 
    	  return "/member/bordForm";		  
      }
}
