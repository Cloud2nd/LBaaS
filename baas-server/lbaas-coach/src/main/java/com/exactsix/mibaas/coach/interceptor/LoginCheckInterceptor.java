package com.exactsix.mibaas.coach.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.exactsix.mibaas.auth.client.UserResponse;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		UserResponse user = (UserResponse) session
				.getAttribute("LOGGEDIN_USER");

		if (!request.getRequestURI().equals("/login")
				&& !request.getRequestURI().equals("/login/process")) {
			if (user == null || !user.isStatus()) {
				response.sendRedirect("/login");
				return false;
			}
		}
		
		/*
		 * else {

			if (user != null && user.isStatus()) {
				response.sendRedirect("/dashboard");
				return true;
			}

		}*/
		 
		return true;

	}
}
