package com.green.codingboard.service;

import java.util.List;

import com.green.codingboard.dto.CommentDTO;

public interface CommentService {
	public void save(CommentDTO commentDTO); 
    public List<CommentDTO> findAll(Long boardId); 
}
