package com.exactsix.mibaas.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDetailDto;
import com.exactsix.mibaas.lecture.repository.LectureDetailRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureDetailRepositoryDto;

/**
 * <pre>
 * Class Name  : LectureDetailService.java
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
public class LectureDetailService {

	private LectureDetailRepository lectureDetailRepository;

	public LectureDetailService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public LectureDetailService(LectureDetailRepository lectureDetailRepository) {
		super();
		this.lectureDetailRepository = lectureDetailRepository;
	}

	/**
	 * <pre>
	 * Get Lecture Detail Infomation
	 * </pre>
	 * 
	 * @return
	 */
	public RestResponse getLectureDetail(String lecturecode) {

		// Make couchbase key
		String key = "lecture::" + lecturecode + "::detail";

		// Initialize Response Data
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");

		// Get Data from Couchbase
		LectureDetailRepositoryDto repositoryDto = null;
		try {
			repositoryDto = lectureDetailRepository.findOne(key);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage("fail to connect");
			return response;
		}

		// Set Lecture Detail Infomation
		LectureDetailDto dto = new LectureDetailDto();
		dto.setAbout(repositoryDto.getAbout());
		dto.setBackground(repositoryDto.getBackground());
		dto.setFormat(repositoryDto.getFormat());
		dto.setLectureCode(repositoryDto.getLectureCode());
		dto.setLectureType(repositoryDto.getLectureType());
		dto.setSyllabus(repositoryDto.getSyllabus());

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
	public RestResponse createOrUpdateLectureDetail(
			LectureDetailDto lectureDetail) {

		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		System.out.println("#############");
		// Make couchbase key
		String key = "lecture::" + lectureDetail.getLectureCode() + "::detail";

		// Initialize Response Data
		RestResponse response = new RestResponse();

		// Get Data from Couchbase
		LectureDetailRepositoryDto repositoryDto = new LectureDetailRepositoryDto();

		repositoryDto.setKey(key);
		repositoryDto.setLectureCode(lectureDetail.getLectureCode());
		repositoryDto.setAbout(lectureDetail.getAbout());
		repositoryDto.setBackground(lectureDetail.getBackground());
		repositoryDto.setFormat(lectureDetail.getFormat());
		repositoryDto.setLectureType(lectureDetail.getLectureType());
		repositoryDto.setSyllabus(lectureDetail.getSyllabus());

		try {
			repositoryDto = lectureDetailRepository.save(repositoryDto);
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
