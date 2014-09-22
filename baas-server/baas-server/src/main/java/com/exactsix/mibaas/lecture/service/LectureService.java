package com.exactsix.mibaas.lecture.service;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDto;
import com.exactsix.mibaas.lecture.repository.LectureRepository;
import com.exactsix.mibaas.lecture.repository.dto.LectureEsDto;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryString;

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

		/*SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
				queryString("couchbaseDocument.doc.lectureCode").field("test1")).build();

		List<LectureEsDto> sampleEntities = search.queryForList(searchQuery,
				LectureEsDto.class);

		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println(sampleEntities.size());*/

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

}