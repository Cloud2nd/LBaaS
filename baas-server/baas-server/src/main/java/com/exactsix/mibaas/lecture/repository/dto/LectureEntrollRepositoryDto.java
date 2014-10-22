package com.exactsix.mibaas.lecture.repository.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class LectureEntrollRepositoryDto {

	@Id
	private String key;

	@Field
	private String lectureCode;

	@Field
	private String userCode;

	@Field
	private String status;

	@Field
	private Date created;

	@Field
	private Date updated;

	public LectureEntrollRepositoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureEntrollRepositoryDto(String key, String lectureCode,
			String userCode) {
		super();
		this.key = key;
		this.lectureCode = lectureCode;
		this.userCode = userCode;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
