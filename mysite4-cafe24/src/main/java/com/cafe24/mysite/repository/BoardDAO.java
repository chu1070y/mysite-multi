package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.dto.PageInfo;
import com.cafe24.mysite.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVO> getList(PageInfo pageInfo){
		
		return sqlSession.selectList("board.selectList", pageInfo);

	}
	
	public Boolean insert(BoardVO vo) {
		
		int count = sqlSession.insert("board.insert", vo);
		
		return 1 == count;
	}

	public Boolean delete(BoardVO vo) {
		
		int count = sqlSession.update("board.delete", vo);
		
		return 1 == count;
	}

	public BoardVO read(Long no) {
		return sqlSession.selectOne("board.read", no);
	}

	public Boolean modify(BoardVO vo) {
		
		int count = sqlSession.update("board.modify", vo);
		
		return 1 == count;
	}

	public Boolean insertResponse(BoardVO vo) {
		
		int count = sqlSession.insert("board.insertResponse", vo);
		
		return 1 == count;
	}

	public Boolean insertResponseUpdate(BoardVO vo) {
		
		int count = sqlSession.insert("board.insertResponseUpdate", vo);
		
		return 1 == count;
		
	}

	public Boolean count(Long no) {
		
		int count = sqlSession.update("board.count", no);
		
		return 1 == count;
	}

	public Integer countBoard(PageInfo pageInfo) {
		return sqlSession.selectOne("board.countBoard", pageInfo);
	}

}
