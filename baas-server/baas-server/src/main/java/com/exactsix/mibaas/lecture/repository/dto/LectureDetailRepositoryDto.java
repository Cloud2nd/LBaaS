package com.exactsix.mibaas.lecture.repository.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class LectureDetailRepositoryDto {

	@Id
	private String key;

	@Field
	private String lectureCode;

	@Field
	private String about;

	@Field
	private String syllabus;

	@Field
	private String background;

	@Field
	private String format;

	@Field
	private String lectureType;

	public LectureDetailRepositoryDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLectureType() {
		return lectureType;
	}

	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}

}
