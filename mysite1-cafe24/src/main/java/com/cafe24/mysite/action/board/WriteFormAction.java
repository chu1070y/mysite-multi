package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인 여부 체크
		HttpSession session = request.getSession();
		
		if(session != null && session.getAttribute("authUser") != null) {
			WebUtil.forward(request, response, "WEB-INF/views/board/write.jsp");
			return;
		}
		
		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=boardList");
		
		
	}

}
