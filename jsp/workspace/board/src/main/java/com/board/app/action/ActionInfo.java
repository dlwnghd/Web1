package com.board.app.action;

public class ActionInfo {
	private boolean isRedirect;
	private String path;
	
	//	기본 생성자
	public ActionInfo() {;}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
