package com.cafe24.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.SiteVO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean insertMain(SiteVO vo) {
		
		int count = sqlSession.insert("admin.insertMain", vo);
		
		return 1 == count;
	}
	
	public SiteVO selectMain() {
		return sqlSession.selectOne("admin.selectMain");
	}
}
