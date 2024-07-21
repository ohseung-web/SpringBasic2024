package com.green.codingboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.codingboard.dao.BoardDAOImpl;
import com.green.codingboard.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAOImpl bdao;
	
	@Override
	public int insert(BoardDTO bdto) {
		return bdao.insert(bdto);
	}

	@Override
	public List<BoardDTO> findAll() {
		return bdao.findAll();
	}

	@Override
	public BoardDTO findById(Long id) {
		return bdao.findById(id);
	}

	@Override
	public void updateHits(Long id) {
		bdao.updateHits(id);
	}

	@Override
	public void delete(Long id) {
		bdao.delete(id);
		
	}

	@Override
	public void update(BoardDTO bdto) {
		bdao.update(bdto);
	}

	@Override
	public List<BoardDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
