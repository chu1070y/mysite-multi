package com.cafe24.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.mysite.security.AuthUser;
import com.cafe24.mysite.security.SecurityUser;
import com.cafe24.mysite.service.UserService;
import com.cafe24.mysite.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVO userVO) { 
		
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute @Valid UserVO userVO,
			BindingResult result, Model model) { 
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println(error);
			}
			
			return "user/join";
		}
		
		model.addAllAttributes(result.getModel());
		
		userService.joinUser(userVO);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping(value="/joinsuccess", method=RequestMethod.GET)
	public String joinSuccess() { 
		
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() { 
		
		return "user/login";
	}

	@RequestMapping( value="/update", method=RequestMethod.GET )
	public String update(
		@AuthUser SecurityUser securityUser,
		Model model ){
		
		UserVO userVO = userService.getUser( securityUser.getNo() );
		
		model.addAttribute( "authUser", userVO );
		
		return "user/update";
	}
	
	@RequestMapping( value="/update", method=RequestMethod.POST )
	public String update( HttpSession session, @ModelAttribute UserVO userVo ){
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/";
		}
		
		userVo.setNo( authUser.getNo() );
		userService.updateUser( userVo );
		
		// session의 authUser 변경
		authUser.setName(userVo.getName());
		
		return "redirect:/user/update?result=success";
	}
	
//	@RequestMapping(value="/auth", method = RequestMethod.POST)
//	public void auth() {
//	}
//	
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public void logout() {
//	}
	


}
