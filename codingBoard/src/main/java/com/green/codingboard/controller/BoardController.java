package com.green.codingboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.codingboard.dto.BoardDTO;
import com.green.codingboard.service.BoardServiceImpl;

@Controller
//@RequestMapping("/codingboard")
public class BoardController {

	@Autowired
	BoardServiceImpl bservice;
	
	// insertFrom���� �̵�
	@GetMapping("/insert")
	public String insertForm() {
		return "insert";
	}
	
	// insert ó��
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDTO bdto) {
		int insertResult = bservice.insert(bdto);
		if(insertResult > 0) {
			return "redirect:/boardlist";
		}else {
			return "insert";
		}
	}
	// �Խñ� ��ü ���
	@GetMapping("/boardlist")
	public String findAll(Model model) {
		List<BoardDTO> bdto = bservice.findAll();
		model.addAttribute("bdtoList", bdto);
		return "List";
	}
	
	// id = 1�� �ϳ��� �Խñ��� �˻�
	@GetMapping("/boardonelist")
	public String findById(@RequestParam("id") long id, Model model) {
		// ��ȸ�� �Խñ��� ��ȸ���� ����
		bservice.updateHits(id);
		BoardDTO bdto = bservice.findById(id);
		model.addAttribute("bdto", bdto);
		return "detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") long id) {
		bservice.delete(id);
		return "redirect:/boardlist/";
	}
	
	// ���� ������ �̵�
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") long id, Model model) {
		BoardDTO bdto = bservice.findById(id);
		model.addAttribute("bdto", bdto);
		return "update";
	}
	
	// ���� ó��
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO bdto, Model model) {
		bservice.update(bdto);
		BoardDTO boardbdto = bservice.findById(bdto.getId());
		model.addAttribute("bdto", boardbdto);
		return "detail";
	//	return "redirect:/codingboard/boardlist?id="+bdto.getId();
	}
}
