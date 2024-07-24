package com.green.codingboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.codingboard.dto.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	@Override
	public void save(CommentDTO commentDTO) {
		sql.insert("Comment.save", commentDTO);
	}

	@Override
	public List<CommentDTO> findAll(Long boardId) {
		// TODO Auto-generated method stub
		return null;
	}

}
