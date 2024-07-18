package com.green.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.contact.dto.ContactDTO;
import com.green.contact.service.ContactServiceImp;

@Controller
@RequestMapping("contactP")
public class ContactController {
  
	@Autowired
	ContactServiceImp cservice;
	
	//insertPage�� �̵�
	@RequestMapping(value="/contactInsertPage", method = RequestMethod.GET)
	public String InsertPage() {
	   return "contactP/contactInsertPage";	
	}
	
	//���̺� insert �ϱ�
	@RequestMapping(value="/contactInsert", method = RequestMethod.POST)
	public String insert(@ModelAttribute ContactDTO cdto) {
		int insertRs = cservice.insert(cdto);
		if(insertRs >= 0) {
			return "redirect:/";
		}else {
			return "contactP/contactInsertPage";
		}
	}
	
	//��ü��� ���
	@RequestMapping(value="/contactListPage", method = RequestMethod.GET)
	public String findall(Model model) {
		List<ContactDTO> cDTO = cservice.findAll();
		model.addAttribute("cDTO", cDTO);
		return "contactP/contactListPage";
	}
	
	//���� �ѻ�� cNo=1 ȸ������ ã��
	@RequestMapping(value="/contactViewPage", method = RequestMethod.GET)
	public String findBycNo(@RequestParam("cNo") int cNo,  Model model) {
		ContactDTO cdto = cservice.selectContactBycNo(cNo);
		model.addAttribute("cDTO", cdto);
		return "contactP/contactViewPage";
	}
	
	//���� �ѻ�� ã�� ���� �����ϱ� 
	@RequestMapping(value="/contactUpdate", method = RequestMethod.POST)
	public String update(@ModelAttribute ContactDTO cdto, @RequestParam("cNo") int cNo) {
		boolean result = cservice.update(cdto);
		System.out.println(result);
		if(result == false) {
			return "redirect:/contactP/contactViewPage?cNo=" + cNo;
		}else {
			return "redirect:/";
		}
	}
	
	//�����ϱ�
	@RequestMapping(value="/contactDelete")
	public String delete(@RequestParam("cNo") int cNo) {
		cservice.delete(cNo);
		return "redirect:/contactP/contactListPage";
	}
}
