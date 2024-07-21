package com.green.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.board.dao.BoardDAOImp;
import com.green.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAOImp bdao;
	
	@Override
	public int getCount() throws Exception {
		return bdao.count(); 
	}

	@Override
	public int remove(Integer bno, String writer) throws Exception {
		return bdao.delete(bno, writer);
	}

	@Override
	public int write(BoardDTO bdto) throws Exception {
		return bdao.insert(bdto);
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		return bdao.selectAll();
	}

	@Override
	public BoardDTO read(Integer bno) throws Exception {
		BoardDTO bdto = bdao.select(bno);
		bdao.increaseViewCnt(bno);
		return bdto ;
	}

	@Override
	public int modity(BoardDTO bdto) throws Exception {
		return bdao.update(bdto);
	}
	
	
	@Override
	public List<BoardDTO> getPage(Map map) throws Exception {
		return bdao.selectPage(map);
	}


}
