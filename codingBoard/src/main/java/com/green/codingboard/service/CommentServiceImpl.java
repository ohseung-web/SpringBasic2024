package com.green.codingboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.codingboard.dao.CommentDAOImpl;
import com.green.codingboard.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentDAOImpl comdao;
	
	@Override
	public void save(CommentDTO commentDTO) {
		comdao.save(commentDTO);
	}

	@Override
	public List<CommentDTO> findAll(Long boardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
