package com.cafe24.security;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.mysite.service.BoardService;

public class CookieInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// @Pathvariable 갖고오긔
		Map<String, String> uriTemplateVars = (Map<String, String>) request.getAttribute( 
				HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE); 
		
		String no = uriTemplateVars.get("no");
		
		Cookie[] cookies = request.getCookies();
		Cookie myCookie = null;
		
		// 쿠키 확인
		for(Cookie cookie: cookies) {
			if("myCookie".equals(cookie.getName())) {
				myCookie = cookie;
				break;
			}
		}
		
		// 쿠키 생성
		if(myCookie == null) {
			Cookie cookie = new Cookie("myCookie", no);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			return;
		}
		
		// 쿠키 내용 조회
		String[] arr = myCookie.getValue().split("_");
		
		for(String str : arr) {
			if (str.equals(no)) {
				return;
			}
		}
		
		// 쿠키 내용 추가
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		BoardService service = ac.getBean(BoardService.class);
		
		myCookie.setValue(myCookie.getValue() + "_" + no);
		
		service.count(Long.parseLong(no));
		
		response.addCookie(myCookie);
	
	}



}
