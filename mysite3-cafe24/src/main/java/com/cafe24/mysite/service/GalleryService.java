package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.GalleryDAO;
import com.cafe24.mysite.vo.GalleryVO;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	public Boolean insertImg(GalleryVO vo) {
		
		vo.setImg(fileUploadService.restore(vo.getMultipartFile()));
		
		return galleryDAO.insertImg(vo);
	}
	
	public List<GalleryVO> getList(){
		return galleryDAO.getList();
	}

}
