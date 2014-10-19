package com.exactsix.mibaas.lecture.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.ChapterDto;
import com.exactsix.mibaas.lecture.repository.LectureChapterRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureChapterRepositoryDto;
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
public class LectureChapterService {

	private LectureChapterRepository lectureChapterRepository;

	@Autowired
	private LectureElasticSearchService search;

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
	public RestResponse createChpater(ChapterDto chapterDto) {

		// make response message
		RestResponse response = new RestResponse();
		chapterDto.setChapterCode(LectureUtil.getUUID());
		create(chapterDto);
		response.setStatus(true);
		response.setMessage("챕터가 정상적으로 등록되었습니다");

		return response;
	}

	/**
	 * <pre>
	 * 강좌 수정
	 * </pre>
	 * 
	 * @param lectureDto
	 * @return
	 * @throws Exception
	 */
	public RestResponse updateChpater(ChapterDto chapterDto) {

		// make response message
		RestResponse response = new RestResponse();
		update(chapterDto);
		response.setStatus(true);
		response.setMessage("챕터가 정상적으로 수정되었습니다");

		return response;
	}

	/**
	 * <pre>
	 * 강좌 삭제
	 * </pre>
	 * 
	 * @param lectureDto
	 * @return
	 * @throws Exception
	 */
	public RestResponse deleteChpater(ChapterDto chapterDto) {

		// make response message
		RestResponse response = new RestResponse();
		delete(chapterDto);
		response.setStatus(true);
		response.setMessage("챕터가 정상적으로 삭제되었습니다");

		return response;
	}

	public RestResponse getChapters(String lecturecode) {

		List<String> keys = search.getChapters(lecturecode);
		String[] tests = keys.toArray(new String[keys.size()]);

		// Get DB
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");

		// lectureChapterRepository.findAll(keys);
		List<ChapterDto> chapterList = new ArrayList<ChapterDto>();

		for (String test : tests) {

			LectureChapterRepositoryDto repositoryDto = lectureChapterRepository
					.findOne(test);

			System.out.println(repositoryDto.getChapterOrder());

			// setting lecture dto
			ChapterDto chapterDto = new ChapterDto();
			chapterDto.setLectureCode(repositoryDto.getLectureCode());
			chapterDto.setChapterCode(repositoryDto.getChapterCode());
			chapterDto.setChapterName(repositoryDto.getChapterName());
			chapterDto.setChapterDescription(repositoryDto
					.getChapterDescription());
			chapterDto.setChapterFile(repositoryDto.getChapterFile());
			chapterDto.setChapterStatus(repositoryDto.getStatus());
			chapterDto.setChapterOrder(repositoryDto.getChapterOrder());
			chapterList.add(chapterDto);
		}

		Collections.sort(chapterList, new ChapterComparator());
		response.setData(chapterList);

		return response;
	}

	public RestResponse getChapter(String lectureCode, String chapterCode) {

		// Get DB
		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("ok");

		LectureChapterRepositoryDto repositoryDto = lectureChapterRepository
				.findOne(LectureUtil.getChapterKey(lectureCode, chapterCode));

		// setting lecture dto
		ChapterDto chapterDto = new ChapterDto();
		chapterDto.setLectureCode(repositoryDto.getLectureCode());
		chapterDto.setChapterCode(repositoryDto.getChapterCode());
		chapterDto.setChapterName(repositoryDto.getChapterName());
		chapterDto.setChapterDescription(repositoryDto.getChapterDescription());
		chapterDto.setChapterFile(repositoryDto.getChapterFile());
		chapterDto.setChapterStatus(repositoryDto.getStatus());
		chapterDto.setChapterOrder(repositoryDto.getChapterOrder());

		response.setData(chapterDto);

		return response;
	}

	private boolean create(ChapterDto chapterDto) {

		LectureChapterRepositoryDto repositoryDto = new LectureChapterRepositoryDto();
		repositoryDto.setKey(LectureUtil.getChapterKey(
				chapterDto.getLectureCode(), chapterDto.getChapterCode()));
		repositoryDto.setLectureCode(chapterDto.getLectureCode());
		repositoryDto.setChapterCode(chapterDto.getChapterCode());
		repositoryDto.setChapterName(chapterDto.getChapterName());
		repositoryDto.setChapterDescription(chapterDto.getChapterDescription());
		repositoryDto.setChapterFile(chapterDto.getChapterFile());
		repositoryDto.setChapterOrder(chapterDto.getChapterOrder());
		repositoryDto.setStatus("create");
		repositoryDto.setCreated(new Date());
		repositoryDto.setUpdated(new Date());

		// save db
		repositoryDto = lectureChapterRepository.save(repositoryDto);

		return true;
	}

	private boolean update(ChapterDto chapterDto) {

		String lectureCode = chapterDto.getLectureCode();
		String chapterCode = chapterDto.getChapterCode();
		
		LectureChapterRepositoryDto repositoryDto = lectureChapterRepository
				.findOne(LectureUtil.getChapterKey(lectureCode, chapterCode));
		
		repositoryDto.setChapterName(chapterDto.getChapterName());
		repositoryDto.setChapterDescription(chapterDto.getChapterDescription());
		repositoryDto.setChapterFile(chapterDto.getChapterFile());
		repositoryDto.setStatus("edited");
		repositoryDto.setUpdated(new Date());
		
		// save db
		repositoryDto = lectureChapterRepository.save(repositoryDto);

		return true;
	}

	private boolean delete(ChapterDto chapterDto) {

		String lectureCode = chapterDto.getLectureCode();
		String chapterCode = chapterDto.getChapterCode();

		// save db
		lectureChapterRepository.delete(LectureUtil.getChapterKey(lectureCode,
				chapterCode));

		return true;
	}

	public class ChapterComparator implements Comparator<ChapterDto> {

		@Override
		public int compare(ChapterDto arg0, ChapterDto arg1) {
			// TODO Auto-generated method stub
			return arg0.getChapterOrder() - arg1.getChapterOrder();
		}
	}

}
