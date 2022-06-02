package com.board.app.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.BoardDAO;
import com.board.app.domain.vo.BoardVO;

public class BoardWriteOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO boardVO = new BoardVO();
		ActionInfo actionInfo = new ActionInfo();
		
		boardVO.setBoardTitle(req.getParameter("boardTitle"));
		boardVO.setBoardContent(req.getParameter("boardContent"));
		boardVO.setMemberNumber((Integer)req.getSession().getAttribute("memberNumber"));
		
		//게시글 추가
		boardDAO.insert(boardVO);
		
		actionInfo.setRedirect(true);
		actionInfo.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		return actionInfo;
	}

}
