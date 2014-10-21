package com.exactsix.mibaas.transcoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exactsix.mibaas.common.response.RestResponse;
import com.exactsix.mibaas.email.service.EmailService;
import com.exactsix.mibaas.sns.service.MobilePushService;

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
public class TranscoderController {

	@Autowired
	private EmailService loginService;

	@Autowired
	private MobilePushService snsService;

	@RequestMapping(value = "/transcoder", method = RequestMethod.GET)
	public @ResponseBody
	RestResponse login() {
		return loginService.sendMail();
	}

}
