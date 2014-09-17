package com.exactsix.mibaas.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureReviewDto;
import com.exactsix.mibaas.lecture.repository.LectureReviewRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureReviewRepositoryDto;

/**
 * <pre>
 * Class Name  : LectureReviewService.java
 * Description :
 * Modification Information
 * 
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2013. 4. 23.   dave              최초생성
 * </pre>
 * 
 * @author dave
 * @since 2014. 9. 16.
 * @version 1.0
 * 
 *          Copyright (C) 2014 by Exact Lab All right reserved.
 */
@Component
public class LectureReviewService {

	private LectureReviewRepository lectureReviewRepository;

	public LectureReviewService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public LectureReviewService(LectureReviewRepository lectureReviewRepository) {
		super();
		this.lectureReviewRepository = lectureReviewRepository;
	}

	/**
	 * <pre>
	 * Get Lecture Detail Infomation
	 * </pre>
	 * 
	 * @return
	 */
	public RestResponse getLectureReview(String lecturecode) {

		// Make couchbase key
		String key = "lecture::" + lecturecode + "::review";

		// Initialize Response Data
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");

		// Get Data from Couchbase
		LectureReviewRepositoryDto repositoryDto = null;
		try {
			repositoryDto = lectureReviewRepository.findOne(key);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage("fail to connect");
			return response;
		}

		// Set Lecture Detail Infomation
		LectureReviewDto dto = new LectureReviewDto();
		dto.setLectureCode(repositoryDto.getLectureCode());
		dto.setCustomerCode(repositoryDto.getCustomerCode());
		dto.setSubject(repositoryDto.getSubject());
		dto.setCommenct(repositoryDto.getCommenct());

		// Setting Lecture Detail Infomation to Response Data
		response.setData(dto);

		// return
		return response;
	}

	/**
	 * <pre>
	 * Get Lecture Detail Infomation
	 * </pre>
	 * 
	 * @return
	 */
	public RestResponse createOrUpdateLectureReview(
			LectureReviewDto lectureReview) {

		// Make couchbase key
		String key = "lecture::" + lectureReview.getLectureCode() + "::review";

		// Initialize Response Data
		RestResponse response = new RestResponse();

		// Get Data from Couchbase
		LectureReviewRepositoryDto repositoryDto = new LectureReviewRepositoryDto();

		repositoryDto.setKey(key);
		repositoryDto.setLectureCode(lectureReview.getLectureCode());
		repositoryDto.setCustomerCode(lectureReview.getCustomerCode());
		repositoryDto.setSubject(lectureReview.getSubject());
		repositoryDto.setCommenct(lectureReview.getCommenct());

		try {
			repositoryDto = lectureReviewRepository.save(repositoryDto);
			response.setStatus(true);
			response.setMessage("ok");
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage("fail to connect");
			return response;
		}

		// return
		return response;
	}
}
