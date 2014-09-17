package com.exactsix.mibaas.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDetailDto;
import com.exactsix.mibaas.lecture.dto.LectureDto;
import com.exactsix.mibaas.lecture.repository.LectureDetailRepository;
import com.exactsix.mibaas.lecture.repository.LectureRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureDetailRepositoryDto;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;

/**
 * <pre>
 * Class Name  : LectureService.java
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
 *          Copyright (C) 2012 by BEANY All right reserved.
 */
@Service
public class LectureService {

	@Autowired
	private LectureRepository lectureRepository;

	@Autowired
	private LectureDetailRepository lectureDetailRepository;

	public LectureService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureService(LectureRepository lectureRepository) {
		super();
		this.lectureRepository = lectureRepository;
	}

	/**
	 * <pre>
	 * 강좌 등록
	 * </pre>
	 * 
	 * @param lectureDto
	 * @return
	 * @throws Exception
	 */
	public RestResponse createLecture(LectureDto lectureDto) {

		// make lecture repository data
		LectureRepositoryDto repositoryDto = new LectureRepositoryDto();
		repositoryDto.setKey("lecture::" + lectureDto.getLectureCode());
		repositoryDto.setLectureCode(lectureDto.getLectureCode());
		repositoryDto.setLectureName(lectureDto.getLectureName());
		repositoryDto.setLectureType(lectureDto.getLectureType());
		repositoryDto.setLectureLanguage(lectureDto.getLectureLanguage());

		// save db
		repositoryDto = lectureRepository.save(repositoryDto);

		// make response message
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("강좌가 정상적으로 등록되었습니다");

		return response;
	}

	public RestResponse getLecture(String lecturecode) {

		/*
		 * Query query = new Query();
		 * query.setKey(ComplexKey.of("lecture::aaa")); List<LectureDto>
		 * allUsers = lectureRepository.findByLectureCode(query);
		 * System.out.println(allUsers);
		 */

		// Get DB
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");
		LectureRepositoryDto repositoryDto = lectureRepository
				.findOne("lecture::" + lecturecode);

		// setting lecture dto
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureName(repositoryDto.getLectureName());
		lectureDto.setLectureCode(repositoryDto.getLectureCode());
		lectureDto.setLectureLanguage(repositoryDto.getLectureLanguage());
		lectureDto.setLectureType(repositoryDto.getLectureType());
		response.setData(lectureDto);

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
	@SuppressWarnings("null")
	public RestResponse createOrUpdateLectureDetail(LectureDetailDto lectureDetail) {

		// Make couchbase key
		String key = "lecture::" + lectureDetail.getLectureCode() + "::detail";

		// Initialize Response Data
		RestResponse response = new RestResponse();

		// Get Data from Couchbase
		LectureDetailRepositoryDto repositoryDto = null;


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
