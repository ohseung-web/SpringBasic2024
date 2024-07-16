package com.green.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.test.dto.SimpleDTO02;
import com.green.test.service.SimpleServicetestImple;

@Controller
public class SimpletestController {

	@Autowired
	SimpleServicetestImple service;
	
	@RequestMapping("simpleListPage")
	public String simpleListPage(@ModelAttribute("sDTO") SimpleDTO02 sdto,  Model model) {
	    service.simpleInsert(sdto);
		return "simple/listPage2";
	}
}
