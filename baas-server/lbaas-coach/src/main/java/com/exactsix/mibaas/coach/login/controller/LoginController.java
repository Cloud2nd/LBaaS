package com.exactsix.mibaas.coach.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exactsix.mibaas.auth.client.UserLogin;
import com.exactsix.mibaas.auth.client.UserResponse;
import com.exactsix.mibaas.coach.login.service.LoginService;

/**
 * <pre>
 * Class Name  : LoginController.java
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
public class LoginController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private LoginService service;

	@RequestMapping("/login")
	public String welcome() {
		return "user/login";
	}

	@RequestMapping("/login/process")
	public String loginProcess(UserLogin login, HttpServletRequest request) {

		System.out.println(login.getEmail());
		System.out.println(login.getPasswd());
		
		UserResponse response = service.login(login);

		if (!response.isStatus()) {
			return "redirect:/login";
		} else {
			request.getSession().setAttribute("LOGGEDIN_USER", response);
			return "redirect:/dashboard";

		}
	}
}
