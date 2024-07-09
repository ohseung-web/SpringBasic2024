package com.green.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.example.dto.MemberDTO;
import com.green.example.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	//회원가입 joinForm.jsp로 맵핑함
	@RequestMapping("/joinForm")
    public String joinForm() {
		return "/member/joinForm";
	}
	
	//회원가입 완료 joinFormOk.jsp로 맵핑함
	@RequestMapping(value="/joinFormOk", method = RequestMethod.POST )
	public String joinFormOk(@ModelAttribute("m") MemberDTO mdto) {
		service.memberJoin(mdto);
		return "/member/joinFormOk";
	}
	
	//로그인 화면 loginForm.jsp로 맵핑함
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	
	//로그인 상태를 session을 이용하여 유지시킨다.
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpSession session, @ModelAttribute("m") MemberDTO mdto,
			String toURL) {
		MemberDTO mem = service.memberSerch(mdto);
		//session.setAttribute()메서도를 이용하여 세션에 저장한다.
		session.setAttribute("mdto", mem);
		//return "/member/loginOk";
		//loginForm.jsp에서 넘어온 toRUL의 값이null이면 home으로 보내기
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		//return "redirect:/"; //HOME으로 이동
		return "redirect:" + toURL;
	}
	
	//로그아웃을 클릭하면 session을 삭제한다.
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();//session 삭제
		return "redirect:/";
	}
}
