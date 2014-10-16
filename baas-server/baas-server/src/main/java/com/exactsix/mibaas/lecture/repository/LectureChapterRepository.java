package com.exactsix.mibaas.lecture.repository;

import org.springframework.data.repository.CrudRepository;

import com.exactsix.mibaas.lecture.repository.dto.LectureChapterRepositoryDto;

public interface LectureChapterRepository extends
		CrudRepository<LectureChapterRepositoryDto, String> {

}
