package com.green.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.mvc03.dto.MemberDTO;

@Controller
//@RequestMapping("/member") 모든메서드의 상위폴더가 같아야 사용할 수 있다.
public class MemberController {
	
   //location.href='index'에 의해서 찾아 오는 곳	
   @RequestMapping(value="/index",method=RequestMethod.GET)
   public String goindex() {
	   return "index";//WEB-INF/views/index.jsp로 이동
   }
   
 //@RequestParam(value="id", required=true)일때 id값이 넘어오지 않으면 error가 출력됨
 //@RequestParam(value="id", required=false)일때 id값이 넘어오지 않아도 error가 출력되지 않음
 //@RequestParam(value="id", required=false, defaultValue="123")일때 id값이 넘어오지 않으면 defaultvalue의 값이 출력됨
   @RequestMapping(value="/member/login",method=RequestMethod.GET)
   public String goLogin(
		   @RequestParam(value="id", required=false, defaultValue="123") String id,
		   @RequestParam("pw") String pw,
		   Model model) {
	       model.addAttribute("id", id);
	       model.addAttribute("pw", pw);
	       return "member/loginResult";  
   }
   
   @RequestMapping(value="/member/login2",method=RequestMethod.POST)
   public String goLogin2(@ModelAttribute("m") MemberDTO mdto) {
	   return "member/loginResult2";
   }
}
