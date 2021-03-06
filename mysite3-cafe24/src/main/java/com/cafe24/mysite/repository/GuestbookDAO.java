package com.cafe24.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.GuestbookVO;

@Repository
public class GuestbookDAO {
	private static int COUNT_PER_PAGE = 5;
	
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean delete(GuestbookVO vo) {
		int count = sqlSession.delete("guestbook.delete",vo);
		return 1 == count;
	}
	
	public Boolean insert(GuestbookVO vo) {
		int count = sqlSession.insert("guestbook.insert",vo);
		return 1 == count;
	}
	
	public List<GuestbookVO> getList(){
		return sqlSession.selectList("guestbook.getList");
	}
	
	public List<GuestbookVO> getList(Long lastNo){
		List<GuestbookVO> result = 
				sqlSession.selectList( "guestbook.getList2", lastNo );
		return result;
	}	
}
