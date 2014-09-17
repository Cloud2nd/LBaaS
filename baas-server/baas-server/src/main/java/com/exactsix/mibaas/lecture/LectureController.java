package com.exactsix.mibaas.lecture;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;

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
@Controller(value = "lectureController")
public class LectureController {

	@Resource(name = "lectureService")
	private LectureService lectureService;


	/**
	 * <pre>
	 * 강좌 리스트
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture", method = RequestMethod.GET)
	public @ResponseBody RestResponse getLectureList() {
		//
		return null;
	}

	
	/**
	 * <pre>
	 * 강좌 등록
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse createLectureList(){
		return null;
	}
	
	/**
	 * <pre>
	 * 강좌 상세정보
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}", method = RequestMethod.GET)
	public @ResponseBody RestResponse getLecture(@PathVariable String lecturekey) {
		return null;
	}
	
	/**
	 * <pre>
	 * 강좌 수정
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse updateLecture(){
		return null;
	}
	
	/**
	 * <pre>
	 * 강좌 삭제
	 * </pre>
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/lecture/{lecturekey}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse deleteLecture(){
		return null;
	}

}