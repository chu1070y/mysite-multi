package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.mysite.dto.PageInfo;
import com.cafe24.mysite.repository.BoardDAO;
import com.cafe24.mysite.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public List<BoardVO> getList(PageInfo pageInfo){
		
		boardDAO.countBoard(pageInfo);
		
		return boardDAO.getList(pageInfo);
	}
	
	public BoardVO getBoard(Long no) {
		return boardDAO.read(no);
	}
	
	public Boolean writeBoard(BoardVO vo) {
		return boardDAO.insert(vo);
	}
	
	public Boolean delete(BoardVO vo) {
		return boardDAO.delete(vo);
	}

	public Boolean modify(BoardVO vo) {
		return boardDAO.modify(vo);
	}

	@Transactional
	public Boolean responseWrite(BoardVO vo) {
		Boolean b1 = boardDAO.insertResponseUpdate(vo);
		System.out.println("1---" + b1);
		Boolean b2 = boardDAO.insertResponse(vo);
		System.out.println("2---" + b2);
		
		return b1 && b2;
	}

	public Boolean count(Long no) {
		return boardDAO.count(no);
	}

	public Integer getCount(PageInfo pageInfo) {
		return boardDAO.countBoard(pageInfo);
	}
	
}
