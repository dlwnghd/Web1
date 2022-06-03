package com.board.app.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;
import com.board.app.domain.dao.BoardDAO;
import com.board.app.domain.dao.FileDAO;
import com.board.app.domain.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uploadPath = "D:\\web_1900_hds\\jsp\\workspace\\board\\WebContent\\upload";
		int fileSize = 1024 * 1024 * 5; //5M
		
		
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		BoardVO boardVO = new BoardVO();
		ActionInfo actionInfo = new ActionInfo();
		
		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		boardVO.setBoardTitle(multipartRequest.getParameter("boardTitle"));
		boardVO.setBoardContent(multipartRequest.getParameter("boardContent"));
		//세션은 req로 받아야 한다.
		boardVO.setMemberNumber((Integer)req.getSession().getAttribute("memberNumber"));
		
		//게시글 추가
		boardDAO.insert(boardVO);
		
		//파일 추가
		fileDAO.insert(multipartRequest, boardDAO.getSeq());
		
		actionInfo.setRedirect(true);
		actionInfo.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		return actionInfo;
	}

}
