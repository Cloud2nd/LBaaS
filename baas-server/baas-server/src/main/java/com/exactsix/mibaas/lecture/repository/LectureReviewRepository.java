package com.exactsix.mibaas.lecture.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;
import com.exactsix.mibaas.lecture.repository.dto.LectureReviewRepositoryDto;

public interface LectureReviewRepository extends
		CrudRepository<LectureReviewRepositoryDto, String> {

	List<LectureRepositoryDto> findAllAdmins();

	// List<LectureDto> findByLastname(Query query);

	List<LectureRepositoryDto> findByLectureCode(Query query);
}
