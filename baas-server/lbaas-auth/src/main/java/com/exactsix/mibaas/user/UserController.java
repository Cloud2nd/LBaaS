package com.exactsix.mibaas.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.user.dto.UserDto;
import com.exactsix.mibaas.user.service.LoginService;

/**
 * <pre>
 * Class Name  : LoginController.java
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
public class UserController {

	@Autowired
	private LoginService loginService;


	@RequestMapping(value = "/usermanagement/login", method = RequestMethod.POST)
	public @ResponseBody RestResponse login(@RequestBody UserDto userDto) {
		return loginService.getLogin(userDto);
	}

	@RequestMapping(value = "/usermanagement/{username}", method = RequestMethod.GET)
	public @ResponseBody RestResponse userList(@PathVariable String username) {
		return loginService.getUser(username);
	}

	@RequestMapping(value = "/usermanagement/{username}", method = RequestMethod.POST)
	public @ResponseBody RestResponse userList(@RequestBody UserDto userDto) {
		return null;
	}
	
	@RequestMapping(value = "/usermanagement/test", method = RequestMethod.POST)
	public @ResponseBody RestResponse device() {
		return null;
	}

}
