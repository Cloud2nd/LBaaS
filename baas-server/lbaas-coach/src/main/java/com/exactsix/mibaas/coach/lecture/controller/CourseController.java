package com.exactsix.mibaas.coach.lecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class Name  : CoachController.java
 * Description :
 * Modification Information
 * 
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2014. 9. 28.   Dave             CoachController
 * </pre>
 * 
 * @author Dave
 * @since 2014. 9. 27.
 * @version 1.0
 * 
 *          Copyright (C) 2012 by ExactSix Lab All right reserved.
 */
@RequestMapping("/course")
@Controller
public class CourseController {

	@RequestMapping(value = "/list")
	public String list() throws Exception {
		return "coach/course_list";
	}

	@RequestMapping(value = "/create")
	public String create() throws Exception {
		return "coach/course_create";
	}

	@RequestMapping(value = "/detail/{lecturecode}")
	public String deatil(@PathVariable String lecturecode, ModelMap model)
			throws Exception {
		model.addAttribute("lectureCode", lecturecode);
		return "coach/course_detail";
	}

	@RequestMapping(value = "/chapter/create")
	public String chapterCreate() throws Exception {
		return "coach/course_chapter_create";
	}

}
