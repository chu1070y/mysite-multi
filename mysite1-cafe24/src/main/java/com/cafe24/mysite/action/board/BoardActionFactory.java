package com.cafe24.mysite.action.board;

import com.cafe24.mysite.action.main.MainAction;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("boardList".equals(actionName)) {
			action = new BoardListAction();
			
		} else if("writeform".equals(actionName)) {
			action = new WriteFormAction();
			
		} else {
			action = new MainAction();
		}
			
		return action;
	}

}
