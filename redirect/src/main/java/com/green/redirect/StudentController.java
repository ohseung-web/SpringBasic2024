package com.green.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    
	@RequestMapping(value="/student1")
	public String student1(HttpServletRequest request, Model model) {
		String a = request.getParameter("a");
		model.addAttribute("a", a);
		model.addAttribute("b", 98);
		return "redirect:student2";
	}
	
	@RequestMapping(value="/student2")
	public String student2(@RequestParam("a") String a, 
			     @RequestParam("b") String b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("c", 99);
		return ("student/student2");
	}
}
