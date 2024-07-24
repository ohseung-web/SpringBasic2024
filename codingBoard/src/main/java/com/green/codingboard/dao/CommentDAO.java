package com.green.codingboard.dao;

import java.util.List;

import com.green.codingboard.dto.CommentDTO;

public interface CommentDAO {

	    public void save(CommentDTO commentDTO);

	    public List<CommentDTO> findAll(Long boardId);
}
