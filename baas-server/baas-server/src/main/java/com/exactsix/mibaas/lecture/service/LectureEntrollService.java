package com.exactsix.mibaas.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.EntrollDto;
import com.exactsix.mibaas.lecture.repository.LectureEntrollRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureEntrollRepositoryDto;

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
public class LectureEntrollService {

	private LectureEntrollRepository lectureEntrollRepository;

	public LectureEntrollService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public LectureEntrollService(
			LectureEntrollRepository lectureEntrollRepository) {
		super();
		this.lectureEntrollRepository = lectureEntrollRepository;
	}

	/**
	 * <pre>
	 * Get Lecture Detail Infomation
	 * </pre>
	 * 
	 * @return
	 */
	public RestResponse createEntrollLecture(EntrollDto entrollDto) {

		// make lecture repository data

		LectureEntrollRepositoryDto repositoryDto = new LectureEntrollRepositoryDto();

		repositoryDto.setKey(getKey(entrollDto.getLectureCode(), entrollDto.getCustomerCode()));
		repositoryDto.setLectureCode(entrollDto.getLectureCode());
		repositoryDto.setUserCode(entrollDto.getCustomerCode());

		// save db
		repositoryDto = lectureEntrollRepository.save(repositoryDto);

		// make response message
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("수강신청이 정상적으로 등록되었습니다");

		return response;
	}

	public RestResponse removeEntrollLecture(EntrollDto entrollDto) {

		// make lecture repository data
		String key = getKey(entrollDto.getLectureCode(), entrollDto.getCustomerCode());

		// save db
		lectureEntrollRepository.delete(key);

		// make response message
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("수강신청이 정상적으로 취소되었습니다");

		return response;
	}

	private String getKey(String lectureCode, String userCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("lecture::");
		sb.append(lectureCode);
		sb.append("::user::");
		sb.append(userCode);
		return sb.toString();
	}

}
