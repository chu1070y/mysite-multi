package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestbookDAO;
import com.cafe24.mysite.vo.GuestbookVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class AddAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");

		GuestbookVO vo = new GuestbookVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContents(contents);

		new GuestbookDAO().insert(vo);

		WebUtil.redirect(request, response, request.getContextPath() + "/guestbook");
		
	}

}
