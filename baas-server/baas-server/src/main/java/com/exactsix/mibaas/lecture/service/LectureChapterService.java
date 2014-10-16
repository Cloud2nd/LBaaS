package com.exactsix.mibaas.lecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.ChapterDto;
import com.exactsix.mibaas.lecture.repository.LectureChapterRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureChapterRepositoryDto;

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
public class LectureChapterService {

	private LectureChapterRepository lectureChapterRepository;

	public LectureChapterService() {
		super();
	}

	@Autowired
	public LectureChapterService(
			LectureChapterRepository lectureChapterRepository) {
		super();
		this.lectureChapterRepository = lectureChapterRepository;
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
	public RestResponse createLecture(ChapterDto chapterDto) {

		// make lecture repository data
		create(chapterDto);

		// make response message
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("챕터가 정상적으로 등록되었습니다");

		return response;
	}

	

	public RestResponse getChapter(String lecturecode) {

		// Get DB
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");
		return response;
	}
	
	private boolean create(ChapterDto chapterDto) {

		LectureChapterRepositoryDto repositoryDto = new LectureChapterRepositoryDto();
		repositoryDto.setKey(getKey(chapterDto.getLectureCode()));
		repositoryDto.setLectureCode(chapterDto.getLectureCode());
		repositoryDto.setChapterCode("a001");
		repositoryDto.setChapterDescription(chapterDto.getChapterDescription());
		repositoryDto.setChapterFile(chapterDto.getChapterFile());

		// save db
		repositoryDto = lectureChapterRepository.save(repositoryDto);

		return true;
	}

	private String getKey(String lectureCode) {
		StringBuffer sb = new StringBuffer();
		sb.append("lecture::");
		sb.append(lectureCode);
		sb.append("::chapter::");
		sb.append("a001");
		return sb.toString();
	}
}
