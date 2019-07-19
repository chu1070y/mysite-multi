package com.cafe24.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.dto.PageInfo;
import com.cafe24.mysite.security.AuthUser;
import com.cafe24.mysite.security.SecurityUser;
import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Model model, @ModelAttribute PageInfo pageInfo) {
		
		pageInfo.setTotalCount(service.getCount(pageInfo));
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("boardList", service.getList(pageInfo));
		
		return "board/list";
	}
	
	@GetMapping("/read/{no}")
	public String read(@PathVariable("no") Long no, Model model, BoardVO vo, @ModelAttribute PageInfo pageInfo) {
		
		// 페이지 정보 갖고오기
		vo = service.getBoard(no);
		
		// 다른 페이지 요청 제어
		if(vo == null) {
			return "error/404";
		}
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("board", vo);
		return "board/view";
	}
	
	@GetMapping("/write")
	public String write(Model model) {
		
		model.addAttribute("object", "write");
		
		return "board/write";
	}
	
	@GetMapping("/responseWrite")
	public String responseWrite(@RequestParam("no") Long no, @ModelAttribute PageInfo pageInfo, Model model) {
		
		model.addAttribute("object", "responseWrite");
		model.addAttribute("no", no);
		model.addAttribute("pageInfo",pageInfo);
		
		return "board/write";
	}
	
	@PostMapping("/write")
	public String writeBoard(@AuthUser SecurityUser securityUser, @ModelAttribute BoardVO vo, HttpSession session) {
		
		vo.setWriterNo(securityUser.getNo());
		
		service.writeBoard(vo);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/responseWrite")
	public String responseWrite(@AuthUser SecurityUser securityUser, @ModelAttribute BoardVO vo, HttpSession session) {
		
		vo.setWriterNo(securityUser.getNo());
		
		service.responseWrite(vo);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String delete(@AuthUser SecurityUser securityUser, @ModelAttribute BoardVO vo, HttpSession session, @ModelAttribute PageInfo pageInfo) {
		
		// 다른 회원 접근 제어
		if(vo.getWriterNo() != securityUser.getNo()) {
			return "redirect:/board/list?page=" + pageInfo.getPage();
		}
		
		service.delete(vo);
		
		return "redirect:/board/list?page=" + pageInfo.getPage();
	}
	
	@GetMapping("/modify/{no}")
	public String modify(@AuthUser SecurityUser securityUser, @PathVariable("no") Long no, @ModelAttribute PageInfo pageInfo,
			Model model, BoardVO vo, HttpSession session) {
		
		vo = service.getBoard(no);
		
		// 이상한 페이지 요청 제어
		if(vo == null) {
			return "error/404";
		}
		
		// 다른 회원 접근 제어
		if(vo.getWriterNo() != securityUser.getNo()) {
			return "redirect:/board/list";
		}
		
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("board", vo);
		
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modifyBoard(@AuthUser SecurityUser securityUser, @ModelAttribute BoardVO vo, @ModelAttribute PageInfo pageInfo, HttpSession session) {
		
		// 다른 회원 접근 제어
		if(vo.getWriterNo() != securityUser.getNo()) {
			return "redirect:/board/list";
		}
		
		service.modify(vo);
		
		return "redirect:/board/read/" + vo.getNo() + "?page=" + pageInfo.getPage() + "&kwd=" + pageInfo.getKwd();
	}
}
