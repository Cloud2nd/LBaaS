package com.exactsix.mibaas.lecture;

import javax.servlet.http.HttpServletRequest;

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
import com.exactsix.mibaas.lecture.service.LectureManager;
import com.exactsix.mibaas.lecture.service.search.LectureElasticSearchService;

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
	private LectureManager lectureManager;

	@Autowired
	private LectureElasticSearchService service;
	
	@Autowired
	private HttpServletRequest context;

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
		return lectureManager.getLectureList();
	}
	
	@RequestMapping(value = "/lecture/inprogress", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getProgressCourseList() {
		//
		return lectureManager.getProgressCourseList();
	}
	

	/**
	 * <pre>
	 * 강좌 정보
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getLecture(@PathVariable String lecturekey) {
		return lectureManager.getLecture(lecturekey);
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
		return lectureManager.createLecture(lectureDto);
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
	@RequestMapping(value = "/lecture", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
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
		return lectureManager.createOrUpdateLectureDetail(lectureDetail);
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
		return lectureManager.getLectureDetail(lecturecode);
	}

	@RequestMapping(value = "/lecture/elk", method = RequestMethod.GET)
	public @ResponseBody
	String getElk() {
		service.test();
		return "OK";
	}
	
	

}
