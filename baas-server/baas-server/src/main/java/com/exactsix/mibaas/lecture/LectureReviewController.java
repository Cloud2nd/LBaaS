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
import com.exactsix.mibaas.lecture.dto.LectureReviewDto;
import com.exactsix.mibaas.lecture.service.LectureManager;

/**
 * <pre>
 * Class Name  : LectureReviewController.java
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
public class LectureReviewController {

	@Autowired
	private LectureManager lectureManager;
	
	/**
	 * <pre>
	 * 강좌 리뷰 목록
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}/reviews", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse getUserToLecture(@PathVariable String lecturekey){
		return lectureManager.getLectureReview(lecturekey);
	}
	
	/**
	 * <pre>
	 * 강좌 리뷰 등록
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}/reviews", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse addUserToLecture(@RequestBody LectureReviewDto lectureReview){
		return lectureManager.createOrUpdateLectureReview(lectureReview);
	}
	
	/**
	 * <pre>
	 * 강좌 리뷰 삭제
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}/reviews", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse deleteUserToLecture(){
		return null;
	}
	
}
