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
		
		// session�� �̿��Ͽ� id, pw�� �����ϴ��� üũ�Ѵ�.
		// MemberController���� �α��� session.setAttribute("mdto",mem)�� ������ "�Ӽ��̸�" 
		// mdto�� session.getAttribute()�� �о���δ�. 
		MemberDTO mem = (MemberDTO) session.getAttribute("mdto");
		
		//�α��ε��� ���� �����̸� loginForm.jsp�� �̵�
		//null�� �ƹ��͵� �������� �ʴ´ٴ� ��
		//empty�� �׸��� �����ϳ� �� �ȿ� �ƹ��͵� ���ٴ� ��
		//loginForm.jsp�� get������� example/member/boardList�� URL�� ������.
//		if(mem == null || mem.getId().isEmpty() || mem.getPwd().isEmpty()) {
//			System.out.println("�Խ��� �ּ� :" + request.getRequestURL());
//			System.out.println("from :" + request.getHeader("referer"));
//			return "redirect:/member/loginForm?toURL=" + request.getRequestURL();
//		}else {
//			//�α��ε� �����̸� boardList.jsp�� �̵�
//			System.out.println("id:" + mem.getId());
//			return "/member/boardList";	
//		}
		
		return "/member/boardList";	
	}
	
}
