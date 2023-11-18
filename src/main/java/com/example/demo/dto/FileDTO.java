package com.example.demo.dto;

public class FileDTO {
	private int fileId;
	private int bbsId;
	private String originalFileName;
	private String fileName;
	private int fileAvailable;

	public int getFileId() {
		return fileId;
	}

	public int getfileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileAvailable() {
		return fileAvailable;
	}

	public void setFileAvailable(int fileAvailable) {
		this.fileAvailable = fileAvailable;
	}

	@Override
	public String toString() {
		return "VALUE : " + fileId + ", "  + bbsId + ", " + originalFileName + ", " + fileName + " = END =  ";
	}
}
