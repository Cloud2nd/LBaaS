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
import com.exactsix.mibaas.lecture.dto.ChapterDto;
import com.exactsix.mibaas.lecture.service.LectureService;

/**
 * <pre>
 * Class Name  : LectureChapterController.java
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
public class LectureChapterController {

	@Autowired
	private LectureService lectureService;

	/**
	 * <pre>
	 * 강좌 챕터 등록
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chapter/{lecturecode}/chapters", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse getChapters(@RequestBody ChapterDto chapterDto) {
		return null;
	}

	

	/**
	 * <pre>
	 * 강좌 챕터 List
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chapter/{lecturecode}/chapters", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse getUserToLecture(@PathVariable String lecturecode) {
		return null;
	}
	
	/**
	 * <pre>
	 * 강좌 챕터 상세
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chapter/{lecturecode}/{chaptercode}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse getChapter(@PathVariable String lecturecode, @PathVariable String chaptercode) {
		return null;
	}
	
	/**
	 * <pre>
	 * 강좌 챕터 삭제
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chapter/{lecturecode}/{chaptercode}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	RestResponse deleteUserToLecture(@PathVariable String lecturecode, @PathVariable String chaptercode) {
		return null;
	}
}
