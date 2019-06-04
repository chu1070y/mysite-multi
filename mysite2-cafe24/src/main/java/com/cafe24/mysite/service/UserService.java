package com.cafe24.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.UserDAO;
import com.cafe24.mysite.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public Boolean joinUser(UserVO userVO) {
		
		return userDAO.insert(userVO);
	}

	public UserVO getUser(UserVO userVO) {
		
		return userDAO.get(userVO.getEmail(), userVO.getPassword());
	}
	
	public UserVO getUser(Long no) {
		
		return userDAO.get(no);
	}

	public Boolean updateUser(UserVO userVO) {
		
		return userDAO.update(userVO);
	}

	public Boolean existEmail(String email) {
		UserVO userVO = userDAO.get(email);
		return userVO != null;
	}

}
