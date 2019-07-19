package com.cafe24.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.GalleryService;
import com.cafe24.mysite.vo.GalleryVO;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	@GetMapping("")
	public String index() {
		return "gallery/index";
	}
	
	@PostMapping("/upload")
	public @ResponseBody JSONResult upload(@ModelAttribute GalleryVO galleryVO) {
		return galleryService.insertImg(galleryVO) ? JSONResult.success("성공") : JSONResult.fail("실패");
	}
	
	@PostMapping("/list")
	public @ResponseBody JSONResult getList() {
		return JSONResult.success(galleryService.getList());
	}
}
