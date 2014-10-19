package com.exactsix.mibaas.lecture.repository.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class LectureChapterRepositoryDto {

	@Id
	private String key;

	@Field
	private String lectureCode;

	@Field
	private String chapterCode;

	@Field
	private String chapterName;

	@Field
	private String chapterDescription;

	@Field
	private String chapterFile;

	@Field
	private int chapterOrder;

	@Field
	private String status;

	@Field
	private Date created;

	@Field
	private Date updated;

	public LectureChapterRepositoryDto() {
		super();
	}

	public LectureChapterRepositoryDto(String key, String lectureCode,
			String chapterCode, String chapterName, String chapterDescription,
			String chapterFile) {
		super();
		this.key = key;
		this.lectureCode = lectureCode;
		this.chapterCode = chapterCode;
		this.chapterName = chapterName;
		this.chapterDescription = chapterDescription;
		this.chapterFile = chapterFile;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
