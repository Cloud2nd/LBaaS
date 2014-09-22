package com.exactsix.mibaas.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDetailDto;
import com.exactsix.mibaas.lecture.dto.LectureDto;
import com.exactsix.mibaas.lecture.dto.LectureReviewDto;

@Service
public class LectureManager {

	@Autowired
	private LectureService lectureService;

	@Autowired
	private LectureDetailService lectureDetailService;
	
	@Autowired
	private LectureReviewService lectureReviewService;

	public RestResponse createLecture(LectureDto lectureDto) {
		return lectureService.createLecture(lectureDto);
	}

	public RestResponse getLecture(String lecturecode) {
		return lectureService.getLecture(lecturecode);
	}

	public RestResponse getLectureDetail(String lecturecode) {
		return lectureDetailService.getLectureDetail(lecturecode);
	}

	public RestResponse createOrUpdateLectureDetail(
			LectureDetailDto lectureDetail) {
		return lectureDetailService.createOrUpdateLectureDetail(lectureDetail);
	}

	public RestResponse getLectureReview(String lecturecode) {
		return lectureReviewService.getLectureReview(lecturecode);
	}

	public RestResponse createOrUpdateLectureReview(
			LectureReviewDto lectureReview) {
		return lectureReviewService.createOrUpdateLectureReview(lectureReview);
	}
}