package com.cafe24.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cafe24.mysite.vo.GuestbookVO;

@Service
public class GuestbookService2 {

	public List<GuestbookVO> getContentsList(Long i) {
		GuestbookVO first = new GuestbookVO(1L, "user1", "1234", "test1", "2019-07-10 12:00:15");
		GuestbookVO second = new GuestbookVO(2L, "user2", "1234", "test2", "2019-07-10 12:00:55");		
	
		List<GuestbookVO> list = new ArrayList<GuestbookVO>();
		list.add(first);
		list.add(second);
		
		return list;
	}

	public GuestbookVO addContents(GuestbookVO guestbookVO) {
		guestbookVO.setNo(10L);
		guestbookVO.setRegDate("2019-07-10 00:00:00");
		
		return null;
	}

	public Long deleteContents(Long no, String password) {
		return no;
	}
	
	
}
