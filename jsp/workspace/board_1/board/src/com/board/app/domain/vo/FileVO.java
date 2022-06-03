package com.board.app.domain.vo;

public class FileVO {
	
	private String fileName;
	private String fileNameOriginal;
	private int boardNumber;
	
	public FileVO() {;}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNameOriginal() {
		return fileNameOriginal;
	}

	public void setFileNameOriginal(String fileNameOrigianl) {
		this.fileNameOriginal = fileNameOrigianl;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
}
