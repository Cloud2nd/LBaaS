package com.exactsix.mibaas.lecture.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;

public interface LectureRepository extends CrudRepository<LectureRepositoryDto, String> {

	List<LectureRepositoryDto> findAllAdmins();
	// List<LectureDto> findByLastname(Query query);

	List<LectureRepositoryDto> findByLectureCode(Query query);
}
