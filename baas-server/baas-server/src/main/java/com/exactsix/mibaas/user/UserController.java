package com.exactsix.mibaas.user;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;

/**
 * <pre>
 * Class Name  : UserController.java
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
@Controller(value = "userController")
public class UserController {

	@Resource(name = "receiverService")
	private ReceiverService receiverService;

	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody RestResponse list() {
		//
		return null;
	}
	
	@RequestMapping(value = "/users/{userkey}", method = RequestMethod.GET)
	public @ResponseBody RestResponse getPermmision(@PathVariable String spacekey) {
		return null;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RestResponse addPermission(){
		return null;
	}
}
