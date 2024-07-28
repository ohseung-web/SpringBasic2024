package com.green.replyboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.replyboard.dto.PageDTO;
import com.green.replyboard.dto.ReplyBoardDTO;
import com.green.replyboard.service.ReplyBoardServiceImpl;

@Controller
public class ReplyBoardController {

	@Autowired
	ReplyBoardServiceImpl rservice;
	
	@GetMapping("/")
	public String getList(Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page ) {
		List<ReplyBoardDTO> list= rservice.getList();
		// ��ü���ε�
		model.addAttribute("list", list); // Model
		List<ReplyBoardDTO> pagingList = rservice.pagingList(page);
		PageDTO pdto = rservice.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pdto);
		return "BoardList"; // View
 	}
	
	//BoardWriterForm ȭ������ �̵�
	@GetMapping("/register")
	public String registerForm() {
		return "BoardWriterForm";
	}
	
	//BoardWriterForm ó��
	@PostMapping("/register")
	public String register(ReplyBoardDTO rdto, Model model) { 
		rservice.register(rdto); // �Խù����(vo->idx, boardGroup)
		System.out.println(rdto);
		//rttr.addFlashAttribute("result", vo.getIdx()); // ${result}
		return "redirect:/";
	}
	
	// �ϳ��� �Խñ� ��������� �̵�
	@GetMapping("/detail")
	public String get(@RequestParam("num") int num, Model model) {
		// ��ȸ�� �Խñ��� ��ȸ���� ����
		rservice.readcount(num);
		ReplyBoardDTO rdto = rservice.get(num);
		model.addAttribute("rdto", rdto);
		return "BoardDetail"; // BoardDetail.jsp
	}
	
	
	@GetMapping("/paging")
	public String paging(Model model, 
			@RequestParam(value="page", required=false, defaultValue="1") int page ) {
		//System.out.println("page :" + page);
		//�ش� ���������� ������ �� ���
		List<ReplyBoardDTO> pagingList = rservice.pagingList(page);
		//System.out.println("pagingList :" + pagingList);
		PageDTO pdto = rservice.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pdto);
		return "BoardList";
	}
	
}
