package com.cafe24.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.BoardDAO;
import com.cafe24.mysite.vo.BoardVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardVO> boardList = new BoardDAO().getList();
		request.setAttribute("boardList", boardList);
		WebUtil.forward(request, response, "WEB-INF/views/board/list.jsp");
	}

}
