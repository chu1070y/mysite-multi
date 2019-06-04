package com.cafe24.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.mysite.service.AdminService;
import com.cafe24.mysite.vo.SiteVO;
import com.cafe24.security.Auth;


@Auth(role=Auth.Role.ADMIN)
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping({"", "/main"})
	public String main(SiteVO vo, Model model) {
		
		vo = service.selectMain();
		
		model.addAttribute("siteVO", vo);
		
		return "admin/main";
	}
	
	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
	@PostMapping("/main/update")
	public String update(@ModelAttribute SiteVO vo) {
		System.out.println(vo);
		System.out.println("===========");
		service.insertMain(vo);
		
		return "redirect:/admin/main";
	}
}
