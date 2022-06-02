package com.board.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.MemberDAO;

public class MemberCheckIdOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		MemberDAO memberDAO = new MemberDAO();
		PrintWriter out = resp.getWriter();
		String memberId = req.getParameter("memberId");
		JSONObject json = new JSONObject();
		
		
		if(memberDAO.checkId(memberId)) {
			json.put("result", "fail");
		}else {
			json.put("result", "success");
		}
		
		out.print(json.toJSONString());
		out.close();
		
		return null;
	}
	
}





