package com.example.demo.dto;

public class FileDTO {
	private int bbsId;
	private String originalFileName;
	private String fileName;

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

	@Override
	public String toString() {
		return "VALUE : " + bbsId + ", " + originalFileName + ", " + fileName + " = END =  ";
	}
}
