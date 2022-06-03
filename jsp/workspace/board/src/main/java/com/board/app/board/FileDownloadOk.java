package com.board.app.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.app.action.Action;
import com.board.app.action.ActionInfo;

public class FileDownloadOk implements Action {

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String uploadPath = "D:\\Web_1900_ljh\\jsp\\workspace\\board\\src\\main\\webapp\\upload";
		String fileName = req.getParameter("fileName");
		String fileNameOriginal = req.getParameter("fileNameOriginal");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		File file = null;
		
		file = new File(uploadPath, fileName);
		String fileNameToSend = new String(fileNameOriginal.getBytes("UTF-8"), "ISO-8859-1");	// 파일 입출력 방식 ISO-8859-1
		inputStream = new FileInputStream(file);	// 해당 경로에 있는 파일 읽어오기
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Description", "파일 다운로드");
		resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileNameToSend + "\""); // 첨부파일 다운로드명은 fileNameToSend로 맞춰서 다운로드
		resp.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
		resp.setHeader("Content-Length", file.length() + "");	// 다운로드 시 걸리는 시간
		
		byte[] b = new byte[(int)file.length()];	// 파일 정보를 byte로 읽음
		int len = 0;
		outputStream = resp.getOutputStream();	// 해당 경로에 있는 파일 출력하기
		
		while((len = inputStream.read(b)) > 0) {	// 더 이상 읽을 바이트가 없으면
			outputStream.write(b, 0, len);	// 브라우저로 출력 됨
		}
		
		outputStream.close();
		inputStream.close();
				
		
		return null;
	}

}























