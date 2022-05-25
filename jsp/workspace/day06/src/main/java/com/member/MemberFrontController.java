package com.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.member.action.ActionInfo;
import com.member.domain.vo.MemberVO;
import com.mybatis.config.MyBatisConfig;

public class MemberFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURL = req.getRequestURI();
		String command = requestURL.substring(requestURL.lastIndexOf("/") + 1);
		ActionInfo actionInfo = null;
		
		if(command.equals("JoinOk.me")) {
			new MemberJoinOk().execute(req, resp);
		} else if(command.equals("Join.me")) {
			actionInfo = new ActionInfo();
			actionInfo.setRedirect(true);
			actionInfo.setPath("/join.jsp");
		} else {
			// 404 일 때 출력할 에러 페이지 경로 작성
		}
	}
}























