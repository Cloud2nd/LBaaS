package com.exactsix.mibaas.coach.login.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactsix.mibaas.auth.client.CourseVilClient;
import com.exactsix.mibaas.auth.client.UserLogin;
import com.exactsix.mibaas.auth.client.UserResponse;

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
@Service
public class LoginService {

	@Autowired
	private CourseVilClient client;

	protected final Log logger = LogFactory.getLog(getClass());

	public UserResponse login(UserLogin login) {

		UserResponse response = client.login(login);
		return response;
	}
}
