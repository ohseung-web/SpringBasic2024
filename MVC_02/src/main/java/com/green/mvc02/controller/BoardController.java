package com.green.mvc02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.mvc02.dto.BoardDTO;

@Controller //나는 컨트롤러
public class BoardController {
   //아래 4개의 어노테이션은 모두 같은 의미이다.
   // 1.@RequestMapping(value="Board/view01")
   // 2.@RequestMapping("Board/view01")
   // 3.@RequestMapping(value="/Board/view01")
   // 4.@RequestMapping("/Board/view01")
	
    //폼에 입력한 자룔를 넎는다.
	// jsp 스타일 => HttpServletRquest 클래스 사용
	// @RequestMapping 에서 method를 사용하려면 반드시 value="view01"이 존재해야 함
	@RequestMapping(value="board/view01",method = RequestMethod.GET)
	public String goView01(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int hit = Integer.parseInt(request.getParameter("hit"));
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("hit", hit);
		
		return "board/Resultview01";
	}
	//===================================
	// 2.spring 스타일
	// @RequestParam("파라미터") 데이터형 저장할변수 선언
	// @RequestParam("name") String name
	// @RequestParam("hit") int hit
	
	@RequestMapping(value="/board/view02",method = RequestMethod.GET)
	//public String goView02(@RequestParam(name="title", required=true) String title) { //에러남
	public String goView02(@RequestParam(required=true) String title,
			@RequestParam("content") String content,
			@RequestParam("hit") int hit, Model model) {
			model.addAttribute("title", title);
			model.addAttribute("content", content);
			model.addAttribute("hit", hit);
			
			return "board/Resultview02";
	}
	
	//@ModelAtribute( )란 커멘트 객체의 이름을 변경할 수 있고
	//그 변경된 이름은 뷰에서 객체 참조할때 사용
	@RequestMapping(value="/board/view03",method = RequestMethod.GET)
	public String goView03(@ModelAttribute("b") BoardDTO bdto, Model model) {
      //	model.addAttribute("bdto", bdto);
		return "board/Resultview03";
	}
}


