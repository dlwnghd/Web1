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
		
		String uploadPath = "D:\\web_1900_hds\\jsp\\workspace\\board\\WebContent\\upload";
		String fileName = req.getParameter("fileName");
		String fileNameOriginal = req.getParameter("fileNameOriginal");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		File file = null;
		
		file = new File(uploadPath, fileName);
		String fileNameToSend = new String(fileNameOriginal.getBytes("UTF-8"), "ISO-8859-1");
		inputStream = new FileInputStream(file);
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Description", "파일 다운로드");
		resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileNameToSend + "\"");
		resp.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
		resp.setHeader("Content-Length", file.length() + "");
		
		byte[] b = new byte[(int)file.length()];
		int len = 0;
		outputStream = resp.getOutputStream();
		
		while((len = inputStream.read(b)) > 0) {
			outputStream.write(b, 0, len);
		}
		
		outputStream.close();
		inputStream.close();
				
		
		return null;
	}

}























