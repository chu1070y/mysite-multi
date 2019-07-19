package com.cafe24.mysite.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController("guestbookAPIController")
@RequestMapping("/api/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService; 
	
	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public JSONResult list(@PathVariable(value = "page") Long lastNo) {
		List<GuestbookVO> list = guestbookService.getContentsList(lastNo);
		return JSONResult.success(list);
	}
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="no", required = false),
//		@ApiImplicitParam(name="id", value="아이디", required = true, dataType = "string"),
//		@ApiImplicitParam(name="pw", value="비밀번호", required = true, dataType = "string"),
//		@ApiImplicitParam(name="name", value="이름", required = true, dataType = "string"),
//		@ApiImplicitParam(name="email", value="이메일주소", required = true, dataType = "string"),
//		@ApiImplicitParam(name="tel_phone", value="휴대폰번호", required = true, dataType = "string")
//	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JSONResult add(@RequestBody GuestbookVO guestbookVO) {
		guestbookService.addContent(guestbookVO);
		return JSONResult.success(guestbookVO);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public JSONResult delete(@RequestBody GuestbookVO vo) {
		boolean result = guestbookService.deleteContent(vo);
		return JSONResult.success(result ? vo.getNo() : -1);
	}
}
