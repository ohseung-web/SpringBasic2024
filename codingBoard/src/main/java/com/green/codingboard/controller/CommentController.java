package com.green.codingboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.codingboard.dto.CommentDTO;
import com.green.codingboard.service.CommentServiceImpl;

@Controller
//@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentServiceImpl comservice;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO comDTO){
		System.out.println("commentDTO :" + comDTO);
		comservice.save(comDTO);
		/*
		 * commentService.save(commentDTO); // 해당 게시글에 작성된 댓글 리스트를 가져옴 List<CommentDTO>
		 * commentDTOList = commentService.findAll(commentDTO.getBoardId()); return
		 * commentDTOList;
		 */
		return null;
	}
	
}
