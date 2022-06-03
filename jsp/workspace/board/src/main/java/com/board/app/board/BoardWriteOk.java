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
		
		// 파일을 업로드를 할 폴더의 경로
		String uploadPath = "D:\\Web_1900_ljh\\jsp\\workspace\\board\\src\\main\\webapp\\upload";
		int fileSize = 1024 * 1024 * 5; //5M = 1024키로바이트 * 1024키로바이트 * 5
		
		
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		BoardVO boardVO = new BoardVO();
		ActionInfo actionInfo = new ActionInfo();
		
		// 이름이 중복되면 DefaultFileRenamePolicy()를 통해 이름이 바뀜
		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		// ⬆️⬆️⬆️서버에는 올라가는데 DB에는 아직 올라가지 않음
		
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
