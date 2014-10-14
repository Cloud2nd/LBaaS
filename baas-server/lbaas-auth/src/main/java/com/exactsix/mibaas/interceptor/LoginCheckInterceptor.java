package com.exactsix.mibaas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestURI = request.getRequestURI().toString();
		String requestURIShort = requestURI.substring(0,
				requestURI.lastIndexOf("/") + 1);

		return true;
	}
}
