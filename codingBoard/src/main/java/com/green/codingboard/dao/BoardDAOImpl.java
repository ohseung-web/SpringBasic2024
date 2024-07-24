package com.green.codingboard.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.codingboard.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSessionTemplate sql;
	
	@Override
	public int insert(BoardDTO bdto) {
		return sql.insert("Board.insert", bdto);
	}

	@Override
	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}

	@Override
	public BoardDTO findById(Long id) {
		// 게시글 하나만 검색
		return sql.selectOne("Board.findById", id);
	}
	
	@Override
	public void updateHits(Long id) {
		sql.update("Board.updateHits", id);
		
	}

	@Override
	public void delete(Long id) {
		sql.delete("Board.delete", id);
		
	}

	@Override
	public void update(BoardDTO bdto) {
		sql.update("Board.update", bdto);
	}

	@Override
	public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
		return sql.selectList("Board.pagingList", pagingParams);
	}

	@Override
	public int boardCount() {
		return sql.selectOne("Board.boardcount");
	}

}
