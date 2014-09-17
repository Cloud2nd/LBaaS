package com.exactsix.mibaas.lecture.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.exactsix.mibaas.lecture.repository.dto.LectureDetailRepositoryDto;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;

public interface LectureDetailRepository extends
		CrudRepository<LectureDetailRepositoryDto, String> {

	List<LectureRepositoryDto> findAllAdmins();

	// List<LectureDto> findByLastname(Query query);

	List<LectureRepositoryDto> findByLectureCode(Query query);
}
