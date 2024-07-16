package com.example.member03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member03")
public class MemberController03 {
   
	@RequestMapping("/save")
	public String saveForm() {
		return "save";
	}
}
