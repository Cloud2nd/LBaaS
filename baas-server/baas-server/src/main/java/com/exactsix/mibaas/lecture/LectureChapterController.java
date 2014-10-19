package com.exactsix.mibaas.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.lecture.dto.ChapterDto;
import com.exactsix.mibaas.lecture.service.LectureManager;

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
	private LectureManager lectureManager;

	/**
	 * <pre>
	 * 강좌 챕터 List
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chapter/{lecturecode}", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getUserToLecture(@PathVariable String lecturecode) {
		return lectureManager.getChapters(lecturecode);
	}

	/**
	 * <pre>
	 * 강좌 챕터 등록
	 * </pre>
	 * 
	 * @param gridParam
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/chapter/{lecturecode}", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse getChapters(@RequestBody ChapterDto chapterDto) {
		return lectureManager.createChapter(chapterDto);
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
	@RequestMapping(value = "/chapter/{lectureCode}/{chapterCode}", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse getChapter(@PathVariable String lectureCode,
			@PathVariable String chapterCode) {
		return lectureManager.getChapter(lectureCode, chapterCode);
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
	@RequestMapping(value = "/chapter/{lecturecode}/{chaptercode}", method = RequestMethod.DELETE)
	public @ResponseBody
	RestResponse deleteUserToLecture(@PathVariable String lecturecode,
			@PathVariable String chaptercode) {

		ChapterDto dto = new ChapterDto();
		dto.setChapterCode(chaptercode);
		dto.setLectureCode(lecturecode);
		return lectureManager.deleteChapter(dto);
	}

	@RequestMapping(value = "/chapter/{lecturecode}/{chaptercode}", method = RequestMethod.PUT)
	public @ResponseBody
	RestResponse updateChapter(@PathVariable String lecturecode,
			@PathVariable String chaptercode, @RequestBody ChapterDto chapterDto) {
		chapterDto.setChapterCode(chaptercode);
		chapterDto.setLectureCode(lecturecode);
		return lectureManager.updateChapter(chapterDto);
	}
}
