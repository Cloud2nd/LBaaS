package com.exactsix.mibaas.coach.user.controller;

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
@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping(value = "/list")
	public String list() throws Exception {
		return "coach/user_list";
	}


}
