package com.exactsix.mibaas.lecture.repository.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class LectureReviewRepositoryDto {

	@Id
	private String key;

	@Field
	private String lectureCode;

	@Field
	private String customerCode;

	@Field
	private String subject;

	@Field
	private String commenct;

	public LectureReviewRepositoryDto() {
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

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCommenct() {
		return commenct;
	}

	public void setCommenct(String commenct) {
		this.commenct = commenct;
	}

}
