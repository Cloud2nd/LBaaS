package com.exactsix.mibaas.coach.home.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class Name  : HomeController.java
 * Description :
 * Modification Information
 * 
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2014. 9. 28.   Dave             Dashboard
 * </pre>
 *
 * @author Dave
 * @since 2014. 9. 27.
 * @version 1.0
 *
 *          Copyright (C) 2012 by ExactSix Lab All right reserved.
 */
@Controller
public class HomeController {
	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping("/")
	public String welcome() {
		return "home/home";
	}
}
