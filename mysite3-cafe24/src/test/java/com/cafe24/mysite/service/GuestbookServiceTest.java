package com.cafe24.mysite.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.mysite.config.AppConfig;
import com.cafe24.mysite.config.TestWebConfig;
import com.cafe24.mysite.vo.GuestbookVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class GuestbookServiceTest {
	
	@Autowired
	private GuestbookService guestbookService;

	@Test
	public void testGuestbookServiceDI() {
		assertNotNull(guestbookService);
	}
	
	@Test
	public void testGetContentList() {
		List<GuestbookVO> list = guestbookService.getList();
		//assertArrayEquals(list);
	}
	
	@Test
	public void testWriteContent() {
		GuestbookVO guestbookVO = new GuestbookVO();
		
		guestbookService.addContent(guestbookVO);
	}
	
//	@AfterClass
//	public void cleanUp() {
//		guestbookDAO.deleteAll();
//	}
}
