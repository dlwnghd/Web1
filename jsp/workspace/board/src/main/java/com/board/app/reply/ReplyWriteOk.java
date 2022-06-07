package com.board.app.reply;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.ReplyDAO;
import com.board.app.domain.vo.ReplyVO;

public class ReplyWriteOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		ReplyVO replyVO = new ReplyVO();
		ReplyDAO replyDAO = new ReplyDAO();
		
		replyVO.setReplyContent(req.getParameter("replyContent"));
		replyVO.setBoardNumber(Integer.parseInt(req.getParameter("boardNumber")));
		replyVO.setMemberNumber((Integer)req.getSession().getAttribute("memberNumber"));
		
		replyDAO.insert(replyVO);
		
		return null;
	}

}
