package com.board.app.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.BoardDAO;

public class BoardUpdate implements Action{
	
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		int page = Integer.parseInt(req.getParameter("page"));
		int boardNumber = Integer.parseInt(req.getParameter("boardNumber"));
		ActionInfo actionInfo = new ActionInfo();
		
		BoardDAO boardDAO = new BoardDAO();
		
		// 회원의 번호로 게시글의 정보 뿐만 아니라 회원의 아이디까지 가져와주는 쿼리 실행
		req.setAttribute("board", boardDAO.selectDetail(boardNumber));
		req.setAttribute("page", page);
		
		actionInfo.setRedirect(false);
		actionInfo.setPath("/app/board/boardUpdate.jsp");
		
		return actionInfo;
	}
}
