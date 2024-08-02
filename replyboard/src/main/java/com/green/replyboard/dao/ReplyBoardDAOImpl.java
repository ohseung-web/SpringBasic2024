package com.green.replyboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.replyboard.dto.PageDTO;
import com.green.replyboard.dto.ReplyBoardDTO;

@Repository
public class ReplyBoardDAOImpl implements ReplyBoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	@Override
	public List<ReplyBoardDTO> getList() {
		return sql.selectList("Rboard.getList");
	}

	@Override
	public void insert(ReplyBoardDTO rdto) {
		sql.insert("Rboard.insert", rdto);
	}

	@Override
	public void insertSelectKey(ReplyBoardDTO rdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReplyBoardDTO read(int num) {
		return sql.selectOne("Rboard.read", num);
	}

	@Override
	public void update(ReplyBoardDTO rdto) {
		sql.update("Rboard.update", rdto);
		
	}

	@Override
	public void delete(int num) {
		sql.delete("Rboard.delete", num);
	}

	@Override
	public void replySeqUpdate(ReplyBoardDTO parent) {
		sql.update("Rboard.replySeqUpdate", parent);
	}

	@Override
	public void replyInsert(ReplyBoardDTO rdto) {
		sql.insert("Rboard.replyInsert", rdto);
	}

	@Override
	public List<ReplyBoardDTO> pagingList(Map<String, Integer> pagingParams) {
		return sql.selectList("Rboard.pagingList", pagingParams);
	}

//	@Override
//	public int boardCount() {
//		return sql.selectOne("Rboard.boardcount");
//	}

	@Override
	public void readcount(int num) {
		sql.update("Rboard.readcount", num);
	}

	@Override
	public void replydelete(int ref) {
		sql.update("Rboard.replydelete", ref);
	}

	@Override
	public int boardCount(String searchType, String keyword) {
		HashMap<String, Object> data = new HashMap<String, Object>();
	    data.put("searchType", searchType);
	    data.put("keyword", keyword);
		return sql.selectOne("Rboard.boardcount", data);
	}

	// 검색에 해당하는 갯수
	@Override
	public int searchCount(String searchType, String keyword) {
		HashMap<String, Object> data = new HashMap<String, Object>();
	    data.put("searchType", searchType);
	    data.put("keyword", keyword);
		return sql.selectOne("Rboard.searchCount", data);
	}

//	검색기능때문에 추가한 기능
	@Override
	public List<ReplyBoardDTO> search(String searchType, String keyword) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
	    data.put("searchType", searchType);
	    data.put("keyword", keyword);
	    
		return sql.selectList("Rboard.search", data);
	}

}
