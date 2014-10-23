package com.exactsix.mibaas.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.exactsix.mibaas.common.response.RestResponse;

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
public class FileController {

	@Autowired
	private FileService service;

	@RequestMapping(value = "/file/save", method = RequestMethod.POST)
	public @ResponseBody
	RestResponse fileSave(@RequestParam("file") MultipartFile file) {

		return service.fileSave(file);

	}

}
