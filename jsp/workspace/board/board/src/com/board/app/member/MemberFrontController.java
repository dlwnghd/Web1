package com.board.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.ActionInfo;

public class MemberFrontController extends HttpServlet {
	
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
//		String command = requestURL.substring(requestURL.lastIndexOf("/") + 1);
		String command = requestURL.substring(req.getContextPath().length());
		ActionInfo actionInfo = null;
		System.out.println(command);
		
		if(command.equals("/member/MemberCheckIdOk.me")) {
			new MemberCheckIdOk().execute(req, resp);
		}else if(command.equals("/member/MemberJoinOk.me")) {
			actionInfo = new MemberJoinOk().execute(req, resp);
		}else if(command.equals("/member/MemberLogin.me")) {
			actionInfo = new ActionInfo();
			actionInfo.setPath("/app/member/login.jsp");
			actionInfo.setRedirect(false);
		}
		
		if(actionInfo != null) {
			if(actionInfo.isRedirect()) {
				resp.sendRedirect(actionInfo.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(actionInfo.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
