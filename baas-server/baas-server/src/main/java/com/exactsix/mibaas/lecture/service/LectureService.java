package com.exactsix.mibaas.lecture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDto;
import com.exactsix.mibaas.lecture.repository.LectureRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;
import com.exactsix.mibaas.lecture.service.search.LectureElasticSearchService;
import com.exactsix.mibaas.lecture.util.LectureUtil;

;
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
@Component
public class LectureService {

	private LectureRepository lectureRepository;

	@Autowired
	private LectureElasticSearchService search;

	public LectureService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
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

		String lectureCode = LectureUtil.getUUID();
		// make lecture repository data
		LectureRepositoryDto repositoryDto = new LectureRepositoryDto();
		repositoryDto.setKey(LectureUtil.getLectureKey(lectureCode));
		repositoryDto.setLectureCode(lectureCode);
		repositoryDto.setLectureName(lectureDto.getLectureName());
		repositoryDto.setLectureType(lectureDto.getLectureType());
		repositoryDto.setLectureLanguage(lectureDto.getLectureLanguage());

		if (lectureDto.getLectureThumbnail() != null
				&& lectureDto.getLectureThumbnail() != "") {
			repositoryDto.setLectureThumbnail(lectureDto.getLectureThumbnail());
		}
		
		// save db
		repositoryDto = lectureRepository.save(repositoryDto);

		// make response message
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("강좌가 정상적으로 등록되었습니다");

		return response;
	}

	public RestResponse getLecture(String lecturecode) {

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
		lectureDto.setLectureThumbnail(repositoryDto.getLectureThumbnail());
		response.setData(lectureDto);

		// return
		return response;
	}

	/**
	 * <pre>
	 * 강좌 리스트를 불러오는 서비스 입니다.
	 * </pre>
	 * 
	 * @return
	 * @throws Exception
	 */
	public RestResponse getLectureList() {

		List<String> keys = search.test();
		String[] tests = keys.toArray(new String[keys.size()]);

		// Get DB
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");

		List<LectureDto> lectureList = new ArrayList<LectureDto>();

		for (String test : tests) {
			LectureRepositoryDto repositoryDto = lectureRepository
					.findOne(test);

			// setting lecture dto
			LectureDto lectureDto = new LectureDto();
			lectureDto.setLectureName(repositoryDto.getLectureName());
			lectureDto.setLectureCode(repositoryDto.getLectureCode());
			lectureDto.setLectureLanguage(repositoryDto.getLectureLanguage());
			lectureDto.setLectureType(repositoryDto.getLectureType());
			lectureDto.setLectureThumbnail(repositoryDto.getLectureThumbnail());


			// Need Approve
			List<String> needApproveKeys = search
					.getNotApproveUser(repositoryDto.getLectureCode());
			lectureDto.setNeedApprove(needApproveKeys.size());

			lectureList.add(lectureDto);
		}

		response.setData(lectureList);

		// return
		return response;
	}

	public RestResponse getProgressCourseList() {

		List<String> keys = search.getProgressCourse();

		List<String> lectureKeys = new ArrayList<String>();

		for (String key : keys) {
			String[] tmp = key.split("::");
			lectureKeys.add(LectureUtil.getLectureKey(tmp[1]));
		}

		String[] tests = lectureKeys.toArray(new String[lectureKeys.size()]);

		// Get DB
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");

		List<LectureDto> lectureList = new ArrayList<LectureDto>();

		for (String test : tests) {
			LectureRepositoryDto repositoryDto = lectureRepository
					.findOne(test);

			// setting lecture dto
			LectureDto lectureDto = new LectureDto();
			lectureDto.setLectureName(repositoryDto.getLectureName());
			lectureDto.setLectureCode(repositoryDto.getLectureCode());
			lectureDto.setLectureLanguage(repositoryDto.getLectureLanguage());
			lectureDto.setLectureType(repositoryDto.getLectureType());
			lectureList.add(lectureDto);
		}

		response.setData(lectureList);

		// return
		return response;
	}

	//
}
