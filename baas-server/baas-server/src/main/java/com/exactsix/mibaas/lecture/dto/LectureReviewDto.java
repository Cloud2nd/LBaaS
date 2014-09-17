package com.exactsix.mibaas.lecture.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class LectureReviewDto {

	private String lectureCode;
	private String customerCode;
	private String subject;
	private String commenct;

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
