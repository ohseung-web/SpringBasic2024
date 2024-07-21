package com.green.member03.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.member03.dto.Member03DTO;
import com.green.member03.service.Member03service;

@Controller
//@RequestMapping("/member03")
public class Member03Controller {
	
	@Autowired
	Member03service memService;
	
	@RequestMapping(value="/save",method = RequestMethod.GET)
	public String saveForm() {
		return "save";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("m") Member03DTO memberDTO) {
        int saveResult = memService.save(memberDTO);
        if (saveResult > 0) {
            return "saveOk";
        } else {
            return "save";
        }
    }

	//로그인 페이지로 이동
	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}
	
    //로그인 처리하는 메서드
	@RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@ModelAttribute Member03DTO memberDTO,
                        HttpSession session) {
        boolean loginResult = memService.login(memberDTO);
        if (loginResult) {
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        } else {
            return "login";
        }
    }
	
	//전체 목록 출력
	@RequestMapping(value="/list", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Member03DTO> memberDTOList = memService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

	// 조회/member?id=1
    @RequestMapping(value="/detail",method=RequestMethod.GET)
    public String findById(@RequestParam("id") Long id, Model model) {
        Member03DTO memberDTO = memService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }
    
    //삭제
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String delete(@RequestParam("id") Long id) {
    	memService.delete(id);
        return "redirect:/list";
    }
    
   // 수정화면 요청
    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        // 세션에 저장된 나의 이메일 가져오기
        String loginEmail = (String) session.getAttribute("loginEmail");
        Member03DTO memberDTO = memService.findByMemberEmail(loginEmail);
        model.addAttribute("member", memberDTO);
        return "update";
    }

    // 수정 처리
    @PostMapping("/update")
    public String update(@ModelAttribute Member03DTO memberDTO) {
        boolean result = memService.update(memberDTO);
        if (result) {
            return "redirect:/list?id=" + memberDTO.getId();
        } else {
            return "index";
        }
    }
}
