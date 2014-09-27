package com.exactsix.mibaas.lecture.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class LectureDto {

	private String lectureCode;
	private String lectureName;
	private String lectureLanguage;
	private String lectureType;
	private String lectureThumbnail;

	public String getLectureCode() {
		return lectureCode;
	}

	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureLanguage() {
		return lectureLanguage;
	}

	public void setLectureLanguage(String lectureLanguage) {
		this.lectureLanguage = lectureLanguage;
	}

	public String getLectureType() {
		return lectureType;
	}

	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}

	public String getLectureThumbnail() {
		return lectureThumbnail;
	}

	public void setLectureThumbnail(String lectureThumbnail) {
		this.lectureThumbnail = lectureThumbnail;
	}

}
