package com.cafe24.mysite.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cafe24.mysite.repository.UserDAO;
import com.cafe24.mysite.vo.UserVO;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDAO.get(username);
		
		SecurityUser securityUser = new SecurityUser();
		
		if(userVO != null) {
			securityUser.setNo(userVO.getNo());
			securityUser.setName(userVO.getName());              // biz data
			securityUser.setUsername(userVO.getEmail());         // principal data
			securityUser.setPassword(userVO.getPassword());
			securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userVO.getRole())));
		}
		
		return securityUser;
	}
}
