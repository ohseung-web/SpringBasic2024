package com.green.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.board.dto.BoardDTO;
import com.green.board.service.BoardServiceImpl;

@Controller
public class BoardController {
    
	@Autowired
	BoardServiceImpl bservice;
	
	@GetMapping("/list")
	public String list(Integer page, Integer pageSize, Model model, HttpServletRequest request) {
		
		if(!loginCheck(request))
			return "redirect:/login/login?toURL="+request.getRequestURL();  // �α����� �������� �α��� ȭ������ �̵�
		
		
		if(page == null) page = 1;
		if(pageSize==null) pageSize = 10;
		
		 try {
			 
			 Map map = new HashMap();
			 map.put("offset", (page-1)*pageSize);
			 map.put("pageSize", pageSize);
				
			 List<BoardDTO> list = bservice.getPage(map);
			 model.addAttribute("list",list);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		return "boardList"; // �α����� �� �����̸�, �Խ��� ȭ������ �̵�
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. ������ ��
		HttpSession session = request.getSession();
		// 2. ���ǿ� id�� �ִ��� Ȯ��, ������ true�� ��ȯ
		return session.getAttribute("id")!=null;
	}
}
