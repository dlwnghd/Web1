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
		String memberId = req.getParameter("memberId");	//	외부에서 전달받은 Id를 파라미터로 받아옴
		JSONObject json = new JSONObject();
		
//		checkId가 true면 아이디가 중복이므로 fail처리
		if(memberDAO.checkId(memberId)) {
			json.put("result", "fail");
		}else {
			json.put("result", "success");
		}
		
		out.print(json.toJSONString());	//	해당 문자열을 출력
		out.close();	//	버퍼 닫기
		
		return null;
	}
	
}





