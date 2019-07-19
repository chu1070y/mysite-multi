package com.cafe24.mysite.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.mysite.config.AppConfig;
import com.cafe24.mysite.config.TestWebConfig;
import com.cafe24.mysite.vo.UserVO;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.build();
	}
	
	@Test
	public void testUserJoin() throws Exception {
		UserVO userVO = new UserVO();
		
		//1. Normal User`s Join Data
		userVO.setName("추추");
		userVO.setEmail("aaa@naver.com");
		userVO.setPassword("1234152zz");
		userVO.setGender("MALE");
		
		ResultActions resultActions = mockMvc.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVO)));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		;
	}
	
	@Test
	public void testUserLogin() throws Exception {
		UserVO userVO = new UserVO();
		
		//1. Normal User`s Join Data
		userVO.setEmail("");
		userVO.setPassword("1234152zz");
		
		ResultActions resultActions = mockMvc.perform(post("/api/user/login")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVO)));
		
		resultActions
		.andDo(print())
		;
	}
	
}
