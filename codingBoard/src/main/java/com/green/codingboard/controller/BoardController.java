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
	
	// index로 넘길때 페이징한 자료까지 같이 넘긴다.
	@GetMapping("/boardListpaging")
	public String goindex(Model model,
		@RequestParam(value="page", required=false, defaultValue="1") int page ) {
		//System.out.println("page :" + page);
		//해당 페이지에서 보여줄 글 목록
		List<BoardDTO> pagingList = bservice.pagingList(page);
		//System.out.println("pagingList :" + pagingList);
		PageDTO pdto = bservice.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pdto);
		
		model.addAttribute("section", "List.jsp");
		return "index";
	}
	
	// insertFrom으로 이동
	@GetMapping("/insert")
	public String insertForm() {
		return "insert";
	}
	
	// insert 처리
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDTO bdto) {
		int insertResult = bservice.insert(bdto);
		if(insertResult > 0) {
			// 글을 작성한 후에도 페이징으로 이동
			return "redirect:/paging";
		}else {
			return "insert";
		}
	}
	
	// 게시글 전체 목록
//	@GetMapping("/boardlist")
//	public String findAll(Model model) {
//		List<BoardDTO> bdto = bservice.findAll();
//		model.addAttribute("bdtoList", bdto);
//		return "List";
//	}
	
	// id = 1인 하나의 게시글을 검색
	@GetMapping("/boardonelist")
	public String findById(@RequestParam("id") long id, Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		// 조회된 게시글의 조회수가 증가
		bservice.updateHits(id);
		BoardDTO bdto = bservice.findById(id);
		model.addAttribute("bdto", bdto);
		//페이징 처리위한 코드
		model.addAttribute("page", page);
		return "detail";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") long id) {
		bservice.delete(id);
		return "redirect:/paging/";
	}
	
	// 수정 폼으로 이동
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") long id, Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		BoardDTO bdto = bservice.findById(id);
		model.addAttribute("bdto", bdto);
		//페이징 처리위한 코드
		model.addAttribute("page", page);
		return "update";
	}
	
	// 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO bdto, Model model) {
		bservice.update(bdto);
		BoardDTO boardbdto = bservice.findById(bdto.getId());
		model.addAttribute("bdto", boardbdto);
		return "detail";
       // return "redirect:/codingboard/boardlist?id="+bdto.getId();
	}		
	   
	// codingboard/paging?page=2
	// 처음 페이지 요청은 1페이지를 보여줌
	// @RequestParam을 이용하여 page=1이라는 초기값을 지정한다.
	// 페이지 요청이 없이 제일처음 페이지는 http://localhost:8090/codingboard/paging 는 page = 1이다.
	@GetMapping("/paging")
	public String paging(Model model, 
			@RequestParam(value="page", required=false, defaultValue="1") int page ) {
		//System.out.println("page :" + page);
		//해당 페이지에서 보여줄 글 목록
		List<BoardDTO> pagingList = bservice.pagingList(page);
		//System.out.println("pagingList :" + pagingList);
		PageDTO pdto = bservice.pagingParam(page);
		model.addAttribute("boardList", pagingList);
		model.addAttribute("paging", pdto);
		return "List";
	}
		
}