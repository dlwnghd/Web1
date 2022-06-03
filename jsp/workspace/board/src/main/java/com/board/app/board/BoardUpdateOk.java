package com.board.app.board;

import java.io.File;
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

public class BoardUpdateOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		String uploadPath = "D:\\Web_1900_ljh\\jsp\\workspace\\board\\src\\main\\webapp\\upload";
		int fileSize = 1024 * 1024 * 5; //5M
		
		BoardVO boardVO = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		ActionInfo actionInfo = new ActionInfo();
		
		int boardNumber = 0, page = 0;
		
		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		page = Integer.parseInt(multipartRequest.getParameter("page"));
		boardNumber = Integer.parseInt(multipartRequest.getParameter("boardNumber"));
		boardVO.setBoardTitle(multipartRequest.getParameter("boardTitle"));
		boardVO.setBoardContent(multipartRequest.getParameter("boardContent"));
		boardVO.setBoardNumber(boardNumber);
		
		boardDAO.update(boardVO);
		fileDAO.select(boardNumber).forEach(file -> {
			File f = new File(uploadPath, file.getFileName());
			if(f.exists()) { f.delete();}
		});
		fileDAO.delete(boardNumber);
		fileDAO.insert(multipartRequest, boardNumber);

		
		actionInfo.setRedirect(true);
		
		//목록보기(페이지 기억)
		actionInfo.setPath(req.getContextPath() + "/board/BoardListOk.bo?page=" + page);
		
		return actionInfo;
	}

}








