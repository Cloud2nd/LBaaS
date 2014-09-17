package com.exactsix.mibaas.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.LectureDetailDto;
import com.exactsix.mibaas.lecture.dto.LectureDto;
import com.exactsix.mibaas.lecture.service.LectureService;

/**
 * <pre>
 * Class Name  : LectureController.java
 * Description :
 * Modification Information
 * 
 * </pre>
 * 
 * @author dave
 * @since 2014. 9. 16.
 * @version 1.0
 * 
 */
@RequestMapping("/api")
@Controller
public class LectureController {

	@Autowired
	private LectureService lectureService;

	/**
	 * <pre>
	 * 강좌 리스트
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getLectureList() {
		//
		// return lectureService.getLecture();
		return null;
	}

	/**
	 * <pre>
	 * 강좌 상세정보
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getLecture(@PathVariable String lecturekey) {
		return lectureService.getLecture(lecturekey);
	}

	/**
	 * <pre>
	 * 강좌 등록
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse createLectureList(@RequestBody LectureDto lectureDto) {
		return lectureService.createLecture(lectureDto);
	}

	/**
	 * <pre>
	 * 강좌 수정
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse updateLectureList(@RequestBody LectureDto lectureDto) {
		return null;
	}

	/**
	 * <pre>
	 * 강좌 상세 등록
	 * </pre>
	 * 
	 * @param lectureDetail
	 * @return
	 */

	@RequestMapping(value = "/lecture/{lecturecode}/detail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse createOrUpdateLectureDetail(
			@RequestBody LectureDetailDto lectureDetail) {
		return lectureService.createOrUpdateLectureDetail(lectureDetail);
	}

	/**
	 * <pre>
	 * 강좌 상세정보 조회
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 */
	@RequestMapping(value = "/lecture/{lecturecode}/detail", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getLectureDetail(@PathVariable String lecturecode) {
		return lectureService.getLecture(lecturecode);
	}

	/**
	 * <pre>
	 * 강좌 삭제
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse deleteLecture() {
		return null;
	}

}
