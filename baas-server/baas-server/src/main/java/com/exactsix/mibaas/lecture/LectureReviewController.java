package com.exactsix.mibaas.lecture;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;

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
@Controller(value = "lectureReviewController")
public class LectureReviewController {

	@Resource(name = "lectureService")
	private LectureService lectureService;
	
	/**
	 * <pre>
	 * 강좌 리뷰 목록
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}/reviews", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse getUserToLecture(){
		return null;
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
	public @ResponseBody RestResponse addUserToLecture(){
		return null;
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
