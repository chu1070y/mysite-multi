package com.cafe24.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.vo.UserVO;

@Controller
public class MainController {
	
	@RequestMapping({"/", "/main"})
	public String main() {
		
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "<h1>안녕하세여</h1>";
	}
	
	@ResponseBody
	@RequestMapping("/hello2")
	public UserVO hello2() {
		UserVO vo = new UserVO();
		vo.setNo(10L);
		vo.setName("누규?");
		vo.setEmail("aaa@aaa.com");
		
		return vo;
	}
}
