package com.exactsix.mibaas.lecture.repository;

import org.springframework.data.repository.CrudRepository;

import com.exactsix.mibaas.lecture.repository.dto.LectureReviewRepositoryDto;

public interface LectureReviewRepository extends
		CrudRepository<LectureReviewRepositoryDto, String> {


}
