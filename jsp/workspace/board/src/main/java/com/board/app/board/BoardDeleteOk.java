package com.board.app.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.BoardDAO;

public class BoardDeleteOk implements Action{
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int boardNumber = Integer.parseInt(req.getParameter("boardNumber"));
		BoardDAO boardDAO = new BoardDAO();
		ActionInfo actionInfo = new ActionInfo();
		
		boardDAO.delete(boardNumber);
		
		actionInfo.setRedirect(true);
		actionInfo.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		return actionInfo;
	}
}
