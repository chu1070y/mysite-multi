package com.cafe24.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.AdminDAO;
import com.cafe24.mysite.vo.SiteVO;

@Service
public class AdminService {
	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private FileUploadService service;

	public Boolean insertMain(SiteVO vo) {
		
		vo.setProfile(service.restore(vo.getMultipartFile()));
		
		return dao.insertMain(vo);
	}

	public SiteVO selectMain() {
		
		return dao.selectMain();
	}
	
	
}
