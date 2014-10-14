package com.exactsix.mibaas.lecture.repository;

import org.springframework.data.repository.CrudRepository;

import com.exactsix.mibaas.lecture.repository.dto.LectureDetailRepositoryDto;

public interface LectureDetailRepository extends
		CrudRepository<LectureDetailRepositoryDto, String> {

}
