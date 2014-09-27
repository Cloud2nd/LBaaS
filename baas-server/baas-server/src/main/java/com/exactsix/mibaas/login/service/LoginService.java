package com.exactsix.mibaas.login.service;

import org.springframework.stereotype.Service;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.login.dto.UserDto;

@Service
public class LoginService {

	public RestResponse getLogin() {

		UserDto user = new UserDto();
		user.setEmail("dave.han1002@gmail.com");
		user.setUsername("한정수");

		RestResponse response = new RestResponse();
		response.setStatus(true);
		response.setMessage("success login");
		response.setData(user);

		return response;
	}

}
