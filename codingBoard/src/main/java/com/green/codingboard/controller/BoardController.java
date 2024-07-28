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
import com.green.codingboard.dto.PageDTO;
import com.green.codingboard.service.BoardServiceImpl;

@Controller
//@RequestMapping("/codingboard")
public class BoardController {

	@Autowired
	BoardServiceImpl bservice;
	
	// index�� �ѱ涧 ����¡�� �ڷ���� ���� �ѱ��.
	@GetMapping("/boardListpaging")
	public String goindex(Model model,
		@RequestParam(value="page", required=false, defaultValue="1") int page ) {
		//System.out.println("page :" + page);
		//�ش� ���������� ������ �� ���
		List<BoardDTO> pagingList = bservice.pagingList(page);
		//System.out.println("pagingList :" + pagingList);
		PageDTO pdto = bservice.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pdto);
		
		model.addAttribute("section", "List.jsp");
		return "index";
	}
	
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
			// ���� �ۼ��� �Ŀ��� ����¡���� �̵�
			return "redirect:/paging";
		}else {
			return "insert";
		}
	}
	
	// �Խñ� ��ü ���
//	@GetMapping("/boardlist")
//	public String findAll(Model model) {
//		List<BoardDTO> bdto = bservice.findAll();
//		model.addAttribute("bdtoList", bdto);
//		return "List";
//	}
	
	// id = 1�� �ϳ��� �Խñ��� �˻�
	@GetMapping("/boardonelist")
	public String findById(@RequestParam("id") long id, Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		// ��ȸ�� �Խñ��� ��ȸ���� ����
		bservice.updateHits(id);
		BoardDTO bdto = bservice.findById(id);
		model.addAttribute("bdto", bdto);
		//����¡ ó������ �ڵ�
		model.addAttribute("page", page);
		return "detail";
	}
	
	// ����
	@GetMapping("/delete")
	public String delete(@RequestParam("id") long id) {
		bservice.delete(id);
		return "redirect:/paging/";
	}
	
	// ���� ������ �̵�
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") long id, Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		BoardDTO bdto = bservice.findById(id);
		model.addAttribute("bdto", bdto);
		//����¡ ó������ �ڵ�
		model.addAttribute("page", page);
		return "update";
	}
	
	// ���� ó��
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO bdto, Model model) {
		bservice.update(bdto);
		BoardDTO boardbdto = bservice.findById(bdto.getId());
		model.addAttribute("bdto", boardbdto);
		return "detail";
       // return "redirect:/codingboard/boardlist?id="+bdto.getId();
	}		
	   
	// codingboard/paging?page=2
	// ó�� ������ ��û�� 1�������� ������
	// @RequestParam�� �̿��Ͽ� page=1�̶�� �ʱⰪ�� �����Ѵ�.
	// ������ ��û�� ���� ����ó�� �������� http://localhost:8090/codingboard/paging �� page = 1�̴�.
	@GetMapping("/paging")
	public String paging(Model model, 
			@RequestParam(value="page", required=false, defaultValue="1") int page ) {
		//System.out.println("page :" + page);
		//�ش� ���������� ������ �� ���
		List<BoardDTO> pagingList = bservice.pagingList(page);
		//System.out.println("pagingList :" + pagingList);
		PageDTO pdto = bservice.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pdto);
		return "List";
	}
		
}