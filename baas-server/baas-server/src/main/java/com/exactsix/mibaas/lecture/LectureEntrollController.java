package com.exactsix.mibaas.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.EntrollDto;
import com.exactsix.mibaas.lecture.service.LectureManager;

@RequestMapping("/api")
@Controller
public class LectureEntrollController {

	@Autowired
	private LectureManager lectureManager;

	@RequestMapping(value = "/entroll/{lecturecode}", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse createEntrollLecture(@PathVariable String lecturecode,
			@RequestBody EntrollDto entrollDto) {
		entrollDto.setLectureCode(lecturecode);
		return lectureManager.createEntrollLecture(entrollDto);
	}

	@RequestMapping(value = "/entroll/{lecturecode}/cancel", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse removeEntrollLecture(@PathVariable String lecturecode, @RequestBody EntrollDto entrollDto) {
		entrollDto.setLectureCode(lecturecode);
		return lectureManager.removeEntrollLecture(entrollDto);
	}

	@RequestMapping(value = "/entroll/{lecturecode}", method = RequestMethod.PUT)
	public @ResponseBody
	RestResponse updateEntrollLecture(@PathVariable String lecturecode,
			@RequestBody EntrollDto entrollDto) {

		entrollDto.setLectureCode(lecturecode);
		return lectureManager.updateEntrollStatus(entrollDto);
	}
}
