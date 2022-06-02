package com.board.app.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.ActionInfo;

public class BoardFrontController extends HttpServlet {
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
		ActionInfo actionInfo = null;
		
		switch(command) {
		case "/board/BoardListOk.bo":
			actionInfo = new BoardListOk().execute(req, resp);
			break;
		case "/board/BoardDetailOk.bo":
			actionInfo = new BoardDetailOk().execute(req, resp);
			break;
		case "/board/BoardWrite.bo":
			actionInfo = new BoardWrite().execute(req, resp);
			break;
		case "/board/BoardWriteOk.bo":
			actionInfo = new BoardWriteOk().execute(req, resp);
			break;
		case "/board/BoardDeleteOk.bo":
			actionInfo = new BoardDeleteOk().execute(req, resp);
			break;
		case "/board/BoardUpdate.bo":
			actionInfo = new BoardUpdate().execute(req, resp);
			break;
		case "/board/BoardUpdateOk.bo":
			actionInfo = new BoardUpdateOk().execute(req, resp);
			break;
		}
		
		//분기 별 결과를 actionInfo에 담았다면 여기로 내려온다.
		
		if(actionInfo != null) {// actionInfo가 null이 아니라면
			if(actionInfo.isRedirect()) {//redirect 방식이라면
				resp.sendRedirect(actionInfo.getPath());//redirect로 전송
				
			}else {//forward 방식이라면
				RequestDispatcher dispatcher = req.getRequestDispatcher(actionInfo.getPath());
				dispatcher.forward(req, resp);//forward로 전송
			}
		}
	}
}















