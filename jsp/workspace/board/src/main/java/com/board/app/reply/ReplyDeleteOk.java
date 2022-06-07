package com.board.app.reply;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.ReplyDAO;

public class ReplyDeleteOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		new ReplyDAO().delete(Integer.parseInt(req.getParameter("replyNumber")));
		
		return null;
	}

}
