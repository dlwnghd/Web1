package com.board.app.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.MemberDAO;

public class BoardWrite implements Action{
	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		MemberDAO memberDAO = new MemberDAO();
		ActionInfo actionInfo = new ActionInfo();
		
//		String memberId = memberDAO.getInfo((Integer)session.getAttribute("memberNumber")).getMemberId();
		
//		req.setAttribute("memberId", memberId);
		
		actionInfo.setRedirect(false);
		actionInfo.setPath("/app/board/boardWrite.jsp");
		
		return actionInfo;
	}
}




