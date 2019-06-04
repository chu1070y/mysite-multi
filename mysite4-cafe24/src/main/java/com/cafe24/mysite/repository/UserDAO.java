package com.cafe24.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.cafe24.mysite.exception.UserDAOException;
import com.cafe24.mysite.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVO get(String email) {
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		UserVO vo =  sqlSession.selectOne("user.getByEmail", email);
		
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		System.out.println(totalTime);
		
		return vo;
	}
	
	public Boolean update(UserVO vo) {
		int count = sqlSession.update("user.update",vo);
		return 1 == count;
	}
	
	// overloading
	public UserVO get(Long no){
		UserVO userVO = sqlSession.selectOne("user.getByNo", no);
		return userVO;
	}
	
	public UserVO get(String email, String password) throws UserDAOException{
			Map<String, String> map = new HashMap<String, String>();
			map.put("email", email);
			map.put("password", password);
			
			UserVO userVO = sqlSession.selectOne("user.getByEmailAndPassword", map);
			return userVO;
	}

	public Boolean insert(UserVO vo) {
		System.out.println(vo);
		int count = sqlSession.insert("user.insert",vo);
		System.out.println(vo);
		return 1 == count;
	}

}
