package com.board.app.reply;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.ActionInfo;

public class ReplyFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		switch(command) {
		case "/board/ReplyListOk.re":
			new ReplyListOk().execute(req, resp);
			break;
		case "/board/ReplyWriteOk.re":
			new ReplyWriteOk().execute(req, resp);
			break;
		case "/board/ReplyUpdateOk.re":
			new ReplyUpdateOk().execute(req, resp);
			break;
		case "/board/ReplyDeleteOk.re":
			new ReplyDeleteOk().execute(req, resp);
			break;
		}
		
	}
}















