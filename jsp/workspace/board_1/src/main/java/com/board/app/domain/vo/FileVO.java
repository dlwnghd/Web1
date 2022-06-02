package com.board.app.domain.vo;

public class FileVO {
   
   private String fileName;
   private String fileNameOrigianl;
   private int boardNumber;
   
   public FileVO() {;}

   public String getFileName() {
      return fileName;
   }

   public void setFileName(String fileName) {
      this.fileName = fileName;
   }

   public String getFileNameOrigianl() {
      return fileNameOrigianl;
   }

   public void setFileNameOrigianl(String fileNameOrigianl) {
      this.fileNameOrigianl = fileNameOrigianl;
   }

   public int getBoardNumber() {
      return boardNumber;
   }

   public void setBoardNumber(int boardNumber) {
      this.boardNumber = boardNumber;
   }
}