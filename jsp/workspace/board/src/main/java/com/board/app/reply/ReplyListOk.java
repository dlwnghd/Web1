package com.board.app.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.ReplyDAO;
import com.board.app.domain.vo.ReplyDTO;
import com.board.app.domain.vo.ReplyVO;

public class ReplyListOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		ReplyDAO replyDAO = new ReplyDAO();
		JSONArray replyJSONs = new JSONArray();
		
		int boardNumber = Integer.parseInt(req.getParameter("boardNumber"));
		List<ReplyDTO> replies = replyDAO.getList(boardNumber);
		
		replies.forEach(reply -> {
			JSONObject replyJSON = new JSONObject();
			replyJSON.put("replyNumber", reply.getReplyNumber());
			replyJSON.put("boardNumber", reply.getBoardNumber());
			replyJSON.put("memberNumber", reply.getMemberNumber());
			replyJSON.put("memberId", reply.getMemberId());
			replyJSON.put("replyContent", reply.getReplyContent());
			
			replyJSONs.add(replyJSON);
		});
		
		out.print(replyJSONs.toJSONString());
		out.close();
		return null;
	}

}
