package com.green.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.example.dto.MemberDTO;
import com.green.example.service.MemberService;

@Controller
@RequestMapping("/member")
public class BoardController {

	@Autowired
	MemberService service;
	
	@RequestMapping("/boardList")
	public String boardList(HttpSession session, Model model,
			HttpServletRequest request) {
		
		// session을 이용하여 id, pw가 존재하는지 체크한다.
		// MemberController에서 로그인 session.setAttribute("mdto",mem)로 저장한 "속성이름" 
		// mdto를 session.getAttribute()로 읽어들인다. 
		MemberDTO mem = (MemberDTO) session.getAttribute("mdto");
		
		//로그인되지 않은 상태이면 loginForm.jsp로 이동
		//null은 아무것도 존재하지 않는다는 뜻
		//empty는 그릇은 존재하나 그 안에 아무것도 없다는 뜻
		//loginForm.jsp에 get방식으로 example/member/boardList의 URL을 보낸다.
//		if(mem == null || mem.getId().isEmpty() || mem.getPwd().isEmpty()) {
//			System.out.println("게시판 주소 :" + request.getRequestURL());
//			System.out.println("from :" + request.getHeader("referer"));
//			return "redirect:/member/loginForm?toURL=" + request.getRequestURL();
//		}else {
//			//로그인된 상태이면 boardList.jsp로 이동
//			System.out.println("id:" + mem.getId());
//			return "/member/boardList";	
//		}
		
		return "/member/boardList";	
	}
	
}
