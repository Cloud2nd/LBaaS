package com.exactsix.mibaas.lecture.repository;

import org.springframework.data.repository.CrudRepository;

import com.exactsix.mibaas.lecture.repository.dto.LectureEntrollRepositoryDto;

public interface LectureEntrollRepository extends
		CrudRepository<LectureEntrollRepositoryDto, String> {

}
