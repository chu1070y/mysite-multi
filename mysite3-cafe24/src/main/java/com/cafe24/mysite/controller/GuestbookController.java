package com.cafe24.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVO;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<GuestbookVO> list = guestbookService.getList();
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
		
		guestbookService.addContent(guestbookVO);
		
		return "redirect:/guestbook/list";
	}
	
	@GetMapping("/delete/{no}")
	public String delete(Model model, @PathVariable("no") Long no) {
		
		model.addAttribute("no", no);
		
		return "guestbook/delete";
	}
	
	@PostMapping("/delete")
	public String delete(@ModelAttribute GuestbookVO guestbookVO, RedirectAttributes redirect) {
		
		if(guestbookService.deleteContent(guestbookVO)) {
			return "redirect:/guestbook/list";
		}
		
		redirect.addFlashAttribute("fail", "fail");
		return "redirect:/guestbook/delete/" + guestbookVO.getNo();
	}
	
	
}
