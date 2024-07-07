package com.green.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	/*
		1. @RequestMapping == url-mapping�̴�
		       => �޼ҵ带 ������� ���̴� ������̼��̴�.
		2. value ="/" ���ؽ�Ʈ �н��� �ǹ��Ѵ�.
		3. http://localhost:8090/mvc02 �� �ּҰ� �ԷµǸ� ��  �޼ҵ带 �����Ѵ�.
		4. method
		     => RequestMethod.GET : �����ϸ� GET����̴�.      
		     => RequestMethod.POST
		5. home �޼ҵ�
		    => �ƹ��ǹ� ����, �ƹ� ������ ����
		6. �Ű������� ���
		     Model model : request �� attribute ������ �����ϴ� Ŭ�����̴�.
    */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );// ��� �����ϴ� ��
		
		return "home";  // ���� �̸��� ������ ���̴�.
		// servlet-context.xml���� ViewResolver �� ���س��� ��
		// prefix : //WEB-INF/views/ => ���λ�μ� �����ض�
		// suffix : .jsp  =>���̻�� ������
		// ������ ���ϵǴ� ���� 
		// return : "WEB-INF/views/home.jsp;
	}
	
	@RequestMapping(value="/success",method=RequestMethod.GET)
	public String success(Model model) {
		return "success";
	}
	
	/* 
	 * �����ϴ� �������� ���
	 * �ּ�â�� http://localhost:8090/mvc02/a/b/c/d �� �ԷµǸ� view01.jsp�� �̵��ǵ��� �Ѵ�.
	     @RequestMapping(value="/a/b/c/d")
	     @RequestMapping("/a/b/c/d")
	*/
	@RequestMapping("/a/b/c/d")
	public String goView01() {
		return "view01";
	}
	
	@RequestMapping("x/y/z")
	public String goLoginPage() {
		return "member/loginPage";  //WEB-INF/views/member/loginPage.jsp �̰��
	}
	
	
	/*
	   1. Model Ŭ����
	        - request�� attribute ������ �����ϴ� Ŭ�����̴�.
	        - addAttribute(�Ӽ��̸�, ��)�������� ����Ѵ�.
	        
	    *��
	    * JSP
	    * HttpServletRequest request : request.setAttribute(�Ӽ��̸�,��)  
	    
	    * Spring
	    * Model model :  model.addAttirbute(�Ӽ��̸�,��)
	    * Model�� �Ű������� �����Ѵ� 
	    * Controller -> View �� �̵��� �� ���� �� ���� ������ ������ Model�� ����Ѵ�.

	*/
	@RequestMapping("view02")
	public String goView02(Model model) {
		model.addAttribute("name","���и�"); // ������ ����Ǵ� ������ request�̴�.
		model.addAttribute("age", "20");
		return "view02"; //WEB-INF/views/view02.jsp�� �̵��Ѵ�.
	}
	
	//view03.jsp�� �̵��ϸ�
	//PersonDTO, ContextDTO ������ Ȯ���� ���ִ�.
	@RequestMapping("view03")
	public String goView03() {
		return "view03"; // WEB-INF/views/wiew03.jsp�� �̵��Ѵ�.
	}
	
	//ModelAndView Ŭ����
//	������ 2.0������ ����ϴ� Ŭ������ ���� ���� ����� �ڵ��̴�.
//	Model�� View(jsp)�� ��� �����Ѵ�.
//	Model�� attribute �߰� : addObject()
//	View �߰� : SetViewName("View�̸�")
	@RequestMapping("v04") //���� �̵��� �������� Mapping�� ��ġ���� �ʱ⶧���� ���ȿ� �����ϴ�.
	public ModelAndView goView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view04");//view�̸� 
		return mav;
	}
	
	@RequestMapping("v05")
	public ModelAndView goView02() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "ȫ�浿");//view�� ���� ������ ��
		mav.addObject("age", 26);
		mav.setViewName("board/view05");//view�̸� 
		return mav;
	}
}
