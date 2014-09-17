package com.exactsix.mibaas.lecture.repository.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class LectureRepositoryDto {

	@Id
	private String key;

	@Field
	private String lectureCode;

	@Field
	private String lectureName;

	@Field
	private String lectureLanguage;

	@Field
	private String lectureType;

	public LectureRepositoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureRepositoryDto(String key, String lectureCode, String lectureName) {
		super();
		this.key = key;
		this.lectureCode = lectureCode;
		this.lectureName = lectureName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

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

}
