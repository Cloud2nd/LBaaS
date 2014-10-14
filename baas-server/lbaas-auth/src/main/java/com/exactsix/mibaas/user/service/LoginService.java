package com.exactsix.mibaas.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.user.dao.UserDao;
import com.exactsix.mibaas.user.dto.UserDto;

@Service
public class LoginService {

	@Autowired
	private UserDao userDao;

	public RestResponse getLogin(UserDto user) {

		RestResponse response = new RestResponse();
		user = userDao.getUser(user.getEmail());
		response.setStatus(true);
		response.setMessage("success login");
		response.setData(user);
		return response;
	}

	public RestResponse getUser(String email) {

		RestResponse response = new RestResponse();

		UserDto user = userDao.getUser(email);
		
		if (user == null) {
			response.setStatus(false);
			response.setMessage("login error");
			response.setCode("100");
		} else {
			response.setStatus(true);
			response.setMessage("success");
			response.setData(user);
		}

		return response;
	}

}
