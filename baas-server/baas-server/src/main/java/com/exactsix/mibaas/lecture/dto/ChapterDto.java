package com.exactsix.mibaas.lecture.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChapterDto {

	private String lectureCode;
	private String chapterCode;
	private String chapterName;
	private String chapterDescription;
	private String chapterFile;
	private int chapterOrder;
	private String chapterStatus;

	public String getLectureCode() {
		return lectureCode;
	}

	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}

	public String getChapterCode() {
		return chapterCode;
	}

	public void setChapterCode(String chapterCode) {
		this.chapterCode = chapterCode;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterDescription() {
		return chapterDescription;
	}

	public void setChapterDescription(String chapterDescription) {
		this.chapterDescription = chapterDescription;
	}

	public String getChapterFile() {
		return chapterFile;
	}

	public void setChapterFile(String chapterFile) {
		this.chapterFile = chapterFile;
	}

	public int getChapterOrder() {
		return chapterOrder;
	}

	public void setChapterOrder(int chapterOrder) {
		this.chapterOrder = chapterOrder;
	}

	public String getChapterStatus() {
		return chapterStatus;
	}

	public void setChapterStatus(String chapterStatus) {
		this.chapterStatus = chapterStatus;
	}

}
