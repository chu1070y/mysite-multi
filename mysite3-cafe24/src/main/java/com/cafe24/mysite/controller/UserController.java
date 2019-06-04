package com.cafe24.mysite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.mysite.service.UserService;
import com.cafe24.mysite.vo.UserVO;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

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
		System.out.println("--------join post");
		System.out.println(result.hasErrors());
		
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

	@Auth
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@AuthUser UserVO userVO) { 
		
		if(userVO == null) {
			return "redirect:/user/login";
		}
		
		return "user/update";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute UserVO userVO, RedirectAttributes redirect) { 
		
		userService.updateUser(userVO);
		
		redirect.addFlashAttribute("update", "update");
		
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/auth", method = RequestMethod.POST)
	public void auth() {
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logout() {
	}
	


}
