package com.green.replyboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.replyboard.dto.PageDTO;
import com.green.replyboard.dto.ReplyBoardDTO;
import com.green.replyboard.service.ReplyBoardServiceImpl;

@Controller
public class ReplyBoardController {

	@Autowired
	ReplyBoardServiceImpl rservice;
	
	//@GetMapping("/") //검색에서 넘어오는 type와 keyword를 PageDTO에 담아주기
	@RequestMapping(value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public String getList(Model model, PageDTO pdto,
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value = "searchType",required = false, defaultValue = "") String searchType,
			@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) {
		
		List<ReplyBoardDTO> pagingList = rservice.pagingList(page);
		System.out.println(searchType);
		System.out.println(keyword);
		
//		List<ReplyBoardDTO> searchList = rservice.search(searchType, keyword); 
//		model.addAttribute("slist", searchList);
		
		pdto = rservice.pagingParam(page);
	    model.addAttribute("boardList", pagingList);
	    model.addAttribute("paging", pdto);

		return "BoardList"; // View
		
//		List<ReplyBoardDTO> list= rservice.getList();
//		// 객체바인딩
//		model.addAttribute("list", list); // Model
	
 	}
	
	//BoardWriterForm 화면으로 이동
	@GetMapping("/register")
	public String registerForm() {
		return "BoardWriterForm";
	}
	
	//BoardWriterForm 처리
	@PostMapping("/register")
	public String register(ReplyBoardDTO rdto, Model model) { 
		rservice.register(rdto); // 게시물등록(vo->idx, boardGroup)
		System.out.println(rdto);
		return "redirect:/";
	}
	
	// 하나의 게시글 정보보기로 이동
	@GetMapping("/detail")
	public String get(@RequestParam("num") int num, Model model,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		// 조회된 게시글의 조회수가 증가
		rservice.readcount(num);
		ReplyBoardDTO rdto = rservice.get(num);
		model.addAttribute("rdto", rdto);
		
		PageDTO pdto = rservice.pagingParam(page);
		model.addAttribute("paging", pdto);
		return "BoardDetail"; // BoardDetail.jsp
	}
	
	// 하나의 게시글을 수정하는 화면으로 이동
	@GetMapping("/modify")
	public String modifyForm(@RequestParam("num") int num, Model model) {
		ReplyBoardDTO rdto = rservice.get(num);
		model.addAttribute("rdto", rdto);
		return "BoardUpdateForm"; //BoardUpdateForm.jsp
	}
	
	//하나의 게시글을 수정처리
	@PostMapping("/modify")
	public String modify(ReplyBoardDTO rdto) {
		 rservice.modify(rdto);
		return "redirect:/"; // list main화면으로 이동
	}
	
	//하나의 게시글을 삭제
	@GetMapping("/remove")
	public String remove(@RequestParam("num") int num,
			@RequestParam("ref") int ref) {
		rservice.remove(num);
//		rservice.repyRemove(ref);
		return "redirect:/"; // 삭제하고 main으로 이동
	}
	
	//답글 작성하는 화면으로 이동
	@GetMapping("/reply")
	public String replyForm(@RequestParam("num") int num, 
			 @RequestParam("ref") int ref,
			 @RequestParam("re_step") int re_step,
			 @RequestParam("re_level") int re_level,Model model) {
		
		//ReplyBoardDTO rdto = rservice.get(num);
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_level", re_level);
		
		return "BoardReWriteForm"; // BoardReWriteForm.jsp로 이동
	}
	
	//답글 작성 처리
	@PostMapping("/reply")
	public String reply(ReplyBoardDTO rdto) {
		 rservice.replyProcess(rdto);
		return "redirect:/"; //답글 저장하고 maim으로 이동
	}
	
	
//	@GetMapping("/paging")
//	public String paging(Model model, 
//			@RequestParam(value="page", required=false, defaultValue="1") int page ) {
//		//System.out.println("page :" + page);
//		//해당 페이지에서 보여줄 글 목록
//		List<ReplyBoardDTO> pagingList = rservice.pagingList(page);
//		//System.out.println("pagingList :" + pagingList);
//		PageDTO pdto = rservice.pagingParam(page);
//		model.addAttribute("boardList", pagingList);
//		model.addAttribute("paging", pdto);
//		return "BoardList";
//	}
	
}
