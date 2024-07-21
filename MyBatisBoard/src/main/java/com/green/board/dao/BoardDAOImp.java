package com.green.board.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.board.dto.BoardDTO;

@Repository
public class BoardDAOImp implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	@Override
	public int insert(BoardDTO bdto) throws Exception {
		// mapper namespace : Board
		return sql.insert("Board.insert", bdto);
	}

	@Override
	public int update(BoardDTO bdto) throws Exception {
		return sql.update("Board.update", bdto);
	}

	@Override
	public BoardDTO select(Integer bno) throws Exception {
		return sql.selectOne("Board.select", bno);
	}

	@Override
	public int increaseViewCnt(Integer bno) throws Exception {
		return sql.update("Board.increaseViewCnt", bno);
	}

	@Override
	public List<BoardDTO> selectAll() throws Exception {
		return sql.selectList("Board.selectAll");
	}

	@Override
	public int deleteAll() throws Exception {
		return sql.delete("Board.deleteAll");
	}

	@Override
	public int count() throws Exception {
		return sql.selectOne("Board.count");
	}

	@Override
	public int delete(Integer bno, String writer) throws Exception {
		Map map = new HashMap();
		map.put("bno", bno);
		map.put("writer", writer);
		return sql.delete("Board.delete", map);
	}

	@Override
	public List<BoardDTO> selectPage(Map map) throws Exception {
		return sql.selectList("Board.selectPage", map);
	}

}
