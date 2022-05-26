package com.member;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import com.member.action.Action;
import com.member.action.ActionInfo;
import com.member.domain.dao.MemberDAO;

public class CheckIdOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		MemberDAO memberDAO = new MemberDAO();
		JSONObject resultJSON = new JSONObject();
		
		String memberId = req.getParameter("memberId");
		resultJSON.put("check", memberDAO.checkId(memberId));
		
		out.print(resultJSON.toJSONString());
		out.close();
		return null;
	}

}
