package com.exactsix.mibaas.lecture.repository;

import org.springframework.data.repository.CrudRepository;

import com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto;

public interface LectureRepository extends
		CrudRepository<LectureRepositoryDto, String> {

}
