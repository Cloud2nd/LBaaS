package com.exactsix.mibaas.lecture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDto;
import com.exactsix.mibaas.lecture.repository.LectureRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureEsDto;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;

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
	private ElasticsearchTemplate search;

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
		 * SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
		 * matchAllQuery()).build();
		 */

		/*
		 * SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
		 * queryString
		 * ("couchbaseDocument.doc.lectureCode").field("test1")).build();
		 * 
		 * List<LectureEsDto> sampleEntities = search.queryForList(searchQuery,
		 * LectureEsDto.class);
		 * 
		 * System.out.println("***********************");
		 * System.out.println("***********************");
		 * System.out.println(sampleEntities.size());
		 */

		/*
		 * QueryBuilder qb =
		 * QueryBuilders.multiMatchQuery("kimchy elasticsearch", "user",
		 * "message");
		 */
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
	 * 강좌 리스트를 불러오는 서비스 입니다.
	 * </pre>
	 * 
	 * @return
	 * @throws Exception
	 */
	public RestResponse getLectureList() {

		List<LectureEsDto> sampleEntities = new ArrayList<LectureEsDto>();

		LectureEsDto tmp1 = new LectureEsDto();
		tmp1.set_id("lecture::test1");

		LectureEsDto tmp2 = new LectureEsDto();
		tmp2.set_id("lecture::test2");

		LectureEsDto tmp3 = new LectureEsDto();
		tmp3.set_id("lecture::test3");

		LectureEsDto tmp4 = new LectureEsDto();
		tmp4.set_id("lecture::test4");

		LectureEsDto tmp5 = new LectureEsDto();
		tmp5.set_id("lecture::test5");

		sampleEntities.add(tmp1);
		sampleEntities.add(tmp2);
		sampleEntities.add(tmp3);
		sampleEntities.add(tmp4);
		sampleEntities.add(tmp5);

		String[] tests = { "lecture::test1", "lecture::test2" };

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
}
