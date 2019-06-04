package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.GuestbookDAO;
import com.cafe24.mysite.vo.GuestbookVO;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDAO guestbookDAO;

	public List<GuestbookVO> getList() {
		
		return guestbookDAO.getList();
	}

	public Boolean addContent(GuestbookVO guestbookVO) {
		
		return guestbookDAO.insert(guestbookVO);
	}

	public Boolean deleteContent(GuestbookVO guestbookVO) {
		
		return guestbookDAO.delete(guestbookVO);		
	}
	
	

}
