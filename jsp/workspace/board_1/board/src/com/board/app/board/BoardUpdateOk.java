package com.board.app.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.BoardDAO;
import com.board.app.domain.vo.BoardVO;

public class BoardUpdateOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		ActionInfo actionInfo = new ActionInfo();
		
		int boardNumber = 0, page = 0;
		
		page = Integer.parseInt(req.getParameter("page"));
		boardNumber = Integer.parseInt(req.getParameter("boardNumber"));
		boardVO.setBoardTitle(req.getParameter("boardTitle"));
		boardVO.setBoardContent(req.getParameter("boardContent"));
		boardVO.setBoardNumber(boardNumber);
		
		boardDAO.update(boardVO);
		
		actionInfo.setRedirect(true);
		
		//목록보기(페이지 기억)
		actionInfo.setPath(req.getContextPath() + "/board/BoardListOk.bo?page=" + page);
		
		return actionInfo;
	}

}








