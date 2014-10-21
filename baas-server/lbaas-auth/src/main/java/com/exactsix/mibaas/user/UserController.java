package com.exactsix.mibaas.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.user.dto.DeviceDto;
import com.exactsix.mibaas.user.dto.UserDeviceDto;
import com.exactsix.mibaas.user.dto.UserDto;
import com.exactsix.mibaas.user.service.UserService;

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
	private UserService userService;

	@RequestMapping(value = "/usermanagement/login", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse login(@RequestBody UserDto userDto) {
		return userService.getLogin(userDto);
	}

	@RequestMapping(value = "/usermanagement/{username}", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse userList(@PathVariable String username) {
		return userService.getUser(username);
	}

	@RequestMapping(value = "/usermanagement/{username}", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse userList(@RequestBody UserDto userDto) {
		return null;
	}

	@RequestMapping(value = "/usermanagement/device", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse device(@RequestBody DeviceDto device) {
		return userService.createDevice(device);
	}

	@RequestMapping(value = "/usermanagement/userdevice", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse userDevice(@RequestBody UserDeviceDto userDevice) {
		return userService.createUserDevice(userDevice);
	}

}
