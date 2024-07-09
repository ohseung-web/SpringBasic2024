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
@RequestMapping("/member") //��� �������� ����� member�� ������
public class MemberController {
	
      @Autowired
      MemberService service;
      
     //	request.getContextPath()  = ������Ʈ Path (���ؽ�Ʈ path) �� �����´�.
     //	��)  http://localhost:8080/project/list.jsp
     //		[return] /project 
     // ��� ���� ��µǴ� request.getContextpath()�� /session�̴�. 
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
      
      //session���� �α��� ���� �����´�.
      @RequestMapping(value="/login", method=RequestMethod.POST)
      public String memLogin(Member member, HttpSession session) {
    	  // session.setAttribute()�� session�� ���� �������ش�.
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
      
      
      //�α׾ƿ� �ϸ� session �����Ѵ�.
      @RequestMapping("/logout")
      public String memLogout(Member member, HttpSession session) {
    	  session.invalidate();
    	  return "member/logoutOk";
      }
      
      //ȸ�� ���� ����
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
      
      //ȸ��Ż��(����)
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
      
      //MyPage�� �̵�
      @RequestMapping("/mypageForm")
      public String mypageForm(Model model, HttpSession session) {
    	  
    	 // ���� �α��ε� id�� pw session�� ����� ���� session.getAttribute()�� ������ mem��� ����Ѵ�.
    	 // �ݵ�� �ٿ�ĳ���� �ؾ� ��
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
      
    //board�� �̵�
      @RequestMapping("/bordForm")
      public String boardForm(HttpSession session) {
    	 // Member mem = (Member) session.getAttribute("member"); 
    	  return "/member/bordForm";		  
      }
}
